package edu.osu.cse.healthapp.db;

import io.realm.RealmObject;

/**
 * Created by siddhi on 4/18/15.
 */
public class CalBurntDO extends RealmObject{
    private String date;
    private String calBurnt;
    public String getCalBurnt() {
        return calBurnt;
    }

    public void setCalBurnt(String calBurnt) {
        this.calBurnt = calBurnt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
