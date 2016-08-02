package akssmk.com.agriculturalapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by sukhbir on 2/8/16.
 */
public class CropProductionActivity extends AppCompatActivity {

    LinearLayout wheat_collapse,paddy_collapse,wheat,paddy;

    RelativeLayout wh1_collapse,wheat_h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crop_production);

        wheat_collapse=(LinearLayout)findViewById(R.id.wheat_collapse);
        paddy_collapse=(LinearLayout)findViewById(R.id.paddy_collapse);


        wheat=(LinearLayout)findViewById(R.id.wheat);
        paddy=(LinearLayout)findViewById(R.id.paddy);

        wh1_collapse=(RelativeLayout) findViewById(R.id.wh1_collapse);
        wheat_h1=(RelativeLayout) findViewById(R.id.wheat_h1);

        wheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wheat_collapse.getVisibility()==View.GONE) {

                    paddy_collapse.setVisibility(View.GONE);
                    wheat_collapse.setVisibility(View.VISIBLE);
                }

                else{

                    wheat_collapse.setVisibility(View.GONE);
                }
            }
        });
        paddy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(paddy_collapse.getVisibility()==View.GONE) {

                    paddy_collapse.setVisibility(View.VISIBLE);
                    wheat_collapse.setVisibility(View.GONE);
                }

                else{

                    paddy_collapse.setVisibility(View.GONE);
                }
            }
        });

        wheat_h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wh1_collapse.getVisibility()==View.GONE) {

                   // paddy_collapse.setVisibility(View.GONE);
                    wh1_collapse.setVisibility(View.VISIBLE);
                }

                else{

                    wh1_collapse.setVisibility(View.GONE);
                }
            }
        });


    }
}
