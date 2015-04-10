package healthapp.cse.osu.edu.healthapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import edu.osu.cse.healthapp.db.LogDO;
import edu.osu.cse.healthapp.helper.DBService;
import edu.osu.cse.healthapp.ui.MyAdapter;
import io.realm.RealmResults;


public class DisplayResultsActivity extends ActionBarActivity {
    DBService dbService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);
        dbService = DBService.getInstance();
        //Realm.deleteRealmFile(this);
        RealmResults<LogDO> logs = dbService.findAllLogs();

        final MyAdapter adapter = new MyAdapter(this, R.id.listView, logs, true);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //realm = Realm.getInstance(this);
        //RealmResults<TimeStamp> timeStamps = realm.where(TimeStamp.class).findAll();
        //final MyAdapter adapter = new MyAdapter(this, R.id.listView, timeStamps, true);
        //ListView listView = (ListView) findViewById(R.id.listView);
        //listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_results, menu);
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
}
