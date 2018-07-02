package com.example.lovekeshkumar.projectmvpbase.activity.Greetings.view;

import android.content.Context;

/**
 * Created by Lovekesh Kumar on 3/5/2018.
 */

public interface IAudioView {

    void showProgress();
    void hideProgress();
    void stopAudio();
    void startAudio();
    Context getContext();
}
