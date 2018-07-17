package com.example.lovekeshkumar.projectmvpbase.fragment.share_chat.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.adapter.ShareChatListAdapter;
import com.example.lovekeshkumar.projectmvpbase.model.Constant;
import com.example.lovekeshkumar.projectmvpbase.fragment.share_chat.presenter.ShareChatPresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.ArrayList;


public class ChatShareFragment extends Fragment implements IChatShareView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyle_view;
    private ProgressBar progress;
    private Utility utility;
    private ShareChatPresenterImpl iShareChatPresenter;

    @SuppressLint("ValidFragment")
    public ChatShareFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatShareFragment newInstance(String param1, String param2) {
        ChatShareFragment fragment = new ChatShareFragment();
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
        View view= inflater.inflate(R.layout.chat_share_fragment_blank, container, false);
        initialization(view);
        recyle_view= Constant.SetRecyclerViewOrientation.setLinnerView(recyle_view,getContext());
        utility = Utility.getInstance(getContext());
        iShareChatPresenter = new ShareChatPresenterImpl(this, utility);

        return view;
    }


    @Override
    public void bindDataOnView(ArrayList<ChatShareDataResponse> response) {
        ArrayList<ChatShareDataResponse> mAndroidArrayList = response;
        ShareChatListAdapter mAdapter = new ShareChatListAdapter(mAndroidArrayList);
        recyle_view.setAdapter(mAdapter);
    }

    @Override
    public void onRecyclerClick(ArrayList<ChatShareDataResponse> response, int position) {

    }

    @Override
    public void showErrorMessage(Throwable error) {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void initialization(View view) {
        recyle_view=(RecyclerView)view.findViewById(R.id.recyle_view);
        progress=(ProgressBar) view.findViewById(R.id.progress);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public Context getContext() {
        return getActivity();
    }


}
