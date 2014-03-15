/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.conclusion;

import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.IdentifierType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;


/**
 * An identifier for a resource.
 *
 * @author Reed Ellsworth
 */
//@XmlType ( name = "Identifier" )
public final class Identifier
{
  private transient boolean hasUniqueKey = false;
  @Text (required = false)
  private URI value;
  @Attribute (required = false)
  private URI type; // from IdentifierType

  public Identifier() {
  }

  public Identifier( URI value ) {
    this.value = value;
  }

  public Identifier( URI value, IdentifierType knownType ) {
    this.value = value;
    setKnownType( knownType );
  }

  /**
   * The id value.
   *
   * @return The id value.
   */
  public URI getValue() {
    return value;
  }

  /**
   * The id value.
   *
   * @param value The id value.
   */
  public void setValue( URI value ) {
    this.value = value;
  }

  /**
   * The type of the id.
   *
   * @return The type of the id.
   */
  public URI getType() {
    return type;
  }

  /**
   * The type of the id.
   *
   * @param type The type of the id.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * The type of the id.
   *
   * @param type   The type of the id.
   * @param unique Whether the type of this identifier implies that the value is unique among all other identifiers of the same type.
   */
  public void setType( URI type, boolean unique ) {
    this.type = type;
    this.hasUniqueKey = unique;
  }

  /**
   * The enum referencing a known identifier type.
   *
   * @return The enum referencing a known identifier type, or {@link org.gedcomx.types.IdentifierType#OTHER} if not known.
   */
  public IdentifierType getKnownType() {
    return getType() == null ? null : IdentifierType.fromQNameURI( getType() );
  }

  /**
   * Set the value of the id type from a known identifier type.
   *
   * @param knownType The known identifier type.
   */
  public void setKnownType( IdentifierType knownType ) {
    setType(knownType == null ? null : URI.create( EnumUtil.toURIValue( knownType )));
  }


  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (value == null) ? "" : value.toString();
  }

}
