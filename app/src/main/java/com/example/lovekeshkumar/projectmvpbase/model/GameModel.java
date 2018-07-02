package com.example.lovekeshkumar.projectmvpbase.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lovekesh Kumar on 2/27/2018.
 */

public class GameModel extends BaseResult {

    @SerializedName("game")
    public String game;
    @SerializedName("image_url")
    public String image_url;
    @SerializedName("working_url")
    public String working_url;
    @SerializedName("id")
    public String id;
    @SerializedName("screen_type")
    public String screen_type;

}
