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

import org.gedcomx.Gedcomx;
import org.gedcomx.links.HypermediaEnabledData;
import org.simpleframework.xml.*;

import java.util.List;

/**
 * The GEDCOM X bulk record media types are used to exchange bulk genealogical data sets, grouped into records.
 *
 * @author Reed Ellsworth
 */
@Root (strict = false)
// (namespace = GedcomxConstants.GEDCOMX_BULK_RECORDS_NAMESPACE, name = "records" , strict=false)
@Order (elements = {"metadata", "record"})
public class RecordSet extends HypermediaEnabledData
{

  @Attribute (required = false)
  private String lang;
  @Element (required = false)
  private Gedcomx metadata;
  @ElementList (entry = "record", required = false)
  private List<Gedcomx> records;

  /**
   * The language of this genealogical data set. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>.
   * Note that some language-enabled elements MAY override the language.
   *
   * @return The language of the genealogical data.
   */
  public String getLang() {
    return lang;
  }

  /**
   * The language of this genealogical data set. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>.
   * Note that some language-enabled elements MAY override the language.
   *
   * @param lang The language of this genealogical data.
   */
  public void setLang( String lang ) {
    this.lang = lang;
  }

  /**
   * Metadata about this record set; shared among all records in the set.
   *
   * @return Metadata about this record set; shared among all records in the set.
   */
  public Gedcomx getMetadata() {
    return metadata;
  }

  /**
   * Metadata about this record set; shared among all records in the set.
   *
   * @param metadata Metadata about this record set; shared among all records in the set.
   */
  public void setMetadata( Gedcomx metadata ) {
    this.metadata = metadata;
  }

  /**
   * The records included in this genealogical data set.
   *
   * @return The records included in this genealogical data set.
   */
  public List<Gedcomx> getRecords() {
    return records;
  }

  /**
   * The records included in this genealogical data set.
   *
   * @param records The records included in this genealogical data set.
   */
  public void setRecords( List<Gedcomx> records ) {
    this.records = records;
  }

}