package com.example.lovekeshkumar.projectmvpbase.activity.welcome.view;


import android.content.Context;

import com.example.lovekeshkumar.projectmvpbase.interface_gl.ProgressInterface;
import com.example.lovekeshkumar.projectmvpbase.model.GameListResponse;
import com.example.lovekeshkumar.projectmvpbase.model.GameResponse;
import com.example.lovekeshkumar.projectmvpbase.model.VideoTopicResponse;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface IWelcomeView extends ProgressInterface{

    void bindDataOnView(GameResponse response);
    void showErrorMessage(Throwable error);

}

