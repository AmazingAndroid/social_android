package com.example.lovekeshkumar.projectmvpbase.activity.brand_profile.fragment.interactor;


import android.media.MediaPlayer;

import com.example.lovekeshkumar.projectmvpbase.activity.Greetings.presenter.AudioPresenterImpl;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface IBrandProfileInteractor {
  //  void getAllCounty(MainPresenterImpl homePresenter);

    void startAudio(String audioUlr, MediaPlayer mediaPlayer, AudioPresenterImpl audioPresenter);
    void stopAudio(MediaPlayer mediaPlayer, AudioPresenterImpl audioPresenter);
}
