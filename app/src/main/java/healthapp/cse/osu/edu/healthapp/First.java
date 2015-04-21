package healthapp.cse.osu.edu.healthapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Handler;

import healthapp.cse.osu.edu.healthapp.MainActivity;
import healthapp.cse.osu.edu.healthapp.Register;


public class First extends Activity {

    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main=new Intent(First.this,MainActivity.class);
                Intent reg=new Intent(First.this,Register.class);
                if(flag==1) {
                    First.this.startActivity(main);
                    First.this.finish();
                }
                else
                {
                    First.this.startActivity(reg);
                    First.this.finish();
                }
            }
        },1000);
    }


}
