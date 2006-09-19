/*
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
package org.pereni.ctrl.vend.omron.toolbus.commands;


import org.pereni.ctrl.DataImp;
import org.pereni.ctrl.Device;


/**
 * @author Remus
 *
 */
public class AreaReadDM extends MemoryRead{

    
    public static final String NAME = "RD";
    public static final String DESCRIPTION = "DM Area Read";
   
    
    /**
     * 
     */
    public AreaReadDM() {
        setData(new DataImp());   
    }

    
    public AreaReadDM(Device target, int startAddr, int length) {
        this();
        setTarget(target);
        setAddress(startAddr);
        setLength(length);
    }

    /* (non-Javadoc)
     * @see org.pereni.ctrl.Command#getCommandId()
     */
    public int getCommandId() {
        return 1;
    }


    /* (non-Javadoc)
     * @see org.pereni.ctrl.Command#getCommandName()
     */
    public String getCommandName() {
        return NAME;
    }


    /* (non-Javadoc)
     * @see org.pereni.ctrl.comm.AbstractMessage#getCommandDescription()
     */
    @Override
    public String getCommandDescription() {
        return DESCRIPTION;
    }

   
    

}
