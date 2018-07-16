package com.example.lovekeshkumar.projectmvpbase.activity.Greetings.view;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.Greetings.interactor.AudioInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.Greetings.presenter.AudioPresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.Greetings.presenter.IAudioPresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.detail.view.DetailActivity;
import com.example.lovekeshkumar.projectmvpbase.activity.home.interactor.HomeInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.home.presenter.HomePresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.home.presenter.IHomePresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.home.view.IHomeView;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.activity.login.interactor.LoginInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.login.presenter.LoginPresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.adapter.DataAdapter;
import com.example.lovekeshkumar.projectmvpbase.model.Topic;
import com.example.lovekeshkumar.projectmvpbase.model.VideoTopicResponse;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.io.IOException;
import java.util.ArrayList;

public class AudioActivity extends AppCompatActivity implements IAudioView  {
    public Utility utility;
    RecyclerView recyclerView;
    ProgressBar progress;
    IAudioPresenter presenter;
    Button buttonStop,buttonStart ;
    MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_home);
        buttonStart = (Button)findViewById(R.id.button1);
        buttonStop = (Button)findViewById(R.id.button2);
        progress = (ProgressBar) findViewById(R.id.progress);
        mediaplayer = new MediaPlayer();
        mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        presenter=new AudioPresenterImpl(this,new AudioInteractorImpl()) ;
        buttonStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                presenter.onStart(mediaplayer);

            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                presenter.onStop(mediaplayer);



            }
        });
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
    public void stopAudio() {

    }

    @Override
    public void startAudio() {

    }

    @Override
    public Context getContext() {
        return null;
    }

    //recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
     //   progress = (ProgressBar) findViewById(R.id.progress);
     //   showProgress();
       // utility = Utility.getInstance(getApplicationContext());
       // homePresenter = new AudioPresenterImpl(this,new ProfileInteractorImpl(),utility);
    }

//    @Override
//    public void showProgress() {
//        progress.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void hideProgress() {
//        progress.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void stopAudio() {
//
//    }
//
//    @Override
//    public void startAudio() {
//
//    }
//
//    @Override
//    public Context getContext() {
//        return this;
//    }




