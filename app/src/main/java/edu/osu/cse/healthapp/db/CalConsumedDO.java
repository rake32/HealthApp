package edu.osu.cse.healthapp.db;

import io.realm.RealmObject;

/**
 * Created by siddhi on 4/18/15.
 */
public class CalConsumedDO extends RealmObject{
    private String date;
    private String calConsumed;

    public String getCalConsumed() {
        return calConsumed;
    }

    public void setCalConsumed(String calConsumed) {
        this.calConsumed = calConsumed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
