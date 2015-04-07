package edu.osu.cse.healthapp.db;

import io.realm.RealmObject;

/**
 * Created by siddhi on 2/25/15.
 */
public class LogDO extends RealmObject {
    //private long id;
    private String date; // auto detected
    private int calories_consumed;
    private int water_intake;
    private int calories_burnt;// if fitness device data
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

    public int getCalories_consumed() {
        return calories_consumed;
    }

    public void setCalories_consumed(int calories_consumed) {
        this.calories_consumed = calories_consumed;
    }

    public int getWater_intake() {
        return water_intake;
    }

    public void setWater_intake(int water_intake) {
        this.water_intake = water_intake;
    }

    public int getCalories_burnt() {
        return calories_burnt;
    }

    public void setCalories_burnt(int calories_burnt) {
        this.calories_burnt = calories_burnt;
    }
}
