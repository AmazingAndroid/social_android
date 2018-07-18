package com.example.lovekeshkumar.projectmvpbase.activity.store.presenter;

import android.content.Intent;

public interface IStorePresenter {
    void onSuccess(Intent response);
    void onError(Throwable throwable);

}
