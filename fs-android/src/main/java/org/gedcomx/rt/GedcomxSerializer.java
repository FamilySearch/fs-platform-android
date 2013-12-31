package org.gedcomx.rt;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.util.Date;

/**
 * @author Reed Ellsworth
 */
public class GedcomxSerializer
{
  public static Serializer create() {
    RegistryMatcher m = new RegistryMatcher();
    m.bind( org.gedcomx.common.URI.class, UriTransformer.class );
    m.bind( Date.class, DateTransformer.class );
    return new Persister( m );
  }
}
