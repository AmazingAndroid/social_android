package com.example.lovekeshkumar.projectmvpbase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.model.CommonMethod;
import com.example.lovekeshkumar.projectmvpbase.roundedimageview.RoundedImageView;

import java.util.List;

public class AdapterStories extends RecyclerView.Adapter<AdapterStories.ViewHolder> {

    private List<String> mCountryList;
    private Context context;
    public AdapterStories(Context context, List<String> mCountryList) {
        this.mCountryList = mCountryList;
        this.context=context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.img.setCornerRadius(30);
    }

    @Override
    public int getItemCount() {
        return mCountryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView img;

        public ViewHolder(View view) {
            super(view);
            img=(RoundedImageView) view.findViewById(R.id.image_user);
        }
    }
}
