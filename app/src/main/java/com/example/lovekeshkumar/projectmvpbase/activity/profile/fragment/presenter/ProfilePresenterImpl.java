package com.example.lovekeshkumar.projectmvpbase.activity.profile.fragment.presenter;


import android.content.Intent;

import com.example.lovekeshkumar.projectmvpbase.activity.detail.presenter.IDetailPresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.detail.view.IDetailView;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public class ProfilePresenterImpl implements IDetailPresenter {
    IDetailView detailView;
   // DetailPresenter detailPresenter;

    public ProfilePresenterImpl(IDetailView detailView, Intent intent) {
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
