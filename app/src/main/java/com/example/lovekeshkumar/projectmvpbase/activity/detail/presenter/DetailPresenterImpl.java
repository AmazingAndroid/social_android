package com.example.lovekeshkumar.projectmvpbase.activity.detail.presenter;


import android.content.Intent;

import com.example.lovekeshkumar.projectmvpbase.activity.detail.view.IDetailView;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public class DetailPresenterImpl implements IDetailPresenter {
    IDetailView detailView;
   // DetailPresenter detailPresenter;

    public DetailPresenterImpl(IDetailView detailView, Intent intent) {
        this.detailView = detailView;
       // this.homeInteractor = homeInteractor;
       // homeInteractor.getAllCounty(this);
        if(intent.getExtras()!=null){
            onSuccess(intent);
        }else{
            onError(new RuntimeException());
        }
    }
    @Override
    public void onSuccess(Intent respomse) {
        if(detailView != null) {
            detailView.hideProgress();
            detailView.showDetails(respomse);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        if(detailView != null) {
            detailView.hideProgress();
            detailView.showErrorMessage(throwable);
        }
    }
}
