package com.example.lovekeshkumar.projectmvpbase.activity.store.presenter;

import android.content.Intent;

import com.example.lovekeshkumar.projectmvpbase.activity.store.view.IStoreView;

public class StorePresenterImpl implements IStorePresenter {
    IStoreView iStoreView;
    public StorePresenterImpl(IStoreView iStoreView, Intent intent) {
     //   this.detailView = detailView;
        // this.homeInteractor = homeInteractor;
        // homeInteractor.getAllCounty(this);
        if(intent.getExtras()!=null){
            onSuccess(intent);
        }else{
            onError(new RuntimeException());
        }
    }


    @Override
    public void onSuccess(Intent response) {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
