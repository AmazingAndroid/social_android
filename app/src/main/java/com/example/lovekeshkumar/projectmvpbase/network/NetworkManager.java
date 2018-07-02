package com.example.lovekeshkumar.projectmvpbase.network;

import android.content.Context;
import android.net.ParseException;
import android.util.Log;


import com.example.lovekeshkumar.projectmvpbase.model.BaseResult;
import com.example.lovekeshkumar.projectmvpbase.model.ProfilesRequest;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;
import com.google.gson.Gson;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by HP on 3/23/2017.
 * The class will handle all the implementations related to the login operations
 */
public class NetworkManager implements ServiceCallback {

    public static final String TAG = NetworkManager.class.getSimpleName();
    static NetworkManager networkManager;
    /**
     * 401 response code is when only Access Token is expired
     * <p>
     * 400 response code has 2 cases:-
     * a) When Refresh Token is Expired, in that case error body will be
     * {"error":"invalid_grant"}
     * b) When wrong data input by user, in that case error body will be
     * {"error":"invalid_grant","error_description":"The user name or password is incorrect or credentials registered with different device."}
     */

    Context context;
    CommunicationManager commObj;
    ServiceRedirection serviceRedirectionObj;
    Utility utility;
    int tasksID;
    Object requestObj;
    int lastTaskId; // Used when previous web service will be called with new AccessToken
    //Retrofit Interface
    ApiInterface apiService;

    /**
     * Constructor
     *
     * @param contextObj                 The Context from where the method is called
     * @param successRedirectionListener The listener interface for receiving action events
     * @return none
     */
    private NetworkManager(Context contextObj, ServiceRedirection successRedirectionListener) {
        context = contextObj;
        serviceRedirectionObj = successRedirectionListener;
        utility = Utility.getInstance(contextObj);
        apiService = ApiClient.createService(ApiInterface.class);

    }

    public static NetworkManager get(Context contextObj, ServiceRedirection successRedirectionListener) {
        return networkManager == null ? new NetworkManager(contextObj, successRedirectionListener) : networkManager;
    }

    /**
     * Calls the Web Service of Update Profile
     *
     * @return none
     */
//    public void updateDeviceRegId(UpdateRegIdRequest updateRegIdRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.updateDeviceRegId(updateRegIdRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

    /**
     * Calls the Web Service of authenticateLogin
     *
     * @return none
     */
//    public void authenticateMobileLogin(RegisterMobileRequest registerMobileRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.postMobile(registerMobileRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

    /**
     * Calls the Web Service of Verify Login
     *
     * @return none
     */
//    public void verifyOTP(RegisterMobileRequest registerMobileRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.verifyOTP(registerMobileRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void verifyOtpChangeMobile(RegisterMobileRequest registerMobileRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.verifyOtpChangeMobile(registerMobileRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

    /**
     * Calls the Web Service of Facebook Login
     *
     * @return none
     */
//    public void registerFacebook(FacebookRegistrationRequest facebookRegistrationRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.registerFB(facebookRegistrationRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

    /**
     * Calls the Web Service of Update Profile
     *
     * @return none
     */
//    public void updateProfile(UpdateProfileRequest updateProfileRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.updateProfile(updateProfileRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

    /***
     * Resend OTP
     * @param registerMobileRequest
     * @param tasksID
     */
//    public void reSendOTP(RegisterMobileRequest registerMobileRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.reSendOTP(registerMobileRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

    /***
     * User action on Swipe
     * @param userSwipeRequestModel
     * @param tasksID
     */
//    public void swipeUserActions(UserSwipeRequestModel userSwipeRequestModel, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.swipeUserActions(userSwipeRequestModel);
//        commObj.callWebService(this, tasksID, call);
//    }

    /***
     * Get other user's profile
     * @param tasksID
     */
//    public void profiles(ProfilesRequest profilesModel, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.profiles(profilesModel);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void getadmobid(AdmobRequest admobRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.getadmobid(admobRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void profilesLikeByUser(ProfilesRequest profilesModel, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.profilesLikeByUser(profilesModel);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void userProfileView(ProfilesRequest profilesRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.userProfileView(profilesRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void myProfileDetail(ProfilesRequest profilesModel, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.myProfileDetail(profilesModel);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void userUpdateProfile(ProfilesUpdateRequest profilesUpdateRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.userUpdateProfile(profilesUpdateRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void changeUserMobile(ChangeMobileRequest mobileRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.changeUserMobile(mobileRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void referFriends(RefferFrdRequest mobileRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.referFriends(mobileRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void downloadFile(String fileUrl, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<ResponseBody> call = apiService.downloadFile(fileUrl);
//        commObj.callWebService(this, tasksID, call);
//    }


    /**
     * The interface method implemented in the java files
     *
     * @param data       the result returned by the web service
     * @param tasksID    the ID to differential multiple webservice calls
     * @param statusCode the statusCode returned by the web service
     * @param message    the message returned by the web service
     * @return none
     * @since 2014-08-28
     */
    @Override
    public void onResult(Response data, int tasksID, int statusCode, String message, Throwable t) {

        if (data != null) {
            if (statusCode == ResponseCodes.Success) {
                // Print Server Json Response

                serviceRedirectionObj.onSuccessRedirection(data, tasksID);

            } else {
                // Server communication Errors(400,401,404,500 etc.)


                ErrorModel errorModel = new ErrorModel();
                errorModel.error_code = statusCode;
                if (data != null && data.body() != null) {
                    BaseResult baseResult = new Gson().fromJson((String) data.body(), BaseResult.class);
                    if (baseResult != null) {
                        errorModel.error_message = baseResult.message;
                    } else
                        errorModel.error_message = "Error Code" + statusCode + ":" + "Something went wrong.";

                } else
                    errorModel.error_message = "Something went wrong. Error code" + errorModel.error_code;
                serviceRedirectionObj.onServerErrorRedirection(errorModel, tasksID);
            }
        } else {
            // Java Exceptions
            serviceRedirectionObj.onFailureRedirection(setUpJavaError(statusCode, t));
        }
    }

    // Handling Java Exceptions
    private ErrorModel setUpJavaError(int statusCode, Throwable t) {
        Log.e(TAG, "setUpError statusCode: " + "statusCode");
        ErrorModel errorModel = new ErrorModel();
        // Exception comes by Java
        if (t instanceof SocketTimeoutException) {
            errorModel.error_code = ResponseCodes.SERVER_TIMEOUT_EXCEPTION;
            errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
        } else if (t instanceof TimeoutException) {
            errorModel.error_code = ResponseCodes.URL_CONNECTION_ERROR;
            errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
        } else if (t instanceof ClassCastException) {
            errorModel.error_code = ResponseCodes.MODEL_TYPE_CAST_EXCEPTION;
            errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
        } else if (t instanceof ParseException) {
            errorModel.error_code = ResponseCodes.MODEL_TYPE_CAST_EXCEPTION;
            errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
        } else {
            errorModel.error_code = statusCode;
            errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
        }
        return errorModel;
    }

//    private void uploadFile(Uri fileUri) {
//        // create upload service client
//        FileUploadService service =
//                ServiceGenerator.createService(FileUploadService.class);
//
//        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
//        // use the FileUtils to get the actual file by uri
//        File file = FileUtils.getFile(this, fileUri);
//
//        // create RequestBody instance from file
//        RequestBody requestFile =
//                RequestBody.create(
//                        MediaType.parse(context.getContentResolver().getType(fileUri)),
//                        file
//                );
//
//        // MultipartBody.Part is used to send also the actual file name
//        MultipartBody.Part body =
//                MultipartBody.Part.createFormData("picture", file.getName(), requestFile);
//
//        // add another part within the multipart request
//        String descriptionString = "hello, this is description speaking";
//        RequestBody description =
//                RequestBody.create(
//                        okhttp3.MultipartBody.FORM, descriptionString);
//
//        // finally, execute the request
//        Call<ResponseBody> call = service.upload(description, body);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call,
//                                   Response<ResponseBody> response) {
//                Log.v("Upload", "success");
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e("Upload error:", t.getMessage());
//            }
//        });
//    }


    public void gameDetailList(String id,String auth ,int tasksID) {
        commObj = new CommunicationManager();
        this.tasksID = tasksID;
        Call<String> call = apiService.gameDetailList(id,auth);
        commObj.callWebService(this, tasksID, call);
    }

//    public void coinsPayment(CoinsRequest gameRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.coinsPayment(gameRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void userCoinsLog(CoinsRequest coinsRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.userCoinsLog(coinsRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void purchaseCoins(PaymentRequest paymentRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.purchaseCoins(paymentRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void userBillingLogs(PaymentRequest paymentRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.userBillingLogs(paymentRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void referFriendsCoins(ReffreCoinRequest reffreCoinRequest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.referFriendsCoins(reffreCoinRequest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void getFriendsList(ProfilesUpdateRequest friendrquest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.getFriendsList(friendrquest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void friendStatus(FriendStatusRequest friendrquest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.friendStatus(friendrquest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void swapImage(ProfileModel friendrquest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.swapImage(friendrquest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void removeImage(ProfileModel friendrquest, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.removeImage(friendrquest);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void profileImages(ProfilesRequest request, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.profileImages(request);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void updateLocation(LocationRequest request, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.updateLocation(request);
//        commObj.callWebService(this, tasksID, call);
//    }

// public void topicComments(CommentRequest request, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.topicComments(request);
//        commObj.callWebService(this, tasksID, call);
//    }
//    public void topicComments(TopicCommentRequest request, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.topicComments(request);
//        commObj.callWebService(this, tasksID, call);
//    }

//    public void saveComment(CommentRequest request, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.saveComment(request);
//        commObj.callWebService(this, tasksID, call);
//    }

 public void getVideoTopic(ProfilesRequest request, int tasksID) {
        commObj = new CommunicationManager();
        this.tasksID = tasksID;
        Call<String> call = apiService.getVideoTopic(request);
        commObj.callWebService(this, tasksID, call);
    }

// public void getValantineCard(ValantineCardRequest request, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.getValantineCard(request);
//        commObj.callWebService(this, tasksID, call);
//    }
//    public void sendValentineCard(SendCardRequest request, int tasksID) {
//        commObj = new CommunicationManager();
//        this.tasksID = tasksID;
//        Call<String> call = apiService.sendValentineCard(request);
//        commObj.callWebService(this, tasksID, call);
//    }


}