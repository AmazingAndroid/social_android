package com.example.lovekeshkumar.projectmvpbase.activity.home.interactor;


import com.example.lovekeshkumar.projectmvpbase.activity.home.presenter.HomePresenterImpl;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public interface IHomeInteractor {
  //  void getAllCounty(MainPresenterImpl homePresenter);

    void getVideoList(HomePresenterImpl homePresenter);
}
