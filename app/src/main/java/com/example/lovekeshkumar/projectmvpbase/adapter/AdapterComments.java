package com.example.lovekeshkumar.projectmvpbase.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.model.Comments;
import com.example.lovekeshkumar.projectmvpbase.roundedimageview.RoundedImageView;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.List;

public class AdapterComments extends RecyclerView.Adapter<AdapterComments.ViewHolder> {

    private List<Comments> mList;
    private Context context;
    Utility utility;
    int type;
    public AdapterComments(Context context, List<Comments> mCountryList,int type) {
        this.mList = mCountryList;
        this.context=context;
        this.type=type;
        utility=Utility.getInstance(context);
    }


    @Override
    public AdapterComments.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new AdapterComments.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterComments.ViewHolder holder, int position) {
        if(type==1){
            holder.txt_more_replies.setVisibility(View.GONE);
            holder.img1.getLayoutParams().height=50;
            holder.img1.getLayoutParams().width=50;
            holder.img1.setCornerRadius(7f);
        }else{
            holder.txt_more_replies.setVisibility(View.VISIBLE);
        }
        holder.addReplyLayout.setVisibility(View.GONE);
        holder.comment_title.setText(mList.get(position).getName());
        holder.comment_time.setText(mList.get(position).getTime());
        holder.like_count.setText(mList.get(position).getLikeCount());
        holder.comment_des.setText(mList.get(position).getComment());
        utility.showImagePicassa(mList.get(position).getImageUrl(),holder.img1,null);
        if(mList.get(position).getReplies()!=null){
            AdapterComments adap=new AdapterComments(context,mList.get(position).getReplies(),1);
            holder.recycler_replies.setLayoutManager(new LinearLayoutManager(context));
            holder.recycler_replies.setAdapter(adap);
        }

        holder.reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.addReplyLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView img1,img2;
        TextView comment_title,comment_time,like_count,comment_des,reply,txt_more_replies;
        RecyclerView recycler_replies;
        LinearLayout addReplyLayout;
        public ViewHolder(View view) {
            super(view);
            addReplyLayout=(LinearLayout)view.findViewById(R.id.addReplyLayout);
            img1=(RoundedImageView) view.findViewById(R.id.image_user);
            txt_more_replies=(TextView)view.findViewById(R.id.txt_more_replies);
            reply=(TextView)view.findViewById(R.id.reply);
            comment_des=(TextView)view.findViewById(R.id.comment_des);
            comment_title=(TextView)view.findViewById(R.id.comment_title);
            comment_time=(TextView)view.findViewById(R.id.comment_time);
            like_count=(TextView)view.findViewById(R.id.like_count);
            recycler_replies=(RecyclerView)view.findViewById(R.id.recycler_replies);
        }
    }
}

