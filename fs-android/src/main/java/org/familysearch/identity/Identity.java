package org.familysearch.identity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * <identity xmlns="http://api.familysearch.org/identity/v2" statusCode="200" statusMessage="OK" version="2.7.20130703.0247">
 * <session id="USYSA1FE77F709E524BC173BC04ACE37722A_idses-prod03.a.fsglobal.net" />
 * </identity>
 */
@Root (strict = false)
public class Identity
{
  @Attribute (required = false)
  public Integer statusCode;

  @Attribute (required = false)
  public String statusMessage;

  @Attribute (required = false)
  public String version;

  @Element (required = false)
  private Session session;

  public Session getSession() {
    return this.session;
  }
}
