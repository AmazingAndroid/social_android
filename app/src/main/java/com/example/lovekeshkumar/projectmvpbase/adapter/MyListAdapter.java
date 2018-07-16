package com.example.lovekeshkumar.projectmvpbase.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;

import java.util.ArrayList;
import java.util.List;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    Context context;
    ArrayList productThumb;
    int row_index = -1;
    final int sdk = android.os.Build.VERSION.SDK_INT;
    //BaseFragment.FragmentNavigation mFragmentNavigation;

    public  List<String> products;
    public String title;

    public static RecyclerView horizontalList;
   // private boolean firstCheck = true;
    private String imageValue = null;

    public MyListAdapter(Context context, List<String> hashTagProducts) {
        this.context = context;
        this.context = context;
        this.products = hashTagProducts;
     }

    public MyListAdapter(Context context, ArrayList productThumb,
                         List<String> hashTagProducts, String title) {
        this.context = context;
        this.productThumb = productThumb;
        this.context = context;
        this.products = hashTagProducts;
        //this.mFragmentNavigation = mFragmentNavigation;
        this.title=title;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        if (products != null)
            return products.size();
        else return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        TextView tvHeading, tvDesc, tvPrice, tvTotal, txt_share_count, txt_price;
        ImageView txt_like,txt_comment,txt_share;
        CheckBox checkbox_fav;
        LinearLayout layout_product_list_item;

        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.image);
            tvHeading=itemView.findViewById(R.id.tvHeading);
            tvDesc=itemView.findViewById(R.id.tvDesc);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvTotal=itemView.findViewById(R.id.tvTotal);
            checkbox_fav = (CheckBox) itemView.findViewById(R.id.checkbox_fav);

        }
    }

}

