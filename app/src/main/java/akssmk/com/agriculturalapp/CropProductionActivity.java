package akssmk.com.agriculturalapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import akssmk.com.agriculturalapp.ExpandableRecyclerView.Adapter;
import akssmk.com.agriculturalapp.ExpandableRecyclerView.ChildHeading;
import akssmk.com.agriculturalapp.ExpandableRecyclerView.ParentHeading;


/**
 * Created by sukhbir on 2/8/16.
 */
public class CropProductionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crop_production);


        recyclerView = (RecyclerView) findViewById(R.id.list);
        adapter=new Adapter(createData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

private List<ParentHeading> createData(){
    List<ParentHeading> list=new ArrayList<>();
    List<ChildHeading> sublist=new ArrayList<>();
    ChildHeading childHeading=new ChildHeading(getData(R.string.wh1));
    ChildHeading childHeading1=new ChildHeading(getData(R.string.wh2));
    ChildHeading childHeading2=new ChildHeading(getData(R.string.wh3));

    sublist.add(childHeading);
    sublist.add(childHeading1);
    sublist.add(childHeading2);

    ParentHeading parentHeading=new ParentHeading("Heading 1",sublist);

    List<ChildHeading> sublist2=new ArrayList<>();
    ChildHeading childHeading2_1=new ChildHeading(getData(R.string.wh1));
    ChildHeading childHeading2_2=new ChildHeading(getData(R.string.wh2));
    ChildHeading childHeading2_3=new ChildHeading(getData(R.string.wh3));


    sublist2.add(childHeading2_1);
    sublist2.add(childHeading2_2);
    sublist2.add(childHeading2_3);

    ParentHeading parentHeading1=new ParentHeading("Heading 2",sublist2);

    list.add(parentHeading);
    list.add(parentHeading1);
    return list;
}

    private String getData(int id){
        return getResources().getString(id);
    }
}
