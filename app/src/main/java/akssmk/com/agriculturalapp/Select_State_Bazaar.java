package akssmk.com.agriculturalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class Select_State_Bazaar extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout link1,link2,link3,link4;
    public static String STATE_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bazar_states);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        link1=(LinearLayout)findViewById(R.id.newdelhi_bazar_link);
        link2=(LinearLayout)findViewById(R.id.mp_bazar_link);
        link3=(LinearLayout)findViewById(R.id.rajasthan_bazar_link);
        link4=(LinearLayout)findViewById(R.id.up_bazar_link);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Select State");
        }

        link1.setOnClickListener(this);
        link2.setOnClickListener(this);
        link3.setOnClickListener(this);
        link4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(Select_State_Bazaar.this,ShowRates.class);

        if(v.getId()==R.id.newdelhi_bazar_link){
            i.putExtra(STATE_NAME, "new_delhi");

        }else if(v.getId()==R.id.mp_bazar_link){
            i.putExtra(STATE_NAME, "mp");

        }else if(v.getId()==R.id.rajasthan_bazar_link){
            i.putExtra(STATE_NAME, "rajasthan");

        }else if(v.getId()==R.id.up_bazar_link){
            i.putExtra(STATE_NAME, "up");

        }

        startActivity(i);
    }
}
