package healthapp.cse.osu.edu.healthapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

//import static anand.healthapp.R.layout.support_simple_spinner_dropdown_item;
import edu.osu.cse.healthapp.db.UserDO;
import edu.osu.cse.healthapp.helper.DBService;

import static android.graphics.Color.parseColor;


public class Register extends ActionBarActivity {

    ImageView ok;
    ImageView cancel;
    EditText name;
    RadioGroup rg;
    RadioButton rb;
    EditText bg;

    Calendar c=Calendar.getInstance();
    TextView dob;
    String[] devs={"Fitbit","JawBone","None"};
    ArrayAdapter<CharSequence> adapter;
    Spinner spinner;
    DBService dbService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbService = DBService.getInstance();

        ok=(ImageView)findViewById(R.id.imageView16);
        cancel=(ImageView)findViewById(R.id.imageView17);
        name=(EditText)findViewById(R.id.editText);
        bg=(EditText)findViewById(R.id.editText2);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu=new Intent(Register.this,MainActivity.class);
                //TODO anand , add your UX data to Db
                //dbService.addUser(name.getText(), dob.getText(), "GENDER??",bg.getText(), "yes");//TOOD has ??
                startActivity(menu);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                bg.setText("");
                dob.setText("XX-XX-XX");
                dob.setTextColor( -7829368);
            }
        });
        dob=(TextView)findViewById(R.id.dob);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.devs, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Register.this,listener,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }


    DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            dob.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
            dob.setTextColor(parseColor("#3399ff"));
        }
    };


}
