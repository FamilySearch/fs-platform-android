package org.familysearch.android.volley;

import com.android.volley.Response;
import org.familysearch.platform.FamilySearchConstants;
import org.familysearch.platform.FamilySearchPlatform;
import org.gedcomx.rt.GedcomxSerializer;

/**
 * A REST request builder that will create a Volley request that can be added to the Volley request queue.
 * The body is serialized as a FamilySearchPlatform.class and the appropriate Accept (FamilySearchConstants.FS_PLATFORM_V1_XML_MEDIA_TYPE)
 * and Content-Type (FamilySearchConstants.FS_PLATFORM_V1_XML_MEDIA_TYPE) headers are set.
 * <p>Common usage is as follows:<pre>
  volleyRequestQueue.add(
    new FsPlatformRequest().path( url ).session( sessionId )
      .get( new Response.Listener<FamilySearchPlatform>() {
              public void onResponse( FamilySearchPlatform doc ) {
              }
            },
            new Response.ErrorListener() {
              public void onErrorResponse( VolleyError error ) {
                Log.e( "", "error", error );
              }
            } ) );
 * </pre>
 *
 * </p>
 * @author Reed Ellsworth
 */
public class FsPlatformRequest extends RestRequest<FamilySearchPlatform>
{
  public FsPlatformRequest() {
    super( FamilySearchPlatform.class );
    setAcceptType( FamilySearchConstants.FS_PLATFORM_V1_XML_MEDIA_TYPE );
    setContentType( FamilySearchConstants.FS_PLATFORM_V1_XML_MEDIA_TYPE );
    setXmlSerializer( GedcomxSerializer.create() );
  }

  @Override
  public FsPlatformRequest accept( String... acceptTypes ) {
    super.accept( acceptTypes );
    return this;
  }

  @Override
  public FsPlatformRequest header( String name, String value ) {
    super.header( name, value );
    return this;
  }

  @Override
  public FsPlatformRequest queryParam( String name, String value ) {
    super.queryParam( name, value );
    return this;
  }

  @Override
  public FsPlatformRequest path( String path ) {
    super.path( path );
    return this;
  }

  @Override
  public FsPlatformRequest session( String sessionId ) {
    super.session( sessionId );
    return this;
  }

  @Override
  public FsPlatformRequest timeout( int msTimeout ) {
    super.timeout( msTimeout );
    return this;
  }

  @Override
  public XmlRequest<FamilySearchPlatform> get( Response.Listener<FamilySearchPlatform> listener, Response.ErrorListener errorListener ) {
    return super.get( listener, errorListener );
  }

  @Override
  public XmlRequest<FamilySearchPlatform> post( FamilySearchPlatform body, Response.Listener<FamilySearchPlatform> listener, Response.ErrorListener errorListener ) {
    return super.post( body, listener, errorListener );
  }
}
