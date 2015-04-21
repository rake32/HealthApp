package edu.osu.cse.healthapp.db;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by siddhi on 4/18/15.
 */
public class CalBurntDO extends RealmObject{
    private Date date;
    private String calBurnt;
    public String getCalBurnt() {
        return calBurnt;
    }

    public void setCalBurnt(String calBurnt) {
        this.calBurnt = calBurnt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
