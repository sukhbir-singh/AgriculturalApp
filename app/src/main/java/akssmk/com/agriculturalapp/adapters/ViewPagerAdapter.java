package akssmk.com.agriculturalapp.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sukhbir on 15/8/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    TabFragment tb1,tb2,tb3;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment temp=null;

        if(position==0){
            if(tb1==null){
                TabFragment tf=new TabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("date", "13/08/2016");
                tf.setArguments(bundle);
                tb1=tf;
            }

            temp=tb1;
        }else if(position==1){
            if(tb2==null){
                TabFragment tf=new TabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("date", "13/08/2016");
                tf.setArguments(bundle);
                tb2=tf;
            }

            temp=tb2;
        }else{
            if(tb3==null){
                TabFragment tf=new TabFragment();
                Bundle bundle = new Bundle();
                bundle.putString("date", "16/08/2016");
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
