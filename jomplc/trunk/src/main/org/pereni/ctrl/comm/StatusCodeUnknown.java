/*
 * $Id: StatusCodeUnknown.java,v 1.3 2005/10/24 13:54:55 remus Exp $
 *
 *  Copyright [2005] [Remus Pereni http://remus.pereni.org]
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.pereni.ctrl.comm;

/**
 *
 * @author <a href="http://remus.pereni.org">Remus Pereni</a>
 * @version $Revision: 1.3 $ $Date: 2005/10/24 13:54:55 $
 */
public class StatusCodeUnknown implements StatusCode {

    
    protected static StatusCodeUnknown instance = new StatusCodeUnknown();
    
    
    /**
     * 
     */
    protected StatusCodeUnknown() {

    }

    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.StatusCode#getId()
     */
    public int getId() {
        return -1;
    }

    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.StatusCode#getCode()
     */
    public String getCode() {
        return CODE_UNKNOWN;
    }

    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.StatusCode#getSeverity()
     */
    public int getSeverity() {
        return UNKNOWN;
    }

    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.StatusCode#getDescription()
     */
    public String getDescription() {
        return "Unknown to protocol status code received";
    }
    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getId() + "/" + getCode() + " - " + getDescription();
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if( obj == null || ! (obj instanceof StatusCode) ) return false;
        
        return ((StatusCode)obj).getId() == getId() && ((StatusCode)obj).getCode().equals(getCode());
    }


    public static StatusCodeUnknown getInstance() {
        return instance;
    }
}
