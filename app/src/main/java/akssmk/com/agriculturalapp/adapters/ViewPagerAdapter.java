package akssmk.com.agriculturalapp.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sukhbir on 15/8/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    TabFragment tb1,tb2,tb3;
    String state,district;

    public ViewPagerAdapter(FragmentManager fm,String state,String district) {
        super(fm);
        this.state=state;
        this.district=district;
    }

    @Override
    public Fragment getItem(int position) {
        Calendar cal2 = Calendar.getInstance();

        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date(cal2.getTimeInMillis()));

        cal2.add(Calendar.DATE, -1);
        Date dt2 = new Date(cal2.getTimeInMillis());
        String date_pre = new SimpleDateFormat("dd/MM/yyyy").format(dt2);

        cal2.add(Calendar.DATE,-1);
        Date dt3 = new Date(cal2.getTimeInMillis());
        String date_pre_pre = new SimpleDateFormat("dd/MM/yyyy").format(dt3);

        TabFragment temp=null;

        if(position==0){
            if(tb1==null){
                TabFragment tf=new TabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("date", date_pre_pre);
                bundle.putString("state", state);
                bundle.putString("district", district);
                tf.setArguments(bundle);
                tb1=tf;
            }

            temp=tb1;
        }else if(position==1){
            if(tb2==null){
                TabFragment tf=new TabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("date", date);
                bundle.putString("state", state);
                bundle.putString("district", district);
                tf.setArguments(bundle);
                tb2=tf;
            }

            temp=tb2;
        }else{
            if(tb3==null){
                TabFragment tf=new TabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("date", date_pre);
                bundle.putString("state", state);
                bundle.putString("district", district);
                tf.setArguments(bundle);
                tb3=tf;
            }

            temp=tb3;
        }

        return temp;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
