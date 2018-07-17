package com.example.lovekeshkumar.projectmvpbase.fragment.video_list_demo.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.adapter.StoreAdapter;
import com.example.lovekeshkumar.projectmvpbase.model.Constant;
import com.example.lovekeshkumar.projectmvpbase.model.CommonMethod;
import com.example.lovekeshkumar.projectmvpbase.model.StoreDataModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragmentOne.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentOne extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<StoreDataModel> mCountryList;


    public BlankFragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentOne newInstance(String param1, String param2) {
        BlankFragmentOne fragment = new BlankFragmentOne();
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
        View view = inflater.inflate(R.layout.fragment_blank_fragment_one, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyle_view);
        recyclerView = Constant.SetRecyclerViewOrientation.setGridView(recyclerView, getActivity(), 2);


        StoreAdapter storeAdapter = new StoreAdapter(getActivity(), CommonMethod.getStaticListProduct());
        recyclerView.setAdapter(storeAdapter);
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();

    }


}
