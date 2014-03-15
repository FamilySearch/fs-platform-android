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

import org.gedcomx.common.EvidenceReference;
import org.gedcomx.common.ExtensibleData;
import org.gedcomx.common.Qualifier;
import org.gedcomx.common.URI;
import org.gedcomx.records.Field;
import org.gedcomx.records.HasFields;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.NamePartType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.LinkedList;
import java.util.List;


/**
 * A part of a name.
 *
 * @author Reed Ellsworth
 */
//@XmlType ( name = "NamePart" )
public final class NamePart extends ExtensibleData implements HasFields
{
  @Attribute (required = false)
  private URI type; // from NamePartType
  @Attribute (required = false)
  private String value;
  @ElementList (entry = "qualifier", inline = true, required = false)
  private List<Qualifier> qualifiers;
  @ElementList (entry = "field", inline = true, required = false)
  private List<Field> fields;

  /**
   * The type of the name part.
   *
   * @return The type of the name part.
   */
  public URI getType() {
    return type;
  }

  /**
   * The type of the name part.
   *
   * @param type The type of the name part.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * The enum referencing the known name part type, or {@link org.gedcomx.types.NamePartType#OTHER} if not known.
   *
   * @return The enum referencing the known name part type, or {@link org.gedcomx.types.NamePartType#OTHER} if not known.
   */
  public NamePartType getKnownType() {
    return getType() == null ? null : NamePartType.fromQNameURI( getType() );
  }

  /**
   * Set the type of this name part from an enumeration of known name part types.
   *
   * @param knownType The name part type.
   */
  public void setKnownType( NamePartType knownType ) {
    setType(knownType == null ? null : URI.create( EnumUtil.toURIValue( knownType )));
  }

  /**
   * The value of the name part.
   *
   * @return The value of the name part.
   */
  public String getValue() {
    return value;
  }

  /**
   * The value of the name part.
   *
   * @param value The value of the name part.
   */
  public void setValue( String value ) {
    this.value = value;
  }

  /**
   * The qualifiers associated with this name part.
   *
   * @return The qualifiers associated with this name part.
   */
  public List<Qualifier> getQualifiers() {
    return qualifiers;
  }

  /**
   * Set the qualifiers associated with this name part.
   *
   * @param qualifiers qualifiers to associate with this name part
   */
  public void setQualifiers( List<Qualifier> qualifiers ) {
    this.qualifiers = qualifiers;
  }

  /**
   * Add a qualifier associated with this name part.
   *
   * @param qualifier The qualifier to be added.
   */
  public void addQualifier( Qualifier qualifier ) {
    if (qualifier != null) {
      if (qualifiers == null) {
        qualifiers = new LinkedList<Qualifier>();
      }
      qualifiers.add( qualifier );
    }
  }

  /**
   * Get the fields being used as evidence.
   *
   * @return The record fields being used as evidence.
   */
  public List<Field> getFields() { return fields;  }

  /**
   * Set the list of fields being used as evidence.
   *
   * @param fields - List of fields
   */
  public void setFields( List<Field> fields ) {
    this.fields = fields;
  }

  /**
   * Add a field to the record fields being used as evidence.
   *
   * @param field The field to be added.
   */
  public void addField( Field field ) {
    if (field != null) {
      if (fields == null) {
        fields = new LinkedList<Field>();
      }
      fields.add( field );
    }
  }

}
