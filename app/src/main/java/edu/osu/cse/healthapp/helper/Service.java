package edu.osu.cse.healthapp.helper;

import android.util.Log;
import android.widget.TextView;

import edu.osu.cse.healthapp.db.LogDO;
import edu.osu.cse.healthapp.db.MedicationDO;
import healthapp.cse.osu.edu.healthapp.R;
import io.realm.Realm;

/**
 * Created by siddhi on 4/7/15.
 */
public class Service {
    private Realm realm;

    public Service(Realm realm) {
        this.realm = realm;
    }

    private void addLog(int cc, int cb, int wi, String w) {
        realm.beginTransaction();

        LogDO log = realm.createObject(LogDO.class);
        //log.setId(1);
        log.setDate(Helper.getDateTime());
        log.setCalories_consumed(cc);
        log.setCalories_burnt(cb);
        log.setWater_intake(wi);
        log.setWeight(w);
        // When the write transaction is committed, all changes a synced to disk.
        realm.commitTransaction();
    }

   private void addLog1() {
        // All writes must be wrapped in a transaction to facilitate safe multi threading
        realm.beginTransaction();

        LogDO log = realm.createObject(LogDO.class);
        //log.setId(1);
        log.setDate(Helper.getDateTime());
        log.setCalories_consumed(20);
        log.setCalories_burnt(2);
        log.setWater_intake(3);
        log.setWeight("120");
        // When the write transaction is committed, all changes a synced to disk.
        realm.commitTransaction();
    }

    private void delAll() {
        //
        realm.beginTransaction();
        realm.allObjects(LogDO.class).clear();
        realm.allObjects(MedicationDO.class).clear();
        //realm.allObjects(LogDO.class).clear();
        realm.commitTransaction();
    }
}
