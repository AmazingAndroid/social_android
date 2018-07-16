package com.example.lovekeshkumar.projectmvpbase.constant;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Lovekesh Kumar on 2/27/2018.
 */

public class Constant {
    public static final int VIDEO_LIST_TASK_ID = 100;
    public static final int GAME_LIST_TASK_ID = 101;
    public static final boolean IS_DOGFOOD_BUILD =false ;

    public class FragmentTag {
        public static final String LOGIN_FRAGMENT_TAG ="login_fragment_tag" ;
        public static final String CHATSHARE_FRAGMENT_TAG ="chat_share_fragment_tag" ;
    }

    public class ModelConstants {
        public static final String WAHHAO_ARG_DEMO ="wahhao_arg_demo" ;
    }

    public static class SetRecyclerViewOrientation {

        public static RecyclerView setLinnerView(RecyclerView recyle_view, Context mContext) {
            recyle_view.setLayoutManager(new LinearLayoutManager(mContext));
            recyle_view.setItemViewCacheSize(1000);
            recyle_view.setDrawingCacheEnabled(true);
            recyle_view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
            return recyle_view;
        }

        public static RecyclerView setGridView(RecyclerView recyle_view, Context mContext,int span) {
            recyle_view.setLayoutManager(new GridLayoutManager(mContext, span));
            recyle_view.setDrawingCacheEnabled(true);
            recyle_view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
            return recyle_view;
        }
    }
}
