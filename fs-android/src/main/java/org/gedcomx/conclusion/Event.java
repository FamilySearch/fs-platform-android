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
import org.gedcomx.types.EventType;
import org.simpleframework.xml.*;

import java.util.LinkedList;
import java.util.List;


/**
 * A historical event.
 *
 * @author Reed Ellsworth
 */
@Root (strict = false)
@Order (elements = {"date", "place", "role"})
public class Event extends Subject implements HasDateAndPlace
{
  @Attribute (required = false)
  private URI type; // from org.gedcomx.types.EventType
  @Element (required = false)
  private Date date;
  @Element (required = false)
  private PlaceReference place;
  @ElementList (entry = "role", inline = true, required = false)
  private List<EventRole> roles;

  /**
   * Create an event.
   */
  public Event() {
  }

  /**
   * Create an event with the passed in type and values.
   *
   * @param EventType the event type.
   */
  public Event( EventType EventType ) {
    setKnownType( EventType );
  }

  /**
   * Create a date/place event with the passed in type and values.
   *
   * @param EventType the event type.
   * @param date      The date of applicability of this event.
   * @param place     The place of applicability of this event.
   */
  public Event( EventType EventType, Date date, PlaceReference place ) {
    setKnownType( EventType );
    setDate( date );
    setPlace( place );
  }

  /**
   * The type of the event.
   *
   * @return The type of the event.
   */
  public URI getType() {
    return type;
  }

  /**
   * The type of the event.
   *
   * @param type The type of the event.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the event, or {@link org.gedcomx.types.EventType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the event, or {@link org.gedcomx.types.EventType#OTHER} if not known.
   */
  public org.gedcomx.types.EventType getKnownType() {
    return getType() == null ? null : EventType.fromQNameURI( getType() );
  }

  /**
   * Set the type of this event from a known enumeration of event types.
   *
   * @param knownType the event type.
   */
  public void setKnownType( org.gedcomx.types.EventType knownType ) {
    setType(knownType == null ? null : URI.create( EnumUtil.toURIValue( knownType )));
  }

  /**
   * The date of this event.
   *
   * @return The date of this event.
   */
  @Override
  public Date getDate() {
    return date;
  }

  /**
   * The date of this event.
   *
   * @param date The date of this event.
   */
  @Override
  public void setDate( Date date ) {
    this.date = date;
  }

  /**
   * The place of this event.
   *
   * @return The place of this event.
   */
  @Override
  public PlaceReference getPlace() {
    return place;
  }

  /**
   * The place of this event.
   *
   * @param place The place of this event.
   */
  @Override
  public void setPlace( PlaceReference place ) {
    this.place = place;
  }

  /**
   * The roles played in this event.
   *
   * @return The roles played in this event.
   */
  public List<EventRole> getRoles() {
    return roles;
  }

  /**
   * The roles played in this event.
   *
   * @param roles The roles played in this event.
   */
  public void setRoles( List<EventRole> roles ) {
    this.roles = roles;
  }

  /**
   * Add a role to the list of roles played in this event.
   *
   * @param role The role to be added.
   */
  public void addRole( EventRole role ) {
    if (role != null) {
      if (roles == null) {
        roles = new LinkedList<EventRole>();
      }
      roles.add( role );
    }
  }


}
