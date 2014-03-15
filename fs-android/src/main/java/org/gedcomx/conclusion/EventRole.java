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

import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.EventRoleType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;

/**
 * A role that a specific person plays in an event.
 *
 * @author Reed Ellsworth
 */
@Order (elements = {"person", "details"})
public class EventRole extends Conclusion
{
  @Element (required = false)
  private ResourceReference person;
  @Attribute (required = false)
  private URI type; // from EventRoleType
  @Element (required = false)
  private String details;

  /**
   * Reference to the person playing the role in the event.
   *
   * @return Reference to the person playing the role in the event.
   */
  public ResourceReference getPerson() {
    return person;
  }

  /**
   * Reference to the person playing the role in the event.
   *
   * @param person Reference to the person playing the role in the event.
   */
  public void setPerson( ResourceReference person ) {
    this.person = person;
  }

  /**
   * The role type.
   *
   * @return The role type.
   */
  public URI getType() {
    return type;
  }

  /**
   * The role type.
   *
   * @param type The role type.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * The enum referencing the known role type, or {@link org.gedcomx.types.EventRoleType#OTHER} if not known.
   *
   * @return The enum referencing the known role type, or {@link org.gedcomx.types.EventRoleType#OTHER} if not known.
   */
  public EventRoleType getKnownType() {
    return getType() == null ? null : EventRoleType.fromQNameURI( getType() );
  }

  /**
   * Set the role type from an enumeration of known role types.
   *
   * @param knownType The role type.
   */
  public void setKnownType( EventRoleType knownType ) {
    setType(knownType == null ? null : URI.create( EnumUtil.toURIValue( knownType )));
  }

  /**
   * Details about the role of the person in the event.
   *
   * @return Details about the role of the person in the event.
   */
  public String getDetails() {
    return details;
  }

  /**
   * Details about the role of the person in the event.
   *
   * @param details Details about the role of the person in the event.
   */
  public void setDetails( String details ) {
    this.details = details;
  }

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (person == null) ? "" : person.toString();
  }


}
