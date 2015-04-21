package healthapp.cse.osu.edu.healthapp;

        import android.content.Intent;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.ArrayAdapter;
        import android.widget.Spinner;
        import android.widget.LinearLayout;
        import android.app.AlertDialog;
        import android.widget.LinearLayout.LayoutParams;

        import edu.osu.cse.healthapp.db.UserDO;
        import edu.osu.cse.healthapp.helper.DBService;


public class Me extends ActionBarActivity {
    ImageView add;
    ImageView edit;

    String[] s={"FitBit","JawBone"};
    DBService dbService;
    UserDO usr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        dbService = DBService.getInstance();
        add=(ImageView)findViewById(R.id.imageView19);
        edit=(ImageView)findViewById(R.id.imageView18);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(Me.this, Register.class);
                startActivity(reg);
                finish();
            }
        });


        final ArrayAdapter<String> adp = new ArrayAdapter<String>(Me.this,
                android.R.layout.simple_spinner_item, s);

        final Spinner sp = new Spinner(Me.this);
        sp.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
        sp.setAdapter(adp);

        //final AlertDialog.Builder builder = new AlertDialog.Builder(me.this);
        //builder.setView(sp);
        //builder.create().show();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Me.this);
                builder.setView(sp);
                builder.create().show();

            }
        });

    }

    @Override
    public void onStart(){
        super.onStart();
        usr = dbService.getUser(); //TODO anand , populate your UX fields..
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_me, menu);
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
