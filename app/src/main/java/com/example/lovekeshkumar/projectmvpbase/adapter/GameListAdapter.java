package com.example.lovekeshkumar.projectmvpbase.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.gaming.view.GameActivity;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.model.GameModel;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.List;

/**
 * Created by Lovekesh Kumar on 2/27/2018.
 */

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.ViewHolder> {
    Utility utility;
    private List<GameModel> gameModels;
    private Context context;
    RecyclerClickListener recyclerClickListener;

    public GameListAdapter(List<GameModel> gameModels,RecyclerClickListener recyclerClickListener) {
        this.gameModels = gameModels;
        this.recyclerClickListener = recyclerClickListener;

        this.context = context;
        utility = Utility.getInstance(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Log.d("TAGE", "Game_name:::" + gameModels.get(i).game);
        //viewHolder.tv_android.setText(gameModels.get(i).game);

        GameModel gameModel=gameModels.get(i);
        utility.showImagePicassa(gameModel.image_url, viewHolder.img_android, viewHolder.progressBar);
        //Glide.with(context).load(gameModels.get(i).image_url).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return gameModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //  private TextView tv_android;
        private ImageView img_android;
        private ProgressBar progressBar;
        private Button play_game;
        private RelativeLayout rlViewComp;

        public ViewHolder(View view) {
            super(view);

            // tv_android = (TextView) view.findViewById(R.id.tv_android);
            rlViewComp = (RelativeLayout) view.findViewById(R.id.rlViewComp);
            img_android = (ImageView) view.findViewById(R.id.img_android);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);
            //    play_game = (Button) view.findViewById(R.id.games_play);
            rlViewComp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.putExtra("name",gameModels.get(getPosition()).id);
                    intent.putExtra("api",gameModels.get(getPosition()).image_url);
                    intent.putExtra("version",gameModels.get(getPosition()).screen_type);

                    recyclerClickListener.onRecyclerClick(intent);
                }
//                    else
//                    {
//                        Toast.makeText(context, "This game is not avialable right now", Toast.LENGTH_SHORT).show();
//                    }
//                }
            });


        }


    }

}