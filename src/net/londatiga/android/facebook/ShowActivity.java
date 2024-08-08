package net.londatiga.android.facebook;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowActivity extends Activity {
	private static final String TAG = "Show Activity";
	//LinearLayout linearLayout = (LinearLayout)findViewById(R.id.showactivity);
	String uname,people,item;
	int emo;

    private Integer[] bImageIds = {
    		R.drawable.emb_angry,
            R.drawable.emb_bored,
            R.drawable.emb_happy,
            R.drawable.emb_sad,
            R.drawable.emb_surprised
    };
    private Integer[] gImageIds = {
            R.drawable.emg_angry,
            R.drawable.emg_bored,
            R.drawable.emg_happy,
            R.drawable.emg_inlove,
            R.drawable.emg_sad
    };
    
    private String[] bImags = {
    		"emb_angry",
            "emb_bored",
            "emb_happy",
            "emb_sad",
            "emb_surprised"
    };
	private String[] gImags = {
    		"emg_angry",
            "emg_bored",
            "emg_happy",
            "emg_inlove",
            "emg_sad"
    };

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.showactivity);//
	        
	        Bundle extras = getIntent().getExtras();
	        uname = extras.getString("username");
	        emo = extras.getInt("emotion");
	        people = extras.getString("People");	        
	        item = extras.getString("item");
	        
	        TextView leftTextView = (TextView) findViewById(R.id.showactivityt);
	        leftTextView.setText("Instead of waiting, "+ uname + " is \n" + item);
	        leftTextView.setTextSize((float)22.0);
	        ImageView imgview = (ImageView)findViewById(R.id.imageView1);
	        if(people.equals("boy")){
	        	imgview.setImageResource(bImageIds[emo]);
    		}
    		else if(people.equals("girl")){
    			imgview.setImageResource(gImageIds[emo]);
    		}
	 	        
	        //linearLayout.addView("Instead of waiting, "+ "admin" + "is "+value);
	    }
	public void checkinClicked(View view) {    	
		
	    	Intent showActivityIntent = new Intent(ShowActivity.this,TestPost.class);
	    	showActivityIntent.putExtra("uname", uname);
	    	showActivityIntent.putExtra("emo", emo);
	    	showActivityIntent.putExtra("people", people);
	    	showActivityIntent.putExtra("item", item);
	    	if(people.equals("boy")){
	    		showActivityIntent.putExtra("emoName", bImags[emo]);
    		}
    		else if(people.equals("girl")){
    			showActivityIntent.putExtra("emoName", gImags[emo]);
    		}
	    	startActivity(showActivityIntent);
	    	
	    	Log.d(TAG, "Clicked "+ people + " Emotion " + bImags[emo]);
	    	//finish();
	    }
}
