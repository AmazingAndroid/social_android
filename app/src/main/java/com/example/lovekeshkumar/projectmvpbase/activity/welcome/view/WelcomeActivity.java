package com.example.lovekeshkumar.projectmvpbase.activity.welcome.view;



import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.lovekeshkumar.projectmvpbase.R;

import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.activity.welcome.fragment.VideoRecyclerViewFragment;

import com.example.lovekeshkumar.projectmvpbase.basemodel.BaseActivity;
import com.example.lovekeshkumar.projectmvpbase.constant.Constant;

import com.example.lovekeshkumar.projectmvpbase.utility.Utility;



@SuppressWarnings("ALL")
public class WelcomeActivity extends BaseActivity implements  RecyclerClickListener {
    public Utility utility;
    RecyclerView recyclerView;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initializeViews();
        bindData();
    }

    @Override
    public void initializeViews() {
        //recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
      //  progress = (ProgressBar) findViewById(R.id.progress);
      //  showProgress();
      //  utility = Utility.getInstance(getApplicationContext());
    }

    @Override
    public void bindData() {
        replaceFragment(VideoRecyclerViewFragment.newInstance(1), R.id.main_container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);
       // iGamePresenter = new GamePresenterImpl(this, new GameInteractorImpl(), utility);
    }

    @Override
    public void setListeners() {

    }




    @Override
    public void onRecyclerClick(Intent intent) {

    }
    @Override
    public void onSaveInstanceState(Bundle stateBundle) {
        int osVersion = android.os.Build.VERSION.SDK_INT;
        if (osVersion < Build.VERSION_CODES.N) {
            super.onSaveInstanceState(stateBundle);
        }
    }

}
