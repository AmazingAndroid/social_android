package com.example.lovekeshkumar.projectmvpbase.activity.brand_profile.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.brand_profile.adapter.SimpleRecyclerAdapter;
import com.example.lovekeshkumar.projectmvpbase.model.Constant;

import java.util.ArrayList;
import java.util.List;

public  class DummyFragment extends Fragment {
    int color;
    SimpleRecyclerAdapter adapter;

    public DummyFragment() {
    }

    @SuppressLint("ValidFragment")
    public DummyFragment(int color) {
        this.color = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dummy_fragment, container, false);

        final RelativeLayout frameLayout = (RelativeLayout) view.findViewById(R.id.dummyfrag_bg);
        frameLayout.setBackgroundColor(color);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);
        recyclerView= Constant.SetRecyclerViewOrientation.setGridView(recyclerView,getActivity(),2);
      /*  recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);*/
       // recyclerView.setHasFixedSize(true);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < VersionModel.data.length; i++) {
            list.add(VersionModel.data[i]);
        }

        adapter = new SimpleRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
