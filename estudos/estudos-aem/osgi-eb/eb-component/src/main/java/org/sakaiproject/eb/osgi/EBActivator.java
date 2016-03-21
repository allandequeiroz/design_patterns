/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.sakaiproject.eb.osgi;

import org.azeckoski.osgi.utils.ServiceTrackerPlus;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceRegistration;
import org.sakaiproject.entitybus.DeveloperHelperService;
import org.sakaiproject.entitybus.EntityBroker;
import org.sakaiproject.entitybus.EntityBrokerManager;
import org.sakaiproject.entitybus.access.EntityViewAccessProviderManager;
import org.sakaiproject.entitybus.access.HttpServletAccessProviderManager;
import org.sakaiproject.entitybus.entityprovider.EntityProvider;
import org.sakaiproject.entitybus.entityprovider.EntityProviderManager;
import org.sakaiproject.entitybus.impl.EntityBrokerCoreServiceManager;
import org.sakaiproject.entitybus.providers.ExternalIntegrationProvider;

/**
 * This class starts and stops the EB services module
 */
@SuppressWarnings("deprecation")
public class EBActivator implements BundleActivator {

    protected ServiceRegistration ebRegistration;
    protected ServiceRegistration ebManagerRegistration;
    protected ServiceRegistration ebProviderManagerRegistration;
    protected ServiceRegistration ebEVAPManagerRegistration;
    protected ServiceRegistration ebHSAPManagerRegistration;

    protected EntityBrokerCoreServiceManager coreServiceManager;

    protected ServiceTrackerPlus<ExternalIntegrationProvider> eipTracker;
    protected ServiceTrackerPlus<EntityProvider> providerTracker;

    public void start(BundleContext context) throws Exception {
        System.out.println("INFO: Starting EB module");

        // Create the EB core services
        coreServiceManager = new EntityBrokerCoreServiceManager();

        // register trackers to handle the optional services
        eipTracker = new ServiceTrackerPlus<ExternalIntegrationProvider>(context, ExternalIntegrationProvider.class) {
            @Override
            protected void serviceUpdate(ServiceEvent event, ExternalIntegrationProvider service)
                    throws Exception {
                coreServiceManager.getEntityBrokerManager().setExternalIntegrationProvider(getService());
            }
        };

        // register a tracker for the entity providers (will find them as osgi services and handle registration)
        providerTracker = new ServiceTrackerPlus<EntityProvider>(context, EntityProvider.class) {
            @Override
            protected void serviceUpdate(ServiceEvent event, EntityProvider service)
                    throws Exception {
                EntityProvider provider = getService(event);
                if (event.getType() == ServiceEvent.UNREGISTERING) {
                    coreServiceManager.getEntityProviderManager().unregisterEntityProvider(provider);
                } else {
                    coreServiceManager.getEntityProviderManager().registerEntityProvider(provider);
                }
            }
        };

        // look up a service we optionally want to use but do not require
        ServiceTrackerPlus<DeveloperHelperService> dhsTracker = 
            new ServiceTrackerPlus<DeveloperHelperService>(context, DeveloperHelperService.class);
        DeveloperHelperService dhs = dhsTracker.getService();
        System.out.println("DeveloperHelperService is currently: " + dhs);

        // register the core services from this bundle
        ebRegistration = context.registerService( EntityBroker.class.getName(), coreServiceManager.getEntityBroker(), null);
        ebManagerRegistration = context.registerService( EntityBrokerManager.class.getName(), coreServiceManager.getEntityBrokerManager(), null);
        ebProviderManagerRegistration = context.registerService( EntityProviderManager.class.getName(), coreServiceManager.getEntityProviderManager(), null);
        ebEVAPManagerRegistration = context.registerService( EntityViewAccessProviderManager.class.getName(), coreServiceManager.getEntityViewAccessProviderManager(), null);
        ebHSAPManagerRegistration = context.registerService( HttpServletAccessProviderManager.class.getName(), coreServiceManager.getHttpServletAccessProviderManager(), null);

        System.out.println("INFO: Started EB module and registered services");
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("INFO: Stopping EB module");

        unregisterService(ebRegistration);
        unregisterService(ebManagerRegistration);
        unregisterService(ebProviderManagerRegistration);
        unregisterService(ebEVAPManagerRegistration);
        unregisterService(ebHSAPManagerRegistration);

        ebRegistration = null;
        ebManagerRegistration = null;
        ebProviderManagerRegistration = null;
        ebEVAPManagerRegistration = null;
        ebHSAPManagerRegistration = null;

        if (this.eipTracker != null) {
            this.eipTracker.shutdown();
            this.eipTracker = null;
        }
        if (this.coreServiceManager != null) {
            this.coreServiceManager.shutdown();
            this.coreServiceManager = null;
        }
        System.out.println("INFO: Stopped EB module and unregistered services");
    }

    /**
     * Avoid code replication
     * @param registration the OSGi service registration
     */
    private void unregisterService(ServiceRegistration registration) {
        if (registration != null) {
            try {
                registration.unregister();
            } catch (IllegalStateException e) {
                // No problem
                registration = null;
            }
        }
    }

}
