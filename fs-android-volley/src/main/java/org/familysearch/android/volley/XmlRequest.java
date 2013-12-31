package org.familysearch.android.volley;

import com.android.volley.*;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;
import java.util.Map;

/**
 * Volley adapter for JSON requests that will be parsed into Java objects by Gson.
 */
public class XmlRequest<T> extends Request<T>
{
  Serializer serializer = null;
  private final Class<T> cls;
  private final Map<String, String> headers;
  private final Listener<T> listener;
  private T body = null;

  /**
   * Make a request and return a parsed object from XML using Simple.
   *
   * @param method
   * @param url     URL of the request to make
   * @param cls   Relevant class object, for Gson's reflection
   * @param headers Map of request headers
   */
  public XmlRequest( int method, String url, Class<T> cls, Map<String, String> headers,
                     Listener<T> listener, ErrorListener errorListener ) {
    super( method, url, errorListener );
    this.cls = cls;
    this.headers = headers;
    this.listener = listener;
  }

  public XmlRequest( String url, Class<T> cls, Map<String, String> headers,
                     Listener<T> listener, ErrorListener errorListener ) {
    super( Method.GET, url, errorListener );
    this.cls = cls;
    this.headers = headers;
    this.listener = listener;
  }

  public void setSerializer( Serializer serializer ) {
    this.serializer = serializer;
  }

  public void setBody( T body ) {
    this.body = body;
  }

  @Override
  public Map<String, String> getHeaders() throws AuthFailureError {
    return headers != null ? headers : super.getHeaders();
  }

  @Override
  protected void deliverResponse( T response ) {
    listener.onResponse( response );
  }

  @Override
  public byte[] getBody() throws AuthFailureError {
    if (body == null)
      return super.getBody();
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      serializer.write( body, baos );
      return baos.toByteArray();
    }
    catch (Exception e) {
      VolleyLog.e(e, "error in XmlRequest.getBody");
      return null;
    }
  }

  @Override
  protected Response<T> parseNetworkResponse( NetworkResponse response ) {
    try {
      String data = new String( response.data, HttpHeaderParser.parseCharset( response.headers ) );
      if (serializer == null) {
        serializer = new Persister();
      }
      return Response.success( serializer.read( cls, data ), HttpHeaderParser.parseCacheHeaders( response ) );
    }
    catch (Exception e) {
      return Response.error( new ParseError( e ) );
    }
  }
}