package healthapp.cse.osu.edu.healthapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.osu.cse.healthapp.helper.DBService;
import io.realm.Realm;


public class MenuActivity extends ActionBarActivity {
    private  String TAG = MenuActivity.class.getName();
    private LinearLayout rootLayout = null;
    private Realm realm;

    DBService dbService;
    Button logb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.e(TAG, "+++ ON START +++");
        setUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close Realm when done.
    }

    public void setUp(){
        Log.e(TAG, "+++ IN UI SETUP +++");

        realm = Realm.getInstance(this);
        dbService = DBService.getInstance();
        dbService.init(realm);
        logb = (Button) findViewById(R.id.addLog);
    }

    public void onClick(View view) {
        Log.e(TAG, "+++ IN onCLick +++");
        switch (view.getId()) {
            case R.id.addLogs:
                Intent intent1 = new Intent(this, LogActivity.class);//TODO global ?
                startActivity(intent1);
                break;
            case +R.id.addMedRecords:
                Intent intent2 = new Intent(this, MedActivity.class);//TODO global ?
                startActivity(intent2);
                break;
            case R.id.delAll:
                dbService.delAll();
                break;
            case R.id.showAllLogs:
                Intent intent3 = new Intent(this, DisplayResultsActivity.class);
                startActivity(intent3);
                break;
            case R.id.barCodeScan:
                Intent intent4 = new Intent(this, BarcodeScannerActivity.class);
                startActivity(intent4);
                break;
            case R.id.graphView:
                Intent intent5 = new Intent(this, TimeChartActivity.class);
                startActivity(intent5);
                break;



        }
    }
/*
    private void basicCRUD(Realm realm) {
        Log.d(TAG, "aloha");

        showStatus("Perform basic Create/Read/Update/Delete (CRUD) operations...");

        // All writes must be wrapped in a transaction to facilitate safe multi threading
        realm.beginTransaction();

        LogDO log+ = realm.createObject(LogDO.class);
        //log.setId(+1);
        log.setDate(getDateTime());
        log.setCalories_consumed(20);
        log.setCalories_burnt(2);
        log.setWater_intake(3);
        log.setWeight("120");
        // When the write transaction is committed, all changes a synced to disk.
        realm.commitTransaction();

        // Find the first person (no query conditions) and read a field
        log = realm.where(LogDO.class).findFirst();
        if(log != null) {
            showStatus(log.getWeight() + ":" + log.getCalories_burnt());

            // Update person in a write transaction
            realm.beginTransaction();
            log.setWeight("150");
            showStatus(log.getWeight());
            realm.commitTransaction();

            // Delete all private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date;
        date = new Date();
        return dateFormat.format(date);
    }


 persons
            realm.beginTransaction();
            realm.allObjects(LogDO.class).clear();
            realm.commitTransaction();
        }
        Log.d(TAG, "aloha2");
    }

    private void showStatus(String txt) {
        Log.i(TAG, txt);
        TextView tv = (TextView)findViewById(R.id.statusText);
        tv.setText(txt);
        //rootLayout.addView(tv);
    }
*/
}
