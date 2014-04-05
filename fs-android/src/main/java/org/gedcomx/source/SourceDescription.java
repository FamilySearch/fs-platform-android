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
package org.gedcomx.source;

import org.gedcomx.common.*;
import org.gedcomx.conclusion.Identifier;
import org.gedcomx.links.HypermediaEnabledData;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.IdentifierType;
import org.gedcomx.types.ResourceType;
import org.simpleframework.xml.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * Represents a description of a source.
 */
@Root (strict = false)
@Order (elements = {"citation", "mediator", "source", "analysis", "componentOf", "title", "note", "attribution", "sortKey", "description", "identifier", "created", "modified", "coverage", "repository", "descriptor"})
public class SourceDescription extends HypermediaEnabledData implements Attributable, HasNotes, ReferencesSources
{
  @ElementList (entry = "citation", inline = true, required = false)
  private List<SourceCitation> citations;
  @Attribute (required = false)
  private String mediaType;
  @Attribute (required = false)
  private URI about;
  @Element (required = false)
  private ResourceReference mediator;
  @ElementList (entry = "source", inline = true, required = false)
  private List<SourceReference> sources;
  @Element (required = false)
  private ResourceReference analysis;
  @Element (required = false)
  private SourceReference componentOf;
  @ElementList (entry = "title", inline = true, required = false)
  private List<TextValue> titles;
  @ElementList (entry = "note", inline = true, required = false)
  private List<Note> notes;
  @Element (required = false)
  private Attribution attribution;
  @Attribute (required = false)
  private URI resourceType; // from ResourceType
  @Element (required = false)
  private String sortKey;
  @ElementList (entry = "description", inline = true, required = false)
  private List<TextValue> description;
  @ElementList (entry = "identifier", inline = true, required = false)
  private List<Identifier> identifiers;
  @Element (required = false)
  private Date created;
  @Element (required = false)
  private Date modified;
  @ElementList (entry = "coverage", inline = true, required = false)
  private List<Coverage> coverage;
  @Element (required = false)
  private ResourceReference repository;
  @Element (name = "descriptor", required = false)
  private ResourceReference descriptorRef;

  /**
   * The type of the resource being described.
   *
   * @return The type of the resource being described.
   */
  public URI getResourceType() {
    return resourceType;
  }

  /**
   * The type of the resource being described.
   *
   * @param resourceType The type of the resource being described.
   */
  public void setResourceType( URI resourceType ) {
    this.resourceType = resourceType;
  }

  /**
   * The type of the resource being described.
   *
   * @return The type of the resource being described.
   */
  public ResourceType getKnownType() {
    return getResourceType() == null ? null : ResourceType.fromQNameURI( getResourceType() );
  }

  /**
   * The type of the resource being described.
   *
   * @param type The type of the resource being described.
   */
  public void setKnownType( ResourceType type ) {
    setResourceType(type == null ? null : URI.create( EnumUtil.toURIValue( type )));
  }

  /**
   * The preferred bibliographic citation for this source.
   *
   * @return The preferred bibliographic citation for this source.
   */
  public SourceCitation getCitation() {
    return citations == null || citations.isEmpty() ? null : citations.get( 0 );
  }

  /**
   * The bibliographic citations for this source.
   *
   * @return The bibliographic citations for this source.
   */
  public List<SourceCitation> getCitations() {
    return citations;
  }

  /**
   * Hint about the media (MIME) type of the resource being described.
   *
   * @return Hint about the media (MIME) type of the resource being described.
   */
  public String getMediaType() {
    return mediaType;
  }

  /**
   * Hint about the media (MIME) type of the resource being described.
   *
   * @param mediaType Hint about the media (MIME) type of the resource being described.
   */
  public void setMediaType( String mediaType ) {
    this.mediaType = mediaType;
  }

  /**
   * The bibliographic citations for this source.
   *
   * @param citations The bibliographic citations for this source.
   */
  public void setCitations( List<SourceCitation> citations ) {
    this.citations = citations;
  }

  /**
   * The URI (if applicable) of the actual source.
   *
   * @return The URI (if applicable) of the actual source.
   */
  public URI getAbout() {
    return about;
  }

  /**
   * The URI (if applicable) of the actual source.
   *
   * @param about The URI (if applicable) of the actual source.
   */
  public void setAbout( URI about ) {
    this.about = about;
  }

  /**
   * A reference to the entity that mediates access to the described source.
   *
   * @return A reference to the entity that mediates access to the described source.
   */
  public ResourceReference getMediator() {
    return mediator;
  }

  /**
   * A reference to the entity that mediates access to the described source.
   *
   * @param mediator A reference to the entity that mediates access to the described source.
   */
  public void setMediator( ResourceReference mediator ) {
    this.mediator = mediator;
  }

  /**
   * A reference to the entity that mediates access to the described source.
   *
   * @param mediator A reference to the entity that mediates access to the described source.
   */
  public void setMediatorURI( URI mediator ) {
    this.mediator = mediator != null ? new ResourceReference( mediator ) : null;
  }

  /**
   * References to any sources to which this source is related (usually applicable to sources that are derived from or contained in another source).
   *
   * @return References to any sources to which this source is related (usually applicable to sources that are derived from or contained in another source).
   */
  public List<SourceReference> getSources() {
    return sources;
  }

  /**
   * References to any sources to which this source is related (usually applicable to sources that are derived from or contained in another source).
   *
   * @param sources References to any sources to which this source is related (usually applicable to sources that are derived from or contained in another source).
   */
  public void setSources( List<SourceReference> sources ) {
    this.sources = sources;
  }

  /**
   * A reference to the analysis document explaining the analysis that went into this description of the source.
   *
   * @return A reference to the analysis document explaining the analysis that went into this description of the source.
   */
  public ResourceReference getAnalysis() {
    return analysis;
  }

  /**
   * A reference to the analysis document explaining the analysis that went into this description of the source.
   *
   * @param analysis A reference to the analysis document explaining the analysis that went into this description of the source.
   */
  public void setAnalysis( ResourceReference analysis ) {
    this.analysis = analysis;
  }

  /**
   * A reference to the source that contains this source.
   *
   * @return A reference to the source that contains this source.
   */
  public SourceReference getComponentOf() {
    return componentOf;
  }

  /**
   * A reference to the source that contains this source.
   *
   * @param componentOf A reference to the source that contains this source.
   */
  public void setComponentOf( SourceReference componentOf ) {
    this.componentOf = componentOf;
  }

  /**
   * The preferred title for this source description.
   *
   * @return The preferred title for this source description.
   */
  public TextValue getTitle() {
    return this.titles == null || this.titles.isEmpty() ? null : this.titles.get( 0 );
  }

  /**
   * A list of titles for this source.
   *
   * @return A list of titles for this source.
   */
  public List<TextValue> getTitles() {
    return titles;
  }

  /**
   * A list of titles for this source.
   *
   * @param titles A list of titles for this source.
   */
  public void setTitles( List<TextValue> titles ) {
    this.titles = titles;
  }

  /**
   * Notes about a source.
   *
   * @return Notes about a source.
   */
  public List<Note> getNotes() {
    return notes;
  }

  /**
   * Notes about a source.
   *
   * @param notes Notes about a source.
   */
  public void setNotes( List<Note> notes ) {
    this.notes = notes;
  }

  /**
   * The attribution metadata for this source description.
   *
   * @return The attribution metadata for this source description.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this source description.
   *
   * @param attribution The attribution metadata for this source description.
   */
  public void setAttribution( Attribution attribution ) {
    this.attribution = attribution;
  }


  /**
   * Find the long-term, persistent identifier for this source from the list of identifiers.
   *
   * @return The long-term, persistent identifier for this source.
   */
  public URI getPersistentId() {
    URI identifier = null;
    if (this.identifiers != null) {
      for (Identifier id : this.identifiers) {
        if (IdentifierType.Persistent.equals( id.getKnownType() )) {
          identifier = id.getValue();
          break;
        }
      }
    }
    return identifier;
  }

  /**
   * A long-term, persistent, globally unique identifier for this source.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this source.
   */
  public void setPersistentId( URI persistentId ) {
    if (this.identifiers == null) {
      this.identifiers = new ArrayList<Identifier>();
    }

    //clear out any other primary ids.
    Iterator<Identifier> it = this.identifiers.iterator();
    while (it.hasNext()) {
      if (IdentifierType.Persistent.equals( it.next().getKnownType() )) {
        it.remove();
      }
    }

    Identifier identifier = new Identifier();
    identifier.setKnownType( IdentifierType.Persistent );
    identifier.setValue( persistentId );
    this.identifiers.add( identifier );
  }

  /**
   * The list of identifiers for the source.
   *
   * @return The list of identifiers for the source.
   */
  public List<Identifier> getIdentifiers() {
    return identifiers;
  }

  /**
   * The list of identifiers of the source.
   *
   * @param identifiers The list of identifiers of the source.
   */
  public void setIdentifiers( List<Identifier> identifiers ) {
    this.identifiers = identifiers;
  }

  /**
   * A sort key to be used in determining the position of this source relative to other sources in the same collection.
   *
   * @return A sort key to be used in determining the position of this source relative to other sources in the same collection.
   */
  public String getSortKey() {
    return sortKey;
  }

  /**
   * A sort key to be used in determining the position of this source relative to other sources in the same collection.
   *
   * @param sortKey A sort key to be used in determining the position of this source relative to other sources in the same collection.
   */
  public void setSortKey( String sortKey ) {
    this.sortKey = sortKey;
  }

  /**
   * Human-readable descriptions of the source.
   *
   * @return Human-readable descriptions of the source.
   */
  public List<TextValue> getDescription() {
    return description;
  }

  /**
   * Human-readable descriptions of the source.
   *
   * @param description Human-readable descriptions of the source.
   */
  public void setDescription( List<TextValue> description ) {
    this.description = description;
  }

  /**
   * The date the source was created.
   *
   * @return The date the source was created.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * The date the source was created.
   *
   * @param created The date the source was created.
   */
  public void setCreated( Date created ) {
    this.created = created;
  }

  /**
   * The date the source was last modified.
   *
   * @return The date the source was last modified.
   */
  public Date getModified() {
    return modified;
  }

  /**
   * The date the source was last modified.
   *
   * @param modified The date the source was last modified.
   */
  public void setModified( Date modified ) {
    this.modified = modified;
  }

  /**
   * Declarations of the coverage of the source.
   *
   * @return Declarations of the coverage of the source.
   */
  public List<Coverage> getCoverage() {
    return coverage;
  }

  /**
   * Declarations of the coverage of the source.
   *
   * @param coverage Declarations of the coverage of the source.
   */
  public void setCoverage( List<Coverage> coverage ) {
    this.coverage = coverage;
  }

  /**
   * Reference to an agent describing the repository in which the source is found.
   *
   * @return Reference to an agent describing the repository in which the source is found.
   */
  public ResourceReference getRepository() {
    return repository;
  }

  /**
   * Reference to an agent describing the repository in which the source is found.
   *
   * @param repository Reference to an agent describing the repository in which the source is found.
   */
  public void setRepository( ResourceReference repository ) {
    this.repository = repository;
  }

  /**
   * Reference to a descriptor of fields and type of data that can be expected to be extracted from the source.
   *
   * @return Reference to a descriptor of fields and type of data that can be expected to be extracted from the source.
   */
  public ResourceReference getDescriptorRef() {
    return descriptorRef;
  }

  /**
   * Reference to a descriptor of fields and type of data that can be expected to be extracted from the source.
   *
   * @param descriptorRef Reference to a descriptor of fields and type of data that can be expected to be extracted from the source.
   */
  public void setDescriptorRef( ResourceReference descriptorRef ) {
    this.descriptorRef = descriptorRef;
  }
}
