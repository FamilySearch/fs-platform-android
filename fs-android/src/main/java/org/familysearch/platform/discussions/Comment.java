/**
 * Copyright 2011-2012 Intellectual Reserve, Inc. All Rights reserved.
 */
package org.familysearch.platform.discussions;

import org.gedcomx.common.ResourceReference;
import org.gedcomx.links.HypermediaEnabledData;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.Date;

/**
 */
@Root (strict = false)
@Order (elements = {"text", "created", "contributor"})
@SuppressWarnings ("gedcomx:no_id")
public class Comment extends HypermediaEnabledData
{
  @Element (required = false)
  private String text;
  @Element (required = false)
  private ResourceReference contributor;
  @Element (required = false)
  private Date created;

  /**
   * Get the text of the comment
   *
   * @return The text or "message body" of the comment
   */
  public String getText() {
    return text;
  }

  /**
   * Set "message body" of comment
   *
   * @param text the comment text, itself
   */
  public void setText( String text ) {
    this.text = text;
  }

  /**
   * Get the contributor who submitted this comment
   *
   * @return contributor of comment
   */
  public ResourceReference getContributor() {
    return contributor;
  }

  /**
   * Set the contributor of this comment
   *
   * @param contributor reference to who submitted the comment
   */
  public void setContributor( ResourceReference contributor ) {
    this.contributor = contributor;
  }

  /**
   * Get the date of comment creation
   *
   * @return date of creation
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Set the date the comment was created
   *
   * @param created date of creation
   */
  public void setCreated( Date created ) {
    this.created = created;
  }


}
