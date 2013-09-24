package org.familysearch.android.volley;

import com.android.volley.Response;
import org.gedcomx.Gedcomx;
import org.gedcomx.rt.GedcomxConstants;
import org.gedcomx.rt.GedcomxSerializer;

/**
 * A REST request builder that will create a Volley request that can be added to the Volley request queue.
 * The body is serialized as a Gedcomx.class and the appropriate Accept (GedcomxConstants.GEDCOMX_XML_MEDIA_TYPE)
 * and Content-Type (FamilySearchConstants.GEDCOMX_XML_MEDIA_TYPE) headers are set.
 * <p>Common usage is as follows:<pre>
  volleyRequestQueue.add(
    new GedcomxRequest().path( url ).session( sessionId )
      .get( new Response.Listener<Gedcomx>() {
              public void onResponse( Gedcomx doc ) {
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
public class GedcomxRequest extends RestRequest<Gedcomx>
{
  public GedcomxRequest() {
    super( Gedcomx.class );
    setAcceptType( GedcomxConstants.GEDCOMX_XML_MEDIA_TYPE );
    setContentType( GedcomxConstants.GEDCOMX_XML_MEDIA_TYPE );
    setXmlSerializer( GedcomxSerializer.create() );
  }

  @Override
  public GedcomxRequest accept( String... acceptTypes ) {
    super.accept( acceptTypes );
    return this;
  }

  @Override
  public GedcomxRequest header( String name, String value ) {
    super.header( name, value );
    return this;
  }

  @Override
  public GedcomxRequest queryParam( String name, String value ) {
    super.queryParam( name, value );
    return this;
  }

  @Override
  public GedcomxRequest path( String path ) {
    super.path( path );
    return this;
  }

  @Override
  public GedcomxRequest session( String sessionId ) {
    super.session( sessionId );
    return this;
  }

  @Override
  public XmlRequest<Gedcomx> get( Response.Listener<Gedcomx> listener, Response.ErrorListener errorListener ) {
    return super.get( listener, errorListener );
  }

  @Override
  public XmlRequest<Gedcomx> post( Gedcomx body, Response.Listener<Gedcomx> listener, Response.ErrorListener errorListener ) {
    return super.post( body, listener, errorListener );
  }
}
