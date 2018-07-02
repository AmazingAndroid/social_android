package com.example.lovekeshkumar.projectmvpbase.activity.welcome.fragment;


import android.content.Context;
import android.view.View;

import com.example.lovekeshkumar.projectmvpbase.model.GameResponse;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface IVideoRecyclerView {
    void showProgress();
    void hideProgress();
    void setListeners();
    void initialization(View view);
    Context getContext();
    void bindDataOnView(String response);
    void showErrorMessage(Throwable error);

}

