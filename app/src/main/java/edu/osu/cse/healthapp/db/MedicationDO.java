package edu.osu.cse.healthapp.db;

import io.realm.RealmObject;

/**
 * Created by siddhi on 4/7/15.
 */
public class MedicationDO extends RealmObject{
    private String start_date;
    private String end_date;
    private String name;
    private String timings;//000, save as 3 bits, morn, noon, eve

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }
}
