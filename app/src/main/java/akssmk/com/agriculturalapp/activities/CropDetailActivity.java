package akssmk.com.agriculturalapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.adapters.CropActivityAdapter;
import akssmk.com.agriculturalapp.modals.CropDetailItem;
import akssmk.com.agriculturalapp.R;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recycler);

        Integer[] temp=null;

        int num=(int)getIntent().getIntExtra("number",1);
        if(num==1){
            temp=data1;
        }else if(num==2){
            temp=data2;
        }

        mRecyclerView=(RecyclerView)findViewById(R.id.recycler);
        bar=(ProgressBar)findViewById(R.id.progress);
        bar.setVisibility(View.GONE);
        items=new ArrayList<>();
        for(int i=0;i<headings.length;i++)
        {
            CropDetailItem item=new CropDetailItem();
            item.setHeading(headings[i]);
            item.setDetail(temp[i]);
            items.add(item);
        }

        adapter=new CropActivityAdapter(this,items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

    }
}
