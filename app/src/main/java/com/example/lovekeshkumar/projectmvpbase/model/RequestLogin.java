package com.example.lovekeshkumar.projectmvpbase.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestLogin {

    @SerializedName("registered_mobile_area_code")
    @Expose
    public String registeredMobileAreaCode;
    @SerializedName("registered_mobile")
    @Expose
    public String registeredMobile;
    @SerializedName("email")
    @Expose
    public String email;

    public String getRegisteredMobileAreaCode() {
        return registeredMobileAreaCode;
    }

    public void setRegisteredMobileAreaCode(String registeredMobileAreaCode) {
        this.registeredMobileAreaCode = registeredMobileAreaCode;
    }

    public String getRegisteredMobile() {
        return registeredMobile;
    }

    public void setRegisteredMobile(String registeredMobile) {
        this.registeredMobile = registeredMobile;
    }

    public String getEmail() {
        return email;
    }
}