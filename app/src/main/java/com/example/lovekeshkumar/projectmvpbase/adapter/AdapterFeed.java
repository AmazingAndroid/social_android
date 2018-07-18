package com.example.lovekeshkumar.projectmvpbase.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
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
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.activity.welcome.fragment.VideoRecyclerViewFragment;
import com.example.lovekeshkumar.projectmvpbase.basemodel.BaseActivity;
import com.example.lovekeshkumar.projectmvpbase.constant.Constant;
import com.example.lovekeshkumar.projectmvpbase.demofeed.feeddetail.view.FeedDetailFragment;
import com.example.lovekeshkumar.projectmvpbase.model.Feed;
import com.example.lovekeshkumar.projectmvpbase.model.Topic;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class AdapterFeed extends RecyclerView.Adapter<AdapterFeed.ViewHolder> {

    private List<Feed> mList;
    Context context;
    Utility utility;
    public AdapterFeed(Context context, List<Feed> mCountryList) {
        this.context=context;
        this.mList = mCountryList;
        this.utility=Utility.getInstance(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        return new AdapterFeed.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.feed_name.setText(mList.get(position).getName());
        holder.text_feed.setText(mList.get(position).getData());
        int i=mList.get(position).getId();
        switch (i){
            case 2:
            holder.horizontal_scroll_video.setVisibility(View.GONE);
            holder.horizontal_scroll_thumb.setVisibility(View.GONE);
            holder.horizontal_scroll_text.setVisibility(View.VISIBLE);
            GridLayoutManager manager=new GridLayoutManager(context,2);
            manager.setOrientation(GridLayoutManager.VERTICAL);
            holder.horizontal_scroll_text.setLayoutManager(manager);
            ImageAdapter adapter=new ImageAdapter(context,mList.get(position).getUrls());
            holder.horizontal_scroll_text.setAdapter(adapter);
            break;
            case 1:
                holder.horizontal_scroll_video.setVisibility(View.VISIBLE);
                holder.horizontal_scroll_thumb.setVisibility(View.GONE);
                holder.horizontal_scroll_text.setVisibility(View.GONE);
                break;
            case 0:
                holder.horizontal_scroll_video.setVisibility(View.GONE);
                holder.horizontal_scroll_thumb.setVisibility(View.VISIBLE);
                holder.horizontal_scroll_text.setVisibility(View.GONE);
                utility.showImagePicassa(mList.get(position).getImageUrl(),holder.horizontal_scroll_thumb,null);
                break;
        }

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity)context).replaceFragment(FeedDetailFragment.newInstance(mList.get(position)), R.id.main_container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        RecyclerView horizontal_scroll_text;
        ImageView horizontal_scroll_thumb,image_user;
        VideoView horizontal_scroll_video;
        TextView text_feed,feed_name;
        RelativeLayout follow_feed;
        CardView card_view;
        public ViewHolder(View view) {
            super(view);
            card_view=(CardView)view.findViewById(R.id.card_view);
            follow_feed=(RelativeLayout)view.findViewById(R.id.follow_feed);
            image_user=(ImageView) view.findViewById(R.id.image_user);
            horizontal_scroll_video=(VideoView) view.findViewById(R.id.horizontal_scroll_video);
            horizontal_scroll_thumb=(ImageView) view.findViewById(R.id.horizontal_scroll_thumb);
            horizontal_scroll_text=(RecyclerView)view.findViewById(R.id.horizontal_scroll_text);
            text_feed=(TextView)view.findViewById(R.id.text_feed);
            feed_name=(TextView)view.findViewById(R.id.feed_name);
        }
    }
}
