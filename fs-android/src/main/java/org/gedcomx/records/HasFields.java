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

import java.util.List;

/**
 * @author Reed Ellsworth
 */
public interface HasFields
{

  /**
   * The references to the record field values being used as evidence.
   *
   * @return The references to the record field values being used as evidence.
   */
  List<Field> getFields();

  /**
   * The references to the record field values being used as evidence.
   *
   * @param fields The references to the record field values being used as evidence.
   */
  void setFields( List<Field> fields );

}
