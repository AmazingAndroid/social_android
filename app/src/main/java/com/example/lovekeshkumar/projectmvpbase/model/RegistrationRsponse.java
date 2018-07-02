package com.example.lovekeshkumar.projectmvpbase.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationRsponse {

    @SerializedName("result")
    @Expose
    public Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}


