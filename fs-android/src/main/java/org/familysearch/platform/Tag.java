package org.familysearch.platform;

import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * A tag in the FamilySearch system.
 */
@Root (strict = false)
public class Tag implements Serializable
{

  @Attribute (required = false)
  private URI resource;

  public Tag() {
  }

  public Tag( Enum value ) {
    this.resource = URI.create( EnumUtil.toURIValue( value ));
  }

  /**
   * A reference to the value of the tag.
   *
   * @return A reference to the value of the tag.
   */
  public URI getResource() {
    return resource;
  }

  /**
   * A reference to the value of the tag.
   *
   * @param resource A reference to the value of the tag.
   */
  public void setResource( URI resource ) {
    this.resource = resource;
  }
}
