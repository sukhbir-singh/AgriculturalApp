package akssmk.com.agriculturalapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    GraphView graphView;
    TextView text;
    private ArrayList<ItemSurvey> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        text = (TextView) findViewById(R.id.graph_des);

        Intent in = getIntent();
        text.setText("Year vs Production");

        Log.v("hi", "111");
        
        if(in != null){
            Bundle extra=getIntent().getBundleExtra("extra");
            items = (ArrayList<ItemSurvey>) extra.getSerializable("All");
            Log.v("data123",items.get(0).getYear());
        }

        ArrayList<String> year = new ArrayList<>();
        ArrayList<String> area = new ArrayList<>();
        ArrayList<String> production = new ArrayList<>();

        double total = 0;

        DataPoint[] ar = new DataPoint[items.size()];

        for(int i=0;i<items.size();i++){
            if((items.get(i).getProduction()).equals("null") || items.get(i).getArea().equals("null")){
                ar[i] = new DataPoint(0,0);
                continue;
            }

            Log.v("value", items.get(i).getProduction() + " " + items.get(i).getArea());

            total=Double.valueOf(Double.parseDouble(items.get(i).getProduction())/Double.parseDouble(items.get(i).getArea()));
            DataPoint temp = new DataPoint(Double.parseDouble(items.get(i).getYear()),total );
            ar[i] = temp;
        }

      /*  graphView = (GraphView) findViewById(R.id.indi_graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(ar);

       /* graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setMaxX(items.size() + 1);
        graphView.getViewport().setMaxY(10);
        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMinY(0);


        graphView.addSeries(series);
        graphView.getViewport().setScrollable(true);

        series.setColor(Color.parseColor("#b2b2ff"));*/
        GraphView graph = (GraphView) findViewById(R.id.indi_graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(ar);

        graph.addSeries(series);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (NavUtils.getParentActivityName(this) != null) {

                    finish();

                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}