package com.example.lovekeshkumar.projectmvpbase.fragment.video_list_demo.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.adapter.MyListAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {

    private  View view;
    RecyclerView recyclerView;
    List<String> list;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_orders, container, false);
        init(view);
        return view;
    }

    public void init(View v){
        list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        recyclerView=v.findViewById(R.id.recyclerView);
        MyListAdapter adapter=new MyListAdapter(getActivity(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

}
