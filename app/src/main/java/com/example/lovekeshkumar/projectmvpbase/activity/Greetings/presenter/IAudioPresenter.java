package com.example.lovekeshkumar.projectmvpbase.activity.Greetings.presenter;


import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface IAudioPresenter {
    void onStart(MediaPlayer mediaplayer);
    void onStop(MediaPlayer mediaplayer);
    void onError(Throwable throwable);
    void onSuccess();
    Context getContext();


}
