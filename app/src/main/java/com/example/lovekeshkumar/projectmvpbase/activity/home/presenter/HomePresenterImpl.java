package com.example.lovekeshkumar.projectmvpbase.activity.home.presenter;


import android.content.Context;

import com.example.lovekeshkumar.projectmvpbase.activity.home.interactor.HomeInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.home.interactor.IHomeInteractor;
import com.example.lovekeshkumar.projectmvpbase.activity.home.view.IHomeView;
import com.example.lovekeshkumar.projectmvpbase.model.VideoTopicResponse;
import com.example.lovekeshkumar.projectmvpbase.network.ErrorModel;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;
import com.google.gson.Gson;

import retrofit2.Response;


public class HomePresenterImpl implements IHomePresenter {
    IHomeView homeView;
    IHomeInteractor homeInteractor;
    Utility utility;

    public HomePresenterImpl(IHomeView homeView, HomeInteractorImpl homeInteractor, Utility utility) {
        this.homeView = homeView;
        this.homeInteractor = homeInteractor;
        this.utility = utility;
        homeInteractor.getVideoList(this);
    }

//    @Override
//    public void onSuccess(VideoTopicResponse response) {
//
//    }
//
//    @Override
//    public void onError(Throwable throwable) {
//        if(homeView != null) {
//            homeView.hideProgress();
//            homeView.showErrorMessage(throwable);
//        }
//    }

    @Override
    public Context getContext() {
        if (homeView != null) {
            return homeView.getContext();
        } else {
            return null;
        }
    }

    @Override
    public void onSuccessRedirection(Response object, int taskID) {

        if (!utility.isNetworkAvailable()) {
            return;
        }
        if (homeView != null) {
            homeView.hideProgress();
        }
        VideoTopicResponse videoTopicResponse = new Gson().fromJson((String) object.body(), VideoTopicResponse.class);
        if (videoTopicResponse != null &&
                videoTopicResponse.topics != null &&
                videoTopicResponse.topics.size() > 0) {
            homeView.bindDataOnView(videoTopicResponse);

        }

    }

    @Override
    public void onServerErrorRedirection(ErrorModel errorModel, int taskID) {

    }

    @Override
    public void onFailureRedirection(ErrorModel errorModel) {

    }
}
