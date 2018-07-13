package com.example.lovekeshkumar.projectmvpbase.activity.profile.fragment.presenter;


import android.content.Intent;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface IProfilePresenter {
    void onSuccess(Intent response);
    void onError(Throwable throwable);
}
