package edu.osu.cse.healthapp.helper;

import android.util.Log;

import java.util.Date;

import edu.osu.cse.healthapp.db.CalBurntDO;
import edu.osu.cse.healthapp.db.CalConsumedDO;
import edu.osu.cse.healthapp.db.MedicationDO;
import edu.osu.cse.healthapp.db.StepsDO;
import edu.osu.cse.healthapp.db.UserDO;
import edu.osu.cse.healthapp.db.WaterDO;
import edu.osu.cse.healthapp.db.WeightDO;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by siddhi on 4/7/15.
 */
public class DBService {
    private Realm realm;
    private static DBService   dbService;

    public void addUser(String name, String dob, String gender, String bldGrp, String hasFitBit) {
        Log.d("addWtLog","user");
        realm.beginTransaction();
        UserDO o = realm.createObject(UserDO.class);
        o.setName(name);
        o.setDOB(dob);
        o.setBloodGroup(bldGrp);
        o.setHasFitBit(hasFitBit);
        realm.commitTransaction();
    }

    public void addWtLog(String w) {
        Log.d("addWtLog",w);
        realm.beginTransaction();
        WeightDO o = realm.createObject(WeightDO.class);
        o.setDate(Helper.getDateTime());
        o.setWeight(w);
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

    public UserDO getUser() {
        RealmResults<UserDO> user = realm.where(UserDO.class).findAll();
        return user.first();//should be only one
    }


    public RealmResults<WeightDO> findAllWtLogs() {
        RealmResults<WeightDO> logs = realm.where(WeightDO.class).findAll();
        return logs;
    }

    public RealmResults<StepsDO> findAllSteps() {
        RealmResults<StepsDO> logs = realm.where(StepsDO.class).findAll();
        return logs;
    }

    public RealmResults<CalConsumedDO> findAllCalConsumedLogs() {
        RealmResults<CalConsumedDO> logs = realm.where(CalConsumedDO.class).findAll();
        return logs;
    }

    public RealmResults<CalBurntDO> findAllCalBurntLogs() {
        RealmResults<CalBurntDO> logs = realm.where(CalBurntDO.class).findAll();
        return logs;
    }

    public RealmResults<WaterDO> findAllWaterLogs() {
        RealmResults<WaterDO> logs = realm.where(WaterDO.class).findAll();
        return logs;
    }


    public RealmResults<WeightDO> findRangeLogs(String startDate, String endDate) {
        RealmResults<WeightDO> logs = realm.where(WeightDO.class).findAll();
        return logs;
    }

//TODO better way
    public WeightDO findLastWt() {
        RealmResults<WeightDO> results = realm.where(WeightDO.class).findAllSorted("date", RealmResults.SORT_ORDER_DESCENDING);
        if(results.isEmpty())
            return null;
        return results.get(0);
    }

    public void delAll() {
        realm.beginTransaction();
        realm.allObjects(WeightDO.class).clear();
        realm.allObjects(CalBurntDO.class).clear();
        realm.allObjects(CalConsumedDO.class).clear();
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
