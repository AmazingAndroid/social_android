package com.example.lovekeshkumar.projectmvpbase.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.ArrayList;

/**
 * Create by: Mukesh Yadav
 * www.androiddevelopersolutions.com
 */
public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder> {

    private ArrayList<ChatShareDataResponse> mCountryList;
    //Activity activity;
    Utility utility;
    RecyclerClickListener recyclerClickListener;
    public CollectionAdapter(Context context, ArrayList<ChatShareDataResponse> mCountryList) {
        this.mCountryList = mCountryList;
        this.recyclerClickListener = recyclerClickListener;
        utility = Utility.getInstance(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_collection, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        utility.showImagePicassa(mCountryList.get(position).getImage_Url(), holder.image_post, null);
        //holder.mTvName.setText(mCountryList.get(position).getTopicTitle());
       // holder.mTvVersion.setText(mCountryList.get(position).getTopicDescription());
      //  holder.mTvApi.setText(mCountryList.get(position).getTopicType());
    }

    @Override
    public int getItemCount() {
        return mCountryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

     //   private TextView mTvName,mTvVersion,mTvApi;
        ImageView image_post;
        public ViewHolder(View view) {
            super(view);

           // mTvName = (TextView)view.findViewById(R.id.tv_name);
            image_post = (ImageView)view.findViewById(R.id.image_post);
          //  mTvVersion = (TextView)view.findViewById(R.id.tv_version);
         //   mTvApi = (TextView)view.findViewById(R.id.tv_api_level);

        }
    }
}