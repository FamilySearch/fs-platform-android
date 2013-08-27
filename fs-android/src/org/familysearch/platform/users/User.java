package org.familysearch.platform.users;

import org.gedcomx.links.HypermediaEnabledData;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Family Tree User Service User
 */
@Root (strict = false)
public class User extends HypermediaEnabledData
{
  @Element (required = false)
  private String id;
  @Element (required = false)
  private String contactName;
  @Element (required = false)
  private String helperAccessPin;
  @Element (required = false)
  private String fullName;
  @Element (required = false)
  private String givenName;
  @Element (required = false)
  private String familyName;
  @Element (required = false)
  private String email;
  @Element (required = false)
  private String alternateEmail;
  @Element (required = false)
  private String country;
  @Element (required = false)
  private String gender;
  @Element (required = false)
  private String birthDate;
  @Element (required = false)
  private String phoneNumber;
  @Element (required = false)
  private String mailingAddress;
  @Element (required = false)
  private String preferredLanguage;
  @Element (required = false)
  private String displayName;
  @Element (required = false)
  private String personId;
  @Element (required = false)
  private String treeUserId;
  @Element (required = false)
  private Boolean ldsMemberAccount;

  public String getId() {
    return id;
  }

  public void setId( String id ) {
    this.id = id;
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName( String contactName ) {
    this.contactName = contactName;
  }

  public String getHelperAccessPin() {
    return helperAccessPin;
  }

  public void setHelperAccessPin( String helperAccessPin ) {
    this.helperAccessPin = helperAccessPin;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName( String fullName ) {
    this.fullName = fullName;
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName( String givenName ) {
    this.givenName = givenName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName( String familyName ) {
    this.familyName = familyName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail( String email ) {
    this.email = email;
  }

  public String getAlternateEmail() {
    return alternateEmail;
  }

  public void setAlternateEmail( String alternateEmail ) {
    this.alternateEmail = alternateEmail;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry( String country ) {
    this.country = country;
  }

  public String getGender() {
    return gender;
  }

  public void setGender( String gender ) {
    this.gender = gender;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate( String birthDate ) {
    this.birthDate = birthDate;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber( String phoneNumber ) {
    this.phoneNumber = phoneNumber;
  }

  public String getMailingAddress() {
    return mailingAddress;
  }

  public void setMailingAddress( String mailingAddress ) {
    this.mailingAddress = mailingAddress;
  }

  public String getPreferredLanguage() {
    return preferredLanguage;
  }

  public void setPreferredLanguage( String preferredLanguage ) {
    this.preferredLanguage = preferredLanguage;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName( String displayName ) {
    this.displayName = displayName;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId( String personId ) {
    this.personId = personId;
  }

  public String getTreeUserId() {
    return treeUserId;
  }

  public void setTreeUserId( String treeUserId ) {
    this.treeUserId = treeUserId;
  }

  public Boolean getLdsMemberAccount() {
    return ldsMemberAccount;
  }

  public void setLdsMemberAccount( Boolean ldsMemberAccount ) {
    this.ldsMemberAccount = ldsMemberAccount;
  }
}
