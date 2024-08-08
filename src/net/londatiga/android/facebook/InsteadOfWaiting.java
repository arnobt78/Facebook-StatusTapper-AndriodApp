package net.londatiga.android.facebook;

import java.util.ArrayList;

import android.R.string;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class InsteadOfWaiting extends ListActivity {
	
    protected static final String TAG = "Insted Of Waiting" ;
    //final ListView lv = (ListView)findViewById(R.id.ListViewId);
    //TextView tv = (TextView) findViewById(R.id.editText1);
    String uname,people;
    String s;
    int emo;
    EditText itemText;
    private ArrayList<String> data;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.list_item);
        
        itemText = (EditText) findViewById(R.id.editText1);
        
        Bundle extras = getIntent().getExtras();
        uname = extras.getString("username");
        emo = extras.getInt("emotion");
        people = extras.getString("People");
        Log.d(TAG, "Received value: emotion = "+ emo);
       
        
        this.data = new ArrayList<String>();
        
        // add some objects into the array list
        this.data.add("having fun");
        this.data.add("reading a book");
        this.data.add("eating fuchka");
        this.data.add("chatting");
        this.data.add("shopping online");
        this.data.add("watching a movie on my phone");
        this.data.add("playing game");
        this.data.add("sketching");
        this.data.add("playing poker");
        this.data.add("drawing");
        this.data.add("listening");
        this.data.add("List Item 3");
        this.data.add("List Item 1");
        this.data.add("List Item 2");
       
        
        // use main.xml for the layout
        setContentView(R.layout.list_item);
        
        // setup the data adaptor
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_template, R.id.text, this.data);
        ListView listView = getListView(); 
        // specify the list adaptor
       
        setListAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int position, long id) {
                                
                 s=data.get(position);
                Log.i(TAG, "onListItemClick: " + s);
                Intent showActivityIntent = new Intent(InsteadOfWaiting.this,ShowActivity.class);
    	    	showActivityIntent.putExtra("item", s);
    	    	
    	    	showActivityIntent.putExtra("emotion",emo);
    	    	showActivityIntent.putExtra("username", uname);
    	    	showActivityIntent.putExtra("People", people);
    	    	
    	    	startActivity(showActivityIntent);
    	    	Log.i(TAG, "onListItemClick AFTER: " + s);

                for(int i=0; i<list.getChildCount(); i++)
                {
                     if(i == position)
                     {
                    	 list.getChildAt(i).setBackgroundColor(Color.BLUE);
                     }
                     else
                     {
                    	 //list.getChildAt(i).setBackgroundColor(Color.BLACK);
                     }
                 }
               // list.setBackgroundColor("#FBDF");
                
                }            
        });
           
    }
public void previous(View view) {    	
	finish();
	 }
public void next(View view) {    
	//s=itemText.getText().toString();
	Intent showActivityIntent = new Intent(InsteadOfWaiting.this,ShowActivity.class);
	showActivityIntent.putExtra("item", s);
	
	showActivityIntent.putExtra("emotion",emo);
	showActivityIntent.putExtra("username", uname);
	showActivityIntent.putExtra("People", people);
	startActivity(showActivityIntent);
	
	Log.d(TAG, "Instead of Item ");
	//finish();
}
}
