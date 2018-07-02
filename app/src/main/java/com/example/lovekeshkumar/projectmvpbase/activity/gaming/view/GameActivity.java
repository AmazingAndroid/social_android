package com.example.lovekeshkumar.projectmvpbase.activity.gaming.view;


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
import com.example.lovekeshkumar.projectmvpbase.activity.gaming.interactor.GameInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.gaming.presenter.GamePresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.gaming.presenter.IGamePresenter;

import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.adapter.GameListAdapter;
import com.example.lovekeshkumar.projectmvpbase.model.GameModel;
import com.example.lovekeshkumar.projectmvpbase.model.GameResponse;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements IGameView, RecyclerClickListener {
    public Utility utility;
    RecyclerView recyclerView;
    ProgressBar progress;
    IGamePresenter iGamePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progress = (ProgressBar) findViewById(R.id.progress);
        showProgress();
        utility = Utility.getInstance(getApplicationContext());
        iGamePresenter = new GamePresenterImpl(this, new GameInteractorImpl(), utility);
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
    public void bindDataOnView(GameResponse response) {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);


        ArrayList<GameModel> mAndroidArrayList = (ArrayList<GameModel>) response.gameModels;
        GameListAdapter mAdapter = new GameListAdapter(mAndroidArrayList, this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void showErrorMessage(Throwable error) {
        hideProgress();
        Toast.makeText(this, "Error " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRecyclerClick(Intent intent) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        intent.setClass(this, DetailActivity.class);
        startActivity(intent);
    }


}
