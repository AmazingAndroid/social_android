package com.example.lovekeshkumar.projectmvpbase.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lovekeshkumar.projectmvpbase.activity.welcome.fragment.VideoRecyclerViewFragment;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.view.BlankFragmentFour;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.view.BlankFragmentOne;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.view.BlankFragmentThree;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.view.BlankFragmentTwo;

public final class PageAdapter extends FragmentStatePagerAdapter {

    public PageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        final Bundle bundle = new Bundle();
        //  bundle.putInt(VideoRecyclerViewFragment.EXTRA_POSITION, position + 1);
        Fragment fragment = null;
        //  final VideoRecyclerViewFragment fragment = new VideoRecyclerViewFragment();
        // fragment.setArguments(bundle);
        switch (position) {

            case 0: {

                fragment = new BlankFragmentOne().newInstance(String.valueOf(position), String.valueOf(position + 1));
                //fragmentOne.setArguments(bundle);
                break;


            }
            case 1: {
                // fragment = new BlankFragmentOne().newInstance(String.valueOf(position), String.valueOf(position+ 1));
                fragment = new VideoRecyclerViewFragment().newInstance(position + 1);

                break;


            }
            case 2: {
                fragment = new BlankFragmentTwo().newInstance(String.valueOf(position), String.valueOf(position + 1));
                break;


            }
            case 3: {
                fragment = new BlankFragmentThree().newInstance(String.valueOf(position), String.valueOf(position + 1));
                break;

            }
            case 4: {
                fragment = new BlankFragmentFour().newInstance(String.valueOf(position), String.valueOf(position + 1));
                break;

            }

        }


        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

}
