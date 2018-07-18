package com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.activity;

import com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.collection.ICollectionFragPresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.collection.ICollectionFragmentView;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;

import java.util.ArrayList;

class ActivityFragmentPresenterImpl implements IActivityFragPresenter{
    IActivityFragmentView iPostFragmentView;

    public ActivityFragmentPresenterImpl(IActivityFragmentView iPostFragmentView) {
    this.iPostFragmentView=iPostFragmentView;
        onSuccess(null);
    }



    @Override
    public void onDestroy() {

    }

    @Override
    public void onError() {

    }


    @Override
    public void onSuccess(ArrayList<ChatShareDataResponse> chatShareDataResponses) {
        iPostFragmentView.bindViewWithResponse(null);
    }
}
