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
package org.gedcomx.atom;

import org.gedcomx.common.URI;
import org.gedcomx.links.Link;
import org.gedcomx.links.SupportsLinks;
import org.gedcomx.rt.GedcomxConstants;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The "atom:entry" element represents an individual entry, acting as a container for metadata and data associated with the entry.
 *
 * @author Reed Ellsworth
 */
@Root (strict = false)
@SuppressWarnings ("gedcomx:no_id")
public class Entry extends ExtensibleElement implements SupportsLinks
{

  @ElementList (entry = "author", inline = true, required = false)
  private List<Person> authors;
  @ElementList (entry = "category", inline = true, required = false)
  private List<Category> categories;
  @Element (required = false)
  private Content content;
  @ElementList (entry = "contributor", inline = true, required = false)
  private List<Person> contributors;
  @Element (required = false)
  private URI id;
  @Element (required = false)
  @Namespace (reference = GedcomxConstants.GEDCOMX_NAMESPACE)
  private Float score;
  @Element (required = false)
  @Namespace (reference = GedcomxConstants.GEDCOMX_NAMESPACE)
  private int confidence;
  @ElementList (entry = "link", inline = true, required = false)
  private List<Link> links;
  @Element (required = false)
  private Date published;
  @Element (required = false)
  private String rights;
  @Element (required = false)
  private String title;
  @Element (required = false)
  private Date updated;
  //  @XmlAnyAttribute
  private Map<QName, String> extensionAttributes;

  /**
   * The author of the entry.
   *
   * @return The author of the entry.
   */
  public List<Person> getAuthors() {
    return authors;
  }

  /**
   * The author of the entry.
   *
   * @param authors The author of the entry.
   */
  public void setAuthors( List<Person> authors ) {
    this.authors = authors;
  }

  /**
   * information about a category associated with an entry.
   *
   * @return information about a category associated with an entry.
   */
  public List<Category> getCategories() {
    return categories;
  }

  /**
   * information about a category associated with an entry.
   *
   * @param categories information about a category associated with an entry.
   */
  public void setCategories( List<Category> categories ) {
    this.categories = categories;
  }

  /**
   * The content of the entry.
   *
   * @return The content of the entry.
   */
  public Content getContent() {
    return content;
  }

  /**
   * The content of the entry.
   *
   * @param content The content of the entry.
   */
  public void setContent( Content content ) {
    this.content = content;
  }

  /**
   * information about a category associated with the entry
   *
   * @return information about a category associated with the entry
   */
  public List<Person> getContributors() {
    return contributors;
  }

  /**
   * information about a category associated with the entry
   *
   * @param contributors information about a category associated with the entry
   */
  public void setContributors( List<Person> contributors ) {
    this.contributors = contributors;
  }

  /**
   * a permanent, universally unique identifier for the entry.
   *
   * @return a permanent, universally unique identifier for the entry.
   */
  public org.gedcomx.common.URI getId() {
    return id;
  }

  /**
   * a permanent, universally unique identifier for the entry.
   *
   * @param id a permanent, universally unique identifier for the entry.
   */
  public void setId( URI id ) {
    this.id = id;
  }

  /**
   * The relevance score, if this entry represents a search result. The value of this score is implementation-specific.
   *
   * @return The relevance score.
   */
  public Float getScore() {
    return score;
  }

  /**
   * The relevance score, if this entry represents a search result. The value of this score is implementation-specific.
   *
   * @param score The relevance score.
   */
  public void setScore( Float score ) {
    this.score = score;
  }

  /**
   * The confidence of the result, if this entry represents a search result.
   *
   * @return The confidence of the result, if this entry represents a search result.
   */
  public int getConfidence() {
    return confidence;
  }

  /**
   * The confidence of the result, if this entry represents a search result.
   *
   * @param confidence The confidence of the result, if this entry represents a search result.
   */
  public void setConfidence( int confidence ) {
    this.confidence = confidence;
  }

  /**
   * a reference from a entry to a Web resource.
   *
   * @return a reference from a entry to a Web resource.
   */
  public List<Link> getLinks() {
    return links;
  }

  /**
   * a reference from a entry to a Web resource.
   *
   * @param links a reference from a entry to a Web resource.
   */
  public void setLinks( List<Link> links ) {
    this.links = links;
  }

  /**
   * Add a hypermedia link.
   *
   * @param link The hypermedia link.
   */
  public void addLink( Link link ) {
    if (this.links == null) {
      setLinks( new ArrayList<Link>() );
    }

    this.links.add( link );
  }

  /**
   * Add a hypermedia link.
   *
   * @param rel  The link rel.
   * @param href The target URI.
   */
  public void addLink( String rel, URI href ) {
    addLink( new Link( rel, href ) );
  }

  /**
   * Add a templated link.
   *
   * @param rel      The link rel.
   * @param template The link template.
   */
  public void addTemplatedLink( String rel, String template ) {
    Link link = new Link();
    link.setRel( rel );
    link.setTemplate( template );
    addLink( link );
  }

  /**
   * Get a link by its rel.
   *
   * @param rel The link rel.
   * @return The link by rel.
   */
  public Link getLink( String rel ) {
    if (this.links != null) {
      for (Link link : getLinks()) {
        if (rel.equals( link.getRel() )) {
          return link;
        }
      }
    }
    return null;
  }

  /**
   * Get a list of links by rel.
   *
   * @param rel The rel of the links.
   * @return The link.
   */
  public List<Link> getLinks( String rel ) {
    ArrayList<Link> links = new ArrayList<Link>();
    if (this.links != null) {
      for (Link link : getLinks()) {
        if (rel.equals( link.getRel() )) {
          links.add( link );
        }
      }
    }
    return links;
  }

  /**
   * instant in time associated with an event early in the life cycle of the entry.
   *
   * @return instant in time associated with an event early in the life cycle of the entry.
   */
  public Date getPublished() {
    return published;
  }

  /**
   * instant in time associated with an event early in the life cycle of the entry.
   *
   * @param published instant in time associated with an event early in the life cycle of the entry.
   */
  public void setPublished( Date published ) {
    this.published = published;
  }

  /**
   * information about rights held in and over the entry.
   *
   * @return information about rights held in and over the entry.
   */
  public String getRights() {
    return rights;
  }

  /**
   * information about rights held in and over the entry.
   *
   * @param rights information about rights held in and over the entry.
   */
  public void setRights( String rights ) {
    this.rights = rights;
  }

  /**
   * a human-readable title for the entry
   *
   * @return a human-readable title for the entry
   */
  public String getTitle() {
    return title;
  }

  /**
   * a human-readable title for the entry
   *
   * @param title a human-readable title for the entry
   */
  public void setTitle( String title ) {
    this.title = title;
  }

  /**
   * the most recent instant in time when the entry was modified in a way the publisher considers significant.
   *
   * @return the most recent instant in time when the entry was modified in a way the publisher considers significant.
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * the most recent instant in time when the entry was modified in a way the publisher considers significant.
   *
   * @param updated the most recent instant in time when the entry was modified in a way the publisher considers significant.
   */
  public void setUpdated( Date updated ) {
    this.updated = updated;
  }

  public Map<QName, String> getExtensionAttributes() {
    return extensionAttributes;
  }

  public void setExtensionAttributes( Map<QName, String> extensionAttributes ) {
    this.extensionAttributes = extensionAttributes;
  }

}
