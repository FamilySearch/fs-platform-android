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

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Order;

/**
 * A way a field is to be displayed to a user.
 *
 * @author Reed Ellsworth
 */
@Order (elements = {"originalValueLabel", "interpretedValueLabel"})
public class FieldDisplay
{

  @Attribute (required = false)
  private String lang;
  private String originalValueLabel;
  private String interpretedValueLabel;

  /**
   * The language of this display information. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of this display information.
   */
  public String getLang() {
    return lang;
  }

  /**
   * The language of this display information. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of this display information.
   */
  public void setLang( String lang ) {
    this.lang = lang;
  }

  /**
   * A label for the original value of the field.
   *
   * @return A label for the original value of the field.
   */
  public String getOriginalValueLabel() {
    return originalValueLabel;
  }

  /**
   * A label for the original value of the field.
   *
   * @param originalValueLabel A label for the original value of the field.
   */
  public void setOriginalValueLabel( String originalValueLabel ) {
    this.originalValueLabel = originalValueLabel;
  }

  /**
   * A label for the interpreted value of the field.
   *
   * @return A label for the interpreted value of the field.
   */
  public String getInterpretedValueLabel() {
    return interpretedValueLabel;
  }

  /**
   * A label for the interpreted value of the field.
   *
   * @param interpretedValueLabel A label for the interpreted value of the field.
   */
  public void setInterpretedValueLabel( String interpretedValueLabel ) {
    this.interpretedValueLabel = interpretedValueLabel;
  }

}
