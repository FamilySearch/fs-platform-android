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
package org.gedcomx.records;

import org.gedcomx.common.URI;
import org.gedcomx.links.HypermediaEnabledData;
import org.gedcomx.rt.EnumUtil;
import org.gedcomx.types.FacetType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import java.util.List;

/**
 * <p>A <tt>facet</tt> is a logical grouping of resources by specific criteria, used for convenience in browsing a collection or a set of search results.</p>
 */
@Order (elements = {"title", "key", "facet", "value"})
public class Facet extends HypermediaEnabledData
{
  @Attribute (required = false)
  private URI type; // from FacetType
  private String title;
  private String key;
  @ElementList (entry = "facet", required = false)
  private List<Facet> facets;
  @ElementList (entry = "value", required = false)
  private List<FacetValue> values;

  /**
   * The type of the facet.
   *
   * @return The type of the facet.
   */
  public URI getType() {
    return type;
  }

  /**
   * The type of the facet.
   *
   * @param type The type of the facet.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * The known type of the facet.
   *
   * @return The type of the facet.
   */
  public FacetType getKnownType() {
    return getType() == null ? null : FacetType.fromQNameURI( getType() );
  }

  /**
   * The type of the facet.
   *
   * @param type The type of the facet.
   */
  public void setKnownType( FacetType type ) {
    setType(type == null ? null : URI.create( EnumUtil.toURIValue( type )));
  }

  /**
   * A title for the facet.
   *
   * @return A title for the facet.
   */
  public String getTitle() {
    return title;
  }

  /**
   * A title for the facet.
   *
   * @param title A title for the facet.
   */
  public void setTitle( String title ) {
    this.title = title;
  }

  /**
   * A key unique within the context of this facet, used to apply the facet.
   *
   * @return A key unique within the context of this facet, used to apply the facet.
   */
  public String getKey() {
    return key;
  }

  /**
   * A key unique within the context of this facet, used to apply the facet.
   *
   * @param key A key unique within the context of this facet, used to apply the facet.
   */
  public void setKey( String key ) {
    this.key = key;
  }

  /**
   * The set of sub-facets of this facet.
   *
   * @return The set of sub-facets of this facet.
   */
  public List<Facet> getFacets() {
    return facets;
  }

  /**
   * The set of sub-facets of this facet.
   *
   * @param facets The set of sub-facets of this facet.
   */
  public void setFacets( List<Facet> facets ) {
    this.facets = facets;
  }

  /**
   * The set of values for the field.
   *
   * @return The set of values for the field.
   */
  public List<FacetValue> getValues() {
    return values;
  }

  /**
   * The set of values for the field.
   *
   * @param values The set of values for the field.
   */
  public void setValues( List<FacetValue> values ) {
    this.values = values;
  }

}
