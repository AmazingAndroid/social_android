package com.example.lovekeshkumar.projectmvpbase.fragment.share_chat.presenter;

import android.content.Context;

import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;
import com.example.lovekeshkumar.projectmvpbase.network.ServiceRedirection;

import java.util.ArrayList;

public  interface IShareChatPresenter extends ServiceRedirection {

    void sucessListCall(ArrayList<ChatShareDataResponse> chatShareDataResponses);
    Context getContext();
}
