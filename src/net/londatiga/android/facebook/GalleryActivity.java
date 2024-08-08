package net.londatiga.android.facebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.Toast;

public class GalleryActivity extends Activity {
    /** Called when the activity is first created. */
	String uname = "";
	String people = "",emo;
	
	private String[] bImageIds = {
    		"emb_angry",
            "emb_bored",
            "emb_happy",
            "emb_sad",
            "emb_surprised"
    };
	private String[] gImageIds = {
    		"emg_angry",
            "emg_bored",
            "emg_happy",
            "emg_inlove",
            "emg_sad"
    };
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Bundle extras = getIntent().getExtras();
        uname = extras.getString("username"); 
        people = getIntent().getExtras().getString("People").toString();
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        
        if(getIntent().getExtras().getString("People").equals("boy")){        	
        	gallery.setAdapter(new ImageAdapterBoy(this));
         }
         else{
        	 gallery.setAdapter(new ImageAdapterGirl(this));
         }
    
        //gallery.setAdapter(new ImageAdapterBoy(this));

        gallery.setOnItemClickListener(new OnItemClickListener() {
        	@Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
               // Toast.makeText(GalleryActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//        		if(people.equals("boy")){
//        			emo = bImageIds[position];
//        		}
//        		else if(people.equals("girl")){
//        			emo = gImageIds[position];
//        		}
                
                Intent GalleryIntent = new Intent(GalleryActivity.this,InsteadOfWaiting.class);
                GalleryIntent.putExtra("emotion",position);
                GalleryIntent.putExtra("username", uname);
                GalleryIntent.putExtra("People", people);
            	startActivity(GalleryIntent);
            }

        });
    }
    public void nextClicked(View view) {    	
    	Intent GalleryIntent = new Intent(GalleryActivity.this,InsteadOfWaiting.class);
    	GalleryIntent.putExtra("People", "girl");
    	startActivity(GalleryIntent);

        	//Log.d(TAG, "Girl Clicked");
        	//finish();
        }
    public void previousClicked(View view) {    	
//    	Intent IamaIntent = new Intent(IamActivity.this,GalleryActivity.class);
//    	IamaIntent.putExtra("People", "girl");
//    	startActivity(IamaIntent);
//
//        	Log.d(TAG, "Girl Clicked");
        	finish();
        }
}