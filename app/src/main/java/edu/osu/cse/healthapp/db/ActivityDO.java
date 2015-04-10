package edu.osu.cse.healthapp.db;

import io.realm.RealmObject;

/**
 * Created by siddhi on 4/9/15.
 */
public class ActivityDO extends RealmObject {
    private String date;
    private String steps;
    //measure the approximate distance as a function of time with one flag on, and height ?
    private String distWalked;
    private String distBiked;
    private String distRan;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getDistWalked() {
        return distWalked;
    }

    public void setDistWalked(String distWalked) {
        this.distWalked = distWalked;
    }

    public String getDistBiked() {
        return distBiked;
    }

    public void setDistBiked(String distBiked) {
        this.distBiked = distBiked;
    }

    public String getDistRan() {
        return distRan;
    }

    public void setDistRan(String distRan) {
        this.distRan = distRan;
    }
}
