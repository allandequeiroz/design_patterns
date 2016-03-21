/**
 * $Id: UserEntityProvider.java 59798 2009-04-13 16:18:49Z aaronz@vt.edu $
 * $URL: https://source.sakaiproject.org/contrib/caret/osgi-eb/tags/eb-1.0/eb-webapp/src/main/java/org/sakaiproject/eb/rest/providers/UserEntityProvider.java $
 * UserEntityProvider.java - entity-broker - Jun 28, 2008 2:59:57 PM - azeckoski
 **************************************************************************
 * Copyright (c) 2008 Sakai Foundation
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

package org.sakaiproject.eb.rest.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.eb.rest.providers.model.EntityUser;
import org.sakaiproject.entitybus.DeveloperHelperService;
import org.sakaiproject.entitybus.EntityReference;
import org.sakaiproject.entitybus.EntityView;
import org.sakaiproject.entitybus.entityprovider.CoreEntityProvider;
import org.sakaiproject.entitybus.entityprovider.EntityProviderManager;
import org.sakaiproject.entitybus.entityprovider.annotations.EntityCustomAction;
import org.sakaiproject.entitybus.entityprovider.capabilities.ActionsExecutable;
import org.sakaiproject.entitybus.entityprovider.capabilities.Describeable;
import org.sakaiproject.entitybus.entityprovider.capabilities.Inputable;
import org.sakaiproject.entitybus.entityprovider.capabilities.Outputable;
import org.sakaiproject.entitybus.entityprovider.capabilities.Resolvable;
import org.sakaiproject.entitybus.entityprovider.capabilities.Sampleable;
import org.sakaiproject.entitybus.entityprovider.extension.Formats;
import org.sakaiproject.entitybus.entityprovider.search.Search;
import org.sakaiproject.entitybus.exception.EntityNotFoundException;

/**
 * Entity Provider for users
 * 
 * @author Aaron Zeckoski (azeckoski @ gmail.com)
 */
public class UserEntityProvider extends AbstractEntityProvider implements CoreEntityProvider, 
        Resolvable, Sampleable, 
        Inputable, Outputable, Describeable, ActionsExecutable {

    private static Log log = LogFactory.getLog(UserEntityProvider.class);

    public UserEntityProvider(EntityProviderManager entityProviderManager,
            DeveloperHelperService developerHelperService) {
        super(entityProviderManager, developerHelperService);
    }

    public static String PREFIX = "user";
    public String getEntityPrefix() {
        return PREFIX;
    }

    @EntityCustomAction(action="current",viewKey=EntityView.VIEW_LIST)
    public EntityUser getCurrentUser(EntityView view) {
        EntityUser eu = null;
        String userId = developerHelperService.getCurrentUserId();
        if (userId != null) {
            eu = makeFakeUser(userId, null);
        }
        if (eu == null) {
            throw new EntityNotFoundException("Could not get the current user", "/user/current");
        }
        return eu;
    }

    /**
     * Creates a fake user based on the userId
     * @param userId
     * @return
     */
    private EntityUser makeFakeUser(String userId, String eid) {
        if (eid == null) {
            eid = userId;
        }
        EntityUser eu = new EntityUser(eid, eid+"@dev.null", "First Last-"+userId, eid, null, "fake");
        eu.setId(userId);
        return eu;
    }

    @EntityCustomAction(action="exists", viewKey=EntityView.VIEW_SHOW)
    public boolean checkUserExists(EntityView view) {
        String userId = view.getEntityReference().getId();
        userId = findAndCheckUserId(userId, null);
        boolean exists = (userId != null);
        return exists;
    }


    public boolean entityExists(String id) {
        if (id == null) {
            return false;
        }
        if ("".equals(id)) {
            return true;
        }
        String userId = findAndCheckUserId(id, null);
        if (userId != null) {
            return true;
        }
        return false;
    }

    public String createEntity(EntityReference ref, Object entity, Map<String, Object> params) {
        // FIXME create user
        throw new UnsupportedOperationException("Not possible to create users in K2 right now");
    }

    public Object getSampleEntity() {
        return new EntityUser();
    }

    public void updateEntity(EntityReference ref, Object entity, Map<String, Object> params) {
        // FIXME update user
        throw new UnsupportedOperationException("Not possible to update users in K2 right now");
    }

    public void deleteEntity(EntityReference ref, Map<String, Object> params) {
        // FIXME delete user
        throw new UnsupportedOperationException("Not possible to delete users in K2 right now");
    }

    public Object getEntity(EntityReference ref) {
        if (ref.getId() == null) {
            return new EntityUser();
        }
        String userId = ref.getId();
        // make a fake user
        EntityUser eu = makeFakeUser(userId, null);
        if (developerHelperService.isEntityRequestInternal(ref.toString())) {
            // internal lookups are allowed to get everything
        } else {
            // external lookups require auth
            boolean allowed = false;
            String currentUserRef = developerHelperService.getCurrentUserReference();
            if (currentUserRef != null) {
                String currentUserId = developerHelperService.getUserIdFromRef(currentUserRef);
                if (developerHelperService.isUserAdmin(currentUserId) 
                        || currentUserId.equals(eu.getId())) {
                    // allowed to access the user data
                    allowed = true;
                }
            }
            if (! allowed) {
                throw new SecurityException("Current user ("+currentUserRef+") cannot access information about user: " + ref);
            }
        }
        return eu;         
    }

    /**
     * WARNING: The search results may be drawn from different populations depending on the
     * search parameters specified. A straight listing with no filtering, or a search on "search"
     * or "criteria", will only retrieve matches from the Sakai-maintained user records. A search
     * on "email" may also check the records maintained by the user directory provider.
     */
    public List<?> getEntities(EntityReference ref, Search search) {
        List<EntityUser> users = new ArrayList<EntityUser>();
        users.add( makeFakeUser("az11111", "aaronz") );
        users.add( makeFakeUser("bz22222", "beckyz") );
        users.add( makeFakeUser("mz33333", "minerva") );
        users.add( makeFakeUser("jb44444", "jimbob") );

        log.warn("No way to get a list of users in K2 right now, returning fake ones");
        return users;
    }

    public String[] getHandledInputFormats() {
        return new String[] { Formats.HTML, Formats.XML, Formats.JSON };
    }

    public String[] getHandledOutputFormats() {
        return new String[] { Formats.XML, Formats.JSON };
    }

    /**
     * Allows for easy retrieval of the user object
     * @param userId a user Id (can be eid)
     * @return the user object
     * @throws IllegalArgumentException if the userId is invalid
     */
    public EntityUser getUserById(String userId) {
        return makeFakeUser(userId, null);
    }

    /**
     * Will check that a userId/eid is valid and will produce a valid userId from the check
     * @param currentUserId user id (can be eid)
     * @param currentUserEid user eid (can be id)
     * @return a valid user id OR null if not valid
     */
    public String findAndCheckUserId(String currentUserId, String currentUserEid) {
        if (currentUserId == null && currentUserEid == null) {
            throw new IllegalArgumentException("Cannot get user from a null userId and eid, ensure at least userId or userEid are set");
        }
        String userId = currentUserId;
        // FIXME ultra simplified for fake data
        return userId;
    }

}
