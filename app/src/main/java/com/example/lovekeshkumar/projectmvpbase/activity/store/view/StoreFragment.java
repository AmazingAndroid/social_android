package com.example.lovekeshkumar.projectmvpbase.activity.store.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.brand_profile.adapter.ViewPagerAdapter;
import com.example.lovekeshkumar.projectmvpbase.activity.brand_profile.fragment.DummyFragment;
import com.example.lovekeshkumar.projectmvpbase.activity.store.presenter.StorePresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.model.Constant;
import com.example.lovekeshkumar.projectmvpbase.font.RobotoTextView;
import com.example.lovekeshkumar.projectmvpbase.fragment.video_list_demo.view.BlankFragmentOne;


public class StoreFragment extends Fragment implements IStoreView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    LinearLayout layout_group_buy, layout_explore;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    StorePresenterImpl storePresenter;
    RobotoTextView txtEmail, txtMobile;
    private ViewPager viewPager;
    public StoreFragment() {
        // Required empty public constructor
    }


    public static StoreFragment newInstance(String param1, String param2) {
        StoreFragment fragment = new StoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        initialization(view);
        setListener();
        onClickGroupBuy();
      //  storePresenter=new StorePresenterImpl(this,);

        return view;
    }

    void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }





    private void  setupViewPager(ViewPager viewPager,String tag) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

        if(tag.equalsIgnoreCase(Constant.TabTag.GROUPBUY))
        {
            if(adapter!=null)
            {
                adapter.clearallFrag();
                viewPager.setAdapter(null);

            }
            adapter.clearallFrag();
            viewPager.setAdapter(null);
            adapter.addFrag(new BlankFragmentOne( ), "ENDING SOON");
            adapter.addFrag(new BlankFragmentOne(), "NEWEST");
            adapter.addFrag(new BlankFragmentOne(), "UNDER $20");
            adapter.addFrag(new BlankFragmentOne(), "UNDER $50");
            adapter.addFrag(new BlankFragmentOne(), "UNDER $100");
            adapter.addFrag(new BlankFragmentOne(), "UNDER $150");

            viewPager.setAdapter(adapter);
        }else
        {
            if(adapter!=null)
            {
                adapter.clearallFrag();
                viewPager.setAdapter(null);
            }
            adapter.clearallFrag();
            viewPager.setAdapter(null);
            adapter.addFrag(new DummyFragment( ContextCompat.getColor(getActivity(), R.color.profile_theam_color)), "HOME");
            adapter.addFrag(new DummyFragment( ContextCompat.getColor(getActivity(), R.color.profile_theam_color)), "NEWEST");
            adapter.addFrag(new DummyFragment( ContextCompat.getColor(getActivity(), R.color.profile_theam_color)), "$20");
            adapter.addFrag(new DummyFragment( ContextCompat.getColor(getActivity(), R.color.profile_theam_color)), " $50");
            adapter.addFrag(new DummyFragment( ContextCompat.getColor(getActivity(), R.color.profile_theam_color)), " $100");
            adapter.addFrag(new DummyFragment( ContextCompat.getColor(getActivity(), R.color.profile_theam_color)), "$670");


            viewPager.setAdapter(adapter);
        }

    }

    @Override
    public void initialization(View view) {
        layout_group_buy = (LinearLayout) view.findViewById(R.id.layout_group_buy);
        layout_explore = (LinearLayout) view.findViewById(R.id.layout_explore);
         viewPager = (ViewPager) view.findViewById(R.id.tabanim_viewpager);
        setupViewPager(viewPager, Constant.TabTag.GROUPBUY);
        txtEmail = (RobotoTextView) view.findViewById(R.id.txt_login_with_email);
        txtMobile = (RobotoTextView) view.findViewById(R.id.txt_login_with_mobile);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        // tabLayout.setTabTextColors(Color.parseColor("#fff"),Color.parseColor("#fff"));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        showToast("One");
                        break;
                    case 1:
                        showToast("Two");
                        break;
                    case 2:
                        showToast("Three");
                        break;
                    case 3:
                        showToast("Four");
                        break;
                    case 4:
                        showToast("FIVE");
                        break;
                    case 5:
                        showToast("SIX");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void bind() {

    }

    @Override
    public void setListener() {
        layout_group_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGroupBuy();
            }
        });
        layout_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickExplore();
            }
        });
    }

    @Override
    public void onClickGroupBuy() {
        txtMobile.setTextColor(getResources().getColor(R.color.profile_background_color));
        txtEmail.setTextColor(getResources().getColor(R.color.tabseletced_color));
        layout_group_buy.setBackgroundResource(R.drawable.rounded_blue_left_store);
        layout_explore.setBackgroundResource(R.drawable.rounded_white_right_store);
        setupViewPager(viewPager, Constant.TabTag.GROUPBUY);
    }

    @Override
    public void onClickExplore() {
        txtMobile.setTextColor(getResources().getColor(R.color.tabseletced_color));
        txtEmail.setTextColor(getResources().getColor(R.color.profile_background_color));

        layout_explore.setBackgroundResource(R.drawable.rounded_blue_left_store);
        layout_group_buy.setBackgroundResource(R.drawable.rounded_white_right_store);
        setupViewPager(viewPager, Constant.TabTag.EXPLORE);
    }
}
