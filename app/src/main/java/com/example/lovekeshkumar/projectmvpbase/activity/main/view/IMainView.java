package com.example.lovekeshkumar.projectmvpbase.activity.main.view;


import android.content.Context;

import com.example.lovekeshkumar.projectmvpbase.model.Country;
import com.example.lovekeshkumar.projectmvpbase.model.VideoTopicResponse;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface IMainView {
  //  void showProgress();
  //  void hideProgress();
    Context getContext();
    void bindDataOnView();
    void showErrorMessage(Throwable error);
    void navigateToDetail();
}

