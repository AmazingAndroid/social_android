package com.example.lovekeshkumar.projectmvpbase.fragment.share_chat.view;

import android.content.Context;

import com.example.lovekeshkumar.projectmvpbase.interface_gl.ProgressInterface;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;

import java.util.ArrayList;

public interface IChatShareView  extends ProgressInterface{
    void bindDataOnView(ArrayList<ChatShareDataResponse> response);
    void onRecyclerClick(ArrayList<ChatShareDataResponse> response,int position);
    void showErrorMessage(Throwable error);

}
