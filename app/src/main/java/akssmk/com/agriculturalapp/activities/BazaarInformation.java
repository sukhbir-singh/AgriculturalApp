package akssmk.com.agriculturalapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import akssmk.com.agriculturalapp.modals.ItemBazaar;
import akssmk.com.agriculturalapp.R;
import akssmk.com.agriculturalapp.adapters.BazaarAdapter;
import akssmk.com.agriculturalapp.application.MyApplication;
import akssmk.com.agriculturalapp.application.MySingleton;
import akssmk.com.agriculturalapp.utilities.Connection;

/**
 * Created by sukhbir on 14/8/16.
 */
public class BazaarInformation extends AppCompatActivity {

    RecyclerView recyclerView;
    BazaarAdapter adapter;
    String state,district,day;
    TextView state_view,district_view,day_view;
    FloatingActionButton btn;
    ProgressBar p;
    String day_string;
    private ArrayList<ItemBazaar> items;

    private String URL_FINAL = "http://kharita.freevar.com/agriculture_market.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazaar_information);
        Intent i = getIntent();
        items = new ArrayList<>();
        state_view=(TextView)findViewById(R.id.state);
        district_view=(TextView)findViewById(R.id.district);
        day_view=(TextView)findViewById(R.id.arrival_date);
        p = (ProgressBar) findViewById(R.id.progress);
        p.setVisibility(View.VISIBLE);

        recyclerView=(RecyclerView)findViewById(R.id.crop_recycler);
        if(i!=null){
            state=i.getStringExtra(SurveyActivity.STATE);
            district=i.getStringExtra(SurveyActivity.DISTRICT);
            day=i.getStringExtra(SurveyActivity.CROP);

            state_view.setText(state);
            district_view.setText(district);
            if(day!=null){
                Date d=new Date();

                if(day_view.equals("Today")){
                    day_string=new SimpleDateFormat("dd/MM/yyyy").format(d);
                }else if(day_view.equals("Yesterday")){
                    Date d1=new Date();
                    d1.setDate(d.getDate()- 1);
                    day_string=new SimpleDateFormat("dd/MM/yyyy").format(d1);
                }else{
                    Date d2=new Date();
                    d2.setDate(d.getDate()-2);
                    day_string=new SimpleDateFormat("dd/MM/yyyy").format(d2);
                }

                day_view.setText(day_string);

                Log.v("formatted date",day_string);
            }

            sendRequest(URL_FINAL,state,district,"13/08/2016");
        }

    }

    private void sendRequest(String url, final String State, final String District, final String Day)
    {
        StringRequest s = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.v("RESPONSE", response);

                    JSONObject result = new JSONObject(response);
                    JSONArray a=result.getJSONArray("result");
                    for(int i=0;i<a.length();i++){
                        String  market,commodity,variety,min,max,avg;

                        JSONObject w=a.getJSONObject(i);
                        ItemBazaar item = new ItemBazaar();
                        market = w.getString("Market");
                        commodity = w.getString("Commodity");
                        variety = w.getString("Variety");
                        min = w.getString("Min");
                        max = w.getString("Max");
                        avg = w.getString("Modal");

                        item.setMarket(market);
                        item.setCommodity(commodity);
                        item.setMin(min);
                        item.setMax(max);
                        item.setAvg(avg);
                        item.setVariety(variety);

                        items.add(item);

                    }
                    adapter=new BazaarAdapter(BazaarInformation.this,items);
                    recyclerView.setLayoutManager(new LinearLayoutManager(BazaarInformation.this));
                    recyclerView.setAdapter(adapter);
                    p.setVisibility(View.GONE);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(!new Connection(BazaarInformation.this).isInternet()){
                    Toast.makeText(BazaarInformation.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BazaarInformation.this, "Some error occured", Toast.LENGTH_SHORT).show();
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("State",State);
                map.put("District",District);
                map.put("Date",Day);
                return map;
            }
        };
        MySingleton.getInstance(MyApplication.getAppContext()).addToRequestQueue(s);


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
