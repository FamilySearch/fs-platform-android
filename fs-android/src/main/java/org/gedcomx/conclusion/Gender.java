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
import org.gedcomx.common.URI;
import org.gedcomx.records.Field;
import org.gedcomx.records.HasFields;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.GenderType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.LinkedList;
import java.util.List;

/**
 * A gender conclusion.
 *
 * @author Reed Ellsworth
 */
@Root ( strict = false )
public class Gender extends Conclusion implements HasFields
{
  @Attribute (required = false)
  private URI type; // from GenderType
  @ElementList (entry = "field", inline = true, required = false)
  private List<Field> fields;

  /**
   * Default constructor.
   */
  public Gender() {
  }

  /**
   * Constructs a new gender object with the passed in type.
   *
   * @param type The type of the gender.
   */
  public Gender( GenderType type ) {
    setKnownType( type );
  }

  /**
   * The type of the gender.
   *
   * @return The type of the gender.
   */
  public URI getType() {
    return type;
  }

  /**
   * The type of the gender.
   *
   * @param type The type of the gender.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * The known type of the gender.
   *
   * @return The type of the gender.
   */
  public GenderType getKnownType() {
    return getType() == null ? null : GenderType.fromQNameURI( getType() );
  }

  /**
   * The type of the gender.
   *
   * @param type The type of the gender.
   */
  public void setKnownType( GenderType type ) {
    setType(type == null ? null : URI.create( EnumUtil.toURIValue( type )));
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

  @Override
  public String toString() {
    return "type=" + getKnownType();
  }


}
