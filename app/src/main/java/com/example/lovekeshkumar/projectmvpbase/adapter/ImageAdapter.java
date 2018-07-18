package com.example.lovekeshkumar.projectmvpbase.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{
    Context context;
    List<String> urls;
    Utility utility;
    public ImageAdapter(Context context, List<String> data){
        this.context = context;
        this.urls=data;
        this.utility=Utility.getInstance(context);
    }
    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, final int position) {
        utility.showImagePicassa(urls.get(position),holder.imgThumb,null);
        holder.imgThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(urls!=null){
            return urls.size();
        }
        else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
       ImageView imgThumb;
        public ViewHolder(View itemView) {
            super(itemView);
            imgThumb = (ImageView)itemView.findViewById(R.id.image_product_thumb);
        }
    }
}

