package akssmk.com.agriculturalapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by sukhbir on 2/8/16.
 */
public class CropProductionActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout wheat_collapse,paddy_collapse,wheat,paddy;

    RelativeLayout wh1_collapse,wheat_h1;
    
    int[] wh_collapse={R.id.wh1_collapse,R.id.wh2_collapse,R.id.wh3_collapse,R.id.wh4_collapse,R.id.wh5_collapse,R.id.wh6_collapse,R.id.wh7_collapse,R.id.wh8_collapse,
            R.id.wh9_collapse,R.id.wh10_collapse, R.id.wh11_collapse,R.id.wh12_collapse,R.id.wh13_collapse,R.id.wh14_collapse};
    int[] wheat_h={R.id.wheat_h1,R.id.wheat_h2,R.id.wheat_h3,R.id.wheat_h4,R.id.wheat_h5,R.id.wheat_h6,R.id.wheat_h7,R.id.wheat_h8,R.id.wheat_h9,
            R.id.wheat_h10,R.id.wheat_h11,R.id.wheat_h12,R.id.wheat_h13,R.id.wheat_h14};
    
    RelativeLayout[] level11=new RelativeLayout[14];
    RelativeLayout[] level12=new RelativeLayout[14];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crop_production);

        wheat_collapse=(LinearLayout)findViewById(R.id.wheat_collapse);
        paddy_collapse=(LinearLayout)findViewById(R.id.paddy_collapse);

        for(int i=0;i<14;i++){
            level12[i]=(RelativeLayout)findViewById(wh_collapse[i]);
            level11[i]=(RelativeLayout)findViewById(wheat_h[i]);
        }

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

        for(int k=0;k<14;k++){
            level11[k].setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View v) {
        Log.v("a","hi");

        int temp_id=v.getId();
        int index=-1;

        for(int i=0;i<14;i++) {
            if (temp_id == wheat_h[i]) {
                index = i;
                break;
            }
        }

        Log.v("indexx",""+index);

        if(index==-1){
            return;
        }else{

            for(int j=0;j<14;j++){
                Log.v("hideme","bbb");
                if(j!=index)
                level12[j].setVisibility(View.GONE);
            }

            if(level12[index].getVisibility()==View.GONE){
                Log.v("aaaa","bbb");
                level12[index].setVisibility(View.VISIBLE);
            }else{
                Log.v("ddd","bbb");
                level12[index].setVisibility(View.GONE);
            }

        }

    }
}
