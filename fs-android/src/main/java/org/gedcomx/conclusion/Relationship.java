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
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.records.Field;
import org.gedcomx.records.HasFields;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.RelationshipType;
import org.simpleframework.xml.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * A relationship between two or more persons.
 *
 * @author Reed Ellsworth
 */
@Root (strict = false)
@Order (elements = {"person1", "person2", "fact", "field"})
public class Relationship extends Subject implements HasFacts, HasFields
{
  @Attribute (required = false)
  private URI type; // from RelationshipType
  @Element (required = false)
  private ResourceReference person1;
  @Element (required = false)
  private ResourceReference person2;
  @ElementList (entry = "fact", inline = true, required = false)
  private List<Fact> facts;
  @ElementList (entry = "field", inline = true, required = false)
  private List<Field> fields;

  /**
   * The type of this relationship.
   *
   * @return The type of this relationship.
   */
  public URI getType() {
    return type;
  }

  /**
   * The type of this relationship.
   *
   * @param type The type of this relationship.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the relationship, or {@link org.gedcomx.types.RelationshipType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the relationship, or {@link org.gedcomx.types.RelationshipType#OTHER} if not known.
   */
  public RelationshipType getKnownType() {
    return getType() == null ? null : RelationshipType.fromQNameURI( getType() );
  }

  /**
   * Set the relationship type from a known enumeration of relationship types.
   *
   * @param type The relationship type.
   */
  public void setKnownType( RelationshipType type ) {
    setType(type == null ? null : URI.create( EnumUtil.toURIValue( type )));
  }

  /**
   * A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @return A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   *         the other person in this relationship and implies neither order nor role. When the relationship type
   *         implies direction, it goes from "person1" to "person2".
   */
  public ResourceReference getPerson1() {
    return person1;
  }

  /**
   * A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @param person1 A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   *                the other person in this relationship and implies neither order nor role. When the relationship type
   *                implies direction, it goes from "person1" to "person2".
   */
  public void setPerson1( ResourceReference person1 ) {
    this.person1 = person1;
  }

  /**
   * A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @return A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   *         the other person in this relationship and implies neither order nor role. When the relationship type
   *         implies direction, it goes from "person1" to "person2".
   */
  public ResourceReference getPerson2() {
    return person2;
  }

  /**
   * A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @param person2 A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   *                the other person in this relationship and implies neither order nor role. When the relationship type
   *                implies direction, it goes from "person1" to "person2".
   */
  public void setPerson2( ResourceReference person2 ) {
    this.person2 = person2;
  }

  /**
   * The fact conclusions for the relationship.
   *
   * @return The fact conclusions for the relationship.
   */
  public List<Fact> getFacts() {
    return facts;
  }

  /**
   * The fact conclusions for the relationship.
   *
   * @param facts The fact conclusions for the relationship.
   */
  public void setFacts( List<Fact> facts ) {
    this.facts = facts;
  }

  /**
   * Add a fact conclusion.
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
