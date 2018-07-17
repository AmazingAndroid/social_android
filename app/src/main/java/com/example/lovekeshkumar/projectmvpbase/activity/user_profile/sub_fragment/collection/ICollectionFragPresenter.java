package com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.collection;

import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;

import java.util.ArrayList;

/**
 * Created by Mukesh on 12/16/2017.
 * androiddevelopersolutions.com
 */
public interface ICollectionFragPresenter {

    void onDestroy();

    void onError();
    void onSuccess(ArrayList<ChatShareDataResponse> chatShareDataResponses);
}
