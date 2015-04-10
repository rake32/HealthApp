package edu.osu.cse.healthapp.db;

import io.realm.RealmObject;

/**
 * Created by siddhi on 2/25/15.
 */
public class LogDO extends RealmObject {
    //private long id;
    private String date; // auto detected
    private String calories_consumed;
    private String water_intake;
    private String calories_burnt;// if fitness device data or manual..
    private String weight; // optional

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCalories_consumed() {
        return calories_consumed;
    }

    public void setCalories_consumed(String calories_consumed) {
        this.calories_consumed = calories_consumed;
    }

    public String getwater_intake() {
        return water_intake;
    }

    public void setwater_intake(String water_intake) {
        this.water_intake = water_intake;
    }

    public String getCalories_burnt() {
        return calories_burnt;
    }

    public void setCalories_burnt(String calories_burnt) {
        this.calories_burnt = calories_burnt;
    }
}
