package com.example.lovekeshkumar.projectmvpbase.adapter;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.detail.view.DetailActivity;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.model.Result;
import com.example.lovekeshkumar.projectmvpbase.model.Topic;

import java.util.ArrayList;

/**
 * Create by: Mukesh Yadav
 * www.androiddevelopersolutions.com
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Topic> mCountryList;
    //Activity activity;
    RecyclerClickListener recyclerClickListener;
    public DataAdapter(ArrayList<Topic> mCountryList, RecyclerClickListener recyclerClickListener) {
        this.mCountryList = mCountryList;
        this.recyclerClickListener = recyclerClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTvName.setText(mCountryList.get(position).getTopicTitle());
        holder.mTvVersion.setText(mCountryList.get(position).getTopicDescription());
        holder.mTvApi.setText(mCountryList.get(position).getTopicType());
    }

    @Override
    public int getItemCount() {
        return mCountryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTvName,mTvVersion,mTvApi;
        public ViewHolder(View view) {
            super(view);

            mTvName = (TextView)view.findViewById(R.id.tv_name);
            mTvVersion = (TextView)view.findViewById(R.id.tv_version);
            mTvApi = (TextView)view.findViewById(R.id.tv_api_level);
            mTvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name=mCountryList.get(getPosition()).getTopicTitle();
                    String version=mCountryList.get(getPosition()).getTopicDescription();
                    String api=mCountryList.get(getPosition()).getTopicType();
                    Intent intent=new Intent();
                    intent.putExtra("name",name);
                    intent.putExtra("version",version);
                    intent.putExtra("api",api);
                    recyclerClickListener.onRecyclerClick(intent);
                }
            });
        }
    }
}