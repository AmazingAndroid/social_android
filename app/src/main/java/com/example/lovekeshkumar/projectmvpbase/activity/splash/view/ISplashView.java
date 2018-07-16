package com.example.lovekeshkumar.projectmvpbase.activity.splash.view;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.lovekeshkumar.projectmvpbase.model.Country;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface ISplashView {
    String checkSharedPrefrancesValue(SharedPreferences sharedPreferences);
    Context getContext();
    void goToHomeScreen();
    void onBackPressed(Boolean aBoolean);
    void gotoLoginScreen();
    void gotoIntermediateScreen();
    void showErrorMessage(Throwable error);
    void showDetails(Intent intent);

}

