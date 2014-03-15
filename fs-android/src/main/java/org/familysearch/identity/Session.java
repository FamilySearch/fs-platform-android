package org.familysearch.identity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root (strict = false)
public class Session
{
  @Attribute (required = false)
  public String id;
}
