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
import org.gedcomx.common.TextValue;
import org.gedcomx.records.Field;
import org.gedcomx.records.HasFields;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.LinkedList;
import java.util.List;

/**
 * A concluded genealogical date.
 */
@Root (strict = false)
//@ClientName ("DateInfo")
@Order (elements = {"original", "formal", "normalized", "field"})
public class Date extends ExtensibleData implements HasFields
{

  @Element (required = false)
  private String original;
  @Element (required = false)
  private String formal;
  @ElementList (entry = "normalized", inline = true, required = false)
  private List<TextValue> normalized;
  @ElementList (entry = "field", inline = true, required = false)
  private List<Field> fields;

  /**
   * The original text as supplied by the user.
   *
   * @return The original text as supplied by the user.
   */
  public String getOriginal() {
    return original;
  }

  /**
   * The original text as supplied by the user.
   *
   * @param original The original text as supplied by the user.
   */
  public void setOriginal( String original ) {
    this.original = original;
  }

  /**
   * The standardized and/or normalized formal value.
   *
   * @return The formal value.
   */
  public String getFormal() {
    return formal;
  }

  /**
   * The standardized and/or normalized formal value.
   *
   * @param formal The formal value.
   */
  public void setFormal( String formal ) {
    this.formal = formal;
  }

  /**
   * The list of normalized values for the date, provided for display purposes by the application. Normalized values are
   * not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   *
   * @return The list of normalized values for the date, provided for display purposes by the application. Normalized values
   *         are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   */
  public List<TextValue> getNormalizedExtensions() {
    return normalized;
  }

  /**
   * The list of normalized values for the date, provided for display purposes by the application. Normalized values are
   * not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   *
   * @param normalized The list of normalized values for the date, provided for display purposes by the application. Normalized values are
   *                   not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   */
  public void setNormalizedExtensions( List<TextValue> normalized ) {
    this.normalized = normalized;
  }

  /**
   * Add a normalized extension to the list.
   *
   * @param normalizedExtension The normalizedExtension to be added.
   */
  public void addNormalizedExtension( TextValue normalizedExtension ) {
    if (normalizedExtension != null) {
      if (normalized == null) {
        normalized = new LinkedList<TextValue>();
      }
      normalized.add( normalizedExtension );
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

  @Override
  public String toString() {
    return "Date{" + "original='" + original + '\'' + ", formal=" + formal + '}';
  }

}
