package com.example.lovekeshkumar.projectmvpbase.utility;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.StringSignature;
import com.example.lovekeshkumar.projectmvpbase.network.NetworkManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import static android.os.Build.VERSION.SDK_INT;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

/**
 * Created by HP on 3/23/2017.
 */

public class Utility {
 //   private static final String TAG = makeLogTag(Utility.class);
    public static SortedMap<Currency, Locale> currencyLocaleMap;
    static int NOTIFY_REQUEST_CODE = 10;
    static String SIP_DOMAIN = "google.com";
    private static Utility utility;

    static {
        currencyLocaleMap = new TreeMap<Currency, Locale>(new Comparator<Currency>() {
            public int compare(Currency c1, Currency c2) {
                return c1.getCurrencyCode().compareTo(c2.getCurrencyCode());
            }
        });
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                currencyLocaleMap.put(currency, locale);
            } catch (Exception e) {
            }
        }
    }

    public Dialog dialogCompatibility;
    public Button btnCheckCompatibility;
    public TextView txtWarning;
    Context mContext;
    String password = "p4sswd";
    Dialog dialog;
    ArrayList<String> userImageUrls;
    Notification notification;

    String imageFilePath = null;
    boolean isKitKat = SDK_INT >= Build.VERSION_CODES.KITKAT;
    int MAX_IMAGE_DIMENSION = 720;
    ArrayList<ProgressBar> progressBars;
    String score;
    String description;
    TextView txtOverAll;
    TextView textDes;
    Timer timer; /*= new Timer()*/
    private String mCurrentPhotoPath;

    private Utility(Context context) {
        this.mContext = context;
    }

    public static Utility getInstance(Context context) {
        if (utility == null) {
            utility = new Utility(context);
        }
        return utility;
    }

    /***
     * Get Display size in Point
     * @param appCompatActivity
     * - Current Activity
     * @return
     * - Point of Screen size
     */
    public static Point getScreenPoint(AppCompatActivity appCompatActivity) {
        WindowManager wm = (WindowManager) appCompatActivity.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    /***
     *
     * @param sip
     * @return
     */
    public static String createNumberSipAddress(String sip) {
        String reformt = sip;
        if (sip != null) {
            boolean isformat = false;
            if (sip.contains("tel:") && sip.contains("context")) {
                //From:"9870049796" <tel:9870049796;phone-conext=+91>;tag=ac0dhXZcAU28U.
                // // sip:404882932986434@115.249.90.138
                String[] num1 = sip.split(";");
                String fnum = num1[0].replace("tel:", "").trim();
                String[] num2 = num1[1].split("=");
                String snum = num2[1].replace(">", "").trim();
                reformt = snum + fnum.replace("<", "");
                num1 = null;
                num2 = null;
                fnum = null;
                snum = null;
                isformat = true;

            } else if (!sip.contains("@") && !sip.contains(SIP_DOMAIN)) {
                isformat = true;
            }

            if (isformat) {
                StringBuilder sb = new StringBuilder();
                sb.append("sip:").append(reformt).append("@").append(SIP_DOMAIN);
                reformt = sb.toString();
                sb = null;
            }
        }
        return reformt;
    }

    /**
     * The method validates email address
     *
     * @param email email address to validate
     * @return true if the email entered is valid
     */
    public boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

//    public void setBadgeCount(Context context, LayerDrawable icon, int count) {
//
//        BadgeDrawable badge;
//
//        // Reuse drawable if possible
//        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
//        if (reuse != null && reuse instanceof BadgeDrawable) {
//            badge = (BadgeDrawable) reuse;
//        } else {
//            badge = new BadgeDrawable(context);
//        }
//
//        badge.setCount(count);
//        icon.mutate();
//        icon.setDrawableByLayerId(R.id.ic_badge, badge);
//    }

//    public void showTestingDialog(final Activity activity, String test) {
//        boolean showDialog;
//        if (dialog != null && dialog.isShowing()) {
//            if (userImageUrls.contains(test)) {
//                showDialog = false;
//            } else {
//                showDialog = true;
//            }
//        } else {
//            userImageUrls = null;
//            showDialog = true;
//        }
//        if (!showDialog) {
//            return;
//        }
//        if (userImageUrls == null) {
//            userImageUrls = new ArrayList<>();
//        }
//        dialog = new Dialog(activity, R.style.DialogSlideAnim);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.dialog_friend_connection);
//        dialog.setCanceledOnTouchOutside(false);
//        CircleImageView img_friend = (CircleImageView) dialog.findViewById(R.id.img_friend);
//        userImageUrls.add(test);
//        //showImage(notificationModel.getSender_image(),img_friend,null);
//        CircleImageView img_myself = (CircleImageView) dialog.findViewById(R.id.img_myself);
//        // showImage(registrationResponse.image,img_myself,null);
//        TextView txt_friend_name = (TextView) dialog.findViewById(R.id.txt_friend_name);
//        TextView txt_my_name = (TextView) dialog.findViewById(R.id.txt_my_name);
//        FontelloTextView btnClose = (FontelloTextView) dialog.findViewById(R.id.imgClose);
//        final Button btnStartChat = (Button) dialog.findViewById(R.id.btnStartChat);
//        txt_friend_name.setText("");
//        txt_my_name.setText("");
//
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dialog dialog = (Dialog) btnStartChat.getTag();
//                dialog.dismiss();
//
//            }
//        });
//
//        img_friend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
//        btnStartChat.setTag(dialog);
//        btnStartChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Dialog dialog = (Dialog) btnStartChat.getTag();
//                dialog.dismiss();
//                //dialog.dismiss();
//            }
//        });

    //    // ColorDrawable cd = new ColorDrawable(0xFFFF6666);
//        ColorDrawable cd = new ColorDrawable(Color.parseColor("#80000000"));
//        // ColorDrawable cd = new ColorDrawable(android.graphics.Color.TRANSPARENT);
//        dialog.getWindow().setBackgroundDrawable(cd);
//        // earnCoins.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.getWindow().setGravity(Gravity.CENTER);
//        //  DbHelper.getInstance(mContext).updateNotificationStatus(notificationModel.get_id(), NotificationStatus.READ);
//        dialog.show();
//    }

//    public void progressColor(ProgressBar progressBar, String tag) {
//        //String tag= (String) progressBar.getTag();
//        switch (tag) {
//            case COMMON_GOALS:
//                //ColorDrawable colorDrawable=new ColorDrawable(R.color.competibility_common_goal);
//                //progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.red, null));
//                progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_1, null));
//                break;
//            case PASSION_ND_WORK:
//                progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_2, null));
//
//                break;
//            case SPORTS:
//                progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_3, null));
//
//                break;
//            case SPRITUAL_BELIEF:
//                progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_4, null));
//
//                break;
//            case FOOD:
//                progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_5, null));
//
//                break;
//            case STATE:
//                progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_6, null));
//
//                break;
//        }
//        //if (progress < 30) {
//        //    progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.red, null));
//        // } else if (progress >= 30 && progress < 60) {
//        //     progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.yellow, null));
//        // } else if (progress >= 60 && progress <= 100) {
//        //     progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.green, null));
//        // }
//
//
//    }

    public void clickdilaoge(View view) {
        // CompatibilityDialogeBox(this,80,30,55,70,20);
    }

//    public void CompatibilityDialogeBox(final Activity context, int progressCommonGoals, int progressPassionNdWork,
//                                        int progressSports, int progressSpritualelief, int progressFood, int progressState, String overAll, String description, NotificationModel notificationModel, RegistrationResponse registrationResponse, String chatId) {
//        //   FlurryAgent.logEvent("EARN COIN DIALOGE CLICK");
//
//
//       // FlurryUtils.logCompatibilityScreenEvent();
//        FabricUtil.logCompatibilityScreenEvent(chatId);
//        final Dialog compatebilitymatch = new Dialog(context, R.style.DialogSlideAnim);
//        compatebilitymatch.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        compatebilitymatch.setContentView(R.layout.compatibili);
//        if (compatebilitymatch.getWindow() != null) {
//            compatebilitymatch.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//        compatebilitymatch.getWindow().setGravity(Gravity.CENTER);
//        compatebilitymatch.setCancelable(true);
//        compatebilitymatch.setCanceledOnTouchOutside(false);
//        TextView txtUsername = (TextView) compatebilitymatch.findViewById(R.id.txtUsername);
//        txtOverAll = (TextView) compatebilitymatch.findViewById(R.id.txtOverAll);
//        textDes = (TextView) compatebilitymatch.findViewById(R.id.textDes);
//        FontelloTextView btnCancel = (FontelloTextView) compatebilitymatch.findViewById(R.id.btnCancel);
//        AdView adView = (AdView) compatebilitymatch.findViewById(R.id.adView);
//        adView.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                super.onAdClosed();
//            }
//
//            @Override
//            public void onAdFailedToLoad(int i) {
//                super.onAdFailedToLoad(i);
//            }
//
//            @Override
//            public void onAdLeftApplication() {
//                super.onAdLeftApplication();
//            }
//
//            @Override
//            public void onAdOpened() {
//                super.onAdOpened();
//                final Activity activity = context;
//                int bannerAdClicks = PrefManager.getInstance(activity).getPrefrenceIntdata(PrefManager.Pref.BANNER_AD_CLICK_COUNTER, 0);
//                int range= SharedPrefUtil.getPrefAdmobbannerAdRange(activity);
//                if (bannerAdClicks <range) {
//                    NetworkManager networkManager = null;
//                    networkManager = NetworkManager.get(activity, new ServiceRedirection() {
//                        @Override
//                        public void onSuccessRedirection(Response object, int taskID) {
//                            switch (taskID) {
//                                case Constant.ModelConstants.COIN_FLOW_FROM_AD_TASK_ID:
//                                    try {
//                                        CoinsResponse coinsResponse = new Gson().fromJson((String) object.body(), CoinsResponse.class);
//                                        if (coinsResponse != null && coinsResponse.coinsModels != null && coinsResponse.coinsModels.size() > 0) {
//                                            if (!coinsResponse.coinsModels.get(0).error) {
//                                                Constant.CURRENT_USER_COINS = Integer.parseInt(coinsResponse.coinsModels.get(0).coins);
//                                                if (activity != null) {
//                                                    SharedPrefUtil.setPrefStoreCurrentCoinsStatus(activity, Constant.CURRENT_USER_COINS);
//                                                    String credit=coinsResponse.coinsModels.get(0).credit;
//                                                    if(credit!=null && credit.length()>0){
//                                                        CommonTask.dialogeInformationType(activity, "Rewarded coins", "Congratulations,You have earned "+credit+" coins.");
//                                                    }
//                                                    // CommonTask.dialogeInformationType(ChatActivity.this, "Rewarded coins", "You have earned 25 coins and now you can send messages");
//                                                }
//
//                                            }
//                                        }
//                                    } catch (Exception e) {
//                                    }
//                                    break;
//                            }
//                        }
//
//                        @Override
//                        public void onServerErrorRedirection(ErrorModel errorModel, int taskID) {
//
//                        }
//
//                        @Override
//                        public void onFailureRedirection(ErrorModel errorModel) {
//
//                        }
//                    });
//
//                    hitCoinFlowAPI(Constant.ModelConstants.COIN_FLOW_FROM_AD_TASK_ID, Constant.ModelConstants.BANNER_AD_CLICKED, networkManager);
//                    CommonTask.increaseBannerAdClickCounter(activity);
//                }
//                FabricUtil.eventBannerAdClick(SharedPrefUtil.getPrefCurrentUserChatId(activity));
//                //System.out.print("test");
//            }
//
//            @Override
//            public void onAdLoaded() {
//                super.onAdLoaded();
//            }
//        });
//        CommonTask.displayBannerAds(adView, context);
//        this.score = overAll + "% match";
//        this.description = description;
//        txtOverAll.setText("Calculating...");
//        //textDes.setVisibility(View.GONE);
//        Animation animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.anim.blink);
//        txtOverAll.setVisibility(View.VISIBLE);
//        txtOverAll.startAnimation(animBlink);
//
//        // txtOverAll.setText(score);
//        textDes.setText(description);
//        ImageView my_image = (ImageView) compatebilitymatch.findViewById(R.id.my_image);
//        ImageView user_image = (ImageView) compatebilitymatch.findViewById(R.id.user_image);
//        if (notificationModel != null) {
//            txtUsername.setText(notificationModel.getSendingUser());
//            showImage(notificationModel.getSender_image(), user_image, null);
//        }
//        if (registrationResponse != null) {
//            showImage(registrationResponse.image, my_image, null);
//        }
//
//        RelativeLayout layoutOverAll = (RelativeLayout) compatebilitymatch.findViewById(R.id.layoutOverAll);
//
//
//        ProgressBar progressBarCommonGoals = (ProgressBar) compatebilitymatch.findViewById(R.id.progressCommonGoals);
//        TextView textpercentage1 = (TextView) compatebilitymatch.findViewById(R.id.textpercentage1);
//
//
//        ProgressBar progressBarPassionNdWork = (ProgressBar) compatebilitymatch.findViewById(R.id.progressPassionNdWork);
//        TextView textpercentage2 = (TextView) compatebilitymatch.findViewById(R.id.textpercentage2);
//
//        ProgressBar progressBarSports = (ProgressBar) compatebilitymatch.findViewById(R.id.progressSports);
//        TextView textpercentage3 = (TextView) compatebilitymatch.findViewById(R.id.textpercentage3);
//
//        ProgressBar progressBarSpritualelief = (ProgressBar) compatebilitymatch.findViewById(R.id.progressSpritualelief);
//        TextView textpercentage4 = (TextView) compatebilitymatch.findViewById(R.id.textpercentage4);
//        ProgressBar progressBarFood = (ProgressBar) compatebilitymatch.findViewById(R.id.progressFood);
//        TextView textpercentage5 = (TextView) compatebilitymatch.findViewById(R.id.textpercentage5);
//
//        ProgressBar progressBarState = (ProgressBar) compatebilitymatch.findViewById(R.id.progressState);
//        TextView textpercentage6 = (TextView) compatebilitymatch.findViewById(R.id.textpercentage6);
//
//
//        //TextView watch_video = (TextView) compatebilitymatch.findViewById(R.id.watch_video);
//        progressBars = new ArrayList<>();
//
//        progressBarCommonGoals.setProgress(0);
//        progressBarPassionNdWork.setProgress(0);
//        progressBarSports.setProgress(0);
//        progressBarSpritualelief.setProgress(0);
//        progressBarFood.setProgress(0);
//        progressBarState.setProgress(0);
//
//
//        layoutOverAll.setVisibility(View.VISIBLE);
//
//
//        ProgressData progressData1 = new ProgressData(COMMON_GOALS, progressCommonGoals, 1, textpercentage1);
//        ProgressData progressData2 = new ProgressData(PASSION_ND_WORK, progressPassionNdWork, 1, textpercentage2);
//        ProgressData progressData3 = new ProgressData(SPORTS, progressSports, 1, textpercentage3);
//        ProgressData progressData4 = new ProgressData(SPRITUAL_BELIEF, progressSpritualelief, 1, textpercentage4);
//        ProgressData progressData5 = new ProgressData(FOOD, progressFood, 1, textpercentage5);
//        ProgressData progressData6 = new ProgressData(STATE, progressState, 1, textpercentage6);
//
//        progressBarCommonGoals.setTag(progressData1);
//        progressBarPassionNdWork.setTag(progressData2);
//        progressBarSports.setTag(progressData3);
//        progressBarSpritualelief.setTag(progressData4);
//        progressBarFood.setTag(progressData5);
//        progressBarState.setTag(progressData6);
//
//        progressBars.add(progressBarCommonGoals);
//        progressBars.add(progressBarPassionNdWork);
//        progressBars.add(progressBarSports);
//        progressBars.add(progressBarSpritualelief);
//        progressBars.add(progressBarFood);
//        progressBars.add(progressBarState);
//
//
///*
//        progressBars.add(progressBarCommonGoals);
//        progressBars.add(progressBarPassionNdWork);
//        progressBars.add(progressBarSports);
//        progressBars.add(progressBarSpritualelief);
//        progressBars.add(progressBarFood);
//        progressBars.add(progressBarState);
//*/
//        start(progressBars.get(0), context);
//        //startTimerTask(context, progressBars.get(0), 1, progressPassionNdWork, textpercentage1);
//        //  showProgress(context, progressBarCommonGoals, 1, progressCommonGoals, textpercentage1, COMMON_GOALS, layoutOverAll);
//        // incrementProgress(context, progressBarPassionNdWork, 1, progressPassionNdWork, textpercentage2, PASSION_ND_WORK, layoutOverAll);
//        //  incrementProgress(context, progressBarSports, 1, progressSports, textpercentage3, SPORTS, layoutOverAll);
//        // incrementProgress(context, progressBarSpritualelief, 1, progressSpritualelief, textpercentage4, SPRITUAL_BELIEF, layoutOverAll);
//        //  incrementProgress(context, progressBarFood, 1, progressFood, textpercentage5, FOOD, layoutOverAll);
//        //  incrementProgress(context, progressBarState, 1, progressState, textpercentage6, STATE, layoutOverAll);
//        compatebilitymatch.show();
//        //DbHelper.getInstance(mContext).updateNotificationStatus(notificationModel.get_id(), NotificationStatus.READ);
//        //   CommonTask.displayBannerAds(bannerads, context);
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                compatebilitymatch.dismiss();
//            }
//        });
//    }

    public void showProgress(final Activity activity, final ProgressBar numberProgressBar, final int incrementby, final int progress, final TextView textpercentage1, final String tag, final RelativeLayout laoutOverall) {

        // ObjectAnimator progressAnimator = ObjectAnimator.ofInt(numberProgressBar, "progress", progress, incrementby);
        ObjectAnimator animation = ObjectAnimator.ofInt(numberProgressBar, "progress", progress);
        animation.setDuration(3000); // 0.5 second
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


    }

    public void incrementProgress(final Activity activity, final ProgressBar numberProgressBar, final int incrementby, final int progress, final TextView textpercentage1, final String tag, final RelativeLayout laoutOverall) {
        // numberProgressBar.setTag(tag);
        // if(tag.equals(COMMON_GOALS)){
        //  startTimerTask(activity, progressBars.get(0), incrementby, progress, textpercentage1, timer);
        // }

    }

//    void start(ProgressBar progressBar, Activity activity) {
//        ProgressData progressData = (ProgressData) progressBar.getTag();
//        timer = new Timer();
//        startTimerTask(activity, progressData.tag, progressBar, progressData.incrementBy, progressData.progress, progressData.textView, timer);
//
//     /*   switch (progressData.tag){
//            case COMMON_GOALS:
//                startTimerTask(activity,progressBar, progressData.incrementBy, progressData.progress, progressData.textView, timer);
//
//                //ColorDrawable colorDrawable=new ColorDrawable(R.color.competibility_common_goal);
//                //progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.red, null));
//                // progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_1, null));
//                break;
//            case PASSION_ND_WORK:
//                //  progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_2, null));
//                startTimerTask(activity,progressBar, progressData.incrementBy, progressData.progress, progressData.textView, timer);
//
//                break;
//            case SPORTS:
//                //progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_3, null));
//                startTimerTask(activity,progressBar, progressData.incrementBy, progressData.progress, progressData.textView, timer);
//                break;
//            case SPRITUAL_BELIEF:
//                // progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_4, null));
//                startTimerTask(activity,progressBar, progressData.incrementBy, progressData.progress, progressData.textView, timer);
//                break;
//            case FOOD:
//                // progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_5, null));
//                startTimerTask(activity,progressBar, progressData.incrementBy, progressData.progress, progressData.textView, timer);
//                break;
//            case STATE:
//                //  progressBar.setProgressDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.compat_6, null));
//                startTimerTask(activity,progressBar, progressData.incrementBy, progressData.progress, progressData.textView, timer);
//                break;
//    }*/
//    }

//    public void startTimerTask(final Activity activity, final String tag, final ProgressBar numberProgressBar, final int incrementby, final int progress, final TextView textpercentage1, final Timer timer) {
//
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        numberProgressBar.incrementProgressBy(incrementby);
//                        textpercentage1.setText(String.valueOf(numberProgressBar.getProgress() + " %"));
//                        progressColor(numberProgressBar, tag);
//                     //   LOGD(TAG, "current:" + numberProgressBar.getProgress());
//                        if (numberProgressBar.getProgress() == progress) {
//                            timer.cancel();
//                            timer.purge();
//                            numberProgressBar.setProgress(progress);
//                            // ProgressData progressData= (ProgressData) numberProgressBar.getTag();
//                            if (tag.equals(COMMON_GOALS)) {
//                                start(progressBars.get(1), activity);
//                            } else if (tag.equals(PASSION_ND_WORK)) {
//                                start(progressBars.get(2), activity);
//                            } else if (tag.equals(SPORTS)) {
//                                start(progressBars.get(3), activity);
//                            } else if (tag.equals(SPRITUAL_BELIEF)) {
//                                start(progressBars.get(4), activity);
//                            } else if (tag.equals(FOOD)) {
//                                start(progressBars.get(5), activity);
//                            }
//                            if (tag.equals(STATE)) {
//                                //   laoutOverall.setVisibility(View.VISIBLE);
//                                txtOverAll.setText(score);
//                                textDes.setVisibility(View.VISIBLE);
//                                txtOverAll.clearAnimation();
//                            }
//
//                        } else if (numberProgressBar.getProgress() == 100) {
//                            timer.cancel();
//                            timer.purge();
//                            numberProgressBar.setProgress(progress);
//                        }
//                    }
//                });
//            }
//        }, 10, 20);
//    }

//    public void updateCoins() {
//        Constant.CURRENT_USER_COINS = Integer.parseInt(SharedPrefUtil.getCurrentCoins(mContext));
//    }

//    public void showCompatibilityMatchDialog(final Activity activity, Bundle bundle, final NotificationModel notificationModel, final RegistrationResponse registrationResponse, final String chatId) {
//
//
//        final int commonGoals = Integer.parseInt(bundle.getString(COMMON_GOALS));
//        final int passion_nd_work = Integer.parseInt(bundle.getString(PASSION_ND_WORK));
//        final int sports = Integer.parseInt(bundle.getString(SPORTS));
//        final int spritual_belief = Integer.parseInt(bundle.getString(SPRITUAL_BELIEF));
//        final int food = Integer.parseInt(bundle.getString(FOOD));
//        final int state = Integer.parseInt(bundle.getString(STATE));
//        final String description = bundle.getString(Constant.ModelConstants.DESCRIPTION);
//        final String overall_result = bundle.getString(Constant.ModelConstants.OVERALL_RESULT);
//
//        DbHelper.getInstance(mContext).updateNotificationStatus(notificationModel.get_id(), NotificationStatus.READ);
//        boolean showDialog;
//        if (dialogCompatibility != null && dialogCompatibility.isShowing()) {
//            if (userImageUrls.contains(notificationModel.getSender_image())) {
//                showDialog = false;
//            } else {
//                showDialog = true;
//            }
//        } else {
//            userImageUrls = null;
//            showDialog = true;
//        }
//        if (!showDialog) {
//            return;
//        }
//        if (userImageUrls == null) {
//            userImageUrls = new ArrayList<>();
//        }
//        dialogCompatibility = new Dialog(activity, R.style.DialogSlideAnim);
//        dialogCompatibility.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialogCompatibility.setContentView(R.layout.dialog_compatibility);
//        dialogCompatibility.setCanceledOnTouchOutside(false);
//
//        final CircleImageView img_friend = (CircleImageView) dialogCompatibility.findViewById(R.id.img_friend);
//        userImageUrls.add(notificationModel.getSender_image());
//        showImage(notificationModel.getSender_image(), img_friend, null);
//        CircleImageView img_myself = (CircleImageView) dialogCompatibility.findViewById(R.id.img_myself);
//        showImage(registrationResponse.image, img_myself, null);
//        TextView txt_friend_name = (TextView) dialogCompatibility.findViewById(R.id.txt_friend_name);
//        TextView txtWarning = (TextView) dialogCompatibility.findViewById(R.id.txtWarning);
//
//        //  TextView txt_my_name= (TextView) dialogCompatibility.findViewById(R.id.txt_my_name);
//        FontelloTextView btnClose = (FontelloTextView) dialogCompatibility.findViewById(R.id.imgClose);
//        final Button btnCheckCompatibility = (Button) dialogCompatibility.findViewById(R.id.btnCheckCompatibility);
//        this.btnCheckCompatibility = btnCheckCompatibility;
//        this.txtWarning = txtWarning;
//        btnCheckCompatibility.setTag(dialogCompatibility);
//        txt_friend_name.setText(notificationModel.getSendingUser());
//        //  txt_my_name.setText(registrationResponse.nickname);
//      /*  if (BuildConfig.DEBUG) {
//            FlurryAgent.logEvent("COMPATIBILITY DIALOG DEBUG MODE");
//        } else {
//            FlurryAgent.logEvent("COMPATIBILITY DIALOG");
//        }*/
//      FabricUtil.eventDialogShown(chatId,COMPATIBILITY_MATCH_DIALOG);
//
//        if (Constant.CURRENT_USER_COINS < 100) {
//            txtWarning.setText("You don't have enough coins to check compatibility.");
//            btnCheckCompatibility.setText("Earn Coins to check Compatibility");
//        } else {
//            txtWarning.setText("There is deduction of 100 coins for compatibility check.");
//
//        }
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dialog dialog = (Dialog) btnCheckCompatibility.getTag();
//                dialog.dismiss();
//            }
//        });
//        img_friend.setTag(notificationModel);
//        img_friend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NotificationModel notificationModel = (NotificationModel) img_friend.getTag();
//                NetworkManager networkManager = NetworkManager.get(activity.getApplicationContext(), (ServiceRedirection) activity);
//                ProfilesRequest profilesRequest = new ProfilesRequest();
//                profilesRequest.chatId = notificationModel.getSender_id();
//                networkManager.userProfileView(profilesRequest, Constant.ModelConstants.USER_PROFILE_TASK_ID);
//                FabricUtil.eventProfileDetail(registrationResponse.chatId,COMPATIBILITY_MATCH_DIALOG);
//            }
//        });

//        btnCheckCompatibility.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final NotificationModel notificationModel = (NotificationModel) img_friend.getTag();
//                ProfilesModel chatProfile = new ProfilesModel();
//                chatProfile.chatID = notificationModel.getSender_id();
//                chatProfile.image = notificationModel.getSender_image();
//                chatProfile.nickname = notificationModel.getSendingUser();
//                chatProfile.status = Constant.ModelConstants.FRIEND;
//
//
//                if (btnCheckCompatibility.getText().equals("Earn Coins to check Compatibility")) {
//                    ((DashboardActivity) activity).startWatchVideo();
//                    return;
//                }
//                if (CommonTask.isNetworkAvailable(activity)) {
//
//                    Dialog dialog = (Dialog) btnCheckCompatibility.getTag();
//                    dialog.dismiss();
//                    //  if (Constant.CURRENT_USER_COINS < 100) {
//                    // CommonTask.dialogeWarningTypeWithCancel(activity, "Earn Coins","You don't have enough coins,Do you want to earn more coins",REQUEST_CODE_COMPATIBILITY);
//                    //CommonTask.dialogeWarningType(ProfilesDeatilActivity.this, getResources().getString(R.string.title_coin_box), getString(R.string.need_1000_coins), "OK");
//                    //  CommonTask.dialogeWarningTypeWithCancel(activity, "Earn Coins", mContext.getString(R.string.need_1000_coins), "");
//                    //     return;
//                    // }else{
//                    CompatibilityDialogeBox(activity, commonGoals, passion_nd_work, sports, spritual_belief, food,
//                            state, overall_result, description, notificationModel, registrationResponse,chatId);
//                    ((DashboardActivity) activity).hitCoinsFlowAPI(REQUEST_CODE_COMPATIBILITY);
//
//                } else {
//                    CommonTask.showToast(activity, "No internet connection!");
//                }
//              /*  if (Constant.CURRENT_USER_COINS < 100) {
//                    CommonTask.dialogeWarningTypeWithCancel(activity, "Earn Coins", "You don't have enough coins,Do you want to earn more coins", REQUEST_CODE_COMPATIBILITY);
//
//                } else {
//                    new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
//                            .setTitleText("Important Info!")
//                            .setContentText("There is deduction of 100 coins for compatibility check")
//                            .setConfirmText("Proceed")
//                            .setCancelText("Cancel")
//                            .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                @Override
//                                public void onClick(SweetAlertDialog sweetAlertDialog) {
//                                    sweetAlertDialog.dismissWithAnimation();
//                                }
//                            })
//                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                @Override
//                                public void onClick(SweetAlertDialog sDialog) {
//                                    if(CommonTask.isNetworkAvailable(activity)){
//                                        sDialog.dismissWithAnimation();
//                                        Dialog dialog = (Dialog) btnCheckCompatibility.getTag();
//                                        dialog.dismiss();
//                                        CompatibilityDialogeBox(activity, commonGoals, passion_nd_work, sports, spritual_belief, food,
//                                                state, overall_result, description, notificationModel, registrationResponse);
//                                        ((DashboardActivity) activity).hitCoinsFlowAPI(REQUEST_CODE_COMPATIBILITY);
//
//                                    }else{
//                                        CommonTask.showToast(activity,"No internet connection!");
//                                    }
//
//                                }
//                            })
//                            .show();
//                }*/
//
//
//                // if (Frenzy.profilesModel != null) {
//                //   for (ProfilesModel profilesModel : Frenzy.profilesModel) {
//                //   if (profilesModel.chatID.equals(userId)) {
//                //    chatProfile = profilesModel;
//                //  Intent intent = new Intent(activity, ChatActivity.class);
//                //  intent.putExtra(Constant.ModelConstants.CONDITION_PARAMS_KEY, chatProfile);
//                //  activity.startActivity(intent);
//
//                //Dialog dialog= (Dialog) btnCheckCompatibility.getTag();
//                //dialog.dismiss();
//                //dialog.dismiss();
//            }
//        });

//        // ColorDrawable cd = new ColorDrawable(0xFFFF6666);
//        ColorDrawable cd = new ColorDrawable(Color.parseColor("#80000000"));
//        // ColorDrawable cd = new ColorDrawable(android.graphics.Color.TRANSPARENT);
//        if (dialogCompatibility.getWindow() != null) {
//            dialogCompatibility.getWindow().setBackgroundDrawable(cd);
//        }
//        // earnCoins.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialogCompatibility.getWindow().setGravity(Gravity.CENTER);
//
//        dialogCompatibility.show();
//    }

//    public int getVersionCode() {
//        int versionCode = 2000;
//        try {
//            PackageInfo pInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
//            // String version = pInfo.versionName;
//            versionCode = pInfo.versionCode;
//        } catch (PackageManager.NameNotFoundException e) {
//            //e.printStackTrace();
//            versionCode = getVCode();
//        }
//        return versionCode;
//
//    }

//    public int getVCode() {
//        int versionCode = BuildConfig.VERSION_CODE;
//        return versionCode;
//    }

//    public void showRefferCodeDialog(final Activity activity) {
//
//
//        final Dialog dialog = new Dialog(activity, R.style.DialogSlideAnim);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.refferalcode_dialog);
//        dialog.setCanceledOnTouchOutside(false);
//        final AppCompatEditText inputRefferCode = (AppCompatEditText) dialog.findViewById(R.id.input_reffer_code);
//
//        final Button btnSubmit = (Button) dialog.findViewById(R.id.btn_submit);
//        final Button btnSkip = (Button) dialog.findViewById(R.id.btn_skip);
//        //  FontelloTextView btnClose = (FontelloTextView) dialog.findViewById(R.id.btnClose);
//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String reffercode = inputRefferCode.getText().toString();
//                if (validateForm(inputRefferCode)) {
//                    closeKeyboard(inputRefferCode);
//                    ((DashboardActivity) activity).hitRefferId(reffercode.toUpperCase(), Constant.ModelConstants.USER_REFER_COIN_TASK_ID);
//                }
//            }
//        });
//        btnSkip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        // ColorDrawable cd = new ColorDrawable(0xFFFF6666);
//       // ColorDrawable cd = new ColorDrawable(Color.parseColor("#80000000"));
//        // ColorDrawable cd = new ColorDrawable(android.graphics.Color.TRANSPARENT);
//        if (dialog.getWindow() != null) {
//          //  dialog.getWindow().setBackgroundDrawable(cd);
//            // earnCoins.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//            dialog.getWindow().setGravity(Gravity.CENTER);
//        }
//
//         dialog.show();
//    }

//    private boolean validateForm(AppCompatEditText edtMobile) {
//        if (!utility.isNetworkAvailable()) {
//            CommonTask.showToast(mContext, "No internet");
//            return false;
//        }
//        if (utility.isEditTextEmpty(edtMobile)) {
//            CommonTask.showToast(mContext, mContext.getResources().getString(R.string.enter_refer_id));
//            //showSnackbar(getString(R.string.enter_refer_id));
//            return false;
//        }
//        if (edtMobile.getText().toString().length() > 6) {
//            CommonTask.showToast(mContext, mContext.getResources().getString(R.string.enter_reffre_valid));
//
//
//            return false;
//        }
//        if (edtMobile.getText().toString().length() < 6) {
//            CommonTask.showToast(mContext, mContext.getResources().getString(R.string.enter_reffre_valid));
//
//            return false;
//        }
//        return true;
//    }


//    Dialog dialogDaliyOffer;
//    public void showDailyOfferDialog(final Activity activity, String offer_url, NotificationModel notificationModel, final String chatId) {
//        boolean showDialog;
//
//        if((dialogDaliyOffer != null) && dialogDaliyOffer.isShowing()){
//            return;
//        }
//        dialogDaliyOffer = new Dialog(activity, R.style.DialogSlideAnim);
//        dialogDaliyOffer.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialogDaliyOffer.setContentView(R.layout.dialog_daily_offer);
//        dialogDaliyOffer.setCanceledOnTouchOutside(false);
//
//        ImageView img_offer = (ImageView) dialogDaliyOffer.findViewById(R.id.img_offer);
//        final Button btnBuyCoins = (Button) dialogDaliyOffer.findViewById(R.id.btnBuyCoins);
//
//        FontelloTextView btnClose = (FontelloTextView) dialogDaliyOffer.findViewById(R.id.btnClose);
//        showImage(offer_url, img_offer, null);
//        btnBuyCoins.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                ((DashboardActivity) activity).startWatchVideo();
//                FabricUtil.eventClick(chatId,FabricUtil.WATCH_VIDEO_CLICK,"Daily Offer");
//               // FlurryUtils.logEarnCoinFromDailyOfferEvent();
//            }
//        });
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialogDaliyOffer.dismiss();
//            }
//        });
//        // ColorDrawable cd = new ColorDrawable(0xFFFF6666);
//        ColorDrawable cd = new ColorDrawable(Color.parseColor("#80000000"));
//        // ColorDrawable cd = new ColorDrawable(android.graphics.Color.TRANSPARENT);
//        if (dialogDaliyOffer.getWindow() != null) {
//            dialogDaliyOffer.getWindow().setBackgroundDrawable(cd);
//            // earnCoins.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//            dialogDaliyOffer.getWindow().setGravity(Gravity.CENTER);
//        }
//       // FlurryUtils.logDailyOfferOpenEvent();
//        FabricUtil.logDailyOfferOpenEvent(chatId);
//        DbHelper.getInstance(mContext).updateNotificationStatus(notificationModel.get_id(), NotificationStatus.READ);
//        dialogDaliyOffer.show();
//    }

//    public void showFriendsConnectionDialog(final Activity activity, final NotificationModel notificationModel, final RegistrationResponse registrationResponse) {
//        boolean showDialog;
//        if (dialog != null && dialog.isShowing()) {
//            if (userImageUrls.contains(notificationModel.getSender_image())) {
//                showDialog = false;
//            } else {
//                showDialog = true;
//            }
//        } else {
//            userImageUrls = null;
//            showDialog = true;
//        }
//        if (!showDialog) {
//            return;
//        }
//        if (userImageUrls == null) {
//            userImageUrls = new ArrayList<>();
//        }
//        dialog = new Dialog(activity, R.style.DialogSlideAnim);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.dialog_friend_connection);
//        dialog.setCanceledOnTouchOutside(false);
//
//        final CircleImageView img_friend = (CircleImageView) dialog.findViewById(R.id.img_friend);
//        userImageUrls.add(notificationModel.getSender_image());
//        showImage(notificationModel.getSender_image(), img_friend, null);
//        CircleImageView img_myself = (CircleImageView) dialog.findViewById(R.id.img_myself);
//        showImage(registrationResponse.image, img_myself, null);
//        TextView txt_friend_name = (TextView) dialog.findViewById(R.id.txt_friend_name);
//        TextView txt_my_name = (TextView) dialog.findViewById(R.id.txt_my_name);
//        FontelloTextView btnClose = (FontelloTextView) dialog.findViewById(R.id.imgClose);
//        final Button btnStartChat = (Button) dialog.findViewById(R.id.btnStartChat);
//        btnStartChat.setTag(dialog);
//        txt_friend_name.setText(notificationModel.getSendingUser());
//        txt_my_name.setText(registrationResponse.nickname);
//
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dialog dialog = (Dialog) btnStartChat.getTag();
//                dialog.dismiss();
//
//            }
//        });
//        img_friend.setTag(notificationModel);
//        img_friend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NotificationModel notificationModel = (NotificationModel) img_friend.getTag();
//                NetworkManager networkManager = NetworkManager.get(activity.getApplicationContext(), (ServiceRedirection) activity);
//                ProfilesRequest profilesRequest = new ProfilesRequest();
//                profilesRequest.chatId = notificationModel.getSender_id();
//                networkManager.userProfileView(profilesRequest, Constant.ModelConstants.USER_PROFILE_TASK_ID);
//
//                FabricUtil.eventProfileDetail(registrationResponse.chatId,FRIEND_CONNECTION_DIALOG);
//               /* if (BuildConfig.DEBUG) {
//                    FlurryAgent.logEvent("PROFILE VIEW FROM FRIEND CONNECTION DEBUG MODE");
//                } else {
//                    FlurryAgent.logEvent("PROFILE VIEW FROM FRIEND CONNECTION");
//                }*/
//            }
//        });
//
//        btnStartChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NotificationModel notificationModel = (NotificationModel) img_friend.getTag();
//                ProfilesModel chatProfile = new ProfilesModel();
//                chatProfile.chatID = notificationModel.getSender_id();
//                chatProfile.image = notificationModel.getSender_image();
//                chatProfile.nickname = notificationModel.getSendingUser();
//                chatProfile.status = Constant.ModelConstants.FRIEND;
//                if (chatNotification != null && chatNotification.containsKey(chatProfile.chatID)) {
//                    chatNotification.remove(chatProfile.chatID);
//                }
//                PrefManager.getInstance(activity).saveChatUnreadNotifications(chatNotification);
//                // if (Frenzy.profilesModel != null) {
//                //   for (ProfilesModel profilesModel : Frenzy.profilesModel) {
//                //   if (profilesModel.chatID.equals(userId)) {
//                //    chatProfile = profilesModel;
//                Intent intent = new Intent(activity, ChatActivity.class);
//                intent.putExtra(Constant.ModelConstants.CONDITION_PARAMS_KEY, chatProfile);
//                activity.startActivity(intent);
//               /* if (BuildConfig.DEBUG) {
//                    FlurryAgent.logEvent("CHAT PAGE FROM FRIEND CONNECTION DEBUG MODE");
//                } else {
//                    FlurryAgent.logEvent("CHAT PAGE FROM FRIEND CONNECTION");
//                }*/
//                Dialog dialog = (Dialog) btnStartChat.getTag();
//                dialog.dismiss();
//                //dialog.dismiss();
//            }
//        });
//
//        // ColorDrawable cd = new ColorDrawable(0xFFFF6666);
//        ColorDrawable cd = new ColorDrawable(Color.parseColor("#80000000"));
//        // ColorDrawable cd = new ColorDrawable(android.graphics.Color.TRANSPARENT);
//        dialog.getWindow().setBackgroundDrawable(cd);
//        // earnCoins.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.getWindow().setGravity(Gravity.CENTER);
//        DbHelper.getInstance(mContext).updateNotificationStatus(notificationModel.get_id(), NotificationStatus.READ);
//
//
//        FabricUtil.eventDialogShown(registrationResponse.chatId,FRIEND_CONNECTION_DIALOG);
//       // if (BuildConfig.DEBUG) {
//       //     FlurryAgent.logEvent("FRIEND CONNECTION DIALOG DEBUG MODE");
//       // } else {
//       //     FlurryAgent.logEvent("FRIEND CONNECTION DIALOG");
//       // }
//        dialog.show();
//    }
//
//    public void showFriendsConnectionDialog2(final Activity activity, final NotificationModel notificationModel, RegistrationResponse registrationResponse) {
//        boolean showDialog;
//        final Dialog dialog;
//        dialog = new Dialog(activity, R.style.DialogSlideAnim);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.dialog_friend_connection);
//        dialog.setCanceledOnTouchOutside(false);
//        CircleImageView img_friend = (CircleImageView) dialog.findViewById(R.id.img_friend);
//
//        showImage(notificationModel.getSender_image(), img_friend, null);
//        CircleImageView img_myself = (CircleImageView) dialog.findViewById(R.id.img_myself);
//        showImage(registrationResponse.image, img_myself, null);
//        TextView txt_friend_name = (TextView) dialog.findViewById(R.id.txt_friend_name);
//        TextView txt_my_name = (TextView) dialog.findViewById(R.id.txt_my_name);
//        FontelloTextView btnClose = (FontelloTextView) dialog.findViewById(R.id.imgClose);
//        Button btnStartChat = (Button) dialog.findViewById(R.id.btnStartChat);
//        txt_friend_name.setText(notificationModel.getSendingUser());
//        txt_my_name.setText(registrationResponse.nickname);
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        img_friend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NetworkManager networkManager = NetworkManager.get(activity.getApplicationContext(), (ServiceRedirection) activity);
//
//                ProfilesRequest profilesRequest = new ProfilesRequest();
//                profilesRequest.chatId = notificationModel.getSender_id();
//                networkManager.userProfileView(profilesRequest, Constant.ModelConstants.USER_PROFILE_TASK_ID);
//            }
//        });
//        btnStartChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ProfilesModel chatProfile = new ProfilesModel();
//                chatProfile.chatID = notificationModel.getSender_id();
//                chatProfile.image = notificationModel.getSender_image();
//                chatProfile.nickname = notificationModel.getSendingUser();
//                chatProfile.status = Constant.ModelConstants.FRIEND;
//                if (chatNotification != null && chatNotification.containsKey(chatProfile.chatID)) {
//                    chatNotification.remove(chatProfile.chatID);
//                }
//                PrefManager.getInstance(activity).saveChatUnreadNotifications(chatNotification);
//                // if (Frenzy.profilesModel != null) {
//                //   for (ProfilesModel profilesModel : Frenzy.profilesModel) {
//                //   if (profilesModel.chatID.equals(userId)) {
//                //    chatProfile = profilesModel;
//                Intent intent = new Intent(activity, ChatActivity.class);
//                intent.putExtra(Constant.ModelConstants.CONDITION_PARAMS_KEY, chatProfile);
//                activity.startActivity(intent);
//                dialog.dismiss();
//            }
//        });
//        // ColorDrawable cd = new ColorDrawable(0xFFFF6666);
//        ColorDrawable cd = new ColorDrawable(Color.parseColor("#80000000"));
//        // ColorDrawable cd = new ColorDrawable(android.graphics.Color.TRANSPARENT);
//        dialog.getWindow().setBackgroundDrawable(cd);
//        // earnCoins.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.getWindow().setGravity(Gravity.CENTER);
//        //  DbHelper.getInstance(mContext).updateNotificationStatus(notificationModel.get_id(), NotificationStatus.READ);
//        dialog.show();
//    }

    public void hideKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        // View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        //  if (view == null) {
        //      view = new View(activity);
        //   }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

//    public void removeChatNotification() {
//        NotificationManager mNotificationManager =
//                (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
//
//        mNotificationManager.cancel(CHAT_NOTIFICATION_ID);
//        /*if(chatNotification!=null && chatNotification.size()>0){
//
//        }*/
//    }

    void showNotifications(HashMap<String, ArrayList<String>> chatNotification) {
        int msgCount = 0;
        if (chatNotification.size() > 1) {

            for (String key : chatNotification.keySet()) {
                msgCount += chatNotification.get(key).size();
            }

        }
       /* String notifyText;
        if(msgCount>1 && chatNotification.size()>1 ){
            notifyText=msgCount + " messages from "+ chatNotification.size() + " chats";
        }else if(msgCount>1 && chatNotification.size()==1 ){
            notifyText=msgCount + " messages from "+ chat.getWith_user_name();
        } else if(chatNotification.size()==1 && msgCount==1){
            Set<String> set=chatNotification.keySet();
            String id = null;
            for(String s: set) {
                id = s;
                break;
            }
         }*/
    }

//    public void showNotification(Context context, String title, String text, Chat chat) {
//        if (chatNotification.containsKey(chat.getWith_user_id())) {
///*
//            NotificationMsg msg=chatNotification.get(from);
//            msg.addMsg(text);
//*/
//            ArrayList<String> msgs = chatNotification.get(chat.getWith_user_id());
//            msgs.add(text);
//            // int count=chatNotification.get(from).getCount();
//            chatNotification.put(chat.getWith_user_id(), msgs);
//        } else {
//            ArrayList<String> msgs = new ArrayList<>();
//            // NotificationMsg msg=new NotificationMsg();
//            msgs.add(text);
//            chatNotification.put(chat.getWith_user_id(), msgs);
//        }
//        // int pendingNotificationsCount = getPendingNotificationsCount() + 1;
//        // setPendingNotificationsCount(pendingNotificationsCount);
//        int msgCount = 0;
//        for (String key : chatNotification.keySet()) {
//            msgCount += chatNotification.get(key).size();
//        }
//        PrefManager.getInstance(context).saveChatUnreadNotifications(chatNotification);
//        String notifyText;
//        if (msgCount > 1 && chatNotification.size() > 1) {
//            notifyText = msgCount + " messages from " + chatNotification.size() + " chats";
//        } else if (msgCount > 1 && chatNotification.size() == 1) {
//            notifyText = msgCount + " messages from " + chat.getWith_user_name();
//        } else {
//            notifyText = text + " from " + chat.getWith_user_name();
//        }
//        notify(context, title, text, chat, msgCount, notifyText);
//
//    }
//
//    private void notify(Context context, String title, String text, Chat chat, int msgCount, String notifyText) {
//        Intent intent = new Intent(context, DashboardActivity.class);
//        intent.putExtra(EXTRA_CHAT_NOTIFICATION, true);
//        intent.putExtra(EXTRA_FROM_USER, chat.getWith_user_id());
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
//                Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
//                .setContentText(notifyText)
//                .setContentTitle(title)
//                .setSmallIcon(R.drawable.frenzy_app_icon)
//                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.frenzy_app_icon))
//                .setAutoCancel(true)
//                // .setOngoing(running)
//                // .setOnlyAlertOnce(true)
//                .setContentIntent(PendingIntent.getActivity(context, NOTIFY_REQUEST_CODE, intent, 0));
//
//        NotificationManager mNotificationManager =
//                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//
//        notification = builder.build();
//        notification.number = msgCount;
//
//        mNotificationManager.notify(CHAT_NOTIFICATION_ID, builder.build());
//        if (isDashboardActivityVisible) {
//            Intent chatNotifIntent = new Intent(ACTION_CHAT_NOTIFICATION);
//            chatNotifIntent.putExtra(EXTRA_CHAT_MESSAGE, text);
//            // intent.putExtra(EXTRA_MESSAGE_TAG, tag);
//            chatNotifIntent.putExtra(EXTRA_FROM_USER, chat.getWith_user_id());
//            // intent.putExtra(EXTRA_CALL_ID, callId);
//
//            Receiver.mContext.sendBroadcast(chatNotifIntent);
//
//        }
//    }
//
//    public void saveSipProfile() {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
//        String authId = sharedPreferences.getString(Constant.ModelConstants.AUTH_ID, "");
//        String authKey = sharedPreferences.getString(Constant.ModelConstants.AUTH_KEY, "");
//
//        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(mContext).edit();
//        edit.putString(Settings.PREF_USERNAME, authId);
//        edit.putString(Settings.PREF_PASSWORD, authKey);
//        edit.putString(Settings.PREF_SERVER, SIP_SERVER);
//        edit.putString(Settings.PREF_DOMAIN, SIP_SERVER);
//        edit.putString(Settings.PREF_FROMUSER, authId);
//        edit.putString(Settings.PREF_PORT, String.valueOf(SIP_PORT));
//        edit.putString(Settings.PREF_PROTOCOL, PROTOCOL_UDP);
//        //  edit.putString(Settings.PREF_ACCOUNT,"Line1:10000057@34.210.36.33");
//        edit.putString(Settings.PREF_REGISTER_EXPIRES, SIP_EXPIRES);
//        edit.commit();
//    }
//
//    public void showRippleEffect(View targetView) {
//        if (SDK_INT >= LOLLIPOP) {
//            targetView.setBackground(mContext.getResources().getDrawable(R.drawable.ripple_selector));
//        } else {
//            int[] attrs = new int[]{android.R.attr.selectableItemBackground /* index 0 */};
//            TypedArray ta = mContext.obtainStyledAttributes(attrs);
//            Drawable drawableFromTheme = ta.getDrawable(0 /* index */);
//            ta.recycle();
//            targetView.setBackground(drawableFromTheme);
//            //v.setBackground(activity.getResources().getDrawable(R.drawable.ripple_selector))
//        }
//    }
//
//    public void clearSipProfile() {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
//        // String authId = sharedPreferences.getString(Constant.ModelConstants.AUTH_ID, "");
//        //  String authKey = sharedPreferences.getString(Constant.ModelConstants.AUTH_KEY, "");
//        SharedPreferences.Editor edit = sharedPreferences.edit();
//        edit.remove(Settings.PREF_USERNAME);
//        edit.remove(Settings.PREF_PASSWORD);
//        edit.remove(Settings.PREF_SERVER);
//        edit.remove(Settings.PREF_DOMAIN);
//        edit.remove(Settings.PREF_FROMUSER);
//        edit.remove(Settings.PREF_PORT);
//        edit.remove(Settings.PREF_PROTOCOL);
//        //  edit.putString(Settings.PREF_ACCOUNT,"Line1:10000057@34.210.36.33");
//        edit.remove(Settings.PREF_REGISTER_EXPIRES);
//        edit.commit();
//    }

    /***
     *
     * @param view
     * -View to attach
     * @param message
     * -Message of Snack bar
     */
//    public void showSnackBarToast(View view, String message) {
//        Snackbar snackBar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
//        // snackBar.set
//        View snackBarView = snackBar.getView();
//        snackBarView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.dark_grey)); // Navigation Bg Color
//        TextView tv = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
//        tv.setTextColor(ContextCompat.getColor(mContext, R.color.white));
//        tv.setMaxLines(4);
//        snackBar.show();
//    }

    /***
     * Close keyboard
     * @param v
     * View to control
     */
    public void closeKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    /***
     * Show alertdialog with two button
     * @param activity     -Current Activity
     * @param title     Title of Dialog
     * @param message -Message of dialog
     */
//    public void showDialogWithOkButton(Context activity, String title, CharSequence message, final DialogClickInterface dialogClickInterface) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//
//        if (title != null) builder.setTitle(title);
//
//        builder.setMessage(message);
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogClickInterface.onPositiveClick();
//            }
//        });
//        builder.show();
//    }

    /***
     * Show alertdialog with two button
     * @param activity
     * -Current Activity
     * @param title
     * -Title of Dialog
     * @param message
     * -Message of dialog
     */
//    public void showDialogWithOkCancelButton(Context activity, String title, CharSequence message, final DialogClickInterface dialogClickInterface, String positiveName, String negativeButton, Boolean value) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//
//        if (title != null) builder.setTitle(title);
//
//        builder.setMessage(message);
//        builder.setCancelable(value);
//
//        builder.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialogClickInterface.onNegativeClick();
//            }
//        });
//        builder.setPositiveButton(positiveName, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogClickInterface.onPositiveClick();
//            }
//        });
//
//        builder.show();
//    }

    /***
     * Check internet connectivity
     * @return
     */
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /***
     * Set Main Background color faded
     * @param transparencyLevel
     * Transparency level in float
     * LEvel of transparency
     */
    public void setLayoutTransparency(View layout_main_bg, float transparencyLevel) {
        ViewCompat.setAlpha(layout_main_bg, transparencyLevel);
    }

    /***
     *
     * @param bmp
     * @param pt
     * @param targetColor
     * @param replacementColor
     */
    public void floodFill(Bitmap bmp, Point pt, int targetColor, int replacementColor) {
        Queue<Point> q = new LinkedList<Point>();
        q.add(pt);
        while (q.size() > 0) {
            Point n = q.poll();
            if (bmp.getPixel(n.x, n.y) != targetColor)
                continue;

            Point w = n, e = new Point(n.x + 1, n.y);
            while ((w.x > 0) && (bmp.getPixel(w.x, w.y) == targetColor)) {
                bmp.setPixel(w.x, w.y, replacementColor);
                if ((w.y > 0) && (bmp.getPixel(w.x, w.y - 1) == targetColor))
                    q.add(new Point(w.x, w.y - 1));
                if ((w.y < bmp.getHeight() - 1)
                        && (bmp.getPixel(w.x, w.y + 1) == targetColor))
                    q.add(new Point(w.x, w.y + 1));
                w.x--;
            }
            while ((e.x < bmp.getWidth() - 1)
                    && (bmp.getPixel(e.x, e.y) == targetColor)) {
                bmp.setPixel(e.x, e.y, replacementColor);

                if ((e.y > 0) && (bmp.getPixel(e.x, e.y - 1) == targetColor))
                    q.add(new Point(e.x, e.y - 1));
                if ((e.y < bmp.getHeight() - 1)
                        && (bmp.getPixel(e.x, e.y + 1) == targetColor))
                    q.add(new Point(e.x, e.y + 1));
                e.x++;
            }
        }
    }

    /***
     * method to Encrypt
     * @param plaintext
     * Plan Text Array which need to be enc
     * @return
     */
//    public String encryptData(byte[] plaintext) throws CryptorException {
//        JNCryptor cryptor = new AES256JNCryptor();
//
//        byte[] ciphertext = cryptor.encryptData(plaintext, password.toCharArray());
//        return Base64.encodeToString(ciphertext, Base64.DEFAULT);
//
//    }

    /***
     * Method to Decrypt
     * @return
     * @throws
     * @throws UnsupportedEncodingException
     */
//    public String decryptData(String data) throws CryptorException, UnsupportedEncodingException {
//        JNCryptor cryptor = new AES256JNCryptor();
//        byte[] decode = Base64.decode(data, Base64.DEFAULT);
//        String s = new String(cryptor.decryptData(decode, password.toCharArray()), "UTF-8");
//        return s;
//    }

    void showBlockDialog() {

    }


    public void showImage(String url, final ImageView imageView, final ProgressBar progressBar) {
        if (progressBar != null)
            progressBar.setVisibility(View.VISIBLE);
        if (url == null) {
            return;
        }
        if (url.length() == 0) {
            return;
        }
        if (mContext != null) {

            Glide.with(mContext).load(url).asBitmap().fitCenter().listener(new RequestListener<String, Bitmap>() {
                @Override
                public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                    if (progressBar != null)
                        progressBar.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    if (progressBar != null)
                        progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).signature(new StringSignature(url)).into(imageView);
        }

   }

//    public void showImagePicassa(String url, final ImageView imageView, final ProgressBar progressBar, Context context) {
//        if (progressBar != null)
//            progressBar.setVisibility(View.INVISIBLE);
//        if (url == null) {
//            return;
//        }
//        if (url.length() == 0) {
//            return;
//        }
//
//        Picasso.with(context)
//                .load(url)
//                .into(imageView, new Callback() {
//                    @Override
//                    public void onSuccess() {
//                        if (progressBar != null)
//                            progressBar.setVisibility(View.GONE);
//                    }
//
//                    @Override
//                    public void onError() {
//
//                    }
//                });
//    }

    public void showImagePicassa(String url, final ImageView imageView, final ProgressBar progressBar) {
        if (progressBar != null)
            progressBar.setVisibility(View.INVISIBLE);
        if (url == null) {
            return;
        }
        if (url.length() == 0) {
            return;
        }

        Picasso.get().load(url). into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                if (progressBar != null)
                    progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    // convert InputStream to String
    public String convertStreamToString(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

    /***
     * Return true is EditText is empty
     * @param editText
     * @return
     */
    public boolean isEditTextEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    /***
     * Check Permission Runtime
     * @param context
     * Activity Context
     * @param permission
     * Runtime required permission
     * @param requestCode
     * Request Code
     * @return
     */
    public boolean checkPermission(final Context context, final String permission, final int requestCode, String message) {
        int currentAPIVersion = SDK_INT;
        if (currentAPIVersion >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permission)) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage(message);
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, requestCode);
                        }
                    });
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, requestCode);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM), "Camera");
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        setmCurrentPhotoPath(mCurrentPhotoPath);
        return image;
    }

    public String getmCurrentPhotoPath() {
        return mCurrentPhotoPath;
    }

    public void setmCurrentPhotoPath(String mCurrentPhotoPath) {
        this.mCurrentPhotoPath = mCurrentPhotoPath;
    }

//    public void dispatchTakePictureIntent(Activity activity) throws IOException {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        // Ensure that there's a camera activity to handle the intent
//        if (takePictureIntent.resolveActivity(mContext.getPackageManager()) != null) {
//            // Create the File where the photo should go
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException ex) {
//                // Error occurred while creating the File
//                return;
//            }
//            // Continue only if the File was successfully created
//            if (photoFile != null) {
//                Uri photoURI = FileProvider.getUriForFile(activity,
//                        BuildConfig.APPLICATION_ID + ".provider",
//                        createImageFile());
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                activity.startActivityForResult(takePictureIntent, Constant.ModelConstants.REQUEST_CODE_CAMERA);
//            }
//        }
//    }

    public void showFileChooser(Activity activity) throws IOException {

        // Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        // activity.startActivityForResult(cameraIntent,  Constant.ModelConstants.REQUEST_CODE_CAMERA);


    }

    public String importGalleryPic(Intent data, final ImageView imgProfilePic) {

        final boolean[] isImageFromGoogleDrive = {false};
        final Uri uri = data.getData();
        final String[] imgPath = {null};

        if (isKitKat && DocumentsContract.isDocumentUri(mContext, uri)) {
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                String docId = DocumentsContract.getDocumentId(uri);
                String[] split = docId.split(":");
                String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    imgPath[0] = Environment.getExternalStorageDirectory() + "/" + split[1];
                } else {
                    Pattern DIR_SEPORATOR = Pattern.compile("/");
                    Set<String> rv = new HashSet<>();
                    String rawExternalStorage = System.getenv("EXTERNAL_STORAGE");
                    String rawSecondaryStoragesStr = System.getenv("SECONDARY_STORAGE");
                    String rawEmulatedStorageTarget = System.getenv("EMULATED_STORAGE_TARGET");
                    if (TextUtils.isEmpty(rawEmulatedStorageTarget)) {
                        if (TextUtils.isEmpty(rawExternalStorage)) {
                            rv.add("/storage/sdcard0");
                        } else {
                            rv.add(rawExternalStorage);
                        }
                    } else {
                        String rawUserId;
                        if (SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            rawUserId = "";
                        } else {
                            String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                            String[] folders = DIR_SEPORATOR.split(path);
                            String lastFolder = folders[folders.length - 1];
                            boolean isDigit = false;
                            try {
                                Integer.valueOf(lastFolder);
                                isDigit = true;
                            } catch (NumberFormatException ignored) {
                            }
                            rawUserId = isDigit ? lastFolder : "";
                        }
                        if (TextUtils.isEmpty(rawUserId)) {
                            rv.add(rawEmulatedStorageTarget);
                        } else {
                            rv.add(rawEmulatedStorageTarget + File.separator + rawUserId);
                        }
                    }
                    if (!TextUtils.isEmpty(rawSecondaryStoragesStr)) {
                        String[] rawSecondaryStorages = rawSecondaryStoragesStr.split(File.pathSeparator);
                        Collections.addAll(rv, rawSecondaryStorages);
                    }
                    String[] temp = rv.toArray(new String[rv.size()]);
                    for (int i = 0; i < temp.length; i++) {
                        File tempf = new File(temp[i] + "/" + split[1]);
                        if (tempf.exists()) {
                            imgPath[0] = temp[i] + "/" + split[1];
                        }
                    }
                }
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                String id = DocumentsContract.getDocumentId(uri);
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                Cursor cursor = null;
                String column = "_data";
                String[] projection = {column};
                try {
                    cursor = mContext.getContentResolver().query(contentUri, projection, null, null,
                            null);
                    if (cursor != null && cursor.moveToFirst()) {
                        int column_index = cursor.getColumnIndexOrThrow(column);
                        imgPath[0] = cursor.getString(column_index);
                    }
                } finally {
                    if (cursor != null)
                        cursor.close();
                }
            } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String docId = DocumentsContract.getDocumentId(uri);
                String[] split = docId.split(":");
                String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                String selection = "_id=?";
                String[] selectionArgs = new String[]{split[1]};

                Cursor cursor = null;
                String column = "_data";
                String[] projection = {column};

                try {
                    cursor = mContext.getContentResolver().query(contentUri, projection, selection, selectionArgs, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        int column_index = cursor.getColumnIndexOrThrow(column);
                        imgPath[0] = cursor.getString(column_index);
                    }
                } finally {
                    if (cursor != null)
                        cursor.close();
                }
            } else if ("com.google.android.apps.docs.storage".equals(uri.getAuthority())) {
                isImageFromGoogleDrive[0] = true;
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            Cursor cursor = null;
            String column = "_data";
            String[] projection = {column};

            try {
                cursor = mContext.getContentResolver().query(uri, projection, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int column_index = cursor.getColumnIndexOrThrow(column);
                    imgPath[0] = cursor.getString(column_index);
                }
            } finally {
                if (cursor != null)
                    cursor.close();
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            imgPath[0] = uri.getPath();
        }
        Bitmap bitmap = null;
        if (isImageFromGoogleDrive[0]) {
            try {
                File oFile = utility.compressImage(utility.getRealPathFromURI(uri), imgProfilePic);
                // bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(uri));
                // imageProfilePic.setImageBitmap(bitmap);
                //  imageBitmap = bitmap;
                imageFilePath = oFile.getAbsolutePath();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
                   /* File f = new File(imgPath[0]);
                    BitmapFactory.Options bmOptions = new BitmapFactory.Options();
                    bmOptions.inJustDecodeBounds = true;
                   // BitmapFactory.decodeResource(getResources(), R.id.myimage, options);
                    BitmapFactory.decodeFile(f.getAbsolutePath(),bmOptions);

                    bmOptions.inSampleSize = utility.calculateInSampleSize(bmOptions, 600, 600);
                    bmOptions.inJustDecodeBounds = false;

                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),bmOptions);*/
            File oFile = compressImage(imgPath[0], imgProfilePic);
                 /*   if(bitmap.getWidth()<=300 || bitmap.getHeight()<=300){
                        imageProfilePic.post(new Runnable() {
                            @Override
                            public void run() {
                                CommonTask.showToast(getActivity(),"Image too small !");
                            }
                        });

                        return;
                    }*/
            // if(bitmap.getWidth()>600 && bitmap.getHeight()>600){
            // bitmap = Bitmap.createScaledBitmap(bitmap, 600, 600, false);
                      /*  bitmap=utility.scaleImage(getActivity(),bitmap );*/

            //  }
                  /*  ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    bitmapdata=stream.toByteArray();*/

            imageFilePath = oFile.getAbsolutePath();
            File outputFile = null;
            // File cacheDir = new File(getActivity().getCacheDir(), "profile_pic.jpg");
                  /*  try {
                     //   cacheDir.createNewFile();

                        File outputDir = getActivity().getCacheDir(); // context being the Activity pointer
                         outputFile = File.createTempFile("profile_pic", ".jpg", outputDir);
                        FileOutputStream fos = new FileOutputStream(outputFile);
                        fos.write(bitmapdata);
                        fos.flush();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(outputFile!=null){
                        imageFilePath=outputFile.getAbsolutePath();
                    }*/

            // imageFilePath=cacheDir.getAbsolutePath()+"/profile_pic.jpg";
            // Bitmap b = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length)
            //profileImage.setImageBitmap(Bitmap.createScaledBitmap(b, 120, 120, false));

        }

        return imageFilePath;
    }

    public String getRealPathFromURI(Uri contentUri) {
        // Uri contentUri = Uri.parse(contentURI);
        Cursor cursor = mContext.getContentResolver().query(contentUri, null, null, null, null);
        if (cursor == null) {
            return contentUri.getPath();
        } else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(index);
        }
    }

    public File compressImage(String filePath, final ImageView imageView) {

        //String filePath = getRealPathFromURI(imageUri);
        Bitmap scaledBitmap = null;

        BitmapFactory.Options options = new BitmapFactory.Options();

//      by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If
//      you try the use the bitmap here, you will get null.
        options.inJustDecodeBounds = true;
        Bitmap bmp = BitmapFactory.decodeFile(filePath, options);

        int actualHeight = options.outHeight;
        int actualWidth = options.outWidth;

//      max Height and width values of the compressed image is taken as 816x612

        float maxHeight = 816.0f;
        float maxWidth = 612.0f;
        float imgRatio = actualWidth / actualHeight;
        float maxRatio = maxWidth / maxHeight;

//      width and height values are set maintaining the aspect ratio of the image

        if (actualHeight > maxHeight || actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / actualHeight;
                actualWidth = (int) (imgRatio * actualWidth);
                actualHeight = (int) maxHeight;
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / actualWidth;
                actualHeight = (int) (imgRatio * actualHeight);
                actualWidth = (int) maxWidth;
            } else {
                actualHeight = (int) maxHeight;
                actualWidth = (int) maxWidth;

            }
        }

//      setting inSampleSize value allows to load a scaled down version of the original image

        options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);

//      inJustDecodeBounds set to false to load the actual bitmap
        options.inJustDecodeBounds = false;

//      this options allow android to claim the bitmap memory if it runs low on memory
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16 * 1024];

        try {
//          load the bitmap from its path
            bmp = BitmapFactory.decodeFile(filePath, options);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();

        }
        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        float ratioX = actualWidth / (float) options.outWidth;
        float ratioY = actualHeight / (float) options.outHeight;
        float middleX = actualWidth / 2.0f;
        float middleY = actualHeight / 2.0f;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

//      check the rotation of the image and display it properly
        ExifInterface exif;
        try {
            exif = new ExifInterface(filePath);

            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0);
            Log.d("EXIF", "Exif: " + orientation);
            Matrix matrix = new Matrix();
            if (orientation == 6) {
                matrix.postRotate(90);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 3) {
                matrix.postRotate(180);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 8) {
                matrix.postRotate(270);
                Log.d("EXIF", "Exif: " + orientation);
            }
            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0,
                    scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix,
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final Bitmap finalScaledBitmap = scaledBitmap;
        if (scaledBitmap != null) {
            imageView.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(finalScaledBitmap);
                }
            });
        }

        FileOutputStream out = null;
        File file = getTempFile();
        try {
            out = new FileOutputStream(file);

//          write the compressed bitmap at the destination specified by filename.
            if (scaledBitmap != null) {
                scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return file;

    }

//    public void hitCoinFlowAPI(int taskID, String CoinMode, NetworkManager networkManager) {
//
//        if (!utility.isNetworkAvailable()) {
//            // showSnackbar(getString(R.string.internet_error));
//            return;
//        }
//        String chat_id = SharedPrefUtil.getPrefCurrentUserChatId(mContext);
//        CoinsRequest coinsRequest = new CoinsRequest();
//        coinsRequest.chatId = chat_id;
//        coinsRequest.coinMode = CoinMode;
//        networkManager.userCoinsLog(coinsRequest, taskID);
//
//    }

    File getTempFile() {
        File outputDir = mContext.getCacheDir(); // context being the Activity pointer

        try {
            return File.createTempFile("profile_pic", ".jpg", outputDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Bitmap scaleImage(Context context, Bitmap bitmap) {
        int width = bitmap.getWidth();
        if (width > MAX_IMAGE_DIMENSION) {
            float ratio = (float) MAX_IMAGE_DIMENSION / (float) width;
            width = MAX_IMAGE_DIMENSION;
            int height = (int) ((float) bitmap.getHeight() * ratio);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
        }
        // ByteArrayOutputStream stream = new ByteArrayOutputStream();
        // bitmap.compress(format, 100, stream);
        return bitmap;
    }

    public int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

//    public void galleryIntent(Activity activity) {
///*
//        Intent intent = new Intent();
//        intent.setType("image*/
///*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);//
//        activity.startActivityForResult(Intent.createChooser(intent, "Select File"), Constant.ModelConstants.REQUEST_CODE_GALLERY);
//*/
//
//        if (SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Intent intent = new Intent(Intent.ACTION_PICK);
//            //intent.addCategory(Intent.CATEGORY_OPENABLE);
//            intent.setType("image/*");
//            activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), Constant.ModelConstants.REQUEST_CODE_GALLERY);
//        } else {
//            Intent intent = new Intent();
//            intent.setType("image/*");
//            intent.setAction(Intent.ACTION_GET_CONTENT);
//            activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), Constant.ModelConstants.REQUEST_CODE_GALLERY);
//        }
//
//
//    }

    /***
     *
     * @param data
     * @return
     */
    public Bitmap onSelectFromGalleryResult(Intent data) {
        Bitmap bm = null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bm;
    }

    /***
     *Convert bitmap to Base64 String
     * @param image
     * @return
     */
    public String base64Image(Bitmap image) {
        if (image == null)
            return "";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 10, baos); //bm is the bitmap object
        // byte[] b = ;
        return Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
    }

    public int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }


}

