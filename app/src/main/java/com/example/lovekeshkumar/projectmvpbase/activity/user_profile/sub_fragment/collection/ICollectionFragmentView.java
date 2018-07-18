package com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.collection;

import com.example.lovekeshkumar.projectmvpbase.fragment.basemethodfragment.BaseFrag;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;

import java.util.ArrayList;

public  interface ICollectionFragmentView extends BaseFrag{
    void bindViewWithResponse(ArrayList<ChatShareDataResponse> chatShareDataResponses);
}
