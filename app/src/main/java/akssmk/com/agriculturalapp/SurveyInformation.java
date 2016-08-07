package akssmk.com.agriculturalapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SurveyInformation extends AppCompatActivity {

    RecyclerView recyclerView;
    SurveyAdapter adapter;
    String state,district,crop;
    TextView state_view,district_view,crop_view;
    FloatingActionButton btn;
    ProgressBar p;
    private ArrayList<ItemSurvey> items;

    private String URL_FINAL = "http://kharita.freevar.com/agriculture.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_information);
        Intent i = getIntent();
        items = new ArrayList<>();
        state_view=(TextView)findViewById(R.id.state);
        district_view=(TextView)findViewById(R.id.district);
        crop_view=(TextView)findViewById(R.id.crop);
        p = (ProgressBar) findViewById(R.id.progress);
        p.setVisibility(View.VISIBLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.graph);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(items.size()!=0)
                {
                    Intent i = new Intent(SurveyInformation.this,GraphActivity.class);
                    Bundle extra=new Bundle();
                    extra.putSerializable("All",items);
                    i.putExtra("extra",extra);
                    startActivity(i);
                }

            }
        });

        recyclerView=(RecyclerView)findViewById(R.id.crop_recycler);
        if(i!=null){
            state=i.getStringExtra(SurveyActivity.STATE);
            district=i.getStringExtra(SurveyActivity.DISTRICT);
            crop=i.getStringExtra(SurveyActivity.CROP);

            state_view.setText(state);
            district_view.setText(district);
            crop_view.setText(crop);
            sendRequest(URL_FINAL,state,district,crop);
        }

    }

    private void sendRequest(String url, final String State, final String District, final String Crop)
    {
        StringRequest s = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject result = new JSONObject(response);
                    JSONArray a=result.getJSONArray("result");
                    for(int i=0;i<a.length();i++){
                        String yr,ar,pr;
                        JSONObject w=a.getJSONObject(i);
                        ItemSurvey it = new ItemSurvey();
                        yr = w.getString("Year");
                        ar = w.getString("Area");
                        pr = w.getString("Production");
                        it.setYear(yr);
                        it.setArea(ar);
                        it.setProduction(pr);
                        items.add(it);

                    }
                    adapter=new SurveyAdapter(SurveyInformation.this,items);
                    recyclerView.setLayoutManager(new LinearLayoutManager(SurveyInformation.this));
                    recyclerView.setAdapter(adapter);
                    p.setVisibility(View.GONE);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("State",State);
                map.put("District",District);
                map.put("Crop",Crop);
                return map;
            }
        };
        MySingleton.getInstance(MyApplication.getAppContext()).addToRequestQueue(s);


    }
}
