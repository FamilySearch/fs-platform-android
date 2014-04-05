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

import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.NameType;
import org.simpleframework.xml.*;

import java.util.LinkedList;
import java.util.List;


/**
 * A name conclusion.
 *
 * @author Reed Ellsworth
 */
@Order ( elements = {"preferred", "date", "nameForm"} )
@Root ( strict = false )
public class Name extends Conclusion
{
  @Attribute ( required = false )
  private URI type; // from NameType
  @Element ( required = false )
  private Date date;
  @ElementList ( entry = "nameForm", inline = true, required = false )
  private List<NameForm> nameForms;
  @Element ( required = false )
  private Boolean preferred;

  /**
   * The type of the name.
   *
   * @return The type of the name.
   */
  public URI getType() {
    return type;
  }

  /**
   * The type of the name.
   *
   * @param type The type of the name.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * The enum referencing the known name type, or {@link org.gedcomx.types.NameType#OTHER} if not known.
   *
   * @return The enum referencing the known name type, or {@link org.gedcomx.types.NameType#OTHER} if not known.
   */
  public NameType getKnownType() {
    return getType() == null ? null : NameType.fromQNameURI( getType() );
  }

  /**
   * Set the name type from an enumeration of known name types.
   *
   * @param knownType The known type.
   */
  public void setKnownType( NameType knownType ) {
    setType(knownType == null ? null : URI.create( EnumUtil.toURIValue( knownType )));
  }

  /**
   * The date the name was first applied or adopted.
   *
   * @return The date the name was first applied or adopted.
   */
  public Date getDate() {
    return date;
  }

  /**
   * The date the name was first applied or adopted.
   *
   * @param date The date the name was first applied or adopted.
   */
  public void setDate( Date date ) {
    this.date = date;
  }

  /**
   * Alternate forms of the name, such as the romanized form of a non-latin name.
   *
   * @return Alternate forms of the name, such as the romanized form of a non-latin name.
   */
  public List<NameForm> getNameForms() {
    return nameForms;
  }

  /**
   * Alternate forms of the name, such as the romanized form of a non-latin name.
   *
   * @param nameForms Alternate forms of the name, such as the romanized form of a non-latin name.
   */
  public void setNameForms( List<NameForm> nameForms ) {
    this.nameForms = nameForms;
  }

  /**
   * Add a name form to the list of name forms.
   *
   * @param nameForm The name form to be added.
   */
  public void addNameForm( NameForm nameForm ) {
    if (nameForm != null) {
      if (nameForms == null) {
        nameForms = new LinkedList<NameForm>();
      }
      nameForms.add( nameForm );
    }
  }

  /**
   * Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   *
   * @return Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   */
  public Boolean getPreferred() {
    return preferred;
  }

  /**
   * Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   *
   * @param preferred Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   */
  public void setPreferred( Boolean preferred ) {
    this.preferred = preferred;
  }

  @Override
  public String toString() {
    return "type=" + getKnownType() + ",nameForms[0]=" + (nameForms == null ? "null" : nameForms.get( 0 ).getFullText()) + ",pref=" + getPreferred();
  }


}
