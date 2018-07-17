package com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.post_fragment;

import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;

import java.util.ArrayList;

class PostFragmentPresenterImpl implements IPostFragPresenter{
    IPostFragment iPostFragmentView;

    public PostFragmentPresenterImpl(IPostFragment iPostFragmentView) {
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
