package org.familysearch.android.volley;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import org.simpleframework.xml.Serializer;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class RestRequest<T>
{
  String path = null;
  Map<String, String> headers = null;
  Map<String, String> queryParams = null;
  private final Class<T> cls;
  private String acceptType = "application/xml";
  private String contentType = null;
  private Serializer xmlSerializer = null;
  private int timeout = -1;

  public RestRequest( Class<T> cls ) {
    this.cls = cls;
  }

  protected void setContentType( String contentType ) {
    this.contentType = contentType;
  }

  protected void setAcceptType( String acceptType ) {
    this.acceptType = acceptType;
  }

  protected void setXmlSerializer( Serializer xmlSerializer ) {
    this.xmlSerializer = xmlSerializer;
  }

  public RestRequest<T> path( String path ) {
    this.path = path;
    return this;
  }

  public RestRequest<T> header( String name, String value ) {
    if (headers == null) {
      headers = new HashMap<String, String>();
    }
    headers.put( name, value );
    return this;
  }

  public RestRequest<T> queryParam( String name, String value ) {
    if (queryParams == null) {
      queryParams = new HashMap<String, String>();
    }
    queryParams.put( name, value );
    return this;
  }

  public RestRequest<T> session( String sessionId ) {
    return header( "Authorization", "Bearer " + sessionId );
  }

  public RestRequest<T> accept( String... acceptTypes ) {
    StringBuilder acceptType = new StringBuilder();
    for (String type : acceptTypes) {
      if (acceptType.length() > 0)
        acceptType.append( ";" );
      acceptType.append( type );
    }
    return header( "Accept", acceptType.toString() );
  }

  public RestRequest<T> type( String contentType ) {
    return header( "Content-Type", contentType );
  }

  private String getUrl() {
    StringBuilder s = new StringBuilder( path );
    if (queryParams != null && queryParams.size() > 0) {
      s.append( "?" );
      boolean isFirst = true;
      for (Map.Entry<String, String> param : queryParams.entrySet()) {
        if (!isFirst)
          s.append( "&" );
        s.append( param.getKey() ).append( "=" ).append( param.getValue() );
        isFirst = false;
      }
    }
    return s.toString();
  }

  public RestRequest<T> timeout( int msTimeout ) {
    timeout = msTimeout;
    return this;
  }

  public XmlRequest<T> get( Response.Listener<T> listener, Response.ErrorListener errorListener ) {
    if (acceptType != null && (headers == null || !headers.containsKey( "Accept" ))) {
      header( "Accept", acceptType );
    }
    XmlRequest<T> xmlRequest = new XmlRequest<T>( Request.Method.GET, getUrl(), cls, headers, listener, errorListener );
    if (xmlSerializer != null)
      xmlRequest.setSerializer( xmlSerializer );
    if (timeout > 0)
      xmlRequest.setRetryPolicy( new DefaultRetryPolicy( timeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ) );
    return xmlRequest;
  }

  public XmlRequest<T> post( T body, Response.Listener<T> listener, Response.ErrorListener errorListener ) {
    if (contentType != null && (headers == null || !headers.containsKey( "Content-Type" ))) {
      header( "Content-Type", contentType );
    }
    XmlRequest<T> xmlRequest = new XmlRequest<T>( Request.Method.POST, getUrl(), cls, headers, listener, errorListener );
    if (xmlSerializer != null)
      xmlRequest.setSerializer( xmlSerializer );
    xmlRequest.setBody( body );
    return xmlRequest;
  }
}
