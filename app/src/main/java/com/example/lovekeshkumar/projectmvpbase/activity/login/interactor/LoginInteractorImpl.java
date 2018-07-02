package com.example.lovekeshkumar.projectmvpbase.activity.login.interactor;


import android.os.Handler;
import android.text.TextUtils;

import com.example.lovekeshkumar.projectmvpbase.activity.login.presenter.ILoginPresenter;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public class LoginInteractorImpl implements ILoginInteractor {

    @Override
    public void login(final String username, final String password, final ILoginPresenter loginPresenter) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if (TextUtils.isEmpty(username)) {
                    loginPresenter.onUsernameError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    loginPresenter.onPasswordError();
                    return;
                }
                loginPresenter.onSuccess();
            }
        }, 2000);
    }
}
