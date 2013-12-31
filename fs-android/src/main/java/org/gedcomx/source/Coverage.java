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

import org.gedcomx.common.URI;
import org.gedcomx.conclusion.Date;
import org.gedcomx.conclusion.PlaceReference;
import org.gedcomx.links.HypermediaEnabledData;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.RecordType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * A description of the coverage of a resource.
 *
 * @author Reed Ellsworth
 */
@Root (strict = false)
public class Coverage extends HypermediaEnabledData
{

  @Element (required = false)
  private PlaceReference spatial;
  @Element (required = false)
  private Date temporal;
  @Element (required = false)
  private URI recordType;

  /**
   * Spatial coverage.
   *
   * @return Spatial coverage.
   */
  public PlaceReference getSpatial() {
    return spatial;
  }

  /**
   * Spatial coverage.
   *
   * @param spatial Spatial coverage.
   */
  public void setSpatial( PlaceReference spatial ) {
    this.spatial = spatial;
  }

  /**
   * Temporal coverage.
   *
   * @return Temporal coverage.
   */
  public Date getTemporal() {
    return temporal;
  }

  /**
   * Temporal coverage.
   *
   * @param temporal Temporal coverage.
   */
  public void setTemporal( Date temporal ) {
    this.temporal = temporal;
  }

  /**
   * The type of record being covered, if any.
   *
   * @return The type of record being covered.
   */
  public URI getRecordType() {
    return recordType;
  }

  /**
   * The type of record being covered, if any.
   *
   * @param recordType The type of record being covered.
   */
  public void setRecordType( URI recordType ) {
    this.recordType = recordType;
  }

  /**
   * The type of record being covered in this collection, if any.
   *
   * @return The type of record being covered in this collection, if any.
   */
  public RecordType getKnownRecordType() {
    return getRecordType() == null ? null : RecordType.fromQNameURI( getRecordType() );
  }

  /**
   * The type of record being covered in this collection, if any.
   *
   * @param type The type of record being covered in this collection, if any.
   */
  public void setKnownRecordType( RecordType type ) {
    setRecordType(type == null ? null : URI.create( EnumUtil.toURIValue( type )));
  }

}
