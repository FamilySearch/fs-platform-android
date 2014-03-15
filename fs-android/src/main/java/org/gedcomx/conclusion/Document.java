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

import org.gedcomx.common.Attributable;
import org.gedcomx.common.HasText;
import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.DocumentType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;


/**
 * An abstract document that contains derived (conclusionary) text -- for example, a transcription or researcher analysis.
 */
@Root (strict = false)
@Order (elements = {"text"})
public class Document extends Conclusion implements HasText, Attributable
{
  public static final String TEXT_TYPE_PLAIN = "plain";
  public static final String TEXT_TYPE_XHTML = "xhtml";

  @Attribute (required = false)
  private Boolean extracted;
  @Attribute (required = false)
  private URI type; // from DocumentType
  @Attribute (required = false)
  private String textType;
  @Element (required = false)
  private String text;

  /**
   * Whether this document has been identified as "extracted", meaning it captures information extracted from a single source.
   *
   * @return Whether this document has been identified as "extracted".
   */
  public Boolean getExtracted() {
    return extracted;
  }

  /**
   * Whether this document has been identified as "extracted", meaning it captures information extracted from a single source.
   *
   * @param extracted Whether this document has been identified as "extracted".
   */
  public void setExtracted( Boolean extracted ) {
    this.extracted = extracted;
  }

  /**
   * The type of the document.
   *
   * @return The type of the document.
   */
  public URI getType() {
    return type;
  }

  /**
   * The type of the document.
   *
   * @param type The type of the document.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * Whether the text of the document is to be interpreted as plain text (as opposed to XHTML).
   *
   * @return Whether the text of the document is to be interpreted as plain text (as opposed to XHTML).
   */
  public boolean isPlainText() {
    return this.textType == null || TEXT_TYPE_PLAIN.equals( this.textType );
  }

  /**
   * Whether the text of the document is to be interpreted as XHTML text (as opposed to plain text).
   *
   * @return Whether the text of the document is to be interpreted as XHTML text (as opposed to plain text).
   */
  public boolean isXhtmlText() {
    return TEXT_TYPE_XHTML.equals( this.textType );
  }

  /**
   * The text type of the document.
   *
   * @return The text type of the document.
   */
  public String getTextType() {
    return textType;
  }

  /**
   * The text type of the document.
   *
   * @param textType The text type of the document.
   */
  public void setTextType( String textType ) {
    this.textType = textType;
  }

  /**
   * The enum referencing the known type of the document, or {@link org.gedcomx.types.DocumentType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the document, or {@link org.gedcomx.types.DocumentType#OTHER} if not known.
   */
  public org.gedcomx.types.DocumentType getKnownType() {
    return getType() == null ? null : DocumentType.fromQNameURI( getType() );
  }

  /**
   * Set the type of this document from a known enumeration of document types.
   *
   * @param knownType the document type.
   */
  public void setKnownType( org.gedcomx.types.DocumentType knownType ) {
    setType(knownType == null ? null : URI.create( EnumUtil.toURIValue( knownType )));
  }

  /**
   * The document text.
   *
   * @return The document text.
   */
  public String getText() {
    return text;
  }

  /**
   * The document text.
   *
   * @param text The document text.
   */
  public void setText( String text ) {
    this.text = text;
  }


}
