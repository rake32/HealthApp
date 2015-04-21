package healthapp.cse.osu.edu.healthapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.osu.cse.healthapp.helper.DBService;
import edu.osu.cse.healthapp.helper.GraphChoice;
import io.realm.Realm;


public class MainActivity extends ActionBarActivity {
    private  String TAG = MenuActivity.class.getName();
    private Realm realm;
    DBService dbService;

    TextView steps;
    TextView weight;
    TextView cals;
    TextView food;
    TextView water;
    TextView meds;
    TextView me;
    TextView track;
    ImageView isteps;
    ImageView iweight;
    ImageView icals;
    ImageView ifood;
    ImageView iwater;
    ImageView imeds;
    ImageView ime;
    ImageView itrack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this, TimeChartActivity.class);
        final Intent ime = new Intent(this, Me.class);
        final Intent ifood = new Intent(this, Food.class);

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        steps=(TextView)findViewById(R.id.textView);
        steps.setText("STEPS");
        steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("GRAPH_FOR", GraphChoice.STEPS.toString());
                startActivity(intent);
                //Toast.makeText(this,"Steps ")
            }
        });
        weight=(TextView)findViewById(R.id.textView2);
        weight.setText("WEIGHT");
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("GRAPH_FOR", GraphChoice.WEIGHT.toString());
                startActivity(intent);
            }
        });
        cals=(TextView)findViewById(R.id.textView3);
        cals.setText("CALORIES BURNT");
        cals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("GRAPH_FOR", GraphChoice.CALORIES.toString());
                startActivity(intent);
            }
        });
        track=(TextView)findViewById(R.id.textView4);
        track.setText("TRACK RUN");
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        food=(TextView)findViewById(R.id.textView5);
        food.setText("FOOD LOG");
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ifood);
            }
        });
        water=(TextView)findViewById(R.id.textView6);
        water.setText("WATER INTAKE");
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("GRAPH_FOR", GraphChoice.WATER.toString());
                startActivity(intent);
            }
        });
        meds=(TextView)findViewById(R.id.textView7);
        meds.setText("MEDICATIONS");
        meds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        me=(TextView)findViewById(R.id.textView8);
        me.setText("ME");
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ime);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        Log.d(TAG, "+++ ON START +++");
        setUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close Realm when done.
    }

    public void setUp(){
        Log.d(TAG, "+++ IN UI SETUP +++");
        realm = Realm.getInstance(this);
        dbService = DBService.getInstance();
        dbService.init(realm);
    }
}
