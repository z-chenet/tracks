package com.freelance.zacharychenet.tracks.TracksCoreBackEnd;

import com.parse.ParseObject;
import com.parse.ParseClassName;

/**
 * Created by zchen on 9/25/2015.
 */
@ParseClassName("Purchases")
public class Purchases extends ParseObject{

    String nameOfPurchase;
    float costOfPurchase;
    Boolean prio;

    public String getNameOfPurchase() {
        return getString("NameOfPurchase");
    }

    public void setNameOfPurchase(String nameOfPurchase) {
        put("NameOfPurchase", nameOfPurchase);
    }

    public float getCostOfPurchase() {
        return (float) getNumber("CostOfPurchase");
    }

    public void setCostOfPurchase(float costOfPurchase) {
        put("CostOfPurchase", costOfPurchase);
    }

    public Boolean getPrio() {
        return getBoolean("Priority");
    }

    public void setPrio(Boolean prio) {
        put("Priority", prio);
    }

    @Override
    public String toString(){
        return getString("CostOfPurchase") + "\n" + getNumber("CostOfPurchase");
    }

}
