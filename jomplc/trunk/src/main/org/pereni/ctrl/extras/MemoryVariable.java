/*
 * MemoryVariable.java
 *
 * Created on 9 januari 2006, 14:52
 *
 */

package org.pereni.ctrl.extras;

/**
 *
 * @author JanCarel
 */
public class MemoryVariable {
  
  /** Creates a new instance of MemoryVariable.<br>
   * A memory variable has a String memory area e.g. DM HR AR etc
   * and an address in this memory area.
   */
  public MemoryVariable(String memoryArea, int memoryAddress) {
    this.address = memoryAddress;
    this.area = memoryArea;
  }
  
  /**
   * @return the area of this memory variable
   */
  public String getArea(){
    return area;
  }
  
  /**
   * @return the address of this memory variable in the relevant memory area.
   */
  public int getAddress(){
    return address;
  }
  
  public String toString(){
    return area+address;
  }
  
  private String area;
  private int address;
  
}
