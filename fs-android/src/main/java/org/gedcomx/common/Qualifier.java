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

import org.gedcomx.rt.EnumUtil;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

/**
 * A data qualifier. Qualifiers are used to "qualify" certain data elements to provide additional context, information, or details.
 *
 * @author Reed Ellsworth
 */
//@XmlType (name = "Qualifier")
public final class Qualifier
{

  @Attribute (required = false)
  private URI name;
  @Text (required = false)
  private String value;

  public Qualifier() {
  }

  public Qualifier( URI name, String value ) {
    setName( name );
    setValue( value );
  }

  public Qualifier( URI name ) {
    setName( name );
  }

/*
  public Qualifier( Enum name, String value ) {
    setName( name );
    setValue( value );
  }

  public Qualifier( Enum name ) {
    setName( name );
  }
*/

  /**
   * The name of the qualifier. The name should be an element of a constrained vocabulary and is used to determine meaning of the qualifier.
   *
   * @return The name of the qualifier.
   */
  public URI getName() {
    return name;
  }

  /**
   * The name of the qualifier. The name should be an element of a constrained vocabulary and is used to determine meaning of the qualifier.
   *
   * @param name The name of the qualifier.
   */
  public void setName( URI name ) {
    this.name = name;
  }

  /**
   * Get the name as an element of a constrained vocabulary.
   *
   * @param vocabulary The enum containing the constrained vocabulary.
   * @return The vocabulary element.
   */
  public <E extends Enum> E getName( Class<E> vocabulary ) {
    return this.name == null ? null : (E) EnumUtil.fromURI( this.name.toURI(), vocabulary );
  }

  /**
   * Set the qualifier name as an element of a constrained vocabulary.
   *
   * @param element The element.
   */
    public void setName( Enum element ) {
      this.name = element == null ? null : new URI( EnumUtil.toURI( element ).toString());
    }

  /**
   * The value of the qualifier. Some qualifiers may not have values, indicating that the qualifier is to be treated more like a "tag".
   *
   * @return The value of the qualifier.
   */
  public String getValue() {
    return value;
  }

  /**
   * The value of the qualifier. Some qualifiers may not have values, indicating that the qualifier is to be treated more like a "tag".
   *
   * @param value The value of the qualifier.
   */
  public void setValue( String value ) {
    this.value = value;
  }
}
