package com.example.lovekeshkumar.projectmvpbase.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Lovekesh Kumar on 2/27/2018.
 */

public class GameResponse {
    @SerializedName("games")
    public ArrayList<GameModel> gameModels;
}
