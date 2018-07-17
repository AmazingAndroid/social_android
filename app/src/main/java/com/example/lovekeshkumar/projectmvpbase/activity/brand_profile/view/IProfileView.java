package com.example.lovekeshkumar.projectmvpbase.activity.brand_profile.view;


import android.content.Intent;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface IProfileView {
    void showProgress();

    void hideProgress();
    void showErrorMessage(Throwable error);
    void showDetails(Intent intent);

}

