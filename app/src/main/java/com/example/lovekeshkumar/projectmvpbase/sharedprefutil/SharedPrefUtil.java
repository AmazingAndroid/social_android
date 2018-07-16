package com.example.lovekeshkumar.projectmvpbase.sharedprefutil;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import static com.example.lovekeshkumar.projectmvpbase.logutill.LogUtils.makeLogTag;

public class SharedPrefUtil {

 private static final String TAG = makeLogTag(SharedPrefUtil.class);

//    public static RegistrationResponse getPrefProfileModelResponse(Context context) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        RegistrationResponse registrationResponselocal = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.PROFILE_MODEL_KEY, ""), RegistrationResponse.class);
//        return registrationResponselocal;
//    }
//
//    public static String getCurrentCoins(Context context) {
//        return getPrefProfileModelResponse(context).coins;
//    }
//
//    public static String getPrefCurrentUserChatId(Context context) {
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
//        String chat_id = prefs.getString(Constant.ModelConstants.AUTH_ID, "");
//        LOGD(TAG, "chat_id:  " + chat_id);
//        return chat_id;
//    }
//
//    public static void setPrefDefaultProfileImage(Context context, String selectedImage) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        RegistrationResponse registrationResponselocal = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.PROFILE_MODEL_KEY, ""), RegistrationResponse.class);
//        registrationResponselocal.image = selectedImage;
//        LOGD(TAG, "Current image:  " + registrationResponselocal.image);
//        String json = new Gson().toJson(registrationResponselocal, RegistrationResponse.class);
//        sharedPreferences.edit().putString(Constant.ModelConstants.PROFILE_MODEL_KEY, json).commit();
//
//    }
//
//    public static String getPrefAdmobAppId(Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        String sd = sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, "");
//        if (sd.length() > 0) {
//            AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), AdmobResponse.class);
//            //  AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), RegistrationResponse.class);
//            String app_id = admobResponse.admobModels.get(0).app_id;
//            if (app_id != null) {
//                return app_id;
//            } else {
//
//                return Constant.ModelConstants.APP_ID;
//            }
//        } else {
//            return "";
//        }
//
//    }
//
//    public static int getPrefAdmobCounter(Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        String sd = sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, "");
//        if (sd.length() > 0) {
//            AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), AdmobResponse.class);
//            //  AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), RegistrationResponse.class);
//            int range = Integer.parseInt(admobResponse.ad_counter);
//            if (range != 0) {
//                return range;
//            } else {
//
//                return Constant.ModelConstants.RANGERIGHTSWAPE;
//            }
//        } else {
//            return Constant.ModelConstants.RANGERIGHTSWAPE;
//        }
//
//    }
//
//
//    public static String getPrefAdmobAppIdRewardedVideo(Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), AdmobResponse.class);
//        //  AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), RegistrationResponse.class);
//        String app_id = admobResponse.admobModels.get(Constant.ModelConstants.INITIAL_POSITION).reward_id;
//        if (app_id != null) {
//            return app_id;
//            // return "ca-app-pub-3940256099942544/5224354917";
//        } else {
//            return Constant.ModelConstants.AD_UNIT_ID;
//            // return null;
//        }
//
//    }
//
//    public static String getPrefAdmobAppIdfullpageid(Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//
//        AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), AdmobResponse.class);
//        //  AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), RegistrationResponse.class);
//        String app_id = admobResponse.admobModels.get(Constant.ModelConstants.INITIAL_POSITION).full_page;
//        if (app_id != null) {
//            //return "ca-app-pub-3940256099942544/1033173712";
//            return app_id;
//        } else {
//            return Constant.ModelConstants.AD_UNIT_ID_FULL_PAGE;
//            //return null;
//        }
//    }
//
//
//    public static int getPrefAdmobAppfullPageRange(Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), AdmobResponse.class);
//        //  AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), RegistrationResponse.class);
//        String app_id = admobResponse.admobModels.get(Constant.ModelConstants.INITIAL_POSITION).full_page_ad_range;
//        if (app_id != null) {
//            return Integer.parseInt(app_id);
//        } else {
//            return Constant.ModelConstants.FULL_PAGE_AD_CLICKED_RANGE;
//        }
//
//    }
//    public static int getPrefAdmobAppVideoRange(Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), AdmobResponse.class);
//        //  AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), RegistrationResponse.class);
//        String app_id = admobResponse.admobModels.get(Constant.ModelConstants.INITIAL_POSITION).video_ad_range;
//        if (app_id != null) {
//            return Integer.parseInt(app_id);
//        } else {
//            return Constant.ModelConstants.VIDEO_AD_CLICKED_RANGE;
//        }
//
//    }
//    public static int getPrefGamePlayCoinRange(Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), AdmobResponse.class);
//        //  AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), RegistrationResponse.class);
//        String game_level_range = admobResponse.admobModels.get(Constant.ModelConstants.INITIAL_POSITION).game_level_range;
//        if (game_level_range != null) {
//            return Integer.parseInt(game_level_range);
//        } else {
//            return Constant.ModelConstants.GAME_PLAY_COIN_RANGE;
//        }
//
//    }
//    public static int getPrefAdmobbannerAdRange(Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), AdmobResponse.class);
//        //  AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), RegistrationResponse.class);
//        String app_id = admobResponse.admobModels.get(Constant.ModelConstants.INITIAL_POSITION).banner_ad_range;
//        if (app_id != null) {
//            return Integer.parseInt(app_id);
//        } else {
//            return Constant.ModelConstants.BANNER_AD_CLICKED_RANGE;
//        }
//
//    }
//
//    public static String getPrefAdmobAppIdbannerid(Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), AdmobResponse.class);
//        //  AdmobResponse admobResponse = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.ADMOB_ID_KEY, ""), RegistrationResponse.class);
//        String app_id = admobResponse.admobModels.get(Constant.ModelConstants.INITIAL_POSITION).banner_id;
//        return app_id;
//    }
//
//
//
//    public static void setPrefStoreCurrentCoinsStatus(Context context, int currentCoins) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        RegistrationResponse registrationResponselocal = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.PROFILE_MODEL_KEY, ""), RegistrationResponse.class);
//        registrationResponselocal.coins = String.valueOf(currentCoins);
//        LOGD(TAG, "Current Coins:  " + registrationResponselocal.coins);
//        String json = new Gson().toJson(registrationResponselocal, RegistrationResponse.class);
//        sharedPreferences.edit().putString(Constant.ModelConstants.PROFILE_MODEL_KEY, json).commit();
//
//    }
//
//    public static void setPrefadmobCurrentidStatus(Context context, int currentCoins) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        RegistrationResponse registrationResponselocal = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.PROFILE_MODEL_KEY, ""), RegistrationResponse.class);
//        registrationResponselocal.coins = String.valueOf(currentCoins);
//        LOGD(TAG, "Current Coins:  " + registrationResponselocal.coins);
//        String json = new Gson().toJson(registrationResponselocal, RegistrationResponse.class);
//        sharedPreferences.edit().putString(Constant.ModelConstants.PROFILE_MODEL_KEY, json).commit();
//
//    }
//
//    public static void setPrefChatActivityToolTip(Context context, Boolean status) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        sharedPreferences.edit().putBoolean(Constant.ModelConstants.CHAT_ACTIVITY_TOOL_TIP, status).commit();
//
//    }
//
//    public static Boolean getPrefChatActivityToolTip(Context context) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        return sharedPreferences.getBoolean(Constant.ModelConstants.CHAT_ACTIVITY_TOOL_TIP, true);
//
//    }
//
//    public static void setPrefUserCountry(Context context, String status) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        sharedPreferences.edit().putString(Constant.ModelConstants.FRENZY_USER_COUNTRY, status).commit();
//
//    }
//
//    public static String getPrefUserCountry(Context context) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        return sharedPreferences.getString(Constant.ModelConstants.FRENZY_USER_COUNTRY,"USA");
//
//    }


}

