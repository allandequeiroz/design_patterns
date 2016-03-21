/**
 * $Id: EntitySession.java 59798 2009-04-13 16:18:49Z aaronz@vt.edu $
 * $URL: https://source.sakaiproject.org/contrib/caret/osgi-eb/tags/eb-1.0/eb-webapp/src/main/java/org/sakaiproject/eb/rest/providers/model/EntitySession.java $
 * EntitySession.java - entity-broker - Jul 15, 2008 4:05:44 PM - azeckoski
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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.sakaiproject.entitybus.entityprovider.annotations.EntityId;
import org.sakaiproject.entitybus.entityprovider.annotations.EntityLastModified;

/**
 * This models a Sakai Session and hopefully provides all the information one might need about a session,
 * attributes which are passed back are limited for security reasons
 * 
 * @author Aaron Zeckoski (azeckoski @ gmail.com)
 */
@SuppressWarnings("deprecation")
public class EntitySession implements HttpSession {

    @EntityId
    private String id;
    private long creationTime;
    private long lastAccessedTime;
    private int maxInactiveInterval;
    private String userId;

    private long currentTime = System.currentTimeMillis();
    public long getCurrentTime() {
        currentTime = System.currentTimeMillis();
        return currentTime;
    }

    public Map<String, Object> attributes;

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        if (attributes == null) {
            attributes = new HashMap<String, Object>();
        }
        return attributes;
    }

    public void setAttribute(String key, Object value) {
        if (attributes == null) {
            attributes = new HashMap<String, Object>();
        }
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        if (attributes == null) {
            return null;
        }
        return attributes.get(key);
    }

    public EntitySession() {}

    private transient HttpSession session;

    @SuppressWarnings("unchecked")
    public EntitySession(HttpSession session) {
        this.session = session;
        this.creationTime = session.getCreationTime();
        this.id = session.getId();
        this.lastAccessedTime = session.getLastAccessedTime();
        this.maxInactiveInterval = session.getMaxInactiveInterval();
        // get the attributes out
        this.attributes = new HashMap<String, Object>();
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            String key = names.nextElement();
            Object value = session.getAttribute(key);
            this.attributes.put(key, value);
        }
        this.userId = (String) this.attributes.get("user");
        if (this.userId == null) {
            
        }
    }

    public EntitySession(String userId, int maxInactiveInterval) {
        this.creationTime = System.currentTimeMillis();
        this.lastAccessedTime = System.currentTimeMillis();
        this.maxInactiveInterval = maxInactiveInterval;
        this.userId = userId;
    }

    @EntityId
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    @EntityLastModified
    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void setLastAccessedTime(long lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }

    public int getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public void setMaxInactiveInterval(int maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // END BASIC GETTERS and SETTERS

    @SuppressWarnings("unchecked")
    public Enumeration getAttributeNames() {
        if (session != null) {
            return session.getAttributeNames();
        }
        throw new UnsupportedOperationException();
    }

    public void invalidate() {
        if (session != null) {
            session.invalidate();
        }
    }

    public void removeAttribute(String key) {
        if (session != null) {
            session.removeAttribute(key);
        }
        if (attributes != null) {
            attributes.remove(key);
        }
    }

    // Session methods

    public ServletContext getServletContext() {
        ServletContext context = null;
        if (this.session != null) {
            context = this.session.getServletContext();
        }
        return context;
    }

    public HttpSessionContext getSessionContext() {
        HttpSessionContext context = null;
        if (this.session != null) {
            context = this.session.getSessionContext();
        }
        return context;
    }

    public boolean isNew() {
        boolean isnew = false;
        if (this.session != null) {
            isnew = this.session.isNew();
        }
        return isnew;
    }

    public Object getValue(String name) {
        Object value = null;
        if (this.session != null) {
            value = this.session.getValue(name);
        }
        return value;
    }

    public String[] getValueNames() {
        String[] names = null;
        if (this.session != null) {
            names = this.session.getValueNames();
        }
        return names;
    }

    public void putValue(String name, Object value) {
        if (session != null) {
            session.putValue(name, value);
        }
    }

    public void removeValue(String name) {
        if (session != null) {
            session.removeValue(name);
        }
    }

}
