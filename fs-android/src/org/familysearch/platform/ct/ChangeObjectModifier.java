package org.familysearch.platform.ct;

import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;

/**
 * Enumeration of the possible change object modifiers.
 *
 * @author Reed Ellsworth
 */
/*
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
*/
public enum ChangeObjectModifier
{

  /**
   * The person.
   */
  //@XmlQNameEnumValue( namespace = GedcomxConstants.GEDCOMX_TYPES_NAMESPACE )
  Person,

  /**
   * The couple.
   */
  //@XmlQNameEnumValue( namespace = GedcomxConstants.GEDCOMX_TYPES_NAMESPACE )
  Couple,

  /**
   * The child-and-parents relationship.
   */
  ChildAndParentsRelationship;

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
  public static ChangeObjectModifier fromQNameURI( URI qname ) {
    return EnumUtil.fromURIValue( qname.toString(), ChangeObjectModifier.class );
  }


}
