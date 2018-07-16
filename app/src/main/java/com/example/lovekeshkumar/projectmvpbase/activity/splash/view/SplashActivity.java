package com.example.lovekeshkumar.projectmvpbase.activity.splash.view;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.login.view.LoginActivity;
import com.example.lovekeshkumar.projectmvpbase.activity.splash.presenter.ISplashPresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.splash.presenter.SplashPresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.welcome.view.WelcomeActivity;
import com.example.lovekeshkumar.projectmvpbase.constant.Constant;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

public class SplashActivity extends AppCompatActivity implements ISplashView {


    ISplashPresenter splashPresenter;
    public Utility utility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        utility = Utility.getInstance(getApplicationContext());

     //   splashPresenter = new SplashPresenterImpl(this, getIntent());
        splashPresenter = new SplashPresenterImpl(this, null,utility);
    }
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public String checkSharedPrefrancesValue(SharedPreferences sharedPreferences) {
        return null;
    }

    @Override
    public void goToHomeScreen() {
        //  startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));

        Intent intent = new Intent();
        intent.setClass(this, WelcomeActivity.class);
        intent.putExtra(Constant.ModelConstants.WAHHAO_ARG_DEMO, "WAHHAO_ARG_DEMO");
        intent.putExtra(Constant.ModelConstants.WAHHAO_ARG_DEMO, "WAHHAO_ARG_DEMO");
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.pull_in_right);
    }

    @Override
    public void onBackPressed(Boolean aBoolean) {
        if(aBoolean)
        {
            onBackPressed();
        }
    }

    @Override
    public void gotoLoginScreen() {
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        finish();
        overridePendingTransition(R.anim.pull_in_right, R.anim.pull_in_right);
    }

    @Override
    public void gotoIntermediateScreen() {

    }

    @Override
    public void showErrorMessage(Throwable error) {

    }

    @Override
    public void showDetails(Intent intent) {
        Bundle extras = getIntent().getExtras();
        String nameIntent;
        String apiIntent;
        String versionIntent;
        if (extras == null) {
            return;
        } else {
            nameIntent = extras.getString("name");
            apiIntent = extras.getString("api");
            versionIntent = extras.getString("version");

        }
    }


}
