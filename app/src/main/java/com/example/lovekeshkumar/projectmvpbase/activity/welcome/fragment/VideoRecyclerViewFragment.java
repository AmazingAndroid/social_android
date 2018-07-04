package com.example.lovekeshkumar.projectmvpbase.activity.welcome.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.lovekeshkumar.projectmvpbase.R;
import com.example.lovekeshkumar.projectmvpbase.activity.listener.RecyclerClickListener;
import com.example.lovekeshkumar.projectmvpbase.adapter.HashtagMainPageAdapter;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.video_list_demo.adapter.VideoRecyclerViewAdapter;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.video_list_demo.adapter.items.BaseVideoItem;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.video_list_demo.adapter.items.ItemFactory;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.view.IPlaceHolderView;
import com.example.lovekeshkumar.projectmvpbase.fragment.fragmentmain.view.SwapUpFragment;
import com.volokh.danylo.video_player_manager.Config;
import com.volokh.danylo.video_player_manager.manager.PlayerItemChangeListener;
import com.volokh.danylo.video_player_manager.manager.SingleVideoPlayerManager;
import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.meta.MetaData;
import com.volokh.danylo.visibility_utils.calculator.DefaultSingleItemCalculatorCallback;
import com.volokh.danylo.visibility_utils.calculator.ListItemsVisibilityCalculator;
import com.volokh.danylo.visibility_utils.calculator.SingleListViewItemActiveCalculator;
import com.volokh.danylo.visibility_utils.scroll_utils.ItemsPositionGetter;
import com.volokh.danylo.visibility_utils.scroll_utils.RecyclerViewItemPositionGetter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This fragment shows of how to use {@link VideoPlayerManager} with a RecyclerView.
 */
public class VideoRecyclerViewFragment extends Fragment implements IVideoRecyclerView, RecyclerClickListener {
    public static final String EXTRA_POSITION = "position";
    private static final boolean SHOW_LOGS = Config.SHOW_LOGS;
    private static final String TAG = VideoRecyclerViewFragment.class.getSimpleName();
    private RelativeLayout layout_main;
    private  TextView textname ;
    private  TextView swipe;
    private final ArrayList<BaseVideoItem> mList = new ArrayList<>();
    private static final String ARG_PARAM1 = "param1";
    ProgressBar progress;
  ;
    /**
     * Only the one (most visible) view should be active (and playing).
     * To calculate visibility of views we use {@link SingleListViewItemActiveCalculator}
     */
    private final ListItemsVisibilityCalculator mVideoVisibilityCalculator =
            new SingleListViewItemActiveCalculator(new DefaultSingleItemCalculatorCallback(), mList);

    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerViewHashtag;
    private LinearLayoutManager mLayoutManager;
    private GridLayoutManager mLayoutManagerhashtAg;

    public static VideoRecyclerViewFragment newInstance(int param1) {
        VideoRecyclerViewFragment fragment = new VideoRecyclerViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    /**
     * ItemsPositionGetter is used by {@link ListItemsVisibilityCalculator} for getting information about
     * items position in the RecyclerView and LayoutManager
     */
    private ItemsPositionGetter mItemsPositionGetter;

    /**
     * Here we use {@link SingleVideoPlayerManager}, which means that only one video playback is possible.
     */
    private final VideoPlayerManager<MetaData> mVideoPlayerManager = new SingleVideoPlayerManager(new PlayerItemChangeListener() {
        @Override
        public void onPlayerItemChanged(MetaData metaData) {

        }
    });

    private int mScrollState = AbsListView.OnScrollListener.SCROLL_STATE_IDLE;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        try {
            mList.add(ItemFactory.createItemFromAsset("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/1_pyn1fm.mp4", R.drawable.video_sample_1_pic, getActivity(), mVideoPlayerManager));
            mList.add(ItemFactory.createItemFromAsset("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", R.drawable.video_sample_2_pic, getActivity(), mVideoPlayerManager));
            mList.add(ItemFactory.createItemFromAsset("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", R.drawable.video_sample_3_pic, getActivity(), mVideoPlayerManager));
            mList.add(ItemFactory.createItemFromAsset("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", R.drawable.video_sample_4_pic, getActivity(), mVideoPlayerManager));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        View rootView = inflater.inflate(R.layout.fragment_video_recycler_view, container, false);

        initialization(rootView);
        setListeners();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!mList.isEmpty()) {
            // need to call this method from list view handler in order to have filled list

            mRecyclerView.post(new Runnable() {
                @Override
                public void run() {

                    mVideoVisibilityCalculator.onScrollStateIdle(
                            mItemsPositionGetter,
                            mLayoutManager.findFirstVisibleItemPosition(),
                            mLayoutManager.findLastVisibleItemPosition());

                }
            });
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // we have to stop any playback in onStop
        mVideoPlayerManager.resetMediaPlayer();
    }

    @Override
    public void onRecyclerClick(Intent intent) {

    }



    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setListeners() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
                mScrollState = scrollState;
                if (scrollState == RecyclerView.SCROLL_STATE_IDLE && !mList.isEmpty()) {

                    mVideoVisibilityCalculator.onScrollStateIdle(
                            mItemsPositionGetter,
                            mLayoutManager.findFirstVisibleItemPosition(),
                            mLayoutManager.findLastVisibleItemPosition());
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!mList.isEmpty()) {
                    mVideoVisibilityCalculator.onScroll(
                            mItemsPositionGetter,
                            mLayoutManager.findFirstVisibleItemPosition(),
                            mLayoutManager.findLastVisibleItemPosition() - mLayoutManager.findFirstVisibleItemPosition() + 1,
                            mScrollState);
                }
            }
        });
        mItemsPositionGetter = new RecyclerViewItemPositionGetter(mLayoutManager, mRecyclerView);


        swipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                SwapUpFragment fragment = new SwapUpFragment();
                fm.beginTransaction().add(R.id.layout_container, fragment).commit();
            }
        });

    }

    @Override
    public void initialization(View rootView) {
        textname = (TextView) rootView.findViewById(R.id.textname);
         swipe = (TextView) rootView.findViewById(R.id.swipe);
        layout_main = (RelativeLayout) rootView.findViewById(R.id.layout_main);
        layout_main.setVisibility(View.VISIBLE);
        progress = (ProgressBar) rootView.findViewById(R.id.progress);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerViewHashtag = (RecyclerView) rootView.findViewById(R.id.recyle_view2);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerViewHashtag.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayout.HORIZONTAL, false);

       mLayoutManagerhashtAg = new GridLayoutManager(getActivity(),4);

       mLayoutManagerhashtAg.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 3)
                {
                    return 1;
                }else
                {
                    return 2;
                }
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerViewHashtag.setLayoutManager(mLayoutManagerhashtAg);


      /*  ViewTreeObserver viewTreeObserver = mRecyclerViewHashtag.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                calculateCellSize();
            }
        });*/
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);
        Bundle bundle = getArguments();
        int positions = bundle.getInt(ARG_PARAM1);
        textname.setText(String.valueOf(positions));

        //LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.blink);
        VideoRecyclerViewAdapter videoRecyclerViewAdapter = new VideoRecyclerViewAdapter(mVideoPlayerManager, getActivity(), mList);
      ArrayList<String> stringArrayList=new ArrayList<>();
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
        YoYo.with(Techniques.Pulse)
                .duration(1500)

                .playOn(mRecyclerView);
        mRecyclerView.setAdapter(videoRecyclerViewAdapter);
        mRecyclerViewHashtag.setAdapter(hashtagMainPageAdapter);



    }
    private static final int sColumnWidth = 200; // assume cell width of 120dp
    private void calculateCellSize() {
        int spanCount = (int) Math.floor(mRecyclerView.getWidth() / convertDPToPixels(sColumnWidth));
        mLayoutManagerhashtAg.setSpanCount(spanCount);
        //((GridLayoutManager) mRecyclerView.getLayoutManager()).setSpanCount(spanCount);
    }
    private float convertDPToPixels(int dp) {
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float logicalDensity = metrics.density;
        return dp * logicalDensity;
    }

    @Override
    public void bindDataOnView(String response) {

    }

    @Override
    public void showErrorMessage(Throwable error) {

    }
}