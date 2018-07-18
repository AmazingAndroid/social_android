package com.example.lovekeshkumar.projectmvpbase.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.font.RobotoTextView;
import com.example.lovekeshkumar.projectmvpbase.model.StoreDataModel;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.ArrayList;

/**
 * Create by: Mukesh Yadav
 * www.androiddevelopersolutions.com
 */
public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    Utility utility;
    private ArrayList<StoreDataModel> mCountryList;
    //Activity activity;
    RecyclerClickListener recyclerClickListener;
    Context context;
    public StoreAdapter(Context context,ArrayList<StoreDataModel> mCountryList) {
        this.mCountryList = mCountryList;
        this.context = context;
        utility = Utility.getInstance(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_store, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.timeinterval.setText(mCountryList.get(position).getTimeinterval());
        holder.hashtag_name.setText(mCountryList.get(position).getHashtagName());
        holder.brand_name.setText(mCountryList.get(position).getBrandName());
        holder.modelname.setText(mCountryList.get(position).getModel());
        holder.hashtag_price.setText(mCountryList.get(position).getMaxprice() + "  " + mCountryList.get(position).getPriceafterDiscount());
        utility.showImagePicassa(mCountryList.get(position).getImage_url(), holder.image_product, null);

    }

    @Override
    public int getItemCount() {
        return mCountryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_product;
        private RobotoTextView timeinterval, hashtag_price, mTvApi;
        private RobotoTextView hashtag_name, brand_name, modelname;

        public ViewHolder(View view) {
            super(view);

            timeinterval = (RobotoTextView) view.findViewById(R.id.timeinterval);
            image_product = (ImageView) view.findViewById(R.id.image_product);
            hashtag_price = (RobotoTextView) view.findViewById(R.id.hashtag_price);
            hashtag_name = (RobotoTextView) view.findViewById(R.id.hashtag_name);
            brand_name = (RobotoTextView) view.findViewById(R.id.cat_name);
            modelname = (RobotoTextView) view.findViewById(R.id.hashtag_type);


        }
    }
}