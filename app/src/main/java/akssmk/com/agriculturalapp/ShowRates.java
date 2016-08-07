package akssmk.com.agriculturalapp;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

//DELHI http://delagrimarket.nic.in/dambcrateb.asp?comName=4&submit=Select
// comName=1 to 9
//http://delagrimarket.nic.in/report.htm

//Rajasthan http://164.100.222.56/amb/1/mandishowtoday.asp?SORDER=0&CAT=All

public class ShowRates extends AppCompatActivity{
    public static String STATE_NAME;
    private String state_name;
    
    private static final int READ_CATEGORY = 1;
    private static final String TITLE_READ_MORE = "more_title";
    private static final String PUB_DATE ="pub" ;
    private RecyclerView recyclerView;
    private RatesAdapter adapter;
    private ArrayList<NewsItem> list;
    private Toolbar toolbar;
    private static final String CATEGORY_NAME = "Category";
    private String category;
    public static final String PREF_NAME = "newsbuzz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_recycler);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(STATE_NAME)) {
                state_name = intent.getStringExtra(STATE_NAME);
                Log.v("state_name", state_name);
            }
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        list = new ArrayList<>();
        adapter = new RatesAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        if (new Connection(this).isInternet()) {
            sendRequest("http://delagrimarket.nic.in/dambcrateb.asp?comName=4&submit=Select");

            ////loadtoast.show();
        }else{
            Toast.makeText(ShowRates.this,"No Internet Connection",Toast.LENGTH_LONG).show();
        }
    }

    private void    sendRequest(String url) {
        Log.v("sendRequest","request Sent");
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                Log.v("response",response);
                //loadtoast.success();

                //RssExtractor rssExtractor = new RssExtractor(response);
                ArrayList<NewsItem> list = new ArrayList<>(); //rssExtractor.getNewsItems();
                String pubdate="";
                for (int i = 0; i < list.size(); i++) {
                    ContentValues values = new ContentValues();
                    /*values.put(TITLE, list.get(i).title);
                    values.put(LINK_MORE, list.get(i).link_more);
                    values.put(LINK_IMAGE, list.get(i).link_image);
                    values.put(DESCRIPTION, list.get(i).description);
                    values.put(CATEGORY, list.get(i).category);
                    values.put(PUBDATE, list.get(i).pubDate);
                    getContentResolver().insert(DbContract.insertNews(), values);*/
                    pubdate=list.get(i).pubDate;

                }
                /*if(checkdata(pubdate)){
                    getLoaderManager().restartLoader(READ_CATEGORY, null,ShowRates.this);
                    addData(pubdate);
                }*/

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        } )/*{
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();

                //DELHI http://delagrimarket.nic.in/dambcrateb.asp?comName=4&submit=Select
                // comName=1 to 9
                //http://delagrimarket.nic.in/report.htm

                //Rajasthan http://164.100.222.56/amb/1/mandishowtoday.asp?SORDER=0&CAT=All

                params.put("SORDER", "0");
                params.put("CAT", "All");

                return params;
            }
        }*/;
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getInstance(MyApplication.getAppContext()).addToRequestQueue(stringRequest);
    }

    private String getUrl(String category) {
        switch (category) {
            case "Top Stories":
                return "http://news.google.co.in/news?cf=all&hl=en&pz=1&ned=in&output=rss";
            case "Entertainment":
                return "https://news.google.co.in/news/section?cf=all&pz=1&ned=in&topic=e&output=rss";
            case "Technology":
                return "https://news.google.co.in/news/section?cf=all&pz=1&ned=in&topic=tc&output=rss";
            case "Business":
                return "https://news.google.co.in/news?cf=all&hl=en&pz=1&ned=in&topic=b&output=rss";
            case "Sports":
                return "https://news.google.co.in/news?cf=all&hl=en&pz=1&ned=in&topic=s&output=rss";
            case "Health":
                return "https://news.google.co.in/news?cf=all&hl=en&pz=1&ned=in&topic=m&output=rss";
        }
        return "";
    }
}