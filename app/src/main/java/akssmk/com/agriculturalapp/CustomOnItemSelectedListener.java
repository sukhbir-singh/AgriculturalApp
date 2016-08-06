package akssmk.com.agriculturalapp;

/**
 * Created by kharita on 5/8/16.
 */
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {
private DataGetter dataGetter;

    public CustomOnItemSelectedListener(DataGetter dataGetter) {
        this.dataGetter = dataGetter;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {

        dataGetter.getData(parent.getItemAtPosition(pos).toString());
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public interface  DataGetter{
        void getData(String data);
    }

}
