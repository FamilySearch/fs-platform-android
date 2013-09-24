package org.familysearch.platform.ct;

import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;

/**
 * The set of operations applicable to FamilySearch data.
 *
 * @author Reed Ellsworth
 */
/*
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
*/
public enum ChangeOperation
{

  Create,

  Read,

  Update,

  Delete,

  Merge,

  Unmerge,

  Restore;

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
  public static ChangeOperation fromQNameURI( URI qname ) {
    return EnumUtil.fromURIValue( qname.toString(), ChangeOperation.class );
  }


}
