package com.example.lovekeshkumar.projectmvpbase.activity.welcome.view;



import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;

import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.activity.welcome.fragment.VideoRecyclerViewFragment;

import com.example.lovekeshkumar.projectmvpbase.basemodel.BaseActivity;
import com.example.lovekeshkumar.projectmvpbase.constant.Constant;


import com.example.lovekeshkumar.projectmvpbase.demofeed.feed.view.FeedFragment;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.view.BlankFragmentThree;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.view.BlankFragmentTwo;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.view.FragmentOne;
import com.example.lovekeshkumar.projectmvpbase.utility.FragmentHistory;

import com.example.lovekeshkumar.projectmvpbase.utility.Utility;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressWarnings("ALL")
public class WelcomeActivity extends BaseActivity implements  RecyclerClickListener {
    public Utility utility;
    RecyclerView recyclerView;
    ProgressBar progress;

    private SlidingUpPanelLayout mLayout;
    TextView swipe_up;
    ImageView img_up;
    //FrameLayout mainContainer;
    @BindView(R.id.bottom_tab)
    TabLayout bottomTabLayout;

    FrameLayout layout_main;

    private int[] mTabIconsNonSelected = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.mipmap.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher};
    FragmentHistory fragmentHistory;
    private  String[] tabLabels=new String[]{"Products","Related Products","Hastags","Related Hashtags","Others"};
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initializeViews();
        bindData();
    }

    @Override
    public void initializeViews() {

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        swipe_up = (TextView) findViewById(R.id.swipe);
        img_up = (ImageView)findViewById(R.id.img_up);
        bottomTabLayout = (TabLayout) findViewById(R.id.bottom_tab);
        try{
            initTab();
            loadData();
            setListeners();
            ButterKnife.bind(this);
        }catch(Exception e){
            e.printStackTrace();
        }


        //recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
      //  progress = (ProgressBar) findViewById(R.id.progress);
      //  showProgress();
      //  utility = Utility.getInstance(getApplicationContext());
    }

    @Override
    public void bindData() {
        replaceFragment(VideoRecyclerViewFragment.newInstance(1), R.id.main_container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);

       // iGamePresenter = new GamePresenterImpl(this, new GameInteractorImpl(), utility);
    }

    @Override
    public void setListeners() {
        layout_main=(FrameLayout)findViewById(R.id.main_container);
        mLayout.setAnchorPoint(0.7f);
        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                if (newState.equals(SlidingUpPanelLayout.PanelState.COLLAPSED)) {
                    swipe_up.setVisibility(View.VISIBLE);
                    img_up.setVisibility(View.VISIBLE);
                } else if (newState.equals(SlidingUpPanelLayout.PanelState.EXPANDED)) {
                    swipe_up.setVisibility(View.GONE);
                    img_up.setVisibility(View.GONE);
                } else if (newState.equals(SlidingUpPanelLayout.PanelState.DRAGGING)) {
                    swipe_up.setVisibility(View.GONE);
                    img_up.setVisibility(View.GONE);
                }
            }
        });
        mLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });
        layout_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlidingUpPanelLayout.PanelState state = mLayout.getPanelState();
                if (state.equals(SlidingUpPanelLayout.PanelState.EXPANDED)) {
                    mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                }
            }
        });
        bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                switchTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                switchTab(tab.getPosition());
            }
        });
    }




    @Override
    public void onRecyclerClick(Intent intent) {

    }
    @Override
    public void onSaveInstanceState(Bundle stateBundle) {
        int osVersion = android.os.Build.VERSION.SDK_INT;
        if (osVersion < Build.VERSION_CODES.N) {
            super.onSaveInstanceState(stateBundle);
        }
    }


    private void switchTab(int position) {
        switch (position){
            case 0:
                replaceFragment(VideoRecyclerViewFragment.newInstance(1), R.id.main_container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);
                break;
            case 1:
                replaceFragment(FeedFragment.newInstance(), R.id.main_container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);
                break;
            case 2:
                replaceFragment(BlankFragmentTwo.newInstance("","1"), R.id.main_container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);
                break;
            case 3:
                replaceFragment(BlankFragmentThree.newInstance("",""), R.id.main_container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);
                break;
            case 4:
                replaceFragment(VideoRecyclerViewFragment.newInstance(1), R.id.main_container, Constant.FragmentTag.LOGIN_FRAGMENT_TAG);
                break;
        }
    }

    private void initTab() {
        try {
            if (bottomTabLayout != null) {
                for (int i = 0; i < mTabIconsNonSelected.length; i++) {
                    bottomTabLayout.addTab(bottomTabLayout.newTab());
                    TabLayout.Tab tab = bottomTabLayout.getTabAt(i);
                    if (tab != null)
                        tab.setCustomView(getTabView(i, 0));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private View getTabView(int position,int check) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item_bottom, null);
        ImageView icon = (ImageView) view.findViewById(R.id.tab_icon);
        icon.setImageResource(mTabIconsNonSelected[position]);
        return view;
    }

    void loadData(){
        viewPager = (ViewPager)findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), tabLabels[0]);
        adapter.addFragment(new FragmentOne(), tabLabels[1]);
        adapter.addFragment(new FragmentOne(), tabLabels[2]);
        adapter.addFragment(new FragmentOne(), tabLabels[3]);
        adapter.addFragment(new FragmentOne(), tabLabels[4]);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0092ff"));
        tabLayout.setSelectedTabIndicatorHeight((int) (2 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#CCFFFFFF"), Color.parseColor("#0092ff"));
        TabLayout.Tab tab=tabLayout.getTabAt(0);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
