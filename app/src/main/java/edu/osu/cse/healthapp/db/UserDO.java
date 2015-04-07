package edu.osu.cse.healthapp.db;

import io.realm.RealmObject;

/**
 * Created by siddhi on 3/23/15.
 */
public class UserDO extends RealmObject {
    private String name;
    private String pwd;
    private String hasFitBit;//boolean ?
    private String weight;
    private String height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHasFitBit() {
        return hasFitBit;
    }

    public void setHasFitBit(String hasFitBit) {
        this.hasFitBit = hasFitBit;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
