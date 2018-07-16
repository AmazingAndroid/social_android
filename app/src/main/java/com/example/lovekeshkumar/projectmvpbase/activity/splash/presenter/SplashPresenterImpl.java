package com.example.lovekeshkumar.projectmvpbase.activity.splash.presenter;


import android.content.Intent;
import android.os.Handler;

import com.example.lovekeshkumar.projectmvpbase.activity.splash.view.ISplashView;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public class SplashPresenterImpl implements ISplashPresenter {
    ISplashView splashView;
    // DetailPresenter detailPresenter;
    Utility utility;
    private Boolean checknet = false;

    public SplashPresenterImpl(ISplashView splashView, Intent intent, Utility utility) {
        this.splashView = splashView;
        this.utility = utility;
        // this.homeInteractor = homeInteractor;
        // homeInteractor.getAllCounty(this);

        if (!utility.isNetworkAvailable()) {
            playNextScreen();
        } else {
            onSuccess(null);
        }


//        if(intent.getExtras()!=null){
//            onSuccess(intent);
//        }else{
//            onError(new RuntimeException());
//        }
    }

    @Override
    public void onSuccess(Intent intent) {
        if (splashView != null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    splashView.goToHomeScreen();
                }
            }, 3000);

            // splashView.showDetails(intent);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        if (splashView != null) {
            //   splashView.hideProgress();
            splashView.showErrorMessage(throwable);
        }
    }

    private void playNextScreen() {
        if (!utility.isNetworkAvailable()) {
            checknet = true;
            new SweetAlertDialog(splashView.getContext(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("No Internet!")
                    .setContentText("Please check your internet connection.")
                    .setConfirmText("Retry")
                    .setCancelText("Exit")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                            splashView.onBackPressed(checknet);
                        }
                    })
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                            playNextScreen();
                        }
                    })
                    .show();

            return;
        }
    }
}
