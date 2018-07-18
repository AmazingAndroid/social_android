package com.example.lovekeshkumar.projectmvpbase.demofeed.feed.presenter;

import android.util.Log;

import com.example.lovekeshkumar.projectmvpbase.demofeed.feed.view.IFeedView;
import com.example.lovekeshkumar.projectmvpbase.model.CommonMethod;
import com.example.lovekeshkumar.projectmvpbase.model.Feed;

import java.util.List;

/**
 * Created by Lovekesh Kumar on 2/26/2018.
 */

public class FeedPresenterImpl implements IFeedPresenter {

    private IFeedView feedView;

    public FeedPresenterImpl(IFeedView feedView) {
        this.feedView = feedView;
        populate(CommonMethod.getFeedList());
        populateStories(CommonMethod.getStoryList());
    }


    @Override
    public void populate(List<Feed> data) {
        if (data!=null){
         feedView.bindDataOnView(data);
        }else{
            Log.e("Error "," Counld not load data");
        }
    }

    @Override
    public void populateStories(List<String> data) {
        if (data!=null){
            feedView.bindData(data);
        }else{
            Log.e("Error "," Counld not load data");
        }
    }
}
