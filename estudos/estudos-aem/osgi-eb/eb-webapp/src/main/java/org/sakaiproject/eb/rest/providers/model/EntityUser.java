/**
 * $Id: EntityUser.java 59798 2009-04-13 16:18:49Z aaronz@vt.edu $
 * $URL: https://source.sakaiproject.org/contrib/caret/osgi-eb/tags/eb-1.0/eb-webapp/src/main/java/org/sakaiproject/eb/rest/providers/model/EntityUser.java $
 * EntityUser.java - entity-broker - Jun 28, 2008 5:24:57 PM - azeckoski
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

package org.sakaiproject.eb.rest.providers.model;

import java.util.HashMap;
import java.util.Map;

import org.sakaiproject.entitybus.entityprovider.annotations.EntityId;
import org.sakaiproject.entitybus.entityprovider.annotations.EntityLastModified;
import org.sakaiproject.entitybus.entityprovider.annotations.EntityOwner;
import org.sakaiproject.entitybus.entityprovider.annotations.EntityTitle;


/**
 * This class is needed to allow input and output of user data
 * 
 * @author Aaron Zeckoski (azeckoski @ gmail.com)
 */
public class EntityUser {

    @EntityId
    private String id;
    private String eid;
    private String password;
    private String email;
    private String displayName;
    private String sortName;
    private String type;
    private String owner;
    private long lastModified;
    public Map<String, String> props;

    public EntityUser() {}

//    private transient UserInfo userInfo;
//
//    /**
//     * Construct an EntityUser from a legacy user object
//     * @param user a legacy user or user edit
//     */
//    public EntityUser(UserInfo userInfo) {
//        this.userInfo = userInfo;
//        User user = userInfo.getUser();
//        this.id = user.getUuid();
//        //this.eid = user.getEid(); // No more eid in K2
//        this.email = userInfo.getProperty("email");
//        this.firstName = userInfo.getProperty("firstName");
//        this.lastName = userInfo.getProperty("lastName");
//        this.displayName = userInfo.getProperty("displayName");
//        this.owner = userInfo.getProperty("owner");
//        this.lastModified = userInfo.getProperty(JCRConstants.JCR_LASTMODIFIED) == null ? System.currentTimeMillis() : Long.parseLong(userInfo.getProperty(JCRConstants.JCR_LASTMODIFIED));
//    }

    public EntityUser(String eid, String email, String displayName,
            String sortName, String password, String type) {
        this.eid = eid;
        this.password = password;
        this.email = email;
        this.displayName = displayName;
        this.sortName = sortName;
        this.type = type;
    }

    public void setProperty(String key, String value) {
        if (props == null) {
            props = new HashMap<String, String>();
        }
        props.put(key, value);
    }

    public String getProperty(String key) {
        if (props == null) {
            return null;
        }
        return props.get(key);
    }

    @EntityOwner
    public String getOwner() {
        return owner;
    }

    @EntityLastModified
    public long getLastModified() {
        return lastModified;
    }

    @EntityId
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @EntityTitle
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public String getSortName() {
        return sortName;
    }
    
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> getProps() {
        if (props == null) {
            props = new HashMap<String,String>();
        }
        return props;
    }

    public void setProps(Map<String, String> props) {
        this.props = props;
    }

    public String getUuid() {
        return this.id;
    }

}
