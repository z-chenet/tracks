package com.freelance.zacharychenet.tracks;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.freelance.zacharychenet.tracks.TracksCoreBackEnd.Purchases;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class ParseListActivity extends ListActivity {

    List<Purchases> purchases = new ArrayList<Purchases>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_list);

        ParseQuery<Purchases> query = new ParseQuery<Purchases>("Purchases");
        query.findInBackground(new FindCallback<Purchases>() {
            @Override
            public void done(List<Purchases> list, ParseException e) {
                if (e != null){
                    Toast.makeText(ParseListActivity.this, "Error" + e, Toast.LENGTH_SHORT).show();
                }
                for (Purchases purchase: list){
                    Purchases newPurchase = new Purchases();
                    newPurchase.setNameOfPurchase(purchase.getNameOfPurchase());
                    newPurchase.setCostOfPurchase(purchase.getCostOfPurchase());
//                    newPurchase.setPrio(purchase.getPrio());
                    purchases.add(newPurchase);
                }

                ArrayAdapter<Purchases> adapter = new ArrayAdapter<Purchases>(ParseListActivity.this, android.R.layout.simple_list_item_1, purchases);
                setListAdapter(adapter);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_parse_list, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
