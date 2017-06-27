package in.hypatiasoftwaresolutions.apps.plotdatacalculator;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

//import com.example.viru.plotdatacalculator.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class StartActivity extends AppCompatActivity  implements  GoogleApiClient.OnConnectionFailedListener,View.OnClickListener {
    private static final int RC_SIGN_IN = 9001;
    private GoogleApiClient mGoogleApiClient;
    private SignInButton bttnSignIn;
    Button btninsert,btndownload,DeleteAll;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        bttnSignIn=(SignInButton)findViewById(R.id.sign_in_button);
        bttnSignIn.setOnClickListener(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        bttnSignIn.setScopes(gso.getScopeArray());
        signIn();
    }
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }
    //********************************************************************
    public  void DeleteAll(View view)
    {
        DatabaseUtilities.deleteAll(this);
    }
    //************************************************************************
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//*******************************************************
//**********************************************************************
@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
    if (requestCode == RC_SIGN_IN) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        if(result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();

            setTitle(acct.getEmail() + "," + acct.getDisplayName());
            Utilities.loggedinemail=acct.getEmail();
            Utilities.loggedinname=acct.getDisplayName();
            Intent intent=new Intent(StartActivity.this,PlotMainActivity.class);
            startActivity(intent);
        }
        else {
            setTitle("Login failed");
        }

    }
}
//************************************************************************
    @Override
    public void onClick(View v) {
        signIn();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
