package com.freelance.zacharychenet.tracks;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.freelance.zacharychenet.tracks.TracksCoreBackEnd.Purchases;
import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  parse initializer statement
        //  allows saving to local datastore
        Parse.enableLocalDatastore(this);
        //  registers class for the table we want to save purchases to
        ParseObject.registerSubclass(Purchases.class);
        //  initializes the app to the parse database
        Parse.initialize(this, "L239QoxOAQHJEhoYRa0qEZUHAEVqD3nTL12ivdne", "pugVQh54xL3OxlpXM7oB4yizShft4C7hwTiLlsBh");


        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
}
