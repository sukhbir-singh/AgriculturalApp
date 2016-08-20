package akssmk.com.agriculturalapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import akssmk.com.agriculturalapp.R;
import akssmk.com.agriculturalapp.application.MyApplication;
import akssmk.com.agriculturalapp.application.MySingleton;
import akssmk.com.agriculturalapp.utilities.Connection;

public class Select_State_Bazaar extends AppCompatActivity {

    public static final String STATE ="state" ;
    public static final String DISTRICT = "district";
    public static final String CROP ="crop" ;
    private Spinner spinner1, spinner2, spinner3;
    private Button btnSubmit;
    private static final String URL_DISTRICT = "http://kharita.freevar.com/district_market.php";
    private static final String URL_CROP = "http://kharita.freevar.com/crop.php";
    ArrayAdapter<String> arrayAdapter,arrayAdapter1,arrayAdapter2;
    ArrayList<String> list11,list2;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_survey);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner1= (Spinner) findViewById(R.id.spinner1);
        spinner2= (Spinner) findViewById(R.id.spinner2);
        btnSubmit= (Button) findViewById(R.id.btnSubmit);
        p = (ProgressBar) findViewById(R.id.progress);
        list11=new ArrayList<>();
        list11.add("Select District");
        list2=new ArrayList<>();

        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.State_market));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String k = arrayAdapter.getItem(parent.getSelectedItemPosition());

                if (k != null && spinner1.getSelectedItemPosition() != 0) {
                    list11 = new ArrayList<>();
                    list11.add("Select District");
                    sendRequest(URL_DISTRICT, "State", k);
                }
                else if(spinner1.getSelectedItemPosition()==0)
                {
                    list11 = new ArrayList<>();
                    list11.add("Select District");
                    arrayAdapter1 = new ArrayAdapter<String>(Select_State_Bazaar.this, android.R.layout.simple_spinner_dropdown_item, list11);
                    arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(arrayAdapter1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrayAdapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list11);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter1);

        arrayAdapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.Days));
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String State = arrayAdapter.getItem(spinner1.getSelectedItemPosition());
                String District = arrayAdapter1.getItem(spinner2.getSelectedItemPosition());

                if (spinner1.getSelectedItemPosition() != 0&& !District.equals("Select District")) {

                    Intent intent = new Intent(Select_State_Bazaar.this, BazaarActivity2.class);
                    intent.putExtra(STATE, State);
                    intent.putExtra(DISTRICT, District);
                    startActivity(intent);
                }

            }
        });

        p.setVisibility(View.GONE);

    }

    private void sendRequest(final String url, final String key, final String value){
        Log.v("K", value + "");
        p.setVisibility(View.VISIBLE);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("RESPONSE",response);

                if(url==URL_DISTRICT){
                    arrayAdapter1.clear();
                    list11.add("Select District");
                    list11=parseJson(response,"result","District");
                    arrayAdapter1.addAll(list11);
                    arrayAdapter1.notifyDataSetChanged();
                }
                else if (url==URL_CROP){
                    arrayAdapter2.clear();
                    list2.add("Select Crop");
                    list2=parseJson(response,"result","Crop");
                    arrayAdapter2.addAll(list2);
                    arrayAdapter2.notifyDataSetChanged();
                }
                Log.d("data",response);
                p.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                p.setVisibility(View.GONE);
                if(!new Connection(Select_State_Bazaar.this).isInternet()){
                    Toast.makeText(Select_State_Bazaar.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Select_State_Bazaar.this, "Some error occured", Toast.LENGTH_SHORT).show();
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put(key,value);
                return map;
            }
        };

        MySingleton.getInstance(MyApplication.getAppContext()).addToRequestQueue(stringRequest);
    }

    private ArrayList<String> parseJson(String key,String array_name,String object_name){
        ArrayList<String> list=new ArrayList<>();
        try {
            JSONObject j=new JSONObject(key);
            JSONArray a=j.getJSONArray(array_name);
            for(int i=0;i<a.length();i++){
                JSONObject w=a.getJSONObject(i);
                list.add(w.getString(object_name));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
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
