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
package org.gedcomx.agent;

import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.TextValue;
import org.gedcomx.conclusion.Identifier;
import org.gedcomx.links.HypermediaEnabledData;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;


/**
 * An agent, e.g. person, organization, or group. In genealogical research, an agent often
 * takes the role of a contributor.
 *
 * @author Reed Ellsworth
 * @see <a href="http://xmlns.com/foaf/spec/#term_Agent">foaf:Agent</a>
 */
@Root (strict = false)
public class Agent extends HypermediaEnabledData
{

  @ElementList (entry = "name", inline = true, required = false)
  private List<TextValue> names;
  @ElementList (entry = "identifier", inline = true, required = false)
  private List<Identifier> identifiers;
  @Element (required = false)
  private ResourceReference homepage;
  @Element (required = false)
  private ResourceReference openid;
  @ElementList (entry = "account", inline = true, required = false)
  private List<OnlineAccount> accounts;
  @ElementList (entry = "email", inline = true, required = false)
  private List<ResourceReference> emails;
  @ElementList (entry = "phone", inline = true, required = false)
  private List<ResourceReference> phones;
  @ElementList (entry = "address", inline = true, required = false)
  private List<Address> addresses;

  /**
   * The preferred name for this agent.
   *
   * @return The preferred name for this agent.
   */
  public TextValue getName() {
    return this.names == null || this.names.isEmpty() ? null : this.names.get( 0 );
  }

  /**
   * The list of names for the agent.
   *
   * @return The list of names for the agent.
   */
  public List<TextValue> getNames() {
    return names;
  }

  /**
   * The list of names for the agent.
   *
   * @param names The list of names for the agent.
   */
  public void setNames( List<TextValue> names ) {
    this.names = names;
  }

  /**
   * The list of identifiers for the agent.
   *
   * @return The list of identifiers for the agent.
   */
  public List<Identifier> getIdentifiers() {
    return identifiers;
  }

  /**
   * The list of identifiers of the agent.
   *
   * @param identifiers The list of identifiers of the agent.
   */
  public void setIdentifiers( List<Identifier> identifiers ) {
    this.identifiers = identifiers;
  }

  /**
   * The homepage of the person or organization. Note this is different from the
   * homepage of the service where the person or organization has an account.
   *
   * @return The homepage.
   */
  public ResourceReference getHomepage() {
    return homepage;
  }

  /**
   * The homepage of the person or organization. Note this is different from the
   * homepage of the service where the person or organization has an account.
   *
   * @param homepage The homepage.
   */
  public void setHomepage( ResourceReference homepage ) {
    this.homepage = homepage;
  }

  /**
   * The <a href="http://openid.net/">openid</a> of the person or organization.
   *
   * @return The <a href="http://openid.net/">openid</a> of the person or organization.
   */
  public ResourceReference getOpenid() {
    return openid;
  }

  /**
   * The <a href="http://openid.net/">openid</a> of the person or organization.
   *
   * @param openid The <a href="http://openid.net/">openid</a> of the person or organization.
   */
  public void setOpenid( ResourceReference openid ) {
    this.openid = openid;
  }

  /**
   * The accounts that belong to this person or organization.
   *
   * @return The accounts that belong to this person or organization.
   */
  public List<OnlineAccount> getAccounts() {
    return accounts;
  }

  /**
   * The accounts that belong to this person or organization.
   *
   * @param accounts The accounts that belong to this person or organization.
   */
  public void setAccounts( List<OnlineAccount> accounts ) {
    this.accounts = accounts;
  }

  /**
   * The emails that belong to this person or organization.
   *
   * @return The emails that belong to this person or organization.
   */
  public List<ResourceReference> getEmails() {
    return emails;
  }

  /**
   * The emails that belong to this person or organization.
   *
   * @param emails The emails that belong to this person or organization.
   */
  public void setEmails( List<ResourceReference> emails ) {
    this.emails = emails;
  }

  /**
   * The phones that belong to this person or organization.
   *
   * @return The phones that belong to this person or organization.
   */
  public List<ResourceReference> getPhones() {
    return phones;
  }

  /**
   * The phones that belong to this person or organization.
   *
   * @param phones The phones that belong to this person or organization.
   */
  public void setPhones( List<ResourceReference> phones ) {
    this.phones = phones;
  }

  /**
   * The addresses that belong to this person or organization.
   *
   * @return The addresses that belong to this person or organization.
   */
  @SuppressWarnings ("gedcomx:plural_xml_name")
  public List<Address> getAddresses() {
    return addresses;
  }

  /**
   * The addresses that belong to this person or organization.
   *
   * @param addresses The addresses that belong to this person or organization.
   */
  public void setAddresses( List<Address> addresses ) {
    this.addresses = addresses;
  }


}
