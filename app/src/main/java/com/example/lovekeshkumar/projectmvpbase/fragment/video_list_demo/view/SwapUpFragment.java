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
package com.example.lovekeshkumar.projectmvpbase.fragment.video_list_demo.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.lovekeshkumar.projectmvpbase.R;


/**
 * Fragment implementation created to show a poster inside an ImageView widget.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class SwapUpFragment extends Fragment{
    private static final String TAG ="Swap" ;
    FrameLayout main_frame;

    //   private boolean checkScroll = false;

    /**
     * Override method used to initialize the fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sliding_up, container, false);
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "onItemClick", Toast.LENGTH_SHORT).show();
            }
        });*/

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,your_array_list );

        //lv.setAdapter(arrayAdapter);

        //TextView t = (TextView)view. findViewById(R.id.name);
        //t.setText(Html.fromHtml(getString(R.string.hello)));
        //Button f = (Button)view.  findViewById(R.id.follow);
        //f.setText(Html.fromHtml(getString(R.string.follow)));
        //f.setMovementMethod(LinkMovementMethod.getInstance());
        /*f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.twitter.com/umanoapp"));
                startActivity(i);
            }
        });*/
        return view;
    }

}