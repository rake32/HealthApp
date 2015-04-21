package healthapp.cse.osu.edu.healthapp;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ImageView;

        import jim.h.common.android.zxinglib.integrator.IntentIntegrator;
        import jim.h.common.android.zxinglib.integrator.IntentResult;


public class Food extends Activity {
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        View btnScan = findViewById(R.id.barcode_button);
        // Scan button
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set the last parameter to true to open front light if available
                IntentIntegrator.initiateScan(Food.this, R.layout.capture,
                        R.id.viewfinder_view, R.id.preview_view, true);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food, menu);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case IntentIntegrator.REQUEST_CODE:
                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode,
                        resultCode, data);
                if (scanResult == null) {
                    return;
                }
                final String result = scanResult.getContents();
                if (result != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //TODO, anand, kindly put this vlaue in a text view on the same form
                            Log.d("BARRRCCCOODDEE", result);
                            //txtScanResult.setText(result);
                        }
                    });
                }
                break;
            default:
        }
    }

}
