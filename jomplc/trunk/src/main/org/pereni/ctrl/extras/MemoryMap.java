/*
 * MemoryMap.java
 *
 * Created on 9 januari 2006, 16:19
 *
 */

package org.pereni.ctrl.extras;

import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pereni.ctrl.Data;
import org.pereni.ctrl.vend.omron.toolbus.commands.MemoryRead;

/**
 *
 * @author JanCarel
 */
public class MemoryMap {
  
  /** Creates a new instance of MemoryMap
   * This is a hashmap with all the memory variables that have been read.
   * Convenience method to be able to look up the variables quickly.
   */
  protected MemoryMap() {
    memory = new HashMap();
    log = LogFactory.getLog(getClass().getName());
  }
  
  /**
   * handle to the instance of this memory map
   */
  private static MemoryMap _instance;
  
  /**
   * @return the singleton MemoryMap
   */
  public static MemoryMap getInstance(){
    if(_instance == null){
      _instance = new MemoryMap();
    }
    return _instance;
  }
  
  /**
   * add a value to the memory map
   * @param m the memory variable to add
   * @param val the value of this memory variable
   */
  public void addValue(MemoryVariable m, int val){
    Integer i = new Integer(val);
    memory.put(m.toString(), i);
  }
  
  /**
   * get a value for a memoryvariable
   * can also be io area
   * @param m the memory variable to get the value of
   */
  public int getValue(MemoryVariable m){
    if(memory.get(m.toString()) != null){
      int i = ((Integer)memory.get(m.toString())).intValue();
      return i;
    }
    return 0;
  }
  
  /**
   * pop data from a reply into the memory map
   */
  public void process(MemoryRead mr, int mode){
    Data m = mr.getReply();
    String whichMemory = "";
    if(mr.getCommandName().equalsIgnoreCase("RD")){
      whichMemory = "DM";
    }else if(mr.getCommandName().equalsIgnoreCase("RH")){
      whichMemory = "HR";
    }else if(mr.getCommandName().equalsIgnoreCase("RR")){
      whichMemory = "IO";
    }else{
      log.error("could not place memory area for command name "+mr.getCommandName());
      return;
    }
    int[]dataBuff = m.toIntArray();
    int start = mr.getAddress();
    int length = mr.getLength();
    for (int i=0; i < length; i++){
      String val = "";
      for (int j=0 ; j < 4 ; j++){
        val = val + (char)dataBuff[i*4 + j];
      }
      int h=0;
      if(mode == BCD){
        try {
          h = Integer.parseInt(val.trim());
        } catch (NumberFormatException ex) {
          log.debug("NumberFormatException in parsing BCD values");
        }
      }else{
        try {
          /* convert a hex String to int -- Note, there is no lead 0x, case insensitive  */
          h = Integer.parseInt( val.trim(), 16 /* radix */ );
        } catch (NumberFormatException ex) {
          log.debug("NumberFormatException in parsing HEX values");
        }
      }
      addValue(new MemoryVariable(whichMemory, start+i), h);
      
    }
  }
  
  private Log log;
  private HashMap memory;
  public static final int HEX = 1;
  public static final int BCD = 2;
}
