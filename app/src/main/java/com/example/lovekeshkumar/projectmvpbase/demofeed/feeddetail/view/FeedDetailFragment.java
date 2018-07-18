package com.example.lovekeshkumar.projectmvpbase.demofeed.feeddetail.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.adapter.AdapterComments;
import com.example.lovekeshkumar.projectmvpbase.adapter.AdapterFeed;
import com.example.lovekeshkumar.projectmvpbase.adapter.AdapterStories;
import com.example.lovekeshkumar.projectmvpbase.adapter.ImageAdapter;
import com.example.lovekeshkumar.projectmvpbase.demofeed.feed.presenter.FeedPresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.demofeed.feed.view.IFeedView;
import com.example.lovekeshkumar.projectmvpbase.demofeed.feeddetail.presenter.FeedDetailPresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.model.Comments;
import com.example.lovekeshkumar.projectmvpbase.model.Feed;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.List;

public class FeedDetailFragment extends Fragment implements IFeedDetailView {

    private  View view;
    List<Comments> list;
    private FeedDetailPresenterImpl feedPresenter;
    public static Feed f;
    RecyclerView horizontal_scroll_text,recycler_comments;
    ImageView horizontal_scroll_thumb,image_user;
    VideoView horizontal_scroll_video;
    TextView text_feed,feed_name;
    Utility utility;

    public static FeedDetailFragment newInstance(Feed feed) {
        FeedDetailFragment fragment = new FeedDetailFragment();
        f=feed;
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_feed_detail, container, false);
        init(view);
        return view;
    }

    public void init(View v){
        image_user=(ImageView) view.findViewById(R.id.titleImage);
        horizontal_scroll_video=(VideoView) view.findViewById(R.id.horizontal_scroll_video);
        horizontal_scroll_thumb=(ImageView) view.findViewById(R.id.horizontal_scroll_thumb);
        horizontal_scroll_text=(RecyclerView)view.findViewById(R.id.horizontal_scroll_text);
        recycler_comments=(RecyclerView)view.findViewById(R.id.recycler_comments);

        text_feed=(TextView)view.findViewById(R.id.text_feed);
        feed_name=(TextView)view.findViewById(R.id.title);
        utility= Utility.getInstance(getActivity());
        feed_name.setText(f.getName());
        text_feed.setText(f.getData());
        int i=f.getId();
        switch (i){
            case 2:
                horizontal_scroll_video.setVisibility(View.GONE);
                horizontal_scroll_thumb.setVisibility(View.GONE);
                horizontal_scroll_text.setVisibility(View.VISIBLE);
                GridLayoutManager manager=new GridLayoutManager(getActivity(),2);
                manager.setOrientation(GridLayoutManager.VERTICAL);
                horizontal_scroll_text.setLayoutManager(manager);
                ImageAdapter adapter=new ImageAdapter(getActivity(),f.getUrls());
                horizontal_scroll_text.setAdapter(adapter);
                break;
            case 1:
                horizontal_scroll_video.setVisibility(View.VISIBLE);
                horizontal_scroll_thumb.setVisibility(View.GONE);
                horizontal_scroll_text.setVisibility(View.GONE);
                break;
            case 0:
                horizontal_scroll_video.setVisibility(View.GONE);
                horizontal_scroll_thumb.setVisibility(View.VISIBLE);
                horizontal_scroll_text.setVisibility(View.GONE);
                utility.showImagePicassa(f.getImageUrl(),horizontal_scroll_thumb,null);
                break;
        }
        feedPresenter=new FeedDetailPresenterImpl(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void bindDataOnView(List<Comments> response) {
        list = response;
        AdapterComments adapter=new AdapterComments(getActivity(),list,0);
        recycler_comments.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_comments.setAdapter(adapter);
    }

}
