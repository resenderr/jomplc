/*
 * $Id: DataImp.java,v 1.6 2005/10/24 13:53:51 remus Exp $
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
package org.pereni.ctrl;



/**
 * @author <a href="http://remus.pereni.org>Remus Pereni</a>
 *
 */
public class DataImp implements Data {

    protected int[] store;
    protected int length = 0;
    
    /**
     * 
     */
    public DataImp() {
       
    }

    public DataImp(int[] data) {
        set(data);
    }

    
    public DataImp(String data) {
        set(data);
    }

    
    
    /**
     * 
     */
    public DataImp(int size) {
        createStore(size);
    }
    
    
    public void set(String value) {
        if( value == null ) return;
        length = value.length();
        createStore(length);
        for( int cnt = 0; cnt < value.length(); cnt++) {
            store[cnt] = (char)value.charAt(cnt);
        }
    }
    
    
    public void set(int[] value) {
        if( value == null ) return;
        store = value;
        length = value.length;
    }
    
    
    public void set(int value) {
        createStore(1);
        store[0] = value;
    }
    
    
    /* (non-Javadoc)
     * @see org.pereni.ctrl.Data#getLength()
     */
    public int getLength() {
        return length;
    }
    

    /* (non-Javadoc)
     * @see org.pereni.ctrl.Data#toIntArray()
     */
    public int[] toIntArray() {
        if( length == 0 ) return null;
        if( store != null && length == store.length ) return store;
        
        int[] result = new int[length];
        System.arraycopy(store, 0, result, 0, length);
        return result;
    }


    protected void createStore(int size) {
        store = new int[size];
    }

    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String     result = "";
        int[] messageBody = toIntArray();
        
        for( int idx = 0 ; idx < length; idx++) {
            if( Character.isLetter(messageBody[idx])) {
                result += (char) messageBody[idx];
            } else {
                result += (char) messageBody[idx];
            }
        }
        
        return result;    
    }
    
}
