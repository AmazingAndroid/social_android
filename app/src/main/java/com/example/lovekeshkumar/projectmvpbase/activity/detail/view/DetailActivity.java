package com.example.lovekeshkumar.projectmvpbase.activity.detail.view;


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

public class DetailActivity extends AppCompatActivity implements IDetailView {

    RecyclerView recyclerView;
    ProgressBar progress;
    IDetailPresenter detailPresenter;
TextView name,api,version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    name = (TextView) findViewById(R.id.name);
        api = (TextView) findViewById(R.id.api);
        version = (TextView) findViewById(R.id.version);
        progress = (ProgressBar) findViewById(R.id.progress);
        showProgress();

        detailPresenter = new DetailPresenterImpl(this,getIntent());
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
        Bundle extras = getIntent().getExtras();
        String nameIntent;
        String apiIntent;
        String versionIntent;
        if(extras == null) {
            return;
        } else {
            nameIntent= extras.getString("name");
            apiIntent= extras.getString("api");
            versionIntent= extras.getString("version");
            name.setText(nameIntent);
            api.setText(apiIntent);
            version.setText(versionIntent);
        }
    }


}
