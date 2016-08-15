package akssmk.com.agriculturalapp.application;

import android.app.Application;
import android.content.Context;


public class MyApplication extends Application {
    private static MyApplication myApplication ;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
    }
    public static synchronized MyApplication getInstance() {
        return myApplication;
    }
    public static Context getAppContext(){
        return myApplication.getApplicationContext();
    }
}
