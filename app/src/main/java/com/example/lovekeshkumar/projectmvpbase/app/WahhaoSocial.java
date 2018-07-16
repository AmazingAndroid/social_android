package com.example.lovekeshkumar.projectmvpbase.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.example.lovekeshkumar.projectmvpbase.BuildConfig;

public class WahhaoSocial extends Application {
    private static WahhaoSocial Instance;
    public static volatile Handler applicationHandler = null;
    private static Context appContext;

    public static WahhaoSocial getInstance() {
        return Instance;
    }
    public static Context getAppContext() {
        return appContext;
    }
    @Override
    public void onCreate() {

        super.onCreate();
        if (!BuildConfig.DEBUG) {
            //Fabric.with(this, new Crashlytics());
        }

        Instance = this;
        applicationHandler = new Handler(getInstance().getMainLooper());
        // NativeLoader.initNativeLibs(Frenzy.getInstance());
      //  DirectoryUtill.initializedDirectorypath();
        // sAnalytics = GoogleAnalytics.getInstance(this);
     /*   new FlurryAgent.Builder()
                .withLogEnabled(true)
                .build(this, Constant.ModelConstants.FLURRY_API_KEY);*/

    }

}
