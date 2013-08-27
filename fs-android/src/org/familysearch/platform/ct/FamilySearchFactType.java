package org.familysearch.platform.ct;

import org.gedcomx.common.URI;

/**
 * Enumeration of FamilySearch-specific fact types.
 */
/*
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
*/
public enum FamilySearchFactType
{

  /**
   * Affiliation to something.
   */
  Affiliation,

  /**
   * Person died before age eight.
   */
  DiedBeforeEight,

  /**
   * Person's title of nobility.
   */
  TitleOfNobility,

  /**
   * Person's tribe name.
   */
  TribeName,

  /**
   * A child's birth order to parents.
   */
  BirthOrder,

  //  @XmlUnknownQNameEnumValue
  OTHER;

  /**
   * Return the QName value for this enum.
   *
   * @return The QName value for this enum.
   */
  public URI toQNameURI() {
    return null; // org.gedcomx.common.URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(this));
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static FamilySearchFactType fromQNameURI( URI qname ) {
    return null; // org.codehaus.enunciate.XmlQNameEnumUtil.fromURIValue(qname.toString(), FamilySearchFactType.class);
  }

}
