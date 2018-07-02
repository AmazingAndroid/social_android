package com.example.lovekeshkumar.projectmvpbase.activity.Greetings.presenter;


import android.content.Context;
import android.media.MediaPlayer;

import com.example.lovekeshkumar.projectmvpbase.activity.Greetings.interactor.AudioInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.Greetings.interactor.IAudioInteractor;
import com.example.lovekeshkumar.projectmvpbase.activity.Greetings.view.IAudioView;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;


public class AudioPresenterImpl implements IAudioPresenter {
    IAudioView audioView;
    IAudioInteractor audioInteractor;
    Utility utility;
    String AudioURL = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
    public AudioPresenterImpl(IAudioView audioView, AudioInteractorImpl audioInteractor) {
        this.audioView = audioView;
        this.audioInteractor = audioInteractor;
      // audioInteractor.startAudio(this);
    }


//    @Override
//    public void onError(Throwable throwable) {
//        if(homeView != null) {
//            homeView.hideProgress();
//            homeView.showErrorMessage(throwable);
//        }
//    }



    @Override
    public void onStart(MediaPlayer mediaplayer) {
        if (audioView != null) {
            audioView.showProgress();
        }
        audioInteractor.startAudio(AudioURL,mediaplayer,this);
    }

    @Override
    public void onStop(MediaPlayer mediaPlayer) {
        if (audioView != null) {
            audioView.showProgress();
        }
        audioInteractor.stopAudio(mediaPlayer,this);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onSuccess() {
        if (audioView != null) {
            audioView.hideProgress();
        }
    }

    @Override
    public Context getContext() {
        if (audioView != null) {
            return audioView.getContext();
        } else {
            return null;
        }
    }


}
