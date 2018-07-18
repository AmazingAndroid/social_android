package com.example.lovekeshkumar.projectmvpbase.activity.user_profile.sub_fragment.collection;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.adapter.CollectionAdapter;
import com.example.lovekeshkumar.projectmvpbase.model.Constant;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;
import com.example.lovekeshkumar.projectmvpbase.model.CommonMethod;

import java.util.ArrayList;


public class CollectionFragment extends Fragment implements ICollectionFragmentView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerViewPost;
    private CollectionFragmentPresenterImpl presenter;


    public CollectionFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CollectionFragment newInstance(String param1, String param2) {
        CollectionFragment fragment = new CollectionFragment();
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
        View view= inflater.inflate(R.layout.fragment_collection, container, false);

        initialization(view);

        presenter=new CollectionFragmentPresenterImpl(this) ;
        //bindViewWithResponse(null);

        return view;
    }


    @Override
    public void initialization(View view) {
        recyclerViewPost= (RecyclerView) view.findViewById(R.id.recyle_view);
        recyclerViewPost= Constant.SetRecyclerViewOrientation.setGridView(recyclerViewPost,getActivity(),3);
    }

    @Override
    public void bind() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void bindViewWithResponse(ArrayList<ChatShareDataResponse> chatShareDataResponses) {
        CollectionAdapter postsAdapter=new CollectionAdapter(getActivity(), CommonMethod.getStaticDisplayList());
        recyclerViewPost.setAdapter(postsAdapter);
    }
}
