package akssmk.com.agriculturalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class ShowRates extends AppCompatActivity /*implements LoaderManager.LoaderCallbacks<Cursor>*/ {
    public static String STATE_NAME;
    private String state_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rates);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(STATE_NAME)) {
                state_name = intent.getStringExtra(STATE_NAME);
                Log.v("state_name", state_name);
            }
        }

    }

}
