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

import org.gedcomx.common.EvidenceReference;
import org.gedcomx.common.URI;
import org.gedcomx.records.HasFieldBasedEvidence;
import org.gedcomx.types.GenderType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.LinkedList;
import java.util.List;

/**
 * A gender conclusion.
 *
 * @author Reed Ellsworth
 */
@Root ( strict = false )
public class Gender extends Conclusion implements HasFieldBasedEvidence
{
  @Attribute
  private URI type; // from GenderType
  @ElementList ( entry = "fieldValue", inline = true, required = false )
  private List<EvidenceReference> fieldValueReferences;

  /**
   * Default constructor.
   */
  public Gender() {
  }

  /**
   * Constructs a new gender object with the passed in type.
   *
   * @param type The type of the gender.
   */
  public Gender( GenderType type ) {
    setKnownType( type );
  }

  /**
   * The type of the gender.
   *
   * @return The type of the gender.
   */
  public URI getType() {
    return type;
  }

  /**
   * The type of the gender.
   *
   * @param type The type of the gender.
   */
  public void setType( URI type ) {
    this.type = type;
  }

  /**
   * The known type of the gender.
   *
   * @return The type of the gender.
   */
  public GenderType getKnownType() {
    return getType() == null ? null : GenderType.fromQNameURI( getType() );
  }

  /**
   * The type of the gender.
   *
   * @param type The type of the gender.
   */
  public void setKnownType( GenderType type ) {
//    setType(type == null ? null : URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(type)));
  }

  /**
   * The references to the record field values being used as evidence.
   *
   * @return The references to the record field values being used as evidence.
   */
  public List<EvidenceReference> getFieldValueReferences() {
    return fieldValueReferences;
  }

  /**
   * The references to the record field values being used as evidence.
   *
   * @param fieldValueReferences The references to the record field values being used as evidence.
   */
  public void setFieldValueReferences( List<EvidenceReference> fieldValueReferences ) {
    this.fieldValueReferences = fieldValueReferences;
  }

  /**
   * Add a reference to the record field values being used as evidence.
   *
   * @param fieldValueRef The evidence to be added.
   */
  public void addFieldValueReference( EvidenceReference fieldValueRef ) {
    if (fieldValueRef != null) {
      if (fieldValueReferences == null) {
        fieldValueReferences = new LinkedList<EvidenceReference>();
      }
      fieldValueReferences.add( fieldValueRef );
    }
  }

  @Override
  public String toString() {
    return "type=" + getKnownType();
  }


}
