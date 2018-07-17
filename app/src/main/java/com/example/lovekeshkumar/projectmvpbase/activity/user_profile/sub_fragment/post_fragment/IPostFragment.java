package com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.post_fragment;

import com.example.lovekeshkumar.projectmvpbase.fragment.basemethodfragment.BaseFrag;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;

import java.util.ArrayList;

public  interface IPostFragment extends BaseFrag{
    void bindViewWithResponse(ArrayList<ChatShareDataResponse> chatShareDataResponses);
}
