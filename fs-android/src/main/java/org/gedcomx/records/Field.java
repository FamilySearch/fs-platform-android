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
package org.gedcomx.records;

import org.gedcomx.common.URI;
import org.gedcomx.links.HypermediaEnabledData;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.FieldType;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * A field of a record.
 */
@Root (strict = false)
@Order (elements = {"label", "value"})
public class Field extends HypermediaEnabledData
{
  @Element (required = false)
  private String label;
  @Attribute (required = false)
  private URI type; // from FieldType
  @ElementList (entry = "value", required = false)
  private List<FieldValue> values;

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
   * The known type of the field.
   *
   * @return The type of the field.
   */
  public FieldType getKnownType() {
    return getType() == null ? null : FieldType.fromQNameURI( getType() );
  }

  /**
   * The type of the field.
   *
   * @param type The type of the field.
   */
  public void setKnownType( FieldType type ) {
    setType(type == null ? null : URI.create( EnumUtil.toURIValue( type )));
  }


  /**
   * A unique label for the field.
   *
   * @return A unique label for the field.
   */
  public String getLabel() {
    return label;
  }

  /**
   * A unique label for the field.
   *
   * @param label A unique label for the field.
   */
  public void setLabel( String label ) {
    this.label = label;
  }

  /**
   * The set of values for the field.
   *
   * @return The set of values for the field.
   */
  public List<FieldValue> getValues() {
    return values;
  }

  /**
   * The set of values for the field.
   *
   * @param values The set of values for the field.
   */
  public void setValues( List<FieldValue> values ) {
    this.values = values;
  }


}
