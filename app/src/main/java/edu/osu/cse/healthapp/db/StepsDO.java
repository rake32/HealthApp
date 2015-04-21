package edu.osu.cse.healthapp.db;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by siddhi on 4/18/15.
 */
public class StepsDO extends RealmObject {
    private Date date;
    private String steps;

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
