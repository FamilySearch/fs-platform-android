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

import org.gedcomx.links.HypermediaEnabledData;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * A descriptor for a common set of records.
 *
 * @author Reed Ellsworth
 */
//@XmlType (name = "RecordDescriptor")
public class RecordDescriptor extends HypermediaEnabledData
{

  @Attribute (required = false)
  private String lang;
  @ElementList (entry = "field", required = false)
  private List<FieldDescriptor> fields;

  /**
   * The language of this record description. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of this record description.
   */
  public String getLang() {
    return lang;
  }

  /**
   * The language of this record description. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of this record description.
   */
  public void setLang( String lang ) {
    this.lang = lang;
  }

  /**
   * The fields that are applicable to this record.
   *
   * @return The fields that are applicable to this record.
   */
  public List<FieldDescriptor> getFields() {
    return fields;
  }

  /**
   * The fields that are applicable to this record.
   *
   * @param fields The fields that are applicable to this record.
   */
  public void setFields( List<FieldDescriptor> fields ) {
    this.fields = fields;
  }


}
