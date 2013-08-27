package org.gedcomx.common;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Reed Ellsworth
 */
@Root (strict = false)
public class UniqueCustomKeyedItem
{

  @Element (required = false)
  private String key = String.valueOf( hashCode() );
  @Element (required = false)
  private String val1;
  @Element (required = false)
  private String val2;


  public String getKey() {
    return key;
  }

  public void setKey( String key ) {
    this.key = key;
  }

  public String getVal1() {
    return val1;
  }

  public void setVal1( String val1 ) {
    this.val1 = val1;
  }

  public String getVal2() {
    return val2;
  }

  public void setVal2( String val2 ) {
    this.val2 = val2;
  }
}
