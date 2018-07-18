package com.example.lovekeshkumar.projectmvpbase.activity.brand_profile.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.detail.presenter.IDetailPresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.detail.view.IDetailView;
import com.example.lovekeshkumar.projectmvpbase.activity.store.view.StoreFragment;
import com.example.lovekeshkumar.projectmvpbase.activity.user_profile.view.MyProfileFragment;
import com.example.lovekeshkumar.projectmvpbase.basemodel.BaseActivity;
import com.example.lovekeshkumar.projectmvpbase.fragment.share_chat.ChatShareMainFragment;
import com.example.lovekeshkumar.projectmvpbase.model.Constant;

public class ProfileActivity extends BaseActivity implements IDetailView {


    RecyclerView recyclerView;
    ProgressBar progress;
    IDetailPresenter detailPresenter;
TextView name,api,version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bindData();
   //  new BrandProfileFragment().newInstance(Constant.FragmentTag.LOGIN_FRAGMENT_TAG,Constant.FragmentTag.LOGIN_FRAGMENT_TAG);
   /* name = (TextView) findViewById(R.id.name);
        api = (TextView) findViewById(R.id.api);
        version = (TextView) findViewById(R.id.version);
        progress = (ProgressBar) findViewById(R.id.progress);
        showProgress();*/

     //   detailPresenter = new SplashPresenterImpl(this,getIntent());
    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void bindData() {

       // replaceFragment(StoreFragment.newInstance("ss","ss"), R.id.container, Constant.FragmentTag.CHATSHARE_FRAGMENT_TAG);

        //replaceFragment(ChatShareMainFragment.newInstance("ss","ss"), R.id.container, Constant.FragmentTag.CHATSHARE_FRAGMENT_TAG);
      //  replaceFragment(ProfileFragment.newInstance(Constant.FragmentTag.LOGIN_FRAGMENT_TAG,Constant.FragmentTag.LOGIN_FRAGMENT_TAG), R.id.container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);

       // replaceFragment(StoreFragment.newInstance("ss","ss"), R.id.container, Constant.FragmentTag.CHATSHARE_FRAGMENT_TAG);
        replaceFragment(MyProfileFragment.newInstance("ss","ss"), R.id.container, Constant.FragmentTag.MYPROFILE_FRAGMENT_TAG);

       // replaceFragment(ChatShareMainFragment.newInstance("ss","ss"), R.id.container, Constant.FragmentTag.CHATSHARE_FRAGMENT_TAG);
      //  replaceFragment(BrandProfileFragment.newInstance(Constant.FragmentTag.LOGIN_FRAGMENT_TAG,Constant.FragmentTag.LOGIN_FRAGMENT_TAG), R.id.container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);
    }

    @Override
    public void setListeners() {

    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(Throwable error) {

    }

    @Override
    public void showDetails(Intent intent) {

    }


}
