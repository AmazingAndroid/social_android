package com.example.lovekeshkumar.projectmvpbase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.List;

/**
 * Created by Lovekesh Kumar on 2/27/2018.
 */

@SuppressWarnings("ALL")
public class ShareChatListAdapter extends RecyclerView.Adapter<ShareChatListAdapter.ViewHolder> {
    Utility utility;
    private List<ChatShareDataResponse> listResponses;
    private Context context;

    public ShareChatListAdapter(List<ChatShareDataResponse> listResponses) {
        this.listResponses = listResponses;
        this.context = context;
        utility = Utility.getInstance(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_for_start_chat, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Log.d("TAGE", "Game_name:::" + listResponses.get(i));
        viewHolder.user_name.setText(listResponses.get(i).user_Name);
        String listResponse = listResponses.get(i).image_Url;
        utility.showImagePicassa(listResponse, viewHolder.image_user, null);
        //Glide.with(context).load(listResponses.get(i).image_url).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return listResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView user_name;
        private ImageView image_user;
        private CheckBox choose;

        public ViewHolder(View view) {
            super(view);

            user_name = (TextView) view.findViewById(R.id.user_name);
            image_user = (ImageView) view.findViewById(R.id.image_user);
            choose = (CheckBox) view.findViewById(R.id.checkbox_fav);


        }


    }

}