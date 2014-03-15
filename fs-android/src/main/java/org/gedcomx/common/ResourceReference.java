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

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * A generic reference to a resource.
 *
 * @author Reed Ellsworth
 */
@Root (strict = false)
public final class ResourceReference
{

  @Attribute (required = false)
  private URI resource;
  @Attribute (required = false)
  private String resourceId;

  public ResourceReference() {
  }

  public ResourceReference( URI resource ) {
    this.resource = resource;
  }

  public ResourceReference( URI resource, String resourceId ) {
    this.resource = resource;
    this.resourceId = resourceId;
  }

  /**
   * The resource id of the resource being referenced. Used as an extension attribute when resolving the resource is inconvenient.
   *
   * @return The resource id of the resource being referenced.
   */
  public String getResourceId() {
    return resourceId;
  }

  /**
   * The resource id of the resource being referenced. Used as an extension attribute when resolving the resource is inconvenient.
   *
   * @param resourceId The resource id of the resource being referenced.
   */
  public void setResourceId( String resourceId ) {
    this.resourceId = resourceId;
  }

  /**
   * The URI to the resource. For more information, see <a href="http://www.w3.org/TR/webarch/#identification">Architecture of the World
   * Wide Web, Volume One, Section 2</a>
   *
   * @return The URI to the resource.
   * @link http://www.w3.org/TR/webarch/#identification
   */
  public URI getResource() {
    return resource;
  }

  /**
   * The URI to the resource. For more information, see <a href="http://www.w3.org/TR/webarch/#identification">Architecture of the World
   * Wide Web, Volume One, Section 2</a>
   *
   * @param resource The URI to the resource.
   * @link http://www.w3.org/TR/webarch/#identification
   */
  public void setResource( URI resource ) {
    this.resource = resource;
  }

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (resource == null) ? "" : resource.toString();
  }
}
