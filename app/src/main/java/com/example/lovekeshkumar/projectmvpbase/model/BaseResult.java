package com.example.lovekeshkumar.projectmvpbase.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 3/30/2017.
 */

public class BaseResult {
    @SerializedName("error")
    public Boolean error;
    @SerializedName("message")
    public String message;

}
