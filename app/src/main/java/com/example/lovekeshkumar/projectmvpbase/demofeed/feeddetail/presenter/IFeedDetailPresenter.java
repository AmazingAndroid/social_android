package com.example.lovekeshkumar.projectmvpbase.demofeed.feeddetail.presenter;

import com.example.lovekeshkumar.projectmvpbase.model.Comments;
import com.example.lovekeshkumar.projectmvpbase.model.Feed;

import java.util.List;

/**
 * Created by Mukesh on 12/16/2017.
 * androiddevelopersolutions.com
 */
public interface IFeedDetailPresenter {
    void populate(List<Comments> data);
}
