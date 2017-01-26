package com.kagssoft.cobonat.manifests.java;

import android.app.Application;
import android.content.Context;

/**
 * Created by sams on 1/20/2017.
 */

public class MyApplication extends Application {

    private static MyApplication sInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
    }
   public static MyApplication getInstance(){
     return sInstance ;
   }
    public static Context getAppContext(){

        return sInstance.getApplicationContext();
    }
}

