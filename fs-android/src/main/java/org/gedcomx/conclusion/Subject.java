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

import org.gedcomx.common.Attributable;
import org.gedcomx.common.EvidenceReference;
import org.gedcomx.common.URI;
import org.gedcomx.source.SourceReference;
import org.gedcomx.types.IdentifierType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The <tt>Subject</tt> data type defines the abstract concept of a genealogical <em>subject</em>. A <em>subject</em> is something with a unique and
 * intrinsic identity, e.g., a person, a location on the surface of the earth. We identify that <em>subject</em> in time and space using various supporting
 * <em>conclusions</em>, e.g. for a person: things like name, birth date, age, address, etc. We aggregate these supporting <em>conclusions</em> to form an
 * apparently-unique identity by which we can distinguish our<em>subject</em> from all other possible <em>subjects</em>.
 *
 * @author Reed Ellsworth
 */
@Order (elements = {"evidence", "media", "identifier"})
public abstract class Subject extends Conclusion implements Attributable
{

  @Attribute (required = false)
  private Boolean extracted;
  @ElementList (entry = "identifier", inline = true, required = false)
  private List<Identifier> identifiers;
  @ElementList (entry = "media", inline = true, required = false)
  private List<SourceReference> media;
  @ElementList (entry = "evidence", inline = true, required = false)
  private List<EvidenceReference> evidence;

  /**
   * Whether this subject has been identified as "extracted", meaning it captures information extracted from a single source.
   *
   * @return Whether this subject has been identified as "extracted".
   */
  public Boolean getExtracted() {
    return extracted;
  }

  /**
   * Whether this subject has been identified as "extracted", meaning it captures information extracted from a single source.
   *
   * @param extracted Whether this subject has been identified as "extracted".
   */
  public void setExtracted( Boolean extracted ) {
    this.extracted = extracted;
  }

  /**
   * Find the long-term, persistent identifier for this subject from the list of identifiers.
   *
   * @return The long-term, persistent identifier for this subject.
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
   * A long-term, persistent, globally unique identifier for this subject.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this subject.
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
   * The list of identifiers for the subject.
   *
   * @return The list of identifiers for the subject.
   */
  public List<Identifier> getIdentifiers() {
    return identifiers;
  }

  /**
   * The list of identifiers of the subject.
   *
   * @param identifiers The list of identifiers of the subject.
   */
  public void setIdentifiers( List<Identifier> identifiers ) {
    this.identifiers = identifiers;
  }

  /**
   * Add an identifier of the subject.
   *
   * @param identifier The identifier to be added.
   */
  public void addIdentifier( Identifier identifier ) {
    if (identifier != null) {
      if (identifiers == null) {
        identifiers = new LinkedList<Identifier>();
      }
      identifiers.add( identifier );
    }
  }

  /**
   * References to the evidence being referenced for this subject.
   *
   * @return References to the evidence being referenced.
   */
  public List<EvidenceReference> getEvidence() {
    return evidence;
  }

  /**
   * References to the evidence being referenced for this subject.
   *
   * @param evidence References to the evidence being referenced.
   */
  public void setEvidence( List<EvidenceReference> evidence ) {
    this.evidence = evidence;
  }

  /**
   * Add an evidence reference for this subject.
   *
   * @param evidenceRef The evidence to be added.
   */
  public void addEvidence( EvidenceReference evidenceRef ) {
    if (evidenceRef != null) {
      if (evidence == null) {
        evidence = new LinkedList<EvidenceReference>();
      }
      evidence.add( evidenceRef );
    }
  }

  /**
   * References to multimedia resources associated with this subject.
   *
   * @return References to multimedia resources associated with this subject.
   */
  public List<SourceReference> getMedia() {
    return media;
  }

  /**
   * References to multimedia resources associated with this subject.
   *
   * @param media References to multimedia resources associated with this subject.
   */
  public void setMedia( List<SourceReference> media ) {
    this.media = media;
  }

  /**
   * Add an media reference associated with this subject.
   *
   * @param mediaRef The reference to the media to be added.
   */
  public void addMedia( SourceReference mediaRef ) {
    if (mediaRef != null) {
      if (media == null) {
        media = new LinkedList<SourceReference>();
      }
      media.add( mediaRef );
    }
  }
}
