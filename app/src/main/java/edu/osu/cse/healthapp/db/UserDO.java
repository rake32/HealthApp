package edu.osu.cse.healthapp.db;

import io.realm.RealmObject;

/**
 * Created by siddhi on 3/23/15.
 */
public class UserDO extends RealmObject {
    private String name;
    private String DOB;
    private String hasFitBit;//boolean ?
    private String bloodGroup;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHasFitBit() {
        return hasFitBit;
    }

    public void setHasFitBit(String hasFitBit) {
        this.hasFitBit = hasFitBit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

}
