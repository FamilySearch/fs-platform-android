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
package org.gedcomx.common;

import org.gedcomx.links.HypermediaEnabledData;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * A note about a genealogical resource (e.g. conclusion or source).
 *
 * @author Reed Ellsworth
 */
@Root (strict = false)
@Order (elements = {"subject", "text", "attribution"})
public class Note extends HypermediaEnabledData implements Attributable, HasText
{

  @Attribute (required = false)
  private String lang;
  @Element (required = false)
  private String subject;
  @Element (required = false)
  private String text;
  @Element (required = false)
  private Attribution attribution;

  /**
   * The language of the note. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of the note.
   */
  public String getLang() {
    return lang;
  }

  /**
   * The language of the note. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of the note.
   */
  public void setLang( String lang ) {
    this.lang = lang;
  }

  /**
   * The subject of the note. This is a short title describing the contents of the note text.
   *
   * @return The subject of the note.
   */
  public String getSubject() {
    return subject;
  }

  /**
   * The subject of the note.
   *
   * @param text The subject of the note.
   */
  public void setSubject( String text ) {
    this.subject = text;
  }

  /**
   * The text of the note.
   *
   * @return The text of the note.
   */
  @Override
  public String getText() {
    return text;
  }

  /**
   * The text of the note.
   *
   * @param text The text of the note.
   */
  @Override
  public void setText( String text ) {
    this.text = text;
  }

  /**
   * Attribution metadata for a note.
   *
   * @return Attribution metadata for a note.
   */
  @Override
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * Attribution metadata for a note.
   *
   * @param attribution Attribution metadata for a note.
   */
  @Override
  public void setAttribution( Attribution attribution ) {
    this.attribution = attribution;
  }

  @Override
  public String toString() {
    return "Note{" +
      "subject=" + getTextBrief( subject ) +
      ", text=" + getTextBrief( text ) +
      ", attribution=" + attribution +
      '}';
  }

  private String getTextBrief( String text ) {
    if (text != null) {
      final int substrLen = 40;
      if (text.length() > substrLen) {
        return text.substring( 0, substrLen ) + "...";
      }
      return text;
    }
    return null;
  }

}
