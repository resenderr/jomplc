/*
 * $Id: StatusCodeImp.java,v 1.1 2005/07/04 12:26:11 remus Exp $
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
 * The default implementation of a status code.
 * 
 * @author <a href="http://remus.pereni.org">Remus Pereni</a>
 * @version $Revision: 1.1 $ $Date: 2005/07/04 12:26:11 $
 */
public class StatusCodeImp implements StatusCode {
    
    protected String        code = "";
    protected int             id = code.hashCode();
    protected String description = "";
    protected int       severity = UNKNOWN;
    
    
        
    /**
     * @param id
     * @param code
     * @param severity
     * @param description
     */
    public StatusCodeImp(int id, String code, int severity, String description) {
        super();
        this.code = code;
        this.description = description;
        this.id = id;
        this.severity = severity;
    }



    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.StatusCode#getId()
     */
    public int getId() {
        return id;
    }

    
    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.StatusCode#getCode()
     */
    public String getCode() {
        return code;
    }

    
    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.StatusCode#getSeverity()
     */
    public int getSeverity() {
        return severity;
    }



    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.StatusCode#getDescription()
     */
    public String getDescription() {
        return description;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return id + "/" + code + " - " + description;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if( obj == null || ! (obj instanceof StatusCode) ) return false;
        
        return ((StatusCode)obj).getId() == getId() && ((StatusCode)obj).getCode().equals(getCode());
    }

    
    
    
}
