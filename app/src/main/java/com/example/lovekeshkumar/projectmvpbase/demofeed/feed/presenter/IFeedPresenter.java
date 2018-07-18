package com.example.lovekeshkumar.projectmvpbase.demofeed.feed.presenter;

import com.example.lovekeshkumar.projectmvpbase.model.Feed;

import java.util.List;

/**
 * Created by Mukesh on 12/16/2017.
 * androiddevelopersolutions.com
 */
public interface IFeedPresenter {
    void populate(List<Feed> data);
    void populateStories(List<String> data);
}
