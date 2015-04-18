package edu.osu.cse.healthapp.helper;

import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import edu.osu.cse.healthapp.db.LogDO;
import edu.osu.cse.healthapp.db.MedicationDO;
import edu.osu.cse.healthapp.ui.MyAdapter;
import healthapp.cse.osu.edu.healthapp.R;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by siddhi on 4/7/15.
 */
public class DBService {
    private Realm realm;
    private static DBService   dbService;

    public void addLog(String cc, String cb, String wi, String w) {
        realm.beginTransaction();
        LogDO o = realm.createObject(LogDO.class);
        //log.setId(1);
        o.setDate(Helper.getDateTime());
        o.setCalories_consumed(cc);
        o.setCalories_burnt(cb);
        o.setwater_intake(wi);
        o.setWeight(w);
        // When the write transaction is committed, all changes a synced to disk.
        realm.commitTransaction();
    }

/* Also set alarm reminders using appropriate APIs  TODO */
    public void addMed(String from, String to, String name, String timings) {
        realm.beginTransaction();

        MedicationDO o = realm.createObject(MedicationDO.class);
        o.setStart_date(from);
        o.setEnd_date(to);
        o.setName(name);
        o.setTimings(timings);
        realm.commitTransaction();
    }

    public RealmResults<LogDO> findAllLogs() {
        RealmResults<LogDO> logs = realm.where(LogDO.class).findAll();
        return logs;
    }

    public RealmResults<LogDO> findRangeLogs(String startDate, String endDate) {
        RealmResults<LogDO> logs = realm.where(LogDO.class).findAll();//TODO
        return logs;
    }

    public void delAll() {
        realm.beginTransaction();
        realm.allObjects(LogDO.class).clear();
        realm.allObjects(MedicationDO.class).clear();
        realm.commitTransaction();
    }

    /* Make it a singleton class*/
    private DBService(){

    }
    public static DBService getInstance()
    {
        if (dbService == null)
        {
            dbService = new DBService();
        }
        return dbService;
    }

    public void init(Realm realm) {
        this.realm = realm;

    }


}
