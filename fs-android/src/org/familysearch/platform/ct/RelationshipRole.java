package org.familysearch.platform.ct;

import org.gedcomx.common.URI;

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
    return null; // URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(this));
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static RelationshipRole fromQNameURI( URI qname ) {
    return null; // org.codehaus.enunciate.XmlQNameEnumUtil.fromURIValue(qname.toString(), RelationshipRole.class);
  }


}
