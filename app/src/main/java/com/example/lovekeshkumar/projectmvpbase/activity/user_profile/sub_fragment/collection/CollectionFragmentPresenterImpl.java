package com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.collection;

import com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.post_fragment.IPostFragPresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.post_fragment.IPostFragment;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;

import java.util.ArrayList;

class CollectionFragmentPresenterImpl implements ICollectionFragPresenter{
    ICollectionFragmentView iPostFragmentView;

    public CollectionFragmentPresenterImpl(ICollectionFragmentView iPostFragmentView) {
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
