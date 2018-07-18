package com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.activity;

import com.example.lovekeshkumar.projectmvpbase.fragment.basemethodfragment.BaseFrag;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;

import java.util.ArrayList;

public  interface IActivityFragmentView extends BaseFrag{
    void bindViewWithResponse(ArrayList<ChatShareDataResponse> chatShareDataResponses);
}
