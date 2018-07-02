/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.view;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.adapter.GameListAdapter;
import com.example.lovekeshkumar.projectmvpbase.adapter.VideoListAdapterAdapter;
import com.example.lovekeshkumar.projectmvpbase.custom.CustomRecyclerView;
import com.example.lovekeshkumar.projectmvpbase.custom.adapter.AutoPlayVideoAdapter;
import com.example.lovekeshkumar.projectmvpbase.model.GameModel;
import com.example.lovekeshkumar.projectmvpbase.model.VideoModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Fragment implementation created to show a poster inside an ImageView widget.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class PlaceHolderFragment extends Fragment implements IPlaceHolderView,RecyclerClickListener {
    public static final String EXTRA_POSITION = "position";
    CustomRecyclerView recyclerView;
    private static final String VIDEO_RAW_PATH ="https://www.demonuts.com/Demonuts/smallvideo.mp4";
    private RelativeLayout layout_main;
    //   private boolean checkScroll = false;
    private final List<VideoModel> modelList = new ArrayList<>();
    /**
     * Override method used to initialize the fragment.
     */
    Picasso p = Picasso.get();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textname);
        TextView swipe = (TextView) view.findViewById(R.id.swipe);

        recyclerView = (CustomRecyclerView)view.findViewById(R.id.recycler_view);
        layout_main = (RelativeLayout)view.findViewById(R.id.layout_main);
     //   recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Bundle bundle = getArguments();
        int positions = bundle.getInt(EXTRA_POSITION);
        textView.setText(String.valueOf(positions));



        modelList.add(new VideoModel("https://firebasestorage.googleapis.com/v0/b/flickering-heat-5334.appspot.com/o/demo1.mp4?alt=media&token=f6d82bb0-f61f-45bc-ab13-16970c7432c4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795681/2_rp0zyy.jpg", "Video1"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1491561340/hello_cuwgcb.jpg", "Video2"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/3_lfndfq.jpg", "Image3"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Video4"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/1_pyn1fm.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/1_pyn1fm.jpg", "Video5"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1491561340/hello_cuwgcb.jpg", "Video6"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/2_qwpgis.jpg", "Image7"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/1_ybonak.jpg", "Image8"));
        modelList.add(new VideoModel("https://firebasestorage.googleapis.com/v0/b/flickering-heat-5334.appspot.com/o/demo1.mp4?alt=media&token=f6d82bb0-f61f-45bc-ab13-16970c7432c4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795681/2_rp0zyy.jpg", "Video9"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/3_lfndfq.jpg", "Name10"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795676/4_nvnzry.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795676/4_nvnzry.jpg", "Video11"));
        modelList.add(new VideoModel("https://firebasestorage.googleapis.com/v0/b/flickering-heat-5334.appspot.com/o/demo1.mp4?alt=media&token=f6d82bb0-f61f-45bc-ab13-16970c7432c4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795681/2_rp0zyy.jpg", "Video12"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/3_lfndfq.jpg", "Image13"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/2_qwpgis.jpg", "Image14"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Video16"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/1_ybonak.jpg", "Image15"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/1_pyn1fm.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/1_pyn1fm.jpg", "Video17"));
        modelList.add(new VideoModel("https://firebasestorage.googleapis.com/v0/b/flickering-heat-5334.appspot.com/o/demo1.mp4?alt=media&token=f6d82bb0-f61f-45bc-ab13-16970c7432c4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795681/2_rp0zyy.jpg", "Video18"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/2_qwpgis.jpg", "Image19"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/3_lfndfq.jpg", "Image20"));
        modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/1_ybonak.jpg", "Image21"));









        swipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                SwapUpFragment fragment = new SwapUpFragment();
                fm.beginTransaction().add(R.id.layout_container,fragment).commit();
            }
        });
        switch (positions) {

            case 1:
                // TODO: 6/26/2018 set adapter
                layout_main.setVisibility(View.GONE);
                textView.setBackgroundColor(Color.parseColor("#ff00719b"));
                break;
            case 2:
                layout_main.setVisibility(View.VISIBLE);
                showPositionTwoData();
                // TODO: 6/26/2018 set adapter
                textView.setBackgroundColor(Color.parseColor("#ffff4444"));
                break;
            case 3:
                // TODO: 6/26/2018 set adapter
                layout_main.setVisibility(View.GONE);
                textView.setBackgroundColor(Color.parseColor("#ffcd3a3a"));
                break;
            case 4:
                // TODO: 6/26/2018 set adapter
                layout_main.setVisibility(View.GONE);
                textView.setBackgroundColor(Color.parseColor("#ff99cc00"));
                break;

            case 5:
                // TODO: 6/26/2018 set adapter
                layout_main.setVisibility(View.GONE);
                textView.setBackgroundColor(Color.parseColor("#fde800"));
                break;

        }


        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        recyclerView.stopVideos();
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.playAvailableVideos(0);
    }

    @Override
    public void showPositionOneData() {

    }

    @Override
    public void showPositionTwoData() {

        AutoPlayVideoAdapter mAdapter = new AutoPlayVideoAdapter(modelList, p);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //todo before setAdapter
        recyclerView.setActivity(getActivity());

        //optional - to play only first visible video
        recyclerView.setPlayOnlyFirstVideo(true); // false by default

        //optional - by default we check if url ends with ".mp4". If your urls do not end with mp4, you can set this param to false and implement your own check to see if video points to url
        recyclerView.setCheckForMp4(false); //true by default

        //optional - download videos to local storage (requires "android.permission.WRITE_EXTERNAL_STORAGE" in manifest or ask in runtime)
        recyclerView.setDownloadPath(Environment.getExternalStorageDirectory() + "/MyVideo"); // (Environment.getExternalStorageDirectory() + "/Video") by default

        recyclerView.setDownloadVideos(true); // false by default

        List<String> urls = new ArrayList<>();
        for (VideoModel object : modelList) {
            if (object.getVideourl() != null && object.getVideourl().contains("http"))
                urls.add(object.getVideourl());
        }
        recyclerView.preDownload(urls);

        recyclerView.setAdapter(mAdapter);



        /*ArrayList<VideoModel> mAndroidArrayList = new ArrayList<>();
        for(int i=0;i<=4;i++)
        {VideoModel videoModel=new VideoModel();

            videoModel.setVideourl(VIDEO_RAW_PATH);
            videoModel.setTitle_video("Hello");
            mAndroidArrayList.add(videoModel);
        }
        VideoListAdapterAdapter mAdapter = new VideoListAdapterAdapter(mAndroidArrayList, this);
        recyclerView.setAdapter(mAdapter);*/
    }

    @Override
    public void showPositionThreeData() {

    }

    @Override
    public void showPositionFourData() {

    }

    @Override
    public void showPositionFiveData() {

    }

    @Override
    public void onRecyclerClick(Intent intent) {

    }
}