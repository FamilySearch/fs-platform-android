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

import org.gedcomx.types.FactType;
import org.gedcomx.types.NameType;
import org.simpleframework.xml.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * A person.
 *
 * @author Reed Ellsworth
 */
@Root (strict = false)
@Order (elements = {"gender", "name", "fact", "display"})
public class Person extends Subject implements HasFacts
{

  @Attribute (name = "private", required = false)
  private Boolean isPrivate;
  @Element (required = false)
  private Boolean living;
  @Attribute (required = false)
  private Boolean principal;
  @Element (required = false)
  private Gender gender;
  @ElementList (entry = "name", inline = true, required = false)
  private List<Name> names;
  @ElementList (entry = "fact", inline = true, required = false)
  private List<Fact> facts;
  @Element (required = false)
  private DisplayProperties display;

  /**
   * Whether this person has been designated for limited distribution or display.
   *
   * @return Whether this person has been designated for limited distribution or display.
   */
  public Boolean getPrivate() {
    return isPrivate;
  }

  /**
   * Whether this person has been designated for limited distribution or display.
   *
   * @param isPrivate Whether this person has been designated for limited distribution or display.
   */
  public void setPrivate( Boolean isPrivate ) {
    this.isPrivate = isPrivate;
  }

  /**
   * Living status of the person as treated by the system. The value of this property is intended
   * to be based on a system-specific calculation and therefore has limited portability. Conclusions
   * about the living status of a person can be modeled with a fact.
   *
   * @return Living status of the person as treated by the system.
   */
  public Boolean getLiving() {
    return living;
  }

  /**
   * Living status of the person as treated by the system. The value of this property is intended
   * to be based on a system-specific calculation and therefore has limited portability. Conclusions
   * about the living status of a person can be modeled with a fact.
   *
   * @param living Living status of the person as treated by the system.
   */
  public void setLiving( Boolean living ) {
    this.living = living;
  }

  /**
   * Indicator of whether this person is the "principal" person extracted from the record. Applicable
   * only to extracted persons. The meaning of this flag outside the scope of an extracted person is undefined.
   *
   * @return Whether this person is the "principal" person extracted from the record.
   */
  public Boolean getPrincipal() {
    return principal;
  }

  /**
   * Indicator of whether this person is the "principal" person extracted from the record. Applicable
   * only to extracted persons. The meaning of this flag outside the scope of an extracted person is undefined.
   *
   * @param principal Whether this person is the "principal" person extracted from the record.
   */
  public void setPrincipal( Boolean principal ) {
    this.principal = principal;
  }

  /**
   * The gender conclusion for the person.
   *
   * @return The gender conclusion for the person.
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * The gender conclusion for the person.
   *
   * @param gender The gender conclusion for the person.
   */
  public void setGender( Gender gender ) {
    this.gender = gender;
  }

  /**
   * The name conclusions for the person.
   *
   * @return The name conclusions for the person.
   */
  public List<Name> getNames() {
    return names;
  }

  /**
   * Get the first name of the specified type.
   *
   * @param type The type.
   * @return the first name in the name list of the specified type, or null if none.
   */
  public Name getFirstNameOfType( NameType type ) {
    if (this.names == null) {
      return null;
    }

    for (Name name : this.names) {
      if (type.equals( name.getKnownType() )) {
        return name;
      }
    }

    return null;
  }

  /**
   * The name conclusions for the person.
   *
   * @param names The name conclusions for the person.
   */
  public void setNames( List<Name> names ) {
    this.names = names;
  }

  /**
   * Add a name conclusion to the person.
   *
   * @param name The name conclusion to be added.
   */
  public void addName( Name name ) {
    if (name != null) {
      if (names == null) {
        names = new LinkedList<Name>();
      }
      names.add( name );
    }
  }

  /**
   * The fact conclusions for the person.
   *
   * @return The fact conclusions for the person.
   */
  public List<Fact> getFacts() {
    return facts;
  }

  /**
   * Get the first fact of the specified type.
   *
   * @param type The type.
   * @return the first fact in the fact list of the specified type, or null if none.
   */
  public Fact getFirstFactOfType( FactType type ) {
    if (this.facts == null) {
      return null;
    }

    for (Fact fact : this.facts) {
      if (type.equals( fact.getKnownType() )) {
        return fact;
      }
    }

    return null;
  }

  /**
   * Helper method for obtaining specific fact conclusions.
   *
   * @param factType The type of facts to return.
   * @return The fact conclusions that match the factType. An empty list will be returned if no facts are found.
   */
  public List<Fact> getFacts( FactType factType ) {
    ArrayList<Fact> factsToReturn = new ArrayList<Fact>();
    if (facts != null && factType != null) {
      for (Fact fact : facts) {
        if (fact.getKnownType() != null && fact.getKnownType().equals( factType )) {
          factsToReturn.add( fact );
        }
      }
    }
    return factsToReturn;
  }

  /**
   * The fact conclusions for the person.
   *
   * @param facts The fact conclusions for the person.
   */
  public void setFacts( List<Fact> facts ) {
    this.facts = facts;
  }

  /**
   * Add a fact conclusion to the person.
   *
   * @param fact The fact conclusion to be added.
   */
  public void addFact( Fact fact ) {
    if (fact != null) {
      if (facts == null) {
        facts = new ArrayList<Fact>();
      }
      facts.add( fact );
    }
  }

  /**
   * Display properties for the person. Display properties are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   *
   * @return Display properties for the person. Display properties are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   */
  public DisplayProperties getDisplayExtension() {
    return display;
  }

  /**
   * Display properties for the person. Display properties are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   *
   * @param display Display properties for the person. Display properties are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   */
  public void setDisplayExtension( DisplayProperties display ) {
    this.display = display;
  }

  public String getGenderString() {
    if (display != null) {
      return display.getGender();
    }
    return gender == null ? null : gender.getKnownType().toString();
  }

  public String getLifespan() {
    if (display != null) {
      return display.getLifespan();
    }
    return null;
  }

  public String getFullName() {
    if (display != null) {
      return display.getName();
    }
    if (names != null && names.size() > 0 && names.get( 0 ).getNameForms() != null && names.get( 0 ).getNameForms().size() > 0) {
      return names.get( 0 ).getNameForms().get( 0 ).getFullText();
    }
    return null;
  }
}
