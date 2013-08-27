package org.familysearch.platform.android;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import net.neilgoodman.loader.RESTLoader;
import net.neilgoodman.loader.RESTResponse;
import org.familysearch.identity.Identity;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 * A simple ListActivity that display Tweets that contain the word
 * Android in them.
 *
 * @author Neil Goodman
 *
 */
public class LoginActivity extends Activity implements LoaderManager.LoaderCallbacks<RESTResponse>
{
  private static final int LOADER_LOGIN = 0x1;

  static String identityProdPath = "https://api.familysearch.org/identity/v2/login";
  static String identitySandboxPath = "https://sandbox.familysearch.org/identity/v2/login";
  static final String SESSION_ID = "sessionid";

  private static String getLoginPath() {
    return identitySandboxPath;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView( R.layout.login );
  }

  public void login(View v) {
    EditText txtUserName = (EditText) findViewById( R.id.userName );
    EditText txtPassword = (EditText) findViewById( R.id.password );
    doLogin( txtUserName.getText().toString(), txtPassword.getText().toString() );
  }

  private void doLogin( String username, String password ) {

    Uri uri = Uri.parse(getLoginPath());
    String devKey = "WCQY-7J1Q-GKVV-7DNM-SQ5M-9Q5H-JX3H-CMJK"; // diamondedge sandbox

    Bundle params = new Bundle();
    params.putString("key", devKey);
    Bundle headers = new Bundle();
    headers.putString("Authorization", "Basic " + Base64.encodeToString( (username + ":" + password).getBytes(), Base64.NO_WRAP ));

    Bundle args = new Bundle();
    args.putSerializable(RESTLoader.ARGS_VERB, RESTLoader.HTTPVerb.GET);
    args.putParcelable(RESTLoader.ARGS_URI, uri);
    args.putParcelable(RESTLoader.ARGS_PARAMS, params);
    args.putParcelable(RESTLoader.ARGS_HEADERS, headers);

    getLoaderManager().restartLoader( LOADER_LOGIN, args, this );
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

    if (loader.getId() == LOADER_LOGIN) {
      if (code == 200 && !data.equals("")) {
        Serializer serializer = new Persister();
        try {
          Identity session = serializer.read(Identity.class, data);
          String sessionId = session.getSession().id;
          Log.i( getLocalClassName(), "session: " + sessionId );

          Intent intent = new Intent();
          intent.putExtra( SESSION_ID, sessionId );
          setResult( Activity.RESULT_OK, intent );
          finish();
        }
        catch (Exception e) {
          Log.e( getLocalClassName(), "error", e );
        }
      }
      else {
        Toast.makeText(this, "Failed to login (" + code + "). Check your internet settings.", Toast.LENGTH_LONG).show();
      }
    }
  }

  @Override
  public void onLoaderReset( Loader<RESTResponse> loader ) {
  }
}