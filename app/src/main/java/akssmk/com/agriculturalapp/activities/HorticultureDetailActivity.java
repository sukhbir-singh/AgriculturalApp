package akssmk.com.agriculturalapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.R;
import akssmk.com.agriculturalapp.adapters.HorticultureDetailAdapter;
import akssmk.com.agriculturalapp.modals.HorticultureDetailItem;

public class HorticultureDetailActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private HorticultureDetailAdapter adapter;
    ProgressBar bar;

    ArrayList<HorticultureDetailItem> items;

    String[] heading_m_b;
    
    String[] heading_g;

    Integer[] images_m={R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,R.drawable.h11,R.drawable.h12};

    Integer[] images_b={R.drawable.bh1,R.drawable.h2,R.drawable.bh3,R.drawable.h4,R.drawable.h5,R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,R.drawable.h11,R.drawable.bh12};

    Integer[] images_g={R.drawable.gh1,R.drawable.h2,R.drawable.gh3,R.drawable.h4,R.drawable.h5,R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,R.drawable.h11,R.drawable.gh12};


    Integer[] data1={R.string.md1,R.string.md2,R.string.md3,R.string.md4,R.string.md5,R.string.md6,R.string.md7,
            R.string.md8,R.string.md9,R.string.md10,R.string.md11,R.string.md12};

    Integer[] data2={R.string.bd1,R.string.bd2,R.string.bd3,R.string.bd4,R.string.bd5,R.string.bd6,R.string.bd7,
            R.string.bd8,R.string.bd9,R.string.bd10,R.string.bd11,R.string.bd12};

    Integer[] data3={R.string.gd1,R.string.gd2,R.string.gd3,R.string.gd4,R.string.gd5,R.string.gd6,R.string.gd7,
            R.string.gd8,R.string.gd9, R.string.gd10, R.string.gd11, R.string.gd12};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recycler);

        Integer[] temp1=null;
        Integer[] temp2=null;
        Integer[] temp3=null;


        heading_m_b=getResources().getStringArray(R.array.headings_m_b);
        
        heading_g=getResources().getStringArray(R.array.headings_g);

        int num=(int)getIntent().getIntExtra("number",1);
        String title="Horticulture Crops";
        if(num==1){
            temp1=data1;
            temp2=images_m;
            title="Mango Crop Details";
        }else if(num==2){
            temp1=data2;
            temp2=images_b;
            title="Banana Crop Details";
        }else if(num==3){
            temp1=data3;
            temp2=images_g;
            title="Guava Crop Details";
        }

        getSupportActionBar().setTitle(title);

        mRecyclerView=(RecyclerView)findViewById(R.id.recycler);
        bar=(ProgressBar)findViewById(R.id.progress);
        bar.setVisibility(View.GONE);
        items=new ArrayList<>();
        for(int i=0;i<heading_m_b.length;i++)
        {
            HorticultureDetailItem item=new HorticultureDetailItem();
            if(num==3){
                item.setHeading(heading_g[i]);
            }
            else {
                item.setHeading(heading_m_b[i]);
            }
            item.setDetail(temp1[i]);
             item.setImage(temp2[i]);
            items.add(item);
        }

        adapter=new HorticultureDetailAdapter(this,items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

    }
}
