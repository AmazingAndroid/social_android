package com.example.lovekeshkumar.projectmvpbase.custom.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.custom.CustomViewHolder;
import com.example.lovekeshkumar.projectmvpbase.custom.VideosAdapter;
import com.example.lovekeshkumar.projectmvpbase.model.VideoModel;
import com.squareup.picasso.Picasso;

import java.util.List;



/**
 * Created by robert on 17/08/03.
 */
public class AutoPlayVideoAdapter extends VideosAdapter {
    private String TAG = "AutoPlayVideoAdapter";

    private final List<VideoModel> list;
    private final Picasso picasso;

    public class MyViewHolder extends CustomViewHolder {
        final TextView tv, userName;
        final ImageView img_vol, img_playback;
        final AppCompatImageView userIcon;
        //to mute/un-mute video (optional)
        boolean isMuted;
        public MyViewHolder(View x) {
            super(x);
            tv = (TextView)x.findViewById(R.id.tv);
            userName = (TextView)x.findViewById(R.id.fb_user_name);
            img_vol = (ImageView)x.findViewById(R.id.img_vol);
            img_playback = (ImageView)x.findViewById(R.id.img_playback);
            userIcon = (AppCompatImageView)x.findViewById(R.id.fb_user_icon);



        }

        //override this method to get callback when video starts to play
        @Override
        public void videoStarted() {
            super.videoStarted();
            img_playback.setImageResource(R.drawable.ic_action_accounts);
            if (isMuted) {
                muteVideo();
                img_vol.setImageResource(R.drawable.ic_action_accounts);
            } else {
                unmuteVideo();
                img_vol.setImageResource(R.drawable.ic_action_accounts);
            }
        }
        @Override
        public void pauseVideo() {
            super.pauseVideo();
            img_playback.setImageResource(R.drawable.ic_action_accounts);
        }
    }
    public AutoPlayVideoAdapter(List<VideoModel> list_urls, Picasso p) {
        this.list = list_urls;
        this.picasso = p;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        ((MyViewHolder) holder).userName.setText(list.get(position).getTitle_video());
        ((MyViewHolder) holder).tv.setText(String.format("%s・%s", (position + 5) + " minutes from now",list.get(position).getTitle_video().toUpperCase()));
        picasso.load(R.mipmap.ic_launcher).config(Bitmap.Config.RGB_565).into(((MyViewHolder) holder).userIcon);
        //todo
        holder.setImageUrl(list.get(position).getImageurl());
        holder.setVideoUrl(list.get(position).getVideourl());

        //load image into imageview
        if (list.get(position).getImageurl() != null && !list.get(position).getImageurl().isEmpty()) {
            picasso.load(holder.getImageUrl()).config(Bitmap.Config.RGB_565).into(holder.getImageView());

            Log.e(TAG, "--->ImageUrl=" + holder.getImageUrl());
        }

        holder.setLooping(true); //optional - true by default

        //to play pause videos manually (optional)
        ((MyViewHolder) holder).img_playback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.isPlaying()) {
                    holder.pauseVideo();
                    holder.setPaused(true);
                } else {
                    holder.playVideo();
                    holder.setPaused(false);
                }
            }
        });

        //to mute/un-mute video (optional)
        ((MyViewHolder) holder).img_vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MyViewHolder) holder).isMuted) {
                    holder.unmuteVideo();
                    ((MyViewHolder) holder).img_vol.setImageResource(R.drawable.ic_action_accounts);
                } else {
                    holder.muteVideo();
                    ((MyViewHolder) holder).img_vol.setImageResource(R.drawable.ic_action_accounts);
                }
                ((MyViewHolder) holder).isMuted = !((MyViewHolder) holder).isMuted;
            }
        });

        if (list.get(position).getVideourl() == null) {
            ((MyViewHolder) holder).img_vol.setVisibility(View.GONE);
            ((MyViewHolder) holder).img_playback.setVisibility(View.GONE);
        } else {
            ((MyViewHolder) holder).img_vol.setVisibility(View.VISIBLE);
            ((MyViewHolder) holder).img_playback.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public int getItemViewType(int position) {
        return 0;
    }


}
