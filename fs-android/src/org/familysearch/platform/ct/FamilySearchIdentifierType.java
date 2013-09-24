package org.familysearch.platform.ct;

import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;

/**
 * Enumeration of FamilySearch-specific identifier types.
 */
/*
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
*/
public enum FamilySearchIdentifierType
{

  /**
   * The identifier for the parent relationship pair for a given relationship.
   */
  ChildAndParentsRelationship,

  //  @XmlUnknownQNameEnumValue
  OTHER;

  /**
   * Return the QName value for this enum.
   *
   * @return The QName value for this enum.
   */
  public URI toQNameURI() {
    return URI.create( EnumUtil.toURIValue( this ));
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static FamilySearchIdentifierType fromQNameURI( URI qname ) {
    return EnumUtil.fromURIValue( qname.toString(), FamilySearchIdentifierType.class );
  }
}
