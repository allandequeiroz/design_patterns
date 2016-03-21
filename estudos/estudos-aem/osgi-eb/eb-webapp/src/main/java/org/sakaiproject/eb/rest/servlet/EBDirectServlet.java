/**
 * $Id: EBDirectServlet.java 59805 2009-04-13 17:58:31Z aaronz@vt.edu $
 * $URL: https://source.sakaiproject.org/contrib/caret/osgi-eb/tags/eb-1.0/eb-webapp/src/main/java/org/sakaiproject/eb/rest/servlet/EBDirectServlet.java $
 * Example.java - entity-broker - 31 May 2007 7:01:11 PM - azeckoski
 **************************************************************************
 * Copyright (c) 2007, 2008 Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sakaiproject.eb.rest.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sakaiproject.eb.rest.providers.AbstractEntityProvider;
import org.sakaiproject.eb.rest.providers.UserEntityProvider;
import org.sakaiproject.entitybus.DeveloperHelperService;
import org.sakaiproject.entitybus.EntityBrokerManager;
import org.sakaiproject.entitybus.access.HttpServletAccessProviderManager;
import org.sakaiproject.entitybus.entityprovider.EntityProviderManager;
import org.sakaiproject.entitybus.providers.EntityRequestHandler;
import org.sakaiproject.entitybus.rest.EntityBrokerRESTServiceManager;
import org.sakaiproject.entitybus.util.servlet.DirectServlet;

/**
 * Direct servlet allows unfettered access to entity URLs within Sakai K2
 * and provides the EB REST access
 * 
 * @author Aaron Zeckoski (aaron@caret.cam.ac.uk)
 */
@SuppressWarnings("deprecation")
public class EBDirectServlet extends DirectServlet {

    private transient EntityBrokerRESTServiceManager entityRESTServiceManager;
    private transient EntityRequestHandler requestHandler;
    private transient DeveloperHelperService developerHelperService;

    private transient List<AbstractEntityProvider> entityProviders;

    public EBDirectServlet(EntityBrokerManager ebm,
            HttpServletAccessProviderManager hsapm, DeveloperHelperService dhs) {
        super();
        if (ebm == null || dhs == null) {
            throw new IllegalArgumentException("EntityBrokerManager and DeveloperHelperService cannot be null");
        }
        this.developerHelperService = dhs;
        // fire up the EB rest services
        this.entityRESTServiceManager = new EntityBrokerRESTServiceManager(ebm, hsapm);
        EntityRequestHandler erh = this.entityRESTServiceManager.getEntityRequestHandler();
        if (erh == null) {
            throw new RuntimeException("FAILED to load EB EntityRequestHandler");
        } else {
            this.requestHandler = erh; // set for use later
        }
        EntityProviderManager epm = ebm.getEntityProviderManager();
        // fire up the providers
        this.entityProviders = new ArrayList<AbstractEntityProvider>();
        UserEntityProvider uep = new UserEntityProvider(epm, dhs); //, urs, sms);
        this.entityProviders.add( uep );
    }

    /**
     * Called when there is a change to the developer helper service
     * @param dhs the updated developer helper service
     */
    public void updateDHS(DeveloperHelperService dhs) {
        if (this.entityProviders != null) {
            for (AbstractEntityProvider provider : entityProviders) {
                if (provider != null) {
                    try {
                        provider.setDeveloperHelperService(dhs);
                    } catch (Exception e) {
                        System.err.println("Could not udpate dhs for provider ("+provider+"): " + e);
                    }
                }
            }
            this.entityProviders = null;
        }        
    }
    
    @Override
    public EntityRequestHandler initializeEntityRequestHandler() {
        return this.requestHandler;
    }

    @Override
    public void destroy() {
        super.destroy();
        if (this.entityProviders != null) {
            for (AbstractEntityProvider provider : entityProviders) {
                if (provider != null) {
                    try {
                        provider.destroy();
                    } catch (Exception e) {
                        System.err.println("Could not clean up provider ("+provider+") on destroy: " + e);
                    }
                }
            }
            this.entityProviders = null;
        }
        this.entityRESTServiceManager.destroy();
        this.entityRESTServiceManager = null;
        this.requestHandler = null;
        this.developerHelperService = null;
    }


    @Override
    protected String getCurrentLoggedInUserId() {
        return this.developerHelperService.getCurrentUserId();
    }

    @Override
    protected void handleUserLogin(HttpServletRequest req, HttpServletResponse res, String path) {
        throw new SecurityException("no login support yet");
    }

}
