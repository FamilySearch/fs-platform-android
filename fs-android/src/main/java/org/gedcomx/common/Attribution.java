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

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.Date;


/**
 * Attribution for genealogical information. Attribution is used to model <strong>who</strong> is contributing/modifying
 * information, <strong>when</strong> they contributed it, and <strong>why</strong> they are making the
 * contribution/modification.
 */
@Root (strict = false)
@Order (elements = {"contributor", "modified", "changeMessage"})
@SuppressWarnings ("gedcomx:no_id")
public final class Attribution extends ExtensibleData
{

  @Element (required = false)
  private ResourceReference contributor;
  @Element (required = false)
  private Date modified;
  @Element (required = false)
  private String changeMessage;

  /**
   * Reference to the contributor of the attributed data.
   *
   * @return Reference to the contributor of the attributed data.
   */
  public ResourceReference getContributor() {
    return contributor;
  }

  /**
   * Reference to the contributor of the attributed data.
   *
   * @param contributor Reference to the contributor of the attributed data.
   */
  public void setContributor( ResourceReference contributor ) {
    this.contributor = contributor;
  }

  /**
   * The modified timestamp for the attributed data.
   *
   * @return The modified timestamp for the attributed data.
   */
  public Date getModified() {
    return modified;
  }

  /**
   * The modified timestamp for the attributed data.
   *
   * @param modified The modified timestamp for the attributed data.
   */
  public void setModified( Date modified ) {
    this.modified = modified;
  }

  /**
   * The "change message" for the attributed data provided by the contributor.
   *
   * @return The "change message" for the attributed data provided by the contributor.
   */
  public String getChangeMessage() {
    return changeMessage;
  }

  /**
   * The "change message" for the attributed data provided by the contributor.
   *
   * @param changeMessage The "change message" for the attributed data provided by the contributor.
   */
  public void setChangeMessage( String changeMessage ) {
    this.changeMessage = changeMessage;
  }

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (contributor == null) ? "" : contributor.toString();
  }
}
