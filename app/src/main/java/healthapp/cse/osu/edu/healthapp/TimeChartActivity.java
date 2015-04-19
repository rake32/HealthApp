package healthapp.cse.osu.edu.healthapp;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import edu.osu.cse.healthapp.db.StepsDO;
import edu.osu.cse.healthapp.db.WeightDO;
import edu.osu.cse.healthapp.helper.DBService;
import edu.osu.cse.healthapp.helper.GraphChoice;
import io.realm.RealmResults;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class TimeChartActivity extends Activity implements OnItemSelectedListener{

    private GraphicalView mChart;
    private static final String TAG = "BTHealthChartView";
    private LinearLayout chartContainer;
    private Spinner dataType;
    private static GraphChoice choice=GraphChoice.WEIGHT;//default TODO
    private String strChosen = "WEIGHT";
    //chart engine objects
    XYMultipleSeriesDataset dataset ;
    TimeSeries dataSeries2 ;
    TimeSeries dataSeries1;
    XYSeriesRenderer renderer1;
    XYSeriesRenderer renderer2;
    XYMultipleSeriesRenderer multiRenderer;
    DBService dbService;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_chart);
        dbService = DBService.getInstance();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {//TODO
            //strChosen = extras.getString("graph_for");
        }

    }
    private void setTextSize(Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float low = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 13, metrics);
        float med = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 18, metrics);
        multiRenderer.setLabelsTextSize(med);
        multiRenderer.setAxisTitleTextSize(med);
        multiRenderer.setChartTitleTextSize(med);

        multiRenderer.setLegendHeight(160);
        multiRenderer.setLegendTextSize(med);

        if(isTablet(this)){
            renderer1.setLineWidth(4);
            renderer1.setChartValuesTextSize(30);
            renderer1.setDisplayChartValues(true);

            renderer2.setLineWidth(4);
            renderer2.setChartValuesTextSize(30);
            renderer2.setDisplayChartValues(true);

            multiRenderer.setPointSize(5);
        }
        else{
            renderer1.setLineWidth(2);
            renderer1.setChartValuesTextSize(10);
            renderer1.setDisplayChartValues(true);

            renderer2.setLineWidth(2);
            renderer2.setChartValuesTextSize(10);
            renderer2.setDisplayChartValues(true);
        }
    }
    void setColors(){
        multiRenderer.setApplyBackgroundColor(true);
        multiRenderer.setBackgroundColor(Color.GRAY);
        //multiRenderer.setYLabelsColor(0, Color.MAGENTA);
        //multiRenderer.setLabelsColor(Color.GREEN);
        //multiRenderer.setMarginsColor(Color.YELLOW);
        //150 200 200 light blue
        //multiRenderer.setMarginsColor(Color.rgb(150, 200, 200));
        multiRenderer.setYLabelsColor(0, Color.rgb(220,220,220));//yellow shade
        //multiRenderer.setXLabelsColor(Color.WHITE);//yellow shade
        multiRenderer.setXLabelsColor(Color.rgb(220,220,220));//yellow shade
        //multiRenderer.setYLabelsColor(0,Color.rgb(251, 177, 40));//yellow shade
        //multiRenderer.setXLabelsColor(Color.rgb(251, 177, 40));//yellow shade
        //multiRenderer.setLabelsColor(Color.BLACK);
        multiRenderer.setLabelsColor(Color.rgb(30,30,30));
        //multiRenderer.setMarginsColor(Color.rgb(54, 175, 139));//green
        //multiRenderer.setMarginsColor(Color.rgb(56, 168, 173));//greenish blue
        multiRenderer.setMarginsColor(Color.rgb(88, 159, 167));//value
        renderer1.setColor(Color.rgb(215,0,0));//reds
        //renderer1.setColor(Color.rgb(251, 177, 40));
        renderer2.setColor(Color.rgb(35,15,215));
    }

    private void setupChart(){
        Log.e(TAG, "+++ setupChart +++");
        Log.e(TAG, "+++ isTablet ?? +++"+isTablet(this));//set size n all accordingly
        // Creating XYSeriesRenderer to customize dataSeries1
        renderer1 = new XYSeriesRenderer();
        renderer1.setPointStyle(PointStyle.CIRCLE);
        renderer1.setFillPoints(true);
        //renderer1.setChartValuesTextSize(20);//TODO
        renderer1.setDisplayChartValues(true);

        // Creating XYSeriesRenderer to customize dataSeries2
        renderer2 = new XYSeriesRenderer();
        renderer2.setPointStyle(PointStyle.CIRCLE);
        renderer2.setFillPoints(true);;
        //renderer2.setChartValuesTextSize(20);//TODO
        renderer2.setDisplayChartValues(true);

        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setChartTitle("User Data");
        multiRenderer.setXTitle("Day");
        multiRenderer.setZoomButtonsVisible(true);
        multiRenderer.setClickEnabled(true);
        multiRenderer.setSelectableBuffer(10);

        //initializing text size as per device size
        setTextSize(this);
        setColors();
        // Getting a reference to LinearLayout of the MainActivity Layout
        chartContainer = (LinearLayout) findViewById(R.id.chartContainer);

    }
    private void addDataToChart(){
        Log.e(TAG, "+++ addDataToChart +++");
        chartContainer.removeAllViews();//important, else it keeps previous state in mind
        multiRenderer.setYTitle(strChosen);
        multiRenderer.removeAllRenderers();//
        // Creating TimeSeries for systolic
        dataSeries1 = new TimeSeries(strChosen);
        // Creating a dataset to hold each serieselse keeps appending renderes..
        dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(dataSeries1);
        if(strChosen.equals("BP")){// we need a second series in this case
            dataSeries1.setTitle("Sys");
            dataSeries2 = new TimeSeries("Dia");
            dataset.addSeries(dataSeries2);

        }
        else if(strChosen.equals(GraphChoice.CALORIES)){
            dataSeries1.setTitle("Calories Burnt");
            dataSeries2 = new TimeSeries("Calories Consumed");
            dataset.addSeries(dataSeries2);

        }
        // Adding renderer1 and renderer2 to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(renderer1);
        if(strChosen.equals("BP") || strChosen.equals(GraphChoice.CALORIES))
            multiRenderer.addSeriesRenderer(renderer2);

        // Creating a Time Chart
        mChart = (GraphicalView) ChartFactory.getTimeChartView(getBaseContext(), dataset, multiRenderer,"dd-MMM-yyyy");

        // Setting a click event listener for the graph
        mChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "In onClick of graph..");
                Format formatter = new SimpleDateFormat("dd-MMM-yyyy");

                SeriesSelection seriesSelection = mChart.getCurrentSeriesAndPoint();

                if (seriesSelection != null) {
                    Log.e(TAG, "In Series Selection..");
                    int seriesIndex = seriesSelection.getSeriesIndex();
                    String selectedSeries = strChosen;
                    if(seriesIndex==0){
                        if(strChosen.equals("BP"))
                            selectedSeries = "Systolic";//TODO these hardcoded as not in the drop down
                    }
                    else
                        selectedSeries = "Diastolic";

                    // Getting the clicked Date ( x value )
                    long clickedDateSeconds = (long) seriesSelection.getXValue();
                    Date clickedDate = new Date(clickedDateSeconds);
                    String strDate = formatter.format(clickedDate);

                    // Getting the y value
                    int amount = (int) seriesSelection.getValue();

                    // Displaying Toast Message
                    Toast.makeText(
                            getBaseContext(),
                            selectedSeries + " on "  + strDate + " : " + amount ,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Adding the Line Chart to the LinearLayout
        chartContainer.addView(mChart);
        getMainActivityData();
    }
    private void getMainActivityData(){
        Log.e(TAG, "+++ getMainActivityData +++");
        Bundle bundle = getIntent().getExtras();

//        if(strChosen.equals("CALORIES")){
//
//            for( BTHealthUIDO u:uiObjects){
//                if(u.get_weight()!=null)
//                    continue;
//                dataSeries1.add(getDate(u.get_date()), );
//                dataSeries2.add(getDate(u.get_date()), u.get_diastolic());
//            }
//            double minY = 	dataSeries2.getMinY();
//            double minX = 	dataSeries2.getMinX();
//            double maxY = 	dataSeries1.getMaxY();//systolic has teh larger values, so renderer 1
//            double maxX = 	dataSeries1.getMaxX();//will be same for both series
//            multiRenderer.setXAxisMin(minX-1);
//            multiRenderer.setYAxisMin(minY-1);
//            multiRenderer.setYAxisMax(maxY+1);
//            multiRenderer.setXAxisMax(maxX+1);
//            return;
//        }

        if(strChosen.equals(GraphChoice.WEIGHT.toString())){

            RealmResults<WeightDO> logs = dbService.findAllWtLogs();

            for( WeightDO u:logs){
                if(u.getWeight()!=null)
                    dataSeries1.add(getDate(u.getDate()), Double.parseDouble(u.getWeight()));

            }
        }
        else if(strChosen.equals(GraphChoice.STEPS.toString())){
            RealmResults<StepsDO> logs = dbService.findAllSteps();
            for( StepsDO u:logs){
                if(u.getSteps()!=null)
                    dataSeries1.add(getDate(u.getDate()), Double.parseDouble(u.getSteps()));
            }
        }
        //TODO

//        dataSeries1.add(getDate("2015-07-12"),44);
//        dataSeries1.add(getDate("2015-07-15"),54);

        //this extension of axes done as points coincide on the borders otherwise and it's difficult to view the border points
        double minY = 	dataSeries1.getMinY();
        double minX = 	dataSeries1.getMinX();
        double maxY = 	dataSeries1.getMaxY();
        double maxX = 	dataSeries1.getMaxX();//will ebs ame for boths eries
        multiRenderer.setXAxisMin(minX-1);
        multiRenderer.setYAxisMin(minY-1);
        multiRenderer.setYAxisMax(maxY+1);
        multiRenderer.setXAxisMax(maxX+1);
    }
    public  Date getDate(String formattedDate){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);//format used by sql lite db
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public synchronized void onResume(){
        super.onResume();
        Log.e(TAG, "+++ ON RESUME +++");
        if (mChart == null) {
            setupChart();
        }
        addDataToChart();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.time_chart, menu);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        Log.e(TAG, "+++ onItemSelected +++");
        strChosen  = (String)parent.getItemAtPosition(pos);
        addDataToChart();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        choice=GraphChoice.WEIGHT;
        strChosen = "WEIGHT";

    }
    /* Used to set text size based on tab or not*/
    public boolean isTablet(Context context) {
        boolean xlarge = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == 4);
        boolean large = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE);
        return (xlarge || large);
    }
}
