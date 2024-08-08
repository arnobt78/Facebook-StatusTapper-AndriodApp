package net.londatiga.android.facebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class IamActivity extends Activity{
	private static final String TAG = "I Am Activity";
	String uname = "";
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iam);
        Bundle extras = getIntent().getExtras();
       // uname = extras.getString("username"); 
       // Log.d(TAG, "Pass "+ uname);

    }
    public void boyClicked(View view) { 
    	
    	Intent IamaIntent = new Intent(IamActivity.this,GalleryActivity.class);
    	IamaIntent.putExtra("People", "boy");
    	IamaIntent.putExtra("username", uname);
    	startActivity(IamaIntent);

    	Log.d(TAG, "Boy Clicked " + "osername" + uname);
    	//finish();
    }
public void girlClicked(View view) {    	
	Intent IamaIntent = new Intent(IamActivity.this,GalleryActivity.class);
	IamaIntent.putExtra("People", "girl");
	IamaIntent.putExtra("username", uname);
	startActivity(IamaIntent);

    	Log.d(TAG, "Girl Clicked");
    	//finish();
    }
}
