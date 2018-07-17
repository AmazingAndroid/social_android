package com.example.lovekeshkumar.projectmvpbase.activity.welcome.interactor;

import com.example.lovekeshkumar.projectmvpbase.activity.gaming.interactor.IGameInteractor;
import com.example.lovekeshkumar.projectmvpbase.activity.gaming.presenter.GamePresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.model.Constant;
import com.example.lovekeshkumar.projectmvpbase.model.ProfilesRequest;
import com.example.lovekeshkumar.projectmvpbase.network.NetworkManager;

/**
 * Created by Lovekesh Kumar on 2/27/2018.
 */

public class WelcomeInteractorImpl implements IGameInteractor {
    NetworkManager networkManager;

    @Override
    public void getGameList(GamePresenterImpl gamePresenter) {

        ProfilesRequest profilesRequest=new ProfilesRequest();
        profilesRequest.action="register";
        profilesRequest.fname="LOVEKESH";
        profilesRequest.lname="KUMAR";
        profilesRequest.username="lovekesh kumar";
        profilesRequest.email="abc@gmail.com";
        profilesRequest.password="1234567";
        profilesRequest.password="1234567";
        profilesRequest.mobile="9090909090";
        profilesRequest.dob="2018-03-01";
        profilesRequest.nationality="India";
        profilesRequest.work="Dance";
        networkManager= NetworkManager.get(gamePresenter.getContext(),gamePresenter);
        networkManager.gameDetailList("9","08c5b004c092044ea02bc236ce6f40cd72bdfa798a7ee1e3187b64a7f8f9f09a", Constant.GAME_LIST_TASK_ID);
    }
}
