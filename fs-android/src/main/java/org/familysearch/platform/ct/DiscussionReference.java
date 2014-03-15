/**
 * Copyright 2011 Intellectual Reserve, Inc. All Rights reserved.
 */
package org.familysearch.platform.ct;

import org.gedcomx.common.URI;
import org.gedcomx.links.HypermediaEnabledData;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 */
@Root (name = "discussion-reference")
public final class DiscussionReference extends HypermediaEnabledData
{

  @Attribute (required = false)
  private URI resource;

  public DiscussionReference() {
  }

  public DiscussionReference( URI resource ) {
    this.resource = resource;
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
