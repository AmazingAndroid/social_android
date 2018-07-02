package com.example.lovekeshkumar.projectmvpbase.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.font.RobotoTextView;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.List;

/**
 * Created by Lovekesh Kumar on 2/27/2018.
 */

public class HashtagMainPageAdapter extends RecyclerView.Adapter<HashtagMainPageAdapter.ViewHolder> {
    Utility utility;
    private List<String> hashtag_names;
    private Context context;
    RecyclerClickListener recyclerClickListener;

    public HashtagMainPageAdapter(List<String> hashtag_names, RecyclerClickListener recyclerClickListener) {
        this.hashtag_names = hashtag_names;
        this.recyclerClickListener = recyclerClickListener;

        this.context = context;
        utility = Utility.getInstance(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_hashtag_row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {


        //viewHolder.tv_android.setText(hashtag_names.get(i).game);

        String hashtag_name=hashtag_names.get(i);
        viewHolder.text_hashtag.setText(hashtag_name);
      //  utility.showImagePicassa(hashtag_name.image_url, viewHolder.img_android, viewHolder.progressBar);
        //Glide.with(context).load(hashtag_names.get(i).image_url).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return hashtag_names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
          private RobotoTextView text_hashtag;
        private ImageView img_android;
        private ProgressBar progressBar;
        private Button play_game;
        private RelativeLayout rlViewComp;

        public ViewHolder(View view) {
            super(view);

            text_hashtag = (RobotoTextView) view.findViewById(R.id.text_hashtag);
            rlViewComp = (RelativeLayout) view.findViewById(R.id.rlViewComp);
          //  img_android = (ImageView) view.findViewById(R.id.img_android);
          //  progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);
            //    play_game = (Button) view.findViewById(R.id.games_play);
//            rlViewComp.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent();
//                    intent.putExtra("name",hashtag_names.get(getPosition()).id);
//                    intent.putExtra("api",hashtag_names.get(getPosition()).image_url);
//                    intent.putExtra("version",hashtag_names.get(getPosition()).screen_type);
//
//                    recyclerClickListener.onRecyclerClick(intent);
//                }
////                    else
////                    {
////                        Toast.makeText(context, "This game is not avialable right now", Toast.LENGTH_SHORT).show();
////                    }
////                }
//            });


        }


    }

}