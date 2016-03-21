/**
 * $Id: EBRestActivator.java 60891 2009-06-01 12:50:37Z aaronz@vt.edu $
 * $URL: https://source.sakaiproject.org/contrib/caret/osgi-eb/tags/eb-1.0/eb-webapp/src/main/java/org/sakaiproject/eb/rest/osgi/EBRestActivator.java $
 * EBRestActivator.java - eb-sling - Apr 9, 2009 3:30:18 PM - azeckoski
 **************************************************************************
 * Copyright (c) 2008 Aaron Zeckoski
 * Licensed under the Apache License, Version 2.0
 * 
 * A copy of the Apache License has been included in this 
 * distribution and is available at: http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Aaron Zeckoski (azeckoski @ gmail.com) (aaronz @ vt.edu) (aaron @ caret.cam.ac.uk)
 */

package org.sakaiproject.eb.rest.osgi;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import org.azeckoski.osgi.utils.ServiceTracker2;
import org.azeckoski.osgi.utils.ServiceTrackerPlus;
import org.azeckoski.osgi.utils.ServicesTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.sakaiproject.eb.rest.servlet.EBDirectServlet;
import org.sakaiproject.entitybus.DeveloperHelperService;
import org.sakaiproject.entitybus.EntityBrokerManager;
import org.sakaiproject.entitybus.access.HttpServletAccessProviderManager;
import org.sakaiproject.entitybus.util.devhelper.DeveloperHelperServiceMock;

/**
 * Activator for the rest bundle
 * 
 * @author Aaron Zeckoski (azeckoski @ gmail.com)
 */
@SuppressWarnings("deprecation")
public class EBRestActivator implements BundleActivator {

    private final String alias = "/eb";

    private ServicesTracker requiredServicesTracker;
    private ServiceTrackerPlus<HttpServletAccessProviderManager> hsapmTracker;
    private ServiceTrackerPlus<DeveloperHelperService> dhsTracker;
    private EBDirectServlet servlet = null;

    public void start(BundleContext context) throws Exception {
        System.out.println("INFO: Starting EB ReST module");
        // initialize tracker
        this.requiredServicesTracker = new ServicesTracker(context, HttpService.class, EntityBrokerManager.class) {
            @Override
            protected void requiredServicesReady(Object service, ServiceTracker2 changed,
                    Map<String, ServiceTracker2> serviceTrackers) throws Exception {
                // required services are ready so startup
                startServices(getService(HttpService.class), getService(EntityBrokerManager.class));
            }
            @Override
            protected void requiredServicesChanged(Object service, ServiceTracker2 changed,
                    Map<String, ServiceTracker2> serviceTrackers) throws Exception {
                // required services changed so stop and restart
                stopServices(getService(HttpService.class));
                startServices(getService(HttpService.class), getService(EntityBrokerManager.class));
            }
            @Override
            protected void requiredServicesDropped(Object service, ServiceTracker2 changed,
                    Map<String, ServiceTracker2> serviceTrackers) throws Exception {
                // required services gone so shutdown
                stopServices(getService(HttpService.class));
            }
        };

        // optional services trackers
        dhsTracker = new ServiceTrackerPlus<DeveloperHelperService>(context, DeveloperHelperService.class) {
            @Override
            protected void serviceUpdate(ServiceEvent event, DeveloperHelperService service)
                    throws Exception {
                DeveloperHelperService dhs = getService();
                if (servlet != null) {
                    servlet.updateDHS(dhs);
                }
            }
        };
        // TODO need to handle the case of the hsapm changing?
        hsapmTracker = new ServiceTrackerPlus<HttpServletAccessProviderManager>(context, HttpServletAccessProviderManager.class);

        // register the servlet if services are ready
        this.requiredServicesTracker.startCheck();
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("INFO: Stopping EB ReST module");
        // destroy the trackers
        if (this.requiredServicesTracker != null) {
            this.requiredServicesTracker.shutdown();
            this.requiredServicesTracker = null;
        }
        if (this.dhsTracker != null) {
            this.dhsTracker.shutdown();
            this.dhsTracker = null;
        }
        if (this.hsapmTracker != null) {
            this.hsapmTracker.shutdown();
            this.hsapmTracker = null;
        }
        this.servlet = null;
    }
    
    /**
     * Attempts to start the sample servlet using the services it requires,
     * this is also called when there are changes to the required services
     * 
     * @param httpService the Http Service
     * @param sampleService the Sample Service
     * @throws IllegalArgumentException if the params are null
     * @throws RuntimeException if the servlet cannot be registered
     */
    public void startServices(HttpService httpService, EntityBrokerManager ebm) {
        // try to register the servlet
        System.out.println("AZ: preparing to register servlet");

        // get the EB services
        DeveloperHelperService dhs = dhsTracker.getService();
        if (dhs == null) {
            System.err.println("WARN: No DeveloperHelperService available so using the mock for now");
            dhs = new DeveloperHelperServiceMock(); // use the mock for now
        }

        // optional
        HttpServletAccessProviderManager hsapm = hsapmTracker.getService();

        System.out.println("INFO: preparing to register EB ReST servlet");
        // create a default context to share between registrations
        final HttpContext httpContext = httpService.createDefaultHttpContext();
        // register the Servlet
        final Dictionary<String, String> initParams = new Hashtable<String, String>();
        initParams.put("from", "HttpService");
        initParams.put("alias", alias);
        servlet = new EBDirectServlet(ebm, hsapm, dhs);
        try {
            httpService.registerServlet(alias, // alias
                    servlet, // registered servlet
                    initParams, // init params
                    httpContext // http context
            );
            System.out.println("INFO: Started EB ReST Service: registered servlet and resources at " + alias);
        } catch (Exception e) {
            this.servlet = null; // cleanup
            System.err.println("ERROR: Could not start EB ReST Service: Exception registering: " + e);
            throw new RuntimeException("ERROR: Could not start EB ReST Service: Exception registering: " + e, e);
        }
    }

    /**
     * Handles the cleanup when the attempt to startup the ReST servlet fails or when stopping the service
     * this should be crash proof (i.e. no exceptions should come out of this)
     * 
     * @param httpService OPTIONAL the http service which is used to unregister the servlet,
     * this can be null if the service is unavailable
     */
    public void stopServices(HttpService httpService) {
        if (httpService != null) {
            try {
                httpService.unregister(alias);
            } catch (IllegalArgumentException e) {
                System.out.println("WARN: Could not unregister ("+alias+"):" + e);
            }
        } else {
            if (this.servlet != null) {
                this.servlet.destroy();
            }
        }
        this.servlet = null;
        System.out.println("INFO: Stopped EB ReST Service");
    }

}
