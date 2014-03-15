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

import org.gedcomx.common.EvidenceReference;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.Conclusion;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.FieldValueType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.LinkedList;
import java.util.List;


/**
 * An element representing a value in a record field.
 */
//@XmlType (name = "FieldValue")
public final class FieldValue extends Conclusion
{
  /**
   * @see FieldValueType
   */
  @Attribute (required = false)
  private URI type; // from FieldValueType
  @Element (required = false)
  private String text;
  @Attribute (required = false)
  private URI datatype;
  @Attribute (required = false)
  private URI resource;
  @Attribute (required = false)
  private String labelId;

  public FieldValue() {
  }

  public FieldValue( String text ) {
    this.text = text;
  }

  /**
   * The type of the field value.
   *
   * @return The type of the field value.
   */
  public URI getType() {
    return type;
  }

  /**
   * The type of the field value.
   *
   * @param type The type of the field value.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * The known type of the field value.
   *
   * @return The type of the field value.
   */
  public FieldValueType getKnownType() {
    return getType() == null ? null : FieldValueType.fromQNameURI( getType() );
  }

  /**
   * The type of the field value.
   *
   * @param type The type of the field value.
   */
  public void setKnownType( FieldValueType type ) {
    setType(type == null ? null : URI.create( EnumUtil.toURIValue( type )));
  }

  /**
   * The id of the label applicable to this field value.
   *
   * @return The id of the label applicable to this field value.
   */
  public String getLabelId() {
    return labelId;
  }

  /**
   * The id of the label applicable to this field value.
   *
   * @param labelId The id of the label applicable to this field value.
   */
  public void setLabelId(String labelId) {
    this.labelId = labelId;
  }

  /**
   * The text value.
   *
   * @return The text value.
   */
  public String getText() {
    return text;
  }

  /**
   * The text value.
   *
   * @param text The text value.
   */
  public void setText( String text ) {
    this.text = text;
  }

  /**
   * The datatype of the text value of the field.
   *
   * @return The datatype of the text value of the field.
   */
  public URI getDatatype() {
    return datatype;
  }

  /**
   * The datatype of the text value of the field.
   *
   * @param datatype The datatype of the text value of the field.
   */
  public void setDatatype( URI datatype ) {
    this.datatype = datatype;
  }

  /**
   * URI that resolves to the value of the field.
   *
   * @return URI that resolves to the value of the field.
   */
  public URI getResource() {
    return resource;
  }

  /**
   * URI that resolves to the value of the field.
   *
   * @param resource URI that resolves to the value of the field.
   */
  public void setResource( URI resource ) {
    this.resource = resource;
  }
}
