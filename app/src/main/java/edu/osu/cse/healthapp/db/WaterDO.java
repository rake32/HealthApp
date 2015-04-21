package edu.osu.cse.healthapp.db;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by siddhi on 4/18/15.
 */
public class WaterDO extends RealmObject{
    private Date date;
    private String water;

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
