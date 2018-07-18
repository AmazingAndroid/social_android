package com.example.lovekeshkumar.projectmvpbase.demofeed.feeddetail.presenter;

import android.util.Log;

import com.example.lovekeshkumar.projectmvpbase.demofeed.feed.presenter.IFeedPresenter;
import com.example.lovekeshkumar.projectmvpbase.demofeed.feed.view.IFeedView;
import com.example.lovekeshkumar.projectmvpbase.demofeed.feeddetail.view.IFeedDetailView;
import com.example.lovekeshkumar.projectmvpbase.model.Comments;
import com.example.lovekeshkumar.projectmvpbase.model.CommonMethod;
import com.example.lovekeshkumar.projectmvpbase.model.Feed;

import java.util.List;

/**
 * Created by Lovekesh Kumar on 2/26/2018.
 */

public class FeedDetailPresenterImpl implements IFeedDetailPresenter {

    private IFeedDetailView feedView;

    public FeedDetailPresenterImpl(IFeedDetailView feedView) {
        this.feedView = feedView;
        populate(CommonMethod.getCommentList());
    }

    @Override
    public void populate(List<Comments> data) {
        if (data!=null){
            feedView.bindDataOnView(data);
        }else{
            Log.e("Error "," Counld not load data");
        }
    }
}
