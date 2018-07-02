package com.example.lovekeshkumar.projectmvpbase.activity.home.presenter;


import android.content.Context;

import com.example.lovekeshkumar.projectmvpbase.model.Country;
import com.example.lovekeshkumar.projectmvpbase.model.VideoTopicResponse;
import com.example.lovekeshkumar.projectmvpbase.network.ServiceRedirection;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface IHomePresenter extends ServiceRedirection{
   // void onSuccess(VideoTopicResponse response);
  //  void onError(Throwable throwable);
    Context getContext();


}
