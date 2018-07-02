package com.example.lovekeshkumar.projectmvpbase.activity.welcome.interactor;

import com.example.lovekeshkumar.projectmvpbase.activity.gaming.presenter.GamePresenterImpl;

/**
 * Created by Lovekesh Kumar on 2/27/2018.
 */

public interface IWelcomeInteractor {
    void getGameList(GamePresenterImpl gameInteractor);
}
