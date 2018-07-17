package com.example.lovekeshkumar.projectmvpbase.model;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * Created by admin on 6/9/2017.
 */
/*8EA2AB1D9EF2C03075849BBD9A153F6A*/
@SuppressWarnings("ALL")
public class CommonMethod  {

    ProgressDialog progressDialog;

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        // boolean s=activeNetworkInfo.isFailover();
        // boolean s1=activeNetworkInfo.isAvailable();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static int alt_tabs(Context cont) {
        int alt;
        int dx, dy;
        DisplayMetrics metrics = cont.getResources().getDisplayMetrics();
        dx = metrics.widthPixels;
        dy = metrics.heightPixels;
        if (dx < dy)
            alt = dy / 15;
        else
            alt = dy / 10;

        return alt;
    }




    public static String getDurationForMediaPlayer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";
        String minuteString = "";
        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        int milli_seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        if (minutes < 10) {
            minuteString = "0" + minutes;
        } else {
            minuteString = "" + minutes;
        }
        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minuteString + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }

    @NonNull
    public static String getCurrentPosition(long currentPos) {
        String minuteString, secString;
        long min = TimeUnit.MILLISECONDS.toMinutes(currentPos);
        long sec = TimeUnit.MILLISECONDS.toSeconds(currentPos) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentPos));

        if (min < 10) {
            minuteString = "0" + min;
        } else {
            minuteString = "" + min;
        }
        // Prepending 0 to seconds if it is one digit
        if (sec < 10) {
            secString = "0" + sec;
        } else {
            secString = "" + sec;
        }
        return minuteString + ":" + secString;
    }



    public static boolean isServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static String getUserPrimaryEmail(Context context) {
        String possibleEmail = null;
        Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
        Account[] accounts = AccountManager.get(context).getAccounts();
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                possibleEmail = account.name;

            }
        }
        return possibleEmail;
    }

    public static String getUsername(Context context) {
        AccountManager manager = AccountManager.get(context);
        Account[] accounts = manager.getAccountsByType("com.google");
        List<String> possibleEmails = new LinkedList<String>();

        for (Account account : accounts) {
            // TODO: Check possibleEmail against an email regex or treat
            // account.name as an email address only for certain account.type values.
            possibleEmails.add(account.name);
        }

        if (!possibleEmails.isEmpty() && possibleEmails.get(0) != null) {
            String email = possibleEmails.get(0);
            String[] parts = email.split("@");

            if (parts.length > 1)
                return parts[0];
        }
        return null;
    }




    /**
     * Get the system status bar height
     *
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static String getPath(Uri uri, Context context) {
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = context.getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }

    public static String createValue(String key, String value) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(key, value);

            Log.d("output", jsonObject.toString(1));
            return jsonObject.toString(1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getAddress(Context context, double lat, double lng) {
        String add = null;
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            Log.v("IGA", "Address" + addresses.size());
            Address obj = addresses.get(0);

            add = obj.getLocality();
            //  add = add + "\n" + obj.getSubThoroughfare();

            Log.v("IGA", "Address" + add);
//            Toast.makeText(
//                    context,
//                    "Mobile Location (NW): " + add,
//                    Toast.LENGTH_LONG).show();
            return add;
        } catch (IOException e) {
            e.printStackTrace();
            //  Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            //   Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            //   Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return "";
    }


    public static String getFormattedDate(long smsTimeInMilis) {
        Calendar smsTime = Calendar.getInstance();
        smsTime.setTimeInMillis(smsTimeInMilis);

        Calendar now = Calendar.getInstance();

        final String timeFormatString = "h:mm aa";                     // e.g. 02:30 AM
        final String dateTimeFormatString = "EEEE, MMMM d, h:mm aa";   //e.g. Friday, MAarch 02, 02:30 AM
        final String dateTimeFormatString2 = "MMMM d, h:mm aa";        //e.g. MAarch 02, 02:30 AM
        final String yearFormatString = "MMM dd yyyy, h:mm aa";        //e.g. Jan 02 2016, 02:30 AM
        final String yearFormatString2 = "MMMM dd yyyy, h:mm aa";      //e.g. January 02 2016, 02:30 AM
        final long HOURS = 60 * 60 * 60;
        if (now.get(Calendar.DATE) == smsTime.get(Calendar.DATE)) {
            return DateFormat.format(timeFormatString, smsTime) + " Today";
        } else if (now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) == 1) {
            return DateFormat.format(timeFormatString, smsTime) + " Yesterday";
        }/*else if(now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) > 1 && now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) < 7){
            return DateFormat.format(dateTimeFormatString, smsTime).toString()+" This week";
        }*/
        /*else if(now.get(Calendar.YEAR) == smsTime.get(Calendar.YEAR)){
            return DateFormat.format(dateTimeFormatString, smsTime).toString();
        }*/
        else if (now.get(Calendar.YEAR) == smsTime.get(Calendar.YEAR)) {
            return DateFormat.format(dateTimeFormatString2, smsTime).toString();
        } else
            return DateFormat.format(yearFormatString, smsTime).toString();
    }

    public static Bitmap getRoundedCroppedBitmap(Bitmap bitmap, int radius) {
        Bitmap finalBitmap;
        if (bitmap.getWidth() != radius || bitmap.getHeight() != radius)
            finalBitmap = Bitmap.createScaledBitmap(bitmap, radius, radius,
                    false);
        else
            finalBitmap = bitmap;
        Bitmap output = Bitmap.createBitmap(finalBitmap.getWidth(),
                finalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, finalBitmap.getWidth(),
                finalBitmap.getHeight());

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        canvas.drawCircle(finalBitmap.getWidth() / 2 + 0.7f,
                finalBitmap.getHeight() / 2 + 0.7f,
                finalBitmap.getWidth() / 2 + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(finalBitmap, rect, rect, paint);

        return output;
    }



    public static String getFormattedDate2(long smsTimeInMilis) {
        Calendar smsTime = Calendar.getInstance();
        smsTime.setTimeInMillis(smsTimeInMilis);

        Calendar now = Calendar.getInstance();

        final String timeFormatString = "h:mm aa";                     // e.g. 02:30 AM
        final String dateTimeFormatString = "EEEE, MMMM d, h:mm aa";   //e.g. Friday, MAarch 02, 02:30 AM
        final String dateTimeFormatString2 = "MMM d, h:mm aa";        //e.g. MAarch 02, 02:30 AM
        final String dateTimeFormatString3 = "MMM d";
        final String yearFormatString = "MMM dd yyyy, h:mm aa";        //e.g. Jan 02 2016, 02:30 AM
        final String yearFormatString2 = "MMMM dd yyyy, h:mm aa";
        final String yearFormatString3 = "MMM dd yyyy"; //e.g. January 02 2016, 02:30 AM
        final long HOURS = 60 * 60 * 60;
        if (now.get(Calendar.DATE) == smsTime.get(Calendar.DATE)) {
            return DateFormat.format(timeFormatString, smsTime).toString();
        } else if (now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) == 1) {
            return /*DateFormat.format(timeFormatString, smsTime).toString()*/"Yesterday";
        }/*else if(now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) > 1 && now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) < 7){
            return DateFormat.format(dateTimeFormatString, smsTime).toString()+" This week";
        }*/
        /*else if(now.get(Calendar.YEAR) == smsTime.get(Calendar.YEAR)){
            return DateFormat.format(dateTimeFormatString, smsTime).toString();
        }*/
        else if (now.get(Calendar.YEAR) == smsTime.get(Calendar.YEAR)) {
            return DateFormat.format(dateTimeFormatString3, smsTime).toString();
        } else
            return DateFormat.format(yearFormatString3, smsTime).toString();
    }


    public static String getFormattedDate3(long smsTimeInMilis) {
        Calendar smsTime = Calendar.getInstance();
        smsTime.setTimeInMillis(smsTimeInMilis);

        Calendar now = Calendar.getInstance();

        final String timeFormatString = "h:mm aa";                     // e.g. 02:30 AM
        final String dateTimeFormatString = "EEEE, MMMM d, h:mm aa";   //e.g. Friday, MAarch 02, 02:30 AM
        final String dateTimeFormatString2 = "MMMM d, h:mm aa";        //e.g. MAarch 02, 02:30 AM
        final String yearFormatString = "MMM dd yyyy, h:mm aa";        //e.g. Jan 02 2016, 02:30 AM
        final String yearFormatString2 = "MMMM dd yyyy, h:mm aa";      //e.g. January 02 2016, 02:30 AM
        final String yearFormatString3 = "MMM dd yyyy";                //e.g Jan 02 2016
        final long HOURS = 60 * 60 * 60;
        if (now.get(Calendar.DATE) == smsTime.get(Calendar.DATE)) {
            return DateFormat.format(timeFormatString, smsTime).toString();
        } else if (now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) == 1) {
            return "Yesterday";
        }/*else if(now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) > 1 && now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) < 7){
            return DateFormat.format(dateTimeFormatString, smsTime).toString()+" This week";
        }*/
        /*else if(now.get(Calendar.YEAR) == smsTime.get(Calendar.YEAR)){
            return DateFormat.format(dateTimeFormatString, smsTime).toString();
        }*/
       /* else if (now.get(Calendar.YEAR) == smsTime.get(Calendar.YEAR)) {
            return DateFormat.format(yearFormatString3, smsTime).toString();
        }*/
        else
            return DateFormat.format(yearFormatString3, smsTime).toString();
    }
   /* public static void saveMessage(final ChatMessage chatMessage, boolean isAsync){

        if(isAsync){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    chatMessage.setMessageId(String.valueOf(DbHelper.getInstance(getApplicationContext()).saveMessage(chatMessage)));
                    saveChat(chatMessage.getMessage(),chatMessage.getTimestamp());
                }
            }).start();
        }else{
            chatMessage.setMessageId(String.valueOf(DbHelper.getInstance(Frenzy.getInstance().getApplicationContext()).saveMessage(chatMessage)));
        }

    }
    static void saveChat(Chat chat, ChatMessage chatMessage){

        chat.setWith_user_id( );
        chat.setWith_user_name( );
        chat.setLast_chat_msg(lastMessage);
        chat.setLast_chat_msg_time(lastMessageTime);
        DbHelper.getInstance(getApplicationContext()).saveChat(chat);
    }*/




    public static void animation1(View mLogo) {
        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(mLogo, "scaleX", 5.0F, 1.0F);
        scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleXAnimation.setDuration(1200);
        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(mLogo, "scaleY", 5.0F, 1.0F);
        scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleYAnimation.setDuration(1200);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(mLogo, "alpha", 0.0F, 1.0F);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(1200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
        animatorSet.setStartDelay(500);
        animatorSet.start();
    }





    public static String getYouTubeId(String url) {
        String[] parts = url.split("=");
        String part1 = parts[0]; // 004
        String part2 = parts[1]; // 034556
        return part2;
    }

    public static String getYouTubeImage(String url) {
        String video_id = getYouTubeId(url);
        String Image_url = callImageEvent(video_id);
        return Image_url;
    }

    private static String callImageEvent(String video_id) {
        return "https://img.youtube.com/vi/" + video_id + "/0.jpg";
    }


    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }



    public static boolean isValidPhoneNumber(String phoneNumber) {
        return !TextUtils.isEmpty(phoneNumber) && android.util.Patterns.PHONE.matcher(phoneNumber).matches();
    }
//    public static void animation2(View mLogo, Context context) {
//        mLogo.setAlpha(1.0F);
//        Animation anim = AnimationUtils.loadAnimation(context, R.anim.translate_top_to_center);
//        mLogo.startAnimation(anim);
//    }
//
//    public static void animationfromlefttoright(View mLogo, Context context) {
//        mLogo.setAlpha(1.0F);
//        Animation anim = AnimationUtils.loadAnimation(context, R.anim.frombelow);
//        mLogo.startAnimation(anim);
//    }
//
//    public static void animationfromrighttoleft(View mLogo, Context context) {
//        mLogo.setAlpha(1.0F);
//        Animation anim = AnimationUtils.loadAnimation(context, R.anim.activity_close_translate);
//        mLogo.startAnimation(anim);
//    }
//
//    public static void animation3(View view) {
//        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(view, "alpha", 0.0F, 1.0F);
//        alphaAnimation.setStartDelay(1700);
//        alphaAnimation.setDuration(500);
//        alphaAnimation.start();
//    }

    public static String changeStringDateFormat(String startDateString) {
        java.text.DateFormat df = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        Date journeyDate = null;
        try {
            journeyDate = df.parse(startDateString);
            String newDateString = df.format(journeyDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return startDateString;
    }



//    public static void showCustomToast(final Activity context, String Message) {
//        Toast toast = new Toast(context);
//        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.toast_custom_layout, null);
//        if (view != null) {
//            TextView textView = (TextView) view.findViewById(R.id.toastmessage);
//            textView.setText(Message);
//        }
//        toast.setView(view);
//        toast.show();
//    }

    public static void closeKeyboard(Context context, View view) {
        if (view != null) {
            //Clear all the focuses from the views, so as to avoid any issues with hiding keyboard in
            //like android 4.1
            view.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static int getPixel(Context context, int dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return ((int) (dp * metrics.density));
    }

    public static boolean copyTextToClipboard(Context context, String text, int labelResId) {
        ClipboardManager mClipBoardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        String label = context.getResources().getString(labelResId);
        if (mClipBoardManager != null) {
            ClipData mClipData = ClipData.newPlainText(label, text);
            mClipBoardManager.setPrimaryClip(mClipData);
            return true;
        }
        return false;
    }

    public static boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    //Returns a loading indicator dialog
    public static ProgressDialog getSpinningProgressDialog(Context context, String message,
                                                           boolean cancelable) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(cancelable);
        progressDialog.setMessage(message);
        return progressDialog;
    }

    public static File getVideosStorageDir(String VidPath) {
        // Get the directory for the user's public videos directory.
        File f = new File(Environment.getExternalStorageDirectory(), VidPath);
        // Create the storage directory if it does not exist
        if (!f.exists()) {
            if (!f.mkdirs()) {
                // Log.d("CommomMethod",
                //    "failed to create directory. Pls check if app has permission to write and read.");
            }
        }
        return f;
    }

    public static File getVideosThumbStorageDir(String VidPath) {
        // Get the directory for the user's public pictures directory.
        File f = new File(Environment.getExternalStorageDirectory(), VidPath
                + "/.thumbnails");
        // Create the storage directory if it does not exist
        if (!f.exists()) {
            if (!f.mkdirs()) {
                //Log.d("CommomMethod",
                //        "failed to create directory. Pls check if app has permission to write and read.");
            }
        }
        return f;
    }

    public static boolean toBoolean(String s) {
        try {
            return Boolean.parseBoolean(s); // Successfully converted String to boolean
        } catch (Exception e) {
            return false;
        }
    }

    public static String checknullJSON(JSONObject jsonObject, String checkString) {
        try {
            String myvalue;
            if (jsonObject.isNull(checkString)) {
                // Toast.makeText(this, "Cannot Convert!!", Toast.LENGTH_LONG).show();
                //float set to 0
                myvalue = checkString + " data no available";
                return myvalue;
            } else {
                myvalue = jsonObject.getString(checkString);

                return myvalue;
            }
            // Float.valueOf(jsonObject.getString("AverageRating"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }




    public static String removeSpecialChar(String phone) {
        if (phone.contains("-")) {
            phone = phone.replaceAll("[ ]?-[ ]?", "");
        }
        return phone;
    }

    public static String printKeyHash(Activity context) {
        PackageInfo packageInfo;
        String key = null;
        try {
            //getting application package name, as defined in manifest
            String packageName = context.getApplicationContext().getPackageName();

            //Retriving package info
            packageInfo = context.getPackageManager().getPackageInfo(packageName,
                    PackageManager.GET_SIGNATURES);

            Log.e("Package Name=", context.getApplicationContext().getPackageName());

            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = new String(Base64.encode(md.digest(), 0));
                // String key = new String(Base64.encodeBytes(md.digest()));
                Log.e("Key Hash=", key);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("Name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("No such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }

        return key;
    }

    public static void dialogeNormalType(Activity activity, String title, String message) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (!activity.isDestroyed()) { // or call isFinishing() if min sdk version < 17
                showNormal(activity, title, message);
            }

        } else {
            if (!activity.isFinishing()) {
                showNormal(activity, title, message);
            }
        }

    }

    public static int genrateRandaomNumber() {
        Random r = new Random();
        int i1 = r.nextInt(10 - 3) + 3;
        return i1;
    }

    public static String removeSpecialCharacter(String name) {
        String result = name.replaceAll("[-+.^:,%'&#@*$]", "");
        return result;
    }

    public static void showNormal(Activity activity, String title, String message) {
        new SweetAlertDialog(activity, SweetAlertDialog.NORMAL_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .show();
    }

    public static void dialogeInformationType(Activity activity, String title, String message) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (!activity.isDestroyed()) { // or call isFinishing() if min sdk version < 17
                showInfo(activity, title, message);
            }

        } else {
            if (!activity.isFinishing()) {
                showInfo(activity, title, message);
            }
        }

    }

//    public static void storeCurrentCoinsStatus(int currentCoins, Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        RegistrationResponse registrationResponselocal = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.PROFILE_MODEL_KEY, ""), RegistrationResponse.class);
//        registrationResponselocal.coins = String.valueOf(currentCoins);
//        String json = new Gson().toJson(registrationResponselocal, RegistrationResponse.class);
//        sharedPreferences.edit().putString(Constant.ModelConstants.PROFILE_MODEL_KEY, json).commit();
//
//    }

//    public static void storeDefaultImage(String  selectedImage, Context context) {
//
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        RegistrationResponse registrationResponselocal = new Gson().fromJson(sharedPreferences.getString(Constant.ModelConstants.PROFILE_MODEL_KEY, ""), RegistrationResponse.class);
//        registrationResponselocal.image = selectedImage;
//        String json = new Gson().toJson(registrationResponselocal, RegistrationResponse.class);
//        sharedPreferences.edit().putString(Constant.ModelConstants.PROFILE_MODEL_KEY, json).commit();
//
//    }

    public static void dialogeInformationTypeWithoutSuccess(Activity activity, String title, String message) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (!activity.isDestroyed()) { // or call isFinishing() if min sdk version < 17
                showInfo(activity, title, message);
            }

        } else {
            if (!activity.isFinishing()) {
                showInfo(activity, title, message);
            }
        }

    }


    public static void showInfo(Activity activity, String title, String message) {
        new SweetAlertDialog(activity, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .show();
    }


    public static void dialogeWarningType(Activity activity, String title, String message, String btntext) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (!activity.isDestroyed()) { // or call isFinishing() if min sdk version < 17
                showWarning(activity, title, message, btntext);
            }

        } else {
            if (!activity.isFinishing()) {
                showWarning(activity, title, message, btntext);
            }
        }


    }

    public static void showWarning(Activity activity, String title, String message, String btntext) {
        new SweetAlertDialog(activity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .setConfirmText(btntext)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                    }
                })
                .show();
    }





    public static void dialogewithCustomImage(Context context, String title, String message, int resourcs_id) {
        new SweetAlertDialog(context, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText(title)
                .setContentText(message)
                .setCustomImage(resourcs_id)
                .show();

    }

//    public static Bitmap blur(Bitmap image, Context context) {
//        if (null == image) return null;
//
//        Bitmap outputBitmap = Bitmap.createBitmap(image);
//        final RenderScript renderScript = RenderScript.create(context);
//        Allocation tmpIn = Allocation.createFromBitmap(renderScript, image);
//        Allocation tmpOut = Allocation.createFromBitmap(renderScript, outputBitmap);
//
////Intrinsic Gausian blur filter
//        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
//        theIntrinsic.setRadius(Constant.BLUR_RADIUS);
//        theIntrinsic.setInput(tmpIn);
//        theIntrinsic.forEach(tmpOut);
//        tmpOut.copyTo(outputBitmap);
//        return outputBitmap;
//    }



    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else {
            return false;
        }
    }

    public static void trimCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void open(String msg, Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setMessage(msg);

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
              /*  Intent i = new Intent(History.this, DrawerActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();*/
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void showDialog(ProgressDialog progressDialog, Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Submitting Request!");
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
    }

    public void dismissDialog(ProgressDialog progressDialog) {
        progressDialog.dismiss();
    }

    public static ArrayList<ChatShareDataResponse> getStaticDisplayList() {
        ArrayList<ChatShareDataResponse> chatShareDataResponses=new ArrayList<>();
        chatShareDataResponses.add(new ChatShareDataResponse("http://pengaja.com/uiapptemplate/avatars/0.jpg","Isaac Reid",false));
        chatShareDataResponses.add(new ChatShareDataResponse("http://pengaja.com/uiapptemplate/avatars/1.jpg","Isaac Reid",false));
        chatShareDataResponses.add(new ChatShareDataResponse("http://pengaja.com/uiapptemplate/avatars/2.jpg","Isaac Reid",false));
        chatShareDataResponses.add(new ChatShareDataResponse("http://pengaja.com/uiapptemplate/avatars/3.jpg","Isaac Reid",false));
        chatShareDataResponses.add(new ChatShareDataResponse("http://pengaja.com/uiapptemplate/avatars/4.jpg","Isaac Reid",false));
        chatShareDataResponses.add(new ChatShareDataResponse("http://pengaja.com/uiapptemplate/avatars/5.jpg","Isaac Reid",false));
        chatShareDataResponses.add(new ChatShareDataResponse("http://pengaja.com/uiapptemplate/avatars/6.jpg","Isaac Reid",false));
        chatShareDataResponses.add(new ChatShareDataResponse("http://pengaja.com/uiapptemplate/avatars/7.jpg","Isaac Reid",false));
        chatShareDataResponses.add(new ChatShareDataResponse("http://pengaja.com/uiapptemplate/avatars/8.jpg","Isaac Reid",false));
        chatShareDataResponses.add(new ChatShareDataResponse("http://pengaja.com/uiapptemplate/avatars/9.jpg","Isaac Reid",false));


        return chatShareDataResponses;



    }

    public static ArrayList<StoreDataModel> getStaticListProduct() {
        ArrayList<StoreDataModel> mCountryList=new ArrayList<>();
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/0.jpg", "00:09:10", false, "warbyparker", "coley", "crystal", "$95", "$92.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/0.jpg", "00:09:10", false, "warbyparker", "coley", "crystal", "$95", "$92.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/1.jpg", "00:02:10", false, "jet", "reese’s pean...", "", "$10.99", "$9.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/2.jpg", "00:05:45", false, "warbyparker", "Chamberlain", "Mission Clay...", "$95", "$92.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/3.jpg", "00:01:40", false, "warbyparker", "Evvy", "Moonstone", "$95", "$92.99", true));

        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/0.jpg", "00:09:10", false, "warbyparker", "coley", "crystal", "$95", "$92.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/0.jpg", "00:09:10", false, "warbyparker", "coley", "crystal", "$95", "$92.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/1.jpg", "00:02:10", false, "jet", "reese’s pean...", "", "$10.99", "$9.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/2.jpg", "00:05:45", false, "warbyparker", "Chamberlain", "Mission Clay...", "$95", "$92.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/3.jpg", "00:01:40", false, "warbyparker", "Evvy", "Moonstone", "$95", "$92.99", true));

        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/0.jpg", "00:09:10", false, "warbyparker", "coley", "crystal", "$95", "$92.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/0.jpg", "00:09:10", false, "warbyparker", "coley", "crystal", "$95", "$92.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/1.jpg", "00:02:10", false, "jet", "reese’s pean...", "", "$10.99", "$9.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/2.jpg", "00:05:45", false, "warbyparker", "Chamberlain", "Mission Clay...", "$95", "$92.99", true));
        mCountryList.add(new StoreDataModel("http://pengaja.com/uiapptemplate/avatars/3.jpg", "00:01:40", false, "warbyparker", "Evvy", "Moonstone", "$95", "$92.99", true));

        return mCountryList;
    }

    //Google Aanalytics






}
