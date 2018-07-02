package com.example.lovekeshkumar.projectmvpbase.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.model.GameModel;
import com.example.lovekeshkumar.projectmvpbase.model.VideoModel;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.List;

/**
 * Created by Lovekesh Kumar on 2/27/2018.
 */

public class VideoListAdapterAdapter extends RecyclerView.Adapter<VideoListAdapterAdapter.ViewHolder> {
    Utility utility;
    private List<VideoModel> gameModels;
    private Context context;
    RecyclerClickListener recyclerClickListener;

    public VideoListAdapterAdapter(List<VideoModel> gameModels, RecyclerClickListener recyclerClickListener) {
        this.gameModels = gameModels;
        this.recyclerClickListener = recyclerClickListener;
        this.context = context;
        utility = Utility.getInstance(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Log.d("TAGE", "Game_name:::" + gameModels.get(i).getVideourl());
        //viewHolder.tv_android.setText(gameModels.get(i).game);

        VideoModel videoModel=gameModels.get(i);

        Uri path = Uri.parse(videoModel.getVideourl());
        viewHolder.user_video.setVideoURI(path);
        viewHolder. user_video.start();
       // utility.showImagePicassa(videoModel.image_url, viewHolder.img_android, viewHolder.progressBar);
        //Glide.with(context).load(gameModels.get(i).image_url).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return gameModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //  private TextView tv_android;
        private VideoView user_video;
        private ProgressBar progressBar;
        private Button play_game;
        private RelativeLayout rlViewComp;

        public ViewHolder(View view) {
            super(view);

            // tv_android = (TextView) view.findViewById(R.id.tv_android);
            rlViewComp = (RelativeLayout) view.findViewById(R.id.rlViewComp);
            user_video = (VideoView) view.findViewById(R.id.user_video);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);
            //    play_game = (Button) view.findViewById(R.id.games_play);



        }


    }


   /* private void pauseVideo() {
        if (videoView.isPlaying()) {
            videoView.pause();
        }
    }*/

    /**
     * Resume the VideoView content.
     */
    /*private void startVideo() {
        if (!videoView.isPlaying()) {
            videoView.start();
        }
    }*/

}