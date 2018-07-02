package com.example.lovekeshkumar.projectmvpbase.activity.home.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.detail.view.DetailActivity;
import com.example.lovekeshkumar.projectmvpbase.activity.home.interactor.HomeInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.home.presenter.HomePresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.home.presenter.IHomePresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.adapter.DataAdapter;

import com.example.lovekeshkumar.projectmvpbase.model.Topic;
import com.example.lovekeshkumar.projectmvpbase.model.VideoTopicResponse;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;


import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements IHomeView ,RecyclerClickListener {
    public Utility utility;
    RecyclerView recyclerView;
    ProgressBar progress;
    IHomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progress = (ProgressBar) findViewById(R.id.progress);
        showProgress();
        utility = Utility.getInstance(getApplicationContext());
        homePresenter = new HomePresenterImpl(this,new HomeInteractorImpl(),utility);
    }

    @Override
    public void showProgress() {

        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public Context getContext() {
        return this;
    }


    @Override
    public void bindDataOnView(VideoTopicResponse response) {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
      //  VideoTopicResponse topicComment = new Gson().fromJson((String) object.body(), VideoTopicResponse.class);

            ArrayList<Topic>mAndroidArrayList = (ArrayList<Topic>) response.topics;
            DataAdapter mAdapter = new DataAdapter(mAndroidArrayList,this);
            recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void showErrorMessage(Throwable error) {
        Toast.makeText(this, "Error "+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToDetail() {

    }

    @Override
    public void onRecyclerClick(Intent intent) {
        intent.setClass(this, DetailActivity.class);
        startActivity(intent);
    }

//    private void hitGameDetailList() {
//        if (!utility.isNetworkAvailable()) {
//            //showSnackbar(getString(R.string.internet_error));
//            return;
//        }
//        if (progressDialog != null && !progressDialog.isShowing())
//            progressDialog.show();
//        try {
//            // TODO: 10/16/2017 clear cache
//            //   trimCache(this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ProfilesRequest commentRequest = new ProfilesRequest();
//        commentRequest.chatId = "12323213";
//        networkManager.getVideoTopic(commentRequest, Constant.ModelConstants.VIDEO_TOPIC_TASK_ID);
//
//    }
}
