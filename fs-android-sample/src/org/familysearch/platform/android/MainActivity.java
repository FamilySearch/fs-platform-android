package org.familysearch.platform.android;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import net.neilgoodman.loader.RESTLoader;
import net.neilgoodman.loader.RESTResponse;
import org.gedcomx.Gedcomx;
import org.gedcomx.conclusion.Person;
import org.gedcomx.rt.GedcomxSerializer;
import org.simpleframework.xml.Serializer;


public class MainActivity extends Activity implements LoaderManager.LoaderCallbacks<RESTResponse>
{
  private static final int LOGIN_REQUEST = 1;
  private static final int LOADER_CURRENT_PERSON = 0x2;
  private static final String platformPath = "https://sandbox.familysearch.org/platform/";

  private String sessionId = null;

  @Override
  public void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.main );
  }

  public void login(View v) {
    startActivityForResult( new Intent( this, LoginActivity.class ), LOGIN_REQUEST );
  }

  @Override
  protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
    switch(requestCode) {
      case LOGIN_REQUEST:
        if (resultCode == RESULT_OK) {
          sessionId = data.getStringExtra( LoginActivity.SESSION_ID );
          Log.d( "onActivityResult", "SESSION_ID:" + sessionId );
          TextView txtSessionId = (TextView) findViewById( R.id.login_session_id );
          txtSessionId.setText( "Session: " + sessionId );
          TextView txtPerson = (TextView) findViewById( R.id.login_person_name );
          txtPerson.setText( "" );
          getCurrentPerson();
        }
        break;
    }
  }

  private void getCurrentPerson() {
    if (sessionId == null)
      return;
    Uri uri = Uri.parse(platformPath + "tree/current-person");
    Bundle headers = new Bundle();
    headers.putString("Authorization", "Bearer " + sessionId);
    headers.putString("Accept", "application/x-gedcomx-v1+xml");

    Bundle args = new Bundle();
    args.putSerializable(RESTLoader.ARGS_VERB, RESTLoader.HTTPVerb.GET);
    args.putParcelable( RESTLoader.ARGS_URI, uri);
    args.putParcelable( RESTLoader.ARGS_HEADERS, headers);

    getLoaderManager().restartLoader( LOADER_CURRENT_PERSON, args, this );
  }

  @Override
  public Loader<RESTResponse> onCreateLoader(int id, Bundle args) {
    return RESTLoader.create( this, args );
  }

  @Override
  public void onLoadFinished(Loader<RESTResponse> loader, RESTResponse response) {
    int    code = response.getCode();
    String data = response.getData();

    Log.d( getLocalClassName(), "onLoadFinished(" + loader.getId() + ") " + code + ": " + data );

    if (loader.getId() == LOADER_CURRENT_PERSON) {
      if (code == 200 && !data.equals( "" )) {
        Serializer serializer = GedcomxSerializer.create();
        try {
          Gedcomx doc = serializer.read( Gedcomx.class, data );
          if (doc.getPersons() != null && doc.getPersons().size() > 0) {
            Person person = doc.getPersons().get( 0 );
            Log.i( getLocalClassName(), "persons " + doc.getPersons().size() + ": " + person.getId() );
            TextView txtPerson = (TextView) findViewById( R.id.login_person_name );
            txtPerson.setText( "Logged in: " + person.getDisplayExtension().getName() + " (" + person.getId() + ")" );
          }
        }
        catch (Exception e) {
          Log.e( getLocalClassName(), "error", e );
        }
      }
    }
  }

  @Override
  public void onLoaderReset( Loader<RESTResponse> loader ) {
  }
}
