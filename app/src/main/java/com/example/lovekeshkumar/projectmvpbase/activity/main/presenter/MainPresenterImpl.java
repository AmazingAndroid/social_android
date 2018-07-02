package com.example.lovekeshkumar.projectmvpbase.activity.main.presenter;


import android.content.Context;

import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.FlipVerticalTransformer;
import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.ScaleInOutTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.TabletTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutSlideTransformer;
import com.example.lovekeshkumar.projectmvpbase.activity.home.interactor.HomeInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.home.interactor.IHomeInteractor;
import com.example.lovekeshkumar.projectmvpbase.activity.home.presenter.IHomePresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.home.view.IHomeView;
import com.example.lovekeshkumar.projectmvpbase.activity.main.interactor.IMainInteractor;
import com.example.lovekeshkumar.projectmvpbase.activity.main.interactor.MainInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.main.view.IMainView;
import com.example.lovekeshkumar.projectmvpbase.activity.main.view.MainActivity;
import com.example.lovekeshkumar.projectmvpbase.model.TransformerItem;
import com.example.lovekeshkumar.projectmvpbase.model.VideoTopicResponse;
import com.example.lovekeshkumar.projectmvpbase.network.ErrorModel;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Response;


public class MainPresenterImpl implements IMainPresenter {
    IMainView homeView;
    MainInteractorImpl homeInteractor;
    Utility utility;






    public MainPresenterImpl(IMainView iMainView, MainInteractorImpl homeInteractor, Utility utility) {
        this.homeView = iMainView;
        this.homeInteractor = homeInteractor;
        this.utility = utility;
      //  homeInteractor.getVideoList(this);
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


}
