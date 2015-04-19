package healthapp.cse.osu.edu.healthapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.osu.cse.healthapp.helper.DBService;
import edu.osu.cse.healthapp.helper.Helper;
import edu.osu.cse.healthapp.ui.EnterFieldLayout;



public class LogActivity extends ActionBarActivity {
    DBService dbService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        dbService = DBService.getInstance();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log, menu);
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

    public void onClick(View view) {
        //Log.e(TAG, "+++ IN onCLick +++");
        switch (view.getId()) {
            case R.id.addLog:
                retreiveAndSave();
                break;
        }
    }

    private void retreiveAndSave() {
        EnterFieldLayout v;
        EditText et1, et2, et3, et4;
        v = (EnterFieldLayout)findViewById(R.id.ccLL);
        et1 = (EditText)v.findViewById(R.id.fval_txt);
        String s1 = et1.getText().toString();
        v = (EnterFieldLayout)findViewById(R.id.cbLL);
        et2 = (EditText)v.findViewById(R.id.fval_txt);
        String s2 = et2.getText().toString();
        v = (EnterFieldLayout)findViewById(R.id.wiLL);
        et3 = (EditText)v.findViewById(R.id.fval_txt);
        String s3 = et3.getText().toString();
        v = (EnterFieldLayout)findViewById(R.id.wLL);
        et4 = (EditText)v.findViewById(R.id.fval_txt);
        String s4 = et4.getText().toString();
//        if(!(Helper.isValidInt(s1) && Helper.isValidInt(s2) && Helper.isValidInt(s3) && Helper.isValidInt(s4))) {
//            Toast.makeText(getApplicationContext(), "Please Input Correct Information !!",
//                    Toast.LENGTH_SHORT).show();
//            et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");
//            return;
//        }
        //TODO
        dbService.addWtLog(s1);
        //dbService.addLog(s1, s2, s3, s4);
        et1.setText(""); et2.setText(""); et3.setText(""); et4.setText("");
    }
}
