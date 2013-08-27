package org.familysearch.platform;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Mike Gardiner
 */
@Root (strict = false)
public class HealthConfig
{
  @Element (required = false)
  private String databaseVersion;
  @Element (required = false)
  private String buildVersion;
  @Element (required = false)
  private String buildDate;
  @Element (required = false)
  private String platformVersion;

  public String getPlatformVersion() {
    return platformVersion;
  }

  public void setPlatformVersion( String platformVersion ) {
    this.platformVersion = platformVersion;
  }

  public String getDatabaseVersion() {
    return databaseVersion;
  }

  public void setDatabaseVersion( String databaseVersion ) {
    this.databaseVersion = databaseVersion;
  }

  public String getBuildVersion() {
    return buildVersion;
  }

  public void setBuildVersion( String buildVersion ) {
    this.buildVersion = buildVersion;
  }

  public String getBuildDate() {
    return buildDate;
  }

  public void setBuildDate( String buildDate ) {
    this.buildDate = buildDate;
  }
}
