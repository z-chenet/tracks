package com.freelance.zacharychenet.tracks;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.app.ListFragment;

import com.freelance.zacharychenet.tracks.TracksCoreBackEnd.Purchases;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends ListFragment {

    List<Purchases> purchases = new ArrayList<Purchases>();

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParseQuery<Purchases> query = new ParseQuery<Purchases>("Purchases");
        query.findInBackground(new FindCallback<Purchases>() {
            @Override
            public void done(List<Purchases> list, ParseException e) {
                if (e != null){
                }
                for (Purchases purchase: list){
                    Purchases newPurchase = new Purchases();
                    newPurchase.setNameOfPurchase(purchase.getNameOfPurchase());
                    newPurchase.setCostOfPurchase(purchase.getCostOfPurchase());
//                    newPurchase.setPrio(purchase.getPrio());
                    purchases.add(newPurchase);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);

        ListAdapter adapter = new ArrayAdapter<Purchases>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                purchases
        );

        setListAdapter(adapter);

    }
}
