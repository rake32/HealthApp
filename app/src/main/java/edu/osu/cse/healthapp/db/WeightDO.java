package edu.osu.cse.healthapp.db;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by siddhi on 4/18/15.
 */
public class WeightDO extends RealmObject{
    private Date date;
    private String weight;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
