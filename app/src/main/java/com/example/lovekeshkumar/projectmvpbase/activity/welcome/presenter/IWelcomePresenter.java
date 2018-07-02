package com.example.lovekeshkumar.projectmvpbase.activity.welcome.presenter;

import android.content.Context;

import com.example.lovekeshkumar.projectmvpbase.network.ServiceRedirection;

/**
 * Created by Lovekesh Kumar on 2/27/2018.
 */

public interface IWelcomePresenter extends ServiceRedirection {
    Context getContext();
}
