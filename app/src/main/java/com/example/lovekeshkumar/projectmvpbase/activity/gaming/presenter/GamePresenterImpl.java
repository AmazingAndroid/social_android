package com.example.lovekeshkumar.projectmvpbase.activity.gaming.presenter;


import android.content.Context;

import com.example.lovekeshkumar.projectmvpbase.activity.gaming.interactor.GameInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.gaming.interactor.IGameInteractor;
import com.example.lovekeshkumar.projectmvpbase.activity.gaming.view.IGameView;
import com.example.lovekeshkumar.projectmvpbase.activity.home.interactor.HomeInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.home.interactor.IHomeInteractor;
import com.example.lovekeshkumar.projectmvpbase.activity.home.presenter.IHomePresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.home.view.IHomeView;
import com.example.lovekeshkumar.projectmvpbase.model.GameListResponse;
import com.example.lovekeshkumar.projectmvpbase.model.GameResponse;
import com.example.lovekeshkumar.projectmvpbase.model.RegistrationRsponse;
import com.example.lovekeshkumar.projectmvpbase.model.VideoTopicResponse;
import com.example.lovekeshkumar.projectmvpbase.network.ErrorModel;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;
import com.google.gson.Gson;

import retrofit2.Response;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public class GamePresenterImpl implements IGamePresenter {
    IGameView gameView;
    IGameInteractor gameInteractor;
    Utility utility;

    public GamePresenterImpl(IGameView gameView, GameInteractorImpl gameInteractor, Utility utility) {
        this.gameView = gameView;
        this.gameInteractor = gameInteractor;
        this.utility = utility;
        gameInteractor.getGameList(this);
    }


    @Override
    public Context getContext() {
        if (gameView != null) {
            return gameView.getContext();
        } else {
            return null;
        }
    }

    @Override
    public void onSuccessRedirection(Response object, int taskID) {

        if (!utility.isNetworkAvailable()) {
            return;
        }
        if (gameView != null) {
            gameView.hideProgress();
        }
       // RegistrationRsponse gameResponses = new Gson().fromJson((String) object.body(), RegistrationRsponse.class);
     //   if (gameResponses != null
       //         ) {
            //  gameView.bindDataOnView(gameResponses);
            System.out.println("Name: 1" + object.message());
            System.out.println("Name: 1" + object.body());

//System.out.println("Name: 7"+gameResponses.result.);
//System.out.println("Name: 8"+gameResponses.result.);
//System.out.println("Name: 9"+gameResponses.result.);
//System.out.println("Name: 10"+gameResponses.result.);
      //  }

    }

    @Override
    public void onServerErrorRedirection(ErrorModel errorModel, int taskID) {
        System.out.println("Name: 8" + errorModel.error_message);
        System.out.println("Name: 9" + errorModel.error_code);

    }

    @Override
    public void onFailureRedirection(ErrorModel errorModel) {
        System.out.println("Name: 10" + errorModel.error_message);
        System.out.println("Name: 11" + errorModel.error_code);
    }
}
