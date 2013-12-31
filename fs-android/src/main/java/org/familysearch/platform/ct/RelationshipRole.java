package org.familysearch.platform.ct;

import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;

/**
 * Enumeration of relationship roles in the FamilySearch Family Tree.
 *
 * @author Reed Ellsworth
 */
/*
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
*/
public enum RelationshipRole
{

  Father,

  Mother,

  Child,

  Man,

  Woman,

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
  public static RelationshipRole fromQNameURI( URI qname ) {
    return EnumUtil.fromURIValue( qname.toString(), RelationshipRole.class );
  }


}
