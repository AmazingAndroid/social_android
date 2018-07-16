package com.example.lovekeshkumar.projectmvpbase.activity.splash.presenter;


import android.content.Intent;

import com.example.lovekeshkumar.projectmvpbase.model.Country;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface ISplashPresenter {
    void onSuccess(Intent response);
    void onError(Throwable throwable);
}
