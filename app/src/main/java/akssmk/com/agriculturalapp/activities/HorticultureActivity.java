package akssmk.com.agriculturalapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import akssmk.com.agriculturalapp.adapters.MainAdapter;
import akssmk.com.agriculturalapp.modals.MainListItem;
import akssmk.com.agriculturalapp.R;

public class HorticultureActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<MainListItem> list;
    MainAdapter adapter;

    Integer[] imageUrls={R.raw.hor,R.raw.hor,R.raw.hor};

    Integer[] hindiTexts={R.string.horticulture_item1_hi,R.string.horticulture_item2_hi,
            R.string.horticulture_item3_hi};

    Integer[] englishTexts={R.string.horticulture_item1_en,R.string.horticulture_item2_en,
            R.string.horticulture_item3_en};

    String[] backgroundColors={"#d57fe4","#f4a04c","#ca684d"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recycler);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        list=new ArrayList<>();

        Intent[] links=getIntents();

        for (int i=0;i<imageUrls.length;i++)
        {
            MainListItem item=new MainListItem();
            item.setEnglishText(englishTexts[i]);
            item.setHindiText(hindiTexts[i]);
            item.setBackgroundColor(backgroundColors[i]);
            item.setImageUrl(imageUrls[i]);
            item.setIntent(links[i]);
            list.add(item);
        }

        adapter=new MainAdapter(this,list,R.layout.item_horticulture);

        mRecyclerView=(RecyclerView)findViewById(R.id.recycler);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

        findViewById(R.id.progress).setVisibility(View.GONE);
    }

    public Intent[] getIntents(){
        Intent[] links={
                new Intent(this, CropProductionActivity.class),
                new Intent(this, Select_Policy.class),
                new Intent(this, Select_Policy.class),
        };

        return links;
    }
}
