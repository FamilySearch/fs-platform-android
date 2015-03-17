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

import org.gedcomx.common.ExtensibleData;
import org.gedcomx.common.TextValue;
import org.gedcomx.common.URI;
import org.gedcomx.records.Field;
import org.gedcomx.records.HasFields;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import java.util.LinkedList;
import java.util.List;


/**
 * A reference to genealogical place.
 */
@Order (elements = {"original", "normalized", "field"})
public class PlaceReference extends ExtensibleData implements HasFields
{

  @Element (required = false)
  private String original;
  @Attribute (name = "description", required = false)
  private URI descriptionRef;
  @ElementList (entry = "field", inline = true, required = false)
  private List<Field> fields;
  @ElementList (entry = "normalized", inline = true, required = false)
  private List<TextValue> normalized;

  /**
   * The original value as supplied by the user.
   *
   * @return The original value as supplied by the user.
   */
  public String getOriginal() {
    return original;
  }

  /**
   * The original value as supplied by the user.
   *
   * @param original The original value as supplied by the user.
   */
  public void setOriginal( String original ) {
    this.original = original;
  }

  /**
   * A reference to a description of the place being referenced.
   *
   * @return A reference to a description of the place being referenced.
   */
  public URI getDescriptionRef() {
    return descriptionRef;
  }

  /**
   * A reference to a description of the place being referenced.
   *
   * @param descriptionRef A reference to a description of the place being referenced.
   */
  public void setDescriptionRef( URI descriptionRef ) {
    this.descriptionRef = descriptionRef;
  }

  /**
   * The references to the record field values being used as evidence.
   *
   * @return The references to the record field values being used as evidence.
   */
  public List<Field> getFields() {
    return fields;
  }

  /**
   * The references to the record field values being used as evidence.
   *
   * @param fields The references to the record field values being used as evidence.
   */
  public void setFields( List<Field> fields ) {
    this.fields = fields;
  }

  /**
   * Add a reference to the record field values being used as evidence.
   *
   * @param field The evidence to be added.
   */
  public void addField( Field field ) {
    if (field != null) {
      if (fields == null) {
        fields = new LinkedList<Field>();
      }
      fields.add( field );
    }
  }

  public List<TextValue> getNormalized() {
      return normalized;
  }

  public void setNormalized(List<TextValue> normalized) {
      this.normalized = normalized;
  }
  
  public String toString() {
    return "PlaceReference{" + "original='" + original + "', " + "descriptionRef='" + descriptionRef + '\'' + '}';
  }


}
