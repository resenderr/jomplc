/**
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pereni.ctrl.Data;
import org.pereni.ctrl.Device;



/**
 * @author Remus
 * 
 */
public abstract class AbstractMessage implements Message {

    protected StatusCode responseStatusCode = null;
    
    protected Device targetDevice;

    protected Data reply = null;

    protected Data data = null;

    protected boolean hasReply = false;
    
    protected Log log;
    

    /*
     * (non-Javadoc)
     * 
     * @see org.pereni.ctrl.comm.Message#setTarget(org.pereni.ctrl.Device)
     */
    public void setTarget(Device target) {
        targetDevice = target;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.pereni.ctrl.comm.Message#getTarget()
     */
    public Device getTarget() {
        return targetDevice;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.pereni.ctrl.comm.Message#setData(org.pereni.ctrl.Data)
     */
    public void setData(Data data) {
        this.data = data;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.pereni.ctrl.comm.Message#getData()
     */
    public Data getData() {
        return data;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.pereni.ctrl.comm.Message#hasReply()
     */
    public boolean hasReply() {
        return hasReply;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.pereni.ctrl.Command#getCommandDescription()
     */
    public String getCommandDescription() {
        return "";
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.pereni.ctrl.comm.Message#getReply()
     */
    public Data getReply() {
        return reply;
    }
    
    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.Message#setReply(org.pereni.ctrl.Data)
     */
    public void setReply(Data replyRawData) {
        reply = replyRawData;
        if( replyRawData != null ) setHasReply(true);
    }

    
    /**
     * @param hasReply The hasReply to set.
     */
    public void setHasReply(boolean hasReply) {
        this.hasReply = hasReply;
    }

    
    
    /* (non-Javadoc)
     * @see org.pereni.ctrl.Command#getExpectedReplyType()
     */
    public int getExpectedReplyType() {
        return -1;
    }

    
    /**
     * @return Returns the log.
     */
    public Log getLog() {
        if( log != null ) return log;
        
        log = LogFactory.getLog("message." + getCommandName());
        return log;
    }

    /**
     * @param log The log to set.
     */
    public void setLog(Log log) {
        this.log = log;
    }
    
    
    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.Message#getResponseStatusCode()
     */
    public StatusCode getResponseStatusCode() {
        return responseStatusCode;
    }
    

    /**
     * @param responseStatusCode The responseStatusCode to set.
     */
    public void setResponseStatusCode(StatusCode responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }


}
