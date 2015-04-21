package edu.osu.cse.healthapp.db;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by siddhi on 4/18/15.
 */
public class CalConsumedDO extends RealmObject{
    private Date date;
    private String calConsumed;

    public String getCalConsumed() {
        return calConsumed;
    }

    public void setCalConsumed(String calConsumed) {
        this.calConsumed = calConsumed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
