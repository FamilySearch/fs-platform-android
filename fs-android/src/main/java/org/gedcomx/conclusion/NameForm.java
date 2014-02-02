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
import org.gedcomx.records.Field;
import org.gedcomx.records.HasFields;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import java.util.LinkedList;
import java.util.List;

/**
 * A form of a name.
 *
 * @author Reed Ellsworth
 */
@Order (elements = {"fullText", "part", "field"})
public class NameForm extends ExtensibleData implements HasFields
{

  @Attribute (required = false)
  private String lang;
  @Element (required = false)
  private String fullText;
  @ElementList (entry = "part", inline = true)
  private List<NamePart> parts;
  @ElementList (entry = "field", inline = true, required = false)
  private List<Field> fields;

  /**
   * The language of the conclusion. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of the conclusion.
   */
  public String getLang() {
    return lang;
  }

  /**
   * The language of the conclusion. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of the conclusion.
   */
  public void setLang( String lang ) {
    this.lang = lang;
  }

  /**
   * The full text of the name form.
   *
   * @return The full text of the name form.
   */
  public String getFullText() {
    return fullText;
  }

  /**
   * The full text of the name form.
   *
   * @param fullText The full text of the name form.
   */
  public void setFullText( String fullText ) {
    this.fullText = fullText;
  }

  /**
   * The different parts of the name form.
   *
   * @return The different parts of the name form.
   */
  public List<NamePart> getParts() {
    return parts;
  }

  /**
   * The different parts of the name form.
   *
   * @param parts The different parts of the name form.
   */
  public void setParts( List<NamePart> parts ) {
    this.parts = parts;
  }

  /**
   * Add a name part the list of name parts for this name form.
   *
   * @param part The name part to be added.
   */
  public void addPart( NamePart part ) {
    if (part != null) {
      if (parts == null) {
        parts = new LinkedList<NamePart>();
      }
      parts.add( part );
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
