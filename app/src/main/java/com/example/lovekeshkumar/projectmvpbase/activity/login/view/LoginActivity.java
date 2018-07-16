package com.example.lovekeshkumar.projectmvpbase.activity.login.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.login.interactor.LoginInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.login.presenter.ILoginPresenter;
import com.example.lovekeshkumar.projectmvpbase.activity.login.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    EditText username;
    EditText password;
    ProgressBar progress;
    Button button;
    private ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progress = (ProgressBar) findViewById(R.id.progress);
        button = (Button) findViewById(R.id.btnLogin);
        password = (EditText) findViewById(R.id.password);
        username = (EditText) findViewById(R.id.username);
        presenter=new LoginPresenterImpl(this,new LoginInteractorImpl()) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateCredentials(username.getText().toString(), password.getText().toString());
            }
        });
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
    public void setUsernameError() {
        username.setError("Invalid user name");
    }

    @Override
    public void setPasswordError() {
        password.setError("Invalid password");
    }

    @Override
    public void navigateToHome() {
        //startActivity(new Intent(this, GameActivity.class));
      //  finish();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
