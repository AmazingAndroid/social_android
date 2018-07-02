package com.example.lovekeshkumar.projectmvpbase.activity.login.interactor;


import com.example.lovekeshkumar.projectmvpbase.activity.login.presenter.ILoginPresenter;

/**
 * Created by Mukesh on 12/16/2017.
 * androiddevelopersolutions.com
 */
public interface ILoginInteractor {
    void login(String username, String password, ILoginPresenter listener);
}
