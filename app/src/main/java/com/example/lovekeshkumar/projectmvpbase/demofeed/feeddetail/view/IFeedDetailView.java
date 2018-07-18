package com.example.lovekeshkumar.projectmvpbase.demofeed.feeddetail.view;

import com.example.lovekeshkumar.projectmvpbase.model.Comments;
import com.example.lovekeshkumar.projectmvpbase.model.Feed;

import java.util.List;

public interface IFeedDetailView {
    void showProgress();
    void hideProgress();
    void bindDataOnView(List<Comments> response);
}
