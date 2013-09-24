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
package org.familysearch.platform.media;

import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;


/**
 * Enumeration of known media artifact types.
 *
 * @author Ryan Heaton
 */
public enum MediaArtifactType {

  /**
   * The media artifact is a photo.
   */
  Photo,

  /**
   * The media artifact is a portrait.
   */
  Portrait,

  /**
   * The media artifact is a story.
   */
  Story,

  /**
   * Custom
   */
  OTHER;

  /**
   * Return the QName value for this enum.
   *
   * @return The QName value for this enum.
   */
  public URI toQNameURI() {
    return URI.create( EnumUtil.toURIValue( this ) );
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static MediaArtifactType fromQNameURI(URI qname) {
    return EnumUtil.fromURIValue( qname.toString(), MediaArtifactType.class );
  }

}
