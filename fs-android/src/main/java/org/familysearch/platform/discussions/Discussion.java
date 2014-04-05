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
package org.familysearch.platform.discussions;

import org.gedcomx.common.ResourceReference;
import org.gedcomx.links.HypermediaEnabledData;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A discussion.
 */
@Root (strict = false)
@Order (elements = {"title", "details", "created", "contributor", "modified", "numberOfComments", "comment"})
public class Discussion extends HypermediaEnabledData
{

  @Element (required = false)
  private String title;
  @Element (required = false)
  private String details;
  @Element (required = false)
  private ResourceReference contributor;
  @Element (required = false)
  private Date created;
  @Element (required = false)
  private Date modified;    // last date of any change to comments or discussion details
  @Element (required = false)
  private Integer numberOfComments;
  @ElementList (entry = "comment", inline = true, required = false)
  private List<Comment> comments;

  //TODO: need to add a URI to point to the specific resource (eg person) that the discussion is about

  /**
   * get the one-line summary or "subject" of the discussion
   *
   * @return the one-line summary text
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the one-line summary or "subject" of the discussion
   *
   * @param title the one-line summary text
   */
  public void setTitle( String title ) {
    this.title = title;
  }

  /**
   * Get detailed text of the discussion
   *
   * @return The text or "message body" of the discussion
   */
  public String getDetails() {
    return details;
  }

  /**
   * Set discussion details, or "message body" of discussion
   *
   * @param details Details
   */
  public void setDetails( String details ) {
    this.details = details;
  }

  /**
   * Get the contributor who submitted this discussion
   *
   * @return contributor of discussion
   */
  public ResourceReference getContributor() {
    return contributor;
  }

  /**
   * Set the contributor of this discussion
   *
   * @param contributor reference to who submitted the discussion
   */
  public void setContributor( ResourceReference contributor ) {
    this.contributor = contributor;
  }

  /**
   * Get the date of discussion creation
   *
   * @return date of creation
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Set the date the discussion was created
   *
   * @param created date of creation
   */
  public void setCreated( Date created ) {
    this.created = created;
  }

  /**
   * Last date of any change to comments or discussion details
   *
   * @return Date of last modification
   */
  public Date getModified() {
    return modified;
  }

  /**
   * Set the modified date of this discussion. Should be the last date of any change to comments or discussion details
   *
   * @param modified date of last modification
   */
  public void setModified( Date modified ) {
    this.modified = modified;
  }

  /**
   * Get the number of comments associated with this discussion
   *
   * @return Number of comments
   */
  public Integer getNumberOfComments() {
    return numberOfComments;
  }

  /**
   * Set the number of comments associated with this discussion
   *
   * @param numberOfComments number of comment objects with this discussion
   */
  public void setNumberOfComments( Integer numberOfComments ) {
    this.numberOfComments = numberOfComments;
  }

  /**
   * The comments on this discussion.
   *
   * @return The comments on this discussion.
   */
  public List<Comment> getComments() {
    return comments;
  }

  /**
   * The comments on this discussion.
   *
   * @param comments The comments on this discussion.
   */
  public void setComments( List<Comment> comments ) {
    this.comments = comments;
  }

  public void addComment(Comment comment) {
    if (comments == null) {
      comments = new ArrayList<Comment>();
    }
    comments.add( comment );
  }
}
