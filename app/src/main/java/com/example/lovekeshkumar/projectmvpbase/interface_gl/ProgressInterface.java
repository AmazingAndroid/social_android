package com.example.lovekeshkumar.projectmvpbase.interface_gl;

import android.content.Context;
import android.view.View;

public interface ProgressInterface {
    void showProgress();
    void initialization(View view);
    void hideProgress();
    Context getContext();


}
