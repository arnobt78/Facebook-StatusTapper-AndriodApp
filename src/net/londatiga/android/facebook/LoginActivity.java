package net.londatiga.android.facebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private static final String TAG = "UserLogin";
	private EditText  username;
	private EditText  pass;
		 /** Called when the activity is first created. */
	//ArrayList al = new ArrayList();
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username = (EditText) findViewById(R.id.usernametb);
        pass = (EditText) findViewById(R.id.passtb);
               
    }
public void LoginClicked(View view) {   
		Log.d(TAG,  username.getText().toString());
		//Log.d(TAG, pass.getText().toString());
	
    	//if(username.getText().toString().equals("admin") && pass.getText().toString().equals("pass")){
    		//al.add(username.getText());
    		//al.add(pass.getText());
    		Intent loginIntent = new Intent(LoginActivity.this,IamActivity.class);
    		loginIntent.putExtra("username", username.getText().toString());
    		loginIntent.putExtra("pass", pass.getText().toString());
    		startActivity(loginIntent);
    	//}
    	
    	//Log.d(TAG, "Boy Clicked");
    	//finish();
    }
}
