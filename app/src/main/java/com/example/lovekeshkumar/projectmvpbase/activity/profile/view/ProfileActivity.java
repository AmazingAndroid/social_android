package com.example.lovekeshkumar.projectmvpbase.activity.profile.view;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.detail.presenter.DetailPresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.detail.presenter.IDetailPresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.detail.view.IDetailView;
import com.example.lovekeshkumar.projectmvpbase.activity.profile.fragment.ProfileFragment;
import com.example.lovekeshkumar.projectmvpbase.activity.store.view.StoreFragment;
import com.example.lovekeshkumar.projectmvpbase.activity.welcome.fragment.VideoRecyclerViewFragment;
import com.example.lovekeshkumar.projectmvpbase.basemodel.BaseActivity;
import com.example.lovekeshkumar.projectmvpbase.constant.Constant;
import com.example.lovekeshkumar.projectmvpbase.fragment.share_chat.ChatShareMainFragment;
import com.example.lovekeshkumar.projectmvpbase.fragment.share_chat.view.ChatShareFragment;

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
   //  new ProfileFragment().newInstance(Constant.FragmentTag.LOGIN_FRAGMENT_TAG,Constant.FragmentTag.LOGIN_FRAGMENT_TAG);
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
        replaceFragment(StoreFragment.newInstance("ss","ss"), R.id.container, Constant.FragmentTag.CHATSHARE_FRAGMENT_TAG);

       // replaceFragment(ChatShareMainFragment.newInstance("ss","ss"), R.id.container, Constant.FragmentTag.CHATSHARE_FRAGMENT_TAG);
      //  replaceFragment(ProfileFragment.newInstance(Constant.FragmentTag.LOGIN_FRAGMENT_TAG,Constant.FragmentTag.LOGIN_FRAGMENT_TAG), R.id.container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);
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
