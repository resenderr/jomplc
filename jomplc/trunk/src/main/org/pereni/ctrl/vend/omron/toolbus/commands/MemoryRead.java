/*
 * $Id: MemmoryRead.java,v 1.1 2005/07/27 09:52:50 remus Exp $
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
package org.pereni.ctrl.vend.omron.toolbus.commands;

import java.text.DecimalFormat;

import org.pereni.ctrl.DataImp;
import org.pereni.ctrl.utils.OmronUtils;


/**
 *
 * @author <a href="http://remus.pereni.org">Remus Pereni</a>
 * @version $Revision: 1.1 $ $Date: 2005/07/27 09:52:50 $
 */
public abstract class MemoryRead extends ToolbusCommand {
    
    protected int address = 0;
    protected int length = 1;
    
    public static final DecimalFormat FORMAT = new DecimalFormat("0000");
    
    

    /**
     * @return Returns the address.
     */
    public int getAddress() {
        return address;
    }


    /**
     * @param address The address to set.
     */
    public void setAddress(int address) {
        this.address = address;
        ((DataImp)getData()).set(new OmronUtils().getFormatedHex(address) + FORMAT.format(getLength()));
    }


    /**
     * @return Returns the length.
     */
    public int getLength() {
        return length;
    }


    /**
     * @param length The length to set.
     */
    public void setLength(int length) {
        this.length = length;
        ((DataImp)getData()).set(new OmronUtils().getFormatedHex(address) + FORMAT.format(getLength()));
    }
    
    

    
}
