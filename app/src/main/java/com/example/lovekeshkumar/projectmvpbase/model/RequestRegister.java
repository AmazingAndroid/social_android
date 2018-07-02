package com.example.lovekeshkumar.projectmvpbase.model;

import com.google.gson.annotations.SerializedName;

public class RequestRegister {
    @SerializedName("registered_mobile_area_code")
    public String registered_mobile_area_code;
    @SerializedName("registered_mobile")
    public String registered_mobile;
     @SerializedName("full_name")
    public String full_name;
     @SerializedName("email")
    public String email;


}
