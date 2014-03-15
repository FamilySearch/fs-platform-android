package org.familysearch.platform.media;

import org.gedcomx.common.URI;
import org.gedcomx.rt.EnumUtil;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * FamilySearch-specific metadata about a media artifact.
 *
 * @author Ryan Heaton
 */
@Root (strict = false)
public class MediaMetadata {

  @Element (required = false)
  private String filename;
  @Attribute (required = false)
  private URI artifactType;

  /**
   * The original filename of the media item.
   *
   * @return The original filename of the media item.
   */
  public String getFilename() {
    return filename;
  }

  /**
   * The original filename of the media item.
   *
   * @param filename The original filename of the media item.
   */
  public void setFilename(String filename) {
    this.filename = filename;
  }

  /**
   * The type of the gender.
   *
   * @return The type of the gender.
   */
  public org.gedcomx.common.URI getArtifactType() {
    return artifactType;
  }

  /**
   * The type of the gender.
   *
   * @param artifactType The type of the gender.
   */
  public void setArtifactType(URI artifactType) {
    this.artifactType = artifactType;
  }

  /**
   * The known type of the gender.
   *
   * @return The type of the gender.
   */
  public MediaArtifactType getKnownType() {
    return getArtifactType() == null ? null : MediaArtifactType.fromQNameURI(getArtifactType());
  }

  /**
   * The type of the gender.
   *
   * @param type The type of the gender.
   */
  public void setKnownType(MediaArtifactType type) {
    setArtifactType(type == null ? null : URI.create( EnumUtil.toURIValue( type ) ));
  }

}
