package com.example.lovekeshkumar.projectmvpbase.activity.profile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.activity.profile.adapter.ViewPagerAdapter;
import com.example.lovekeshkumar.projectmvpbase.adapter.HashtagMainPageAdapter;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerViewHashtag;
    private LinearLayoutManager mLayoutManager;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.tabanim_viewpager);
        setupViewPager(viewPager);
        mRecyclerViewHashtag = (RecyclerView) view.findViewById(R.id.recyle_view3);
        mRecyclerViewHashtag.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayout.HORIZONTAL, false);
        TabLayout tabLayout = (TabLayout)view. findViewById(R.id.tabanim_tabs);
        mRecyclerViewHashtag.setLayoutManager(mLayoutManager);
        tabLayout.setupWithViewPager(viewPager);

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("@mycatismylife");
        stringArrayList.add("@warbyhometryon");
        stringArrayList.add("@warbyhometryon");


        HashtagMainPageAdapter hashtagMainPageAdapter = new HashtagMainPageAdapter(stringArrayList, new RecyclerClickListener() {
            @Override
            public void onRecyclerClick(Intent intent) {

            }
        });
        //  mRecyclerView.setLayoutAnimation(animation);
        // mRecyclerView.getAdapter().notifyDataSetChanged();
        //  mRecyclerView.scheduleLayoutAnimation();
        //Landing
        //ZoomIn
        //Wave
        //RollIn
        //RotateInUpLeft
        YoYo.with(Techniques.Landing)
                .duration(1500)

                .playOn(mRecyclerViewHashtag);
        mRecyclerViewHashtag.setAdapter(hashtagMainPageAdapter);

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
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
    void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new DummyFragment(
                ContextCompat.getColor(getActivity(), R.color.profile_theam_color)), "HOME");
        adapter.addFrag(new DummyFragment(
                ContextCompat.getColor(getActivity(), R.color.profile_theam_color)), "SHOP");

        adapter.addFrag(new DummyFragment(
                ContextCompat.getColor(getActivity(), R.color.profile_theam_color)), "REVIEWS");

         adapter.addFrag(new DummyFragment(
                ContextCompat.getColor(getActivity(), R.color.profile_theam_color)), "DETAILS");


        viewPager.setAdapter(adapter);
    }

}
