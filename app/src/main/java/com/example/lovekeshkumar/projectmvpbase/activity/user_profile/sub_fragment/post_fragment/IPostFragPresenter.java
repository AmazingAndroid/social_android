package com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.post_fragment;

import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;

import java.util.ArrayList;

/**
 * Created by Mukesh on 12/16/2017.
 * androiddevelopersolutions.com
 */
public interface IPostFragPresenter {

    void onDestroy();

    void onError();
    void onSuccess(ArrayList<ChatShareDataResponse> chatShareDataResponses);
}
