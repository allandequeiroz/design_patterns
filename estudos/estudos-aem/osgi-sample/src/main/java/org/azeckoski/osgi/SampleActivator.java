/**
 * $Id: SampleActivator.java 59782 2009-04-13 12:24:04Z aaronz@vt.edu $
 * $URL: https://source.sakaiproject.org/contrib/caret/osgi-sample/tags/sample-1.1/src/main/java/org/azeckoski/osgi/SampleActivator.java $
 * SampleActivator.java - osgi-sample - Apr 13, 2009 1:06:02 PM - azeckoski
 **************************************************************************
 * Copyright (c) 2008 Aaron Zeckoski
 * Licensed under the Apache License, Version 2.0
 * 
 * A copy of the Apache License has been included in this 
 * distribution and is available at: http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Aaron Zeckoski (azeckoski @ gmail.com) (aaronz @ vt.edu) (aaron @ caret.cam.ac.uk)
 */

package org.azeckoski.osgi;

import java.util.Date;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * This will activate the very simple bundle and print messages on start and stop
 * 
 * @author Aaron Zeckoski (azeckoski @ gmail.com)
 */
public class SampleActivator implements BundleActivator {
    /* (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        System.out.println("Sample starting at: " + new Date());
    }

    /* (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        System.out.println("Sample stopping at: " + new Date());
    }
}
