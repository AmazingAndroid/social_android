package com.example.lovekeshkumar.projectmvpbase.demofeed.feed.view;


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
import com.example.lovekeshkumar.projectmvpbase.adapter.AdapterFeed;
import com.example.lovekeshkumar.projectmvpbase.adapter.AdapterStories;
import com.example.lovekeshkumar.projectmvpbase.demofeed.feed.presenter.FeedPresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.model.Feed;

import java.util.List;

public class FeedFragment extends Fragment implements IFeedView{

    private  View view;
    RecyclerView recycler_feeds,recycler_stories;
    List<Feed> list;
    List<String> urls;
    private FeedPresenterImpl feedPresenter;

    public static FeedFragment newInstance() {
        FeedFragment fragment = new FeedFragment();
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_feed, container, false);
        init(view);
        return view;
    }

    public void init(View v){
        recycler_feeds=v.findViewById(R.id.recycler_feeds);
        recycler_stories=v.findViewById(R.id.recycler_stories);
        feedPresenter=new FeedPresenterImpl(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void bindDataOnView(List<Feed> response) {
        list = response;
        AdapterFeed mAdapter = new AdapterFeed(getActivity(),list);
        recycler_feeds.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_feeds.setAdapter(mAdapter);
    }

    @Override
    public void bindData(List<String> response) {
        urls=response;
        AdapterStories mAdapter=new AdapterStories(getActivity(),urls);
        recycler_stories.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recycler_stories.setAdapter(mAdapter);
    }


}
