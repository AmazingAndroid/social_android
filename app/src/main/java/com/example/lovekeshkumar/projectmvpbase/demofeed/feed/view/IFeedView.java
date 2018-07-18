package com.example.lovekeshkumar.projectmvpbase.demofeed.feed.view;

import com.example.lovekeshkumar.projectmvpbase.model.Feed;

import java.util.List;

public interface IFeedView {
    void showProgress();
    void hideProgress();
    void bindDataOnView(List<Feed> response);
    void bindData(List<String> response);

}
