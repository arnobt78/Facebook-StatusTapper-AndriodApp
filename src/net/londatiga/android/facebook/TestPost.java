package net.londatiga.android.facebook;

import java.io.ByteArrayOutputStream;

import android.os.Bundle;
import android.os.Handler;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.BaseRequestListener;
import com.facebook.android.Facebook;
import com.facebook.android.SessionStore;

/**
 * This example shows how to post status to Facebook wall.
 * 
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 * 
 * http://www.londatiga.net
 */
public class TestPost extends Activity{
	private Facebook mFacebook;
	//private CheckBox mFacebookCb;
	private ProgressDialog mProgress;
	
	String uname,people,item,emoName;
	
	
	private Handler mRunOnUi = new Handler();
	
	private static final String APP_ID = "327637917317250";
	private static final String TAG = "TestPost";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.finishinglayout);
		
		final EditText reviewEdit = (EditText) findViewById(R.id.revieew);
		//mFacebookCb				  = (CheckBox) findViewById(R.id.cb_facebook);
		
		mProgress	= new ProgressDialog(this);		
		mFacebook 	= new Facebook(APP_ID);
		
		Bundle extras = getIntent().getExtras();
       // uname = extras.getString("username");
		emoName = extras.getString("emoName");
        //people = extras.getString("People");
        item = extras.getString("item");
		
		SessionStore.restore(mFacebook, this);

		if (mFacebook.isSessionValid()) {
			//mFacebookCb.setChecked(true);
				
			String name = SessionStore.getName(this);
			name		= (name.equals("")) ? "Unknown" : name;
			
			postToFacebook("Instead of waiting " + name + " is " + item ,emoName);
				
			//mFacebookCb.setText("  Facebook  (" + name + ")");
		}
	}
	
	private void postToFacebook(String msg , String emotion) { 
		
		  mProgress.setMessage("Posting ...");
		  mProgress.show();
		  
		  AsyncFacebookRunner mAsyncFbRunner = new AsyncFacebookRunner(mFacebook);
		  
		  Bundle params = new Bundle();
		      
		  params.putString("message", msg);
		  String u = "http://www.dynamicdevs.com/gg/android/statustapper/emo/" + emotion + ".png";
		  Log.d(TAG, "Emo Name " + u);
		  
		  params.putString("name", "Status tapper");
		  params.putString("caption", "Simplest way to update and create your status :) ");
		  params.putString("link", u);
		  //params.putString("description", "Dexter, seven years old dachshund who loves to catch cats, eat carrot and krupuk");
		  params.putString("picture", u);
		  
		  mAsyncFbRunner.request("me/feed", params, "POST", new WallPostListener());
		 
		
		 }

	private final class WallPostListener extends BaseRequestListener {
		public void onComplete(final String response) {
			mRunOnUi.post(new Runnable() { 
				@Override
				public void run() { 
					mProgress.cancel(); 
					
					Toast.makeText(TestPost.this, "Posted to Facebook", Toast.LENGTH_SHORT).show(); 
					} 
				});
			} 
		}
	
}