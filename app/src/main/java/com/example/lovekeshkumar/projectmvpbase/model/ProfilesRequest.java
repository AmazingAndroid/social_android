package com.example.lovekeshkumar.projectmvpbase.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 5/27/2017.
 */

public class ProfilesRequest {
    @SerializedName("action")
    public String action;
    @SerializedName("fname")
    public String fname;
    @SerializedName("lname")
    public String lname;
    @SerializedName("username")
    public String username;
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("mobile")
    public String mobile;
    @SerializedName("dob")
    public String dob;
    @SerializedName("nationality")
    public String nationality;
    @SerializedName("work")
    public String work;

}
