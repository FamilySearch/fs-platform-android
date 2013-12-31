package org.familysearch.platform.users;

import org.gedcomx.common.TextValue;
import org.gedcomx.common.URI;
import org.simpleframework.xml.Attribute;


public class AgentName extends TextValue
{
  @Attribute (required = false)
  private URI type;

  public AgentName() {
  }

  public AgentName( URI type, String name ) {
    this( type, name, null );
  }

  public AgentName( URI type, String name, String lang ) {
    this.setType( type );
    this.setLang( lang );
    this.setValue( name );
  }

  public URI getType() {
    return type;
  }

  public void setType( URI type ) {
    this.type = type;
  }
}
