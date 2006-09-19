/*
 * AreaWriteDM.java
 *
 * Created on 9 januari 2006, 10:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.pereni.ctrl.vend.omron.toolbus.commands;

import org.pereni.ctrl.DataImp;
import org.pereni.ctrl.Device;

/**
 *
 * @author JanCarel
 */
public class AreaWriteHR extends MemoryWrite {
  
  public static final String NAME = "WH";
  public static final String DESCRIPTION = "HR Area Write";
  
  protected int address;
  protected int value;
  protected DataImp data=new DataImp();
  
  /** Creates a new instance of AreaWriteDM */
  public AreaWriteHR() {
    setData(data);
  }
  
  public AreaWriteHR(Device device) {
    setData(data);
    setTarget(device);
  }
  
  /**
   * @param address
   * @param value
   */
  public AreaWriteHR(Device device, int address, int[] value, int mode) {
    this();
    setMode(mode);
    setTarget(device);
    this.address = address;
    setValue(address, value);
  }
  
  /**
   * @param address
   * @param value
   */
  public AreaWriteHR(Device device, int address, int[] value) {
    this(device, address, value, MemoryWrite.HEX);
  }
  
      /* (non-Javadoc)
       * @see org.pereni.ctrl.Command#getCommandId()
       */
  public int getCommandId() {
    return NAME.hashCode();
  }
  
    /* (non-Javadoc)
     * @see org.pereni.ctrl.Command#getCommandName()
     */
  public String getCommandName() {
    return NAME;
  }
  
}
