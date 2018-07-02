package com.example.lovekeshkumar.projectmvpbase.activity.main.view;


import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.FlipVerticalTransformer;
import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.ScaleInOutTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.TabletTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutSlideTransformer;
import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.activity.main.presenter.MainPresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.adapter.PageAdapter;
import com.example.lovekeshkumar.projectmvpbase.model.TransformerItem;
import com.example.lovekeshkumar.projectmvpbase.utility.DrawerTransformer;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;
import com.example.lovekeshkumar.projectmvpbase.utility.ZoomOutTransformer;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements IMainView, RecyclerClickListener, ActionBar.OnNavigationListener {

    private static final String KEY_SELECTED_PAGE = "KEY_SELECTED_PAGE";
    private static final String KEY_SELECTED_CLASS = "KEY_SELECTED_CLASS";
    private static final ArrayList<TransformerItem> TRANSFORM_CLASSES;
    private int mSelectedItem;
    private ViewPager mPager;
    MainPresenterImpl homePresenter;
    public Utility utility;
    int selectedPage = 1;
    private PageAdapter mAdapter;

    static {
        TRANSFORM_CLASSES = new ArrayList<>();
        TRANSFORM_CLASSES.add(new TransformerItem(DefaultTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(AccordionTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(BackgroundToForegroundTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(CubeInTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(CubeOutTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(DepthPageTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(FlipHorizontalTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(FlipVerticalTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(ForegroundToBackgroundTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(RotateDownTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(RotateUpTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(ScaleInOutTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(StackTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(TabletTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(ZoomInTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(ZoomOutSlideTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(ZoomOutTransformer.class));
        TRANSFORM_CLASSES.add(new TransformerItem(DrawerTransformer.class));
    }

    private MainPresenterImpl value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_transform);


        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(KEY_SELECTED_CLASS);
            selectedPage = savedInstanceState.getInt(KEY_SELECTED_PAGE);
        }


        /// utility = Utility.getInstance(getApplicationContext());
        // homePresenter = new MainPresenterImpl(this, new MainInteractorImpl(), utility);
        bindDataOnView();
    }


    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void bindDataOnView(// TODO: 6/26/2018 pass any array to respond or set your own adapter
    ) {

        final ArrayAdapter<TransformerItem> actionBarAdapter = new ArrayAdapter<TransformerItem>(
                getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, TRANSFORM_CLASSES);


        mAdapter = new PageAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.container);
        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(selectedPage);
        //  BackgroundToForegroundTransformer
        //    CubeInTransformer



        mPager.setPageTransformer(true, new ZoomOutTransformer());

      /*  mPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                int pageWidth = page.getWidth();
                int pageHeight = page.getHeight();
                page.setPivotX(position < 0f ? pageWidth : 0f);
                page.setPivotY(pageHeight * 0.5f);
                page.setRotationY(90f * position);





//                if (position < -1) { // [-Infinity,-1)
//                    // This page is way off-screen to the left.
//                    page.setAlpha(0);
//                } else if(position <= 1){ // Page to the left, page centered, page to the right
//                    // modify page view animations here for pages in view
//                } else { // (1,+Infinity]
//                    // This page is way off-screen to the right.
//                    page.setAlpha(0);
//                }
            }
        });
*/

        final ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setListNavigationCallbacks(actionBarAdapter, this);
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

            //noinspection ResourceType
            actionBar.setDisplayOptions(actionBar.getDisplayOptions() ^ ActionBar.DISPLAY_SHOW_TITLE);

            actionBar.setSelectedNavigationItem(mSelectedItem);
        }
    }

    @Override
    public void showErrorMessage(Throwable error) {
        Toast.makeText(this, "Error " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToDetail() {

    }


    @Override
    public boolean onNavigationItemSelected(int position, long itemId) {
        mSelectedItem = position;
        try {
            mPager.setPageTransformer(true, TRANSFORM_CLASSES.get(position).clazz.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public void onRecyclerClick(Intent intent) {

    }


}
