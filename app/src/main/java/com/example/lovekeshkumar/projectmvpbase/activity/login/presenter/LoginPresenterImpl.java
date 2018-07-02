package com.example.lovekeshkumar.projectmvpbase.activity.login.presenter;

import com.example.lovekeshkumar.projectmvpbase.activity.login.interactor.ILoginInteractor;
import com.example.lovekeshkumar.projectmvpbase.activity.login.interactor.LoginInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.login.view.ILoginView;

/**
 * Created by Lovekesh Kumar on 2/26/2018.
 */

public class LoginPresenterImpl implements ILoginPresenter{

    private ILoginView loginView;
    private ILoginInteractor loginInteractor;


    public LoginPresenterImpl(ILoginView loginView, LoginInteractorImpl loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }


    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}
