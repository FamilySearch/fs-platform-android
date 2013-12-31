package org.gedcomx.rt;

import org.gedcomx.common.URI;
import org.simpleframework.xml.transform.Transform;

/**
 * @author Reed Ellsworth
 */
public class UriTransformer implements Transform<URI>
{
  @Override
  public URI read( String value ) throws Exception {
    return URI.create( value );
  }

  @Override
  public String write( URI value ) throws Exception {
    return value.toString();
  }
}