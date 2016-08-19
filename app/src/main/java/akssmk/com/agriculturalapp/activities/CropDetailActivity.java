package akssmk.com.agriculturalapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.R;
import akssmk.com.agriculturalapp.adapters.CropActivityAdapter;
import akssmk.com.agriculturalapp.modals.CropDetailItem;

public class CropDetailActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private CropActivityAdapter adapter;
    ProgressBar bar;

    ArrayList<CropDetailItem> items;

    Integer[] headings={R.string.wheat_h1,R.string.wheat_h2,R.string.wheat_h3,R.string.wheat_h4,R.string.wheat_h5,
            R.string.wheat_h6,R.string.wheat_h7,R.string.wheat_h8,R.string.wheat_h9,R.string.wheat_h10,
            R.string.wheat_h11,R.string.wheat_h12,R.string.wheat_h13,R.string.wheat_h14};

    Integer[] data1={R.string.wh1,R.string.wh2,R.string.wh3,R.string.wh4,R.string.wh5,R.string.wh6,R.string.wh7,
            R.string.wh8,R.string.wh9,R.string.wh10,R.string.wh11,R.string.wh12,R.string.wh13,R.string.wh14};

    Integer[] data2={R.string.ph1,R.string.ph2,R.string.ph3,R.string.ph4,R.string.ph5,R.string.ph6,R.string.ph7,
            R.string.ph8,R.string.ph9,R.string.ph10,R.string.ph11,R.string.ph12,R.string.ph13,R.string.ph14};

    Integer[] data3={R.string.ad1,R.string.ad2,R.string.ad3,R.string.ad4,R.string.ad5,R.string.ad6,R.string.ad7,
            R.string.ad8,R.string.ad9,R.string.ad10,R.string.ad11};

    Integer[] headings_a={ R.string.ah1,R.string.ah2,R.string.ah3,R.string.ah4,R.string.ah5,R.string.ah6,R.string.ah7,
            R.string.ah8,R.string.ah9,R.string.ah10,R.string.ah11};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recycler);

        Integer[] temp1=null;
        Integer[] temp2=null;

        int num=(int)getIntent().getIntExtra("number",1);
        if(num==1){
            temp1=data1;
        }else if(num==2){
            temp1=data2;
        }else if(num==3){
            temp2=data3;
        }


        mRecyclerView=(RecyclerView)findViewById(R.id.recycler);
        bar=(ProgressBar)findViewById(R.id.progress);
        bar.setVisibility(View.GONE);
        items=new ArrayList<>();

        int l;
        if(num==3)
            l=headings_a.length;
        else
            l=headings.length;

        for(int i=0;i<l;i++)
        {
            CropDetailItem item=new CropDetailItem();
            if(num==3){
                item.setHeading(headings_a[i]);
                item.setDetail(temp2[i]);
            }
            else{
                item.setHeading(headings[i]);
                item.setDetail(temp1[i]);
            }


            items.add(item);
        }

        adapter=new CropActivityAdapter(this,items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

    }
}
