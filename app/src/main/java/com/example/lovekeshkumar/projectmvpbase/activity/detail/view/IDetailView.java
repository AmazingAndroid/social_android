package com.example.lovekeshkumar.projectmvpbase.activity.detail.view;


import android.content.Intent;

import com.example.lovekeshkumar.projectmvpbase.model.Country;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface IDetailView {
    void showProgress();

    void hideProgress();
    void showErrorMessage(Throwable error);
    void showDetails(Intent intent);

}

