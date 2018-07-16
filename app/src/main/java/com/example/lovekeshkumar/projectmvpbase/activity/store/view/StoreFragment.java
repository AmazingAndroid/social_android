package com.example.lovekeshkumar.projectmvpbase.activity.store.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.font.RobotoTextView;


public class StoreFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    LinearLayout layout_login_email, layout_login_phone;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RobotoTextView txtEmail, txtMobile;

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
        View view= inflater.inflate(R.layout.fragment_store, container, false);
        layout_login_email = (LinearLayout) view.findViewById(R.id.layout_group_buy);
        layout_login_phone = (LinearLayout) view.findViewById(R.id.layout_explore);

        txtEmail = (RobotoTextView) view.findViewById(R.id.txt_login_with_email);
        txtMobile = (RobotoTextView) view.findViewById(R.id.txt_login_with_mobile);
        onClickLayoutHashTag();
        layout_login_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLayoutHashTag();
            }
        });
        layout_login_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLayoutPeople();
            }
        });
        return view;
    }

    public void onClickLayoutHashTag() {

        txtMobile.setTextColor(getResources().getColor(R.color.profile_background_color));
        txtEmail.setTextColor(getResources().getColor(R.color.tabseletced_color));

        layout_login_email.setBackgroundResource(R.drawable.rounded_blue_left_store);
        layout_login_phone.setBackgroundResource(R.drawable.rounded_white_right_store);

        //txtInputHint.setText("Email");

    }
    public void onClickLayoutPeople() {



        txtMobile.setTextColor(getResources().getColor(R.color.tabseletced_color));
        txtEmail.setTextColor(getResources().getColor(R.color.profile_background_color));

        layout_login_phone.setBackgroundResource(R.drawable.rounded_blue_left_store);
        layout_login_email.setBackgroundResource(R.drawable.rounded_white_right_store);






    }

}
