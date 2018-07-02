package com.example.lovekeshkumar.projectmvpbase.network;





import com.example.lovekeshkumar.projectmvpbase.model.ProfilesRequest;
import com.example.lovekeshkumar.projectmvpbase.model.RequestLogin;
import com.example.lovekeshkumar.projectmvpbase.model.RequestRegister;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * This interface to create Web-service call methods
 * Created by HP on 3/23/2017.
 */

public interface ApiInterface {

    @POST("user/register")
    Call<String> register_user(@Header("App-Identifier") String header,
                               @Body RequestRegister requestRegister);
    @POST("/user/login")
    Call<String> userLogin(
            @Header("App-Identifier") String header,
            @Body RequestLogin requestLogin);

//    @POST("updateDeviceId")
//    Call<String> updateDeviceRegId(@Body UpdateRegIdRequest updateRegIdRequest);

//    @POST("mobileRegister")
//    Call<String> postMobile(@Body RegisterMobileRequest registerMobileRequest);

//    @POST("VerifyOtp")
//    Call<String> verifyOTP(@Body RegisterMobileRequest registerMobileRequest);

//    @POST("VerifyOtpChangeMobile")
//    Call<String> verifyOtpChangeMobile(@Body RegisterMobileRequest registerMobileRequest);

//    @POST("fbRegister")
//    Call<String> registerFB(@Body FacebookRegistrationRequest facebookRegistrationRequest);

//    @POST("createProfile")
//    Call<String> updateProfile(@Body UpdateProfileRequest updateProfileRequest);

//    @POST("resendOtp")
//    Call<String> reSendOTP(@Body RegisterMobileRequest registerMobileRequest);

//    @POST("profileView")
//    Call<String> profiles(@Body ProfilesRequest profilesModel);

//    @POST("getAdmob")
//    Call<String> getadmobid(@Body AdmobRequest admobRequest);

//    @Multipart
//    @POST("upload")
//    Call<ResponseBody> upload(
//            @Part("description") RequestBody description,
//            @Part MultipartBody.Part file
//    );

//    @POST("profileViewUser")
//    Call<String> userProfileView(@Body ProfilesRequest profilesModel);

//    @POST("userAction")
//    Call<String> swipeUserActions(@Body UserSwipeRequestModel userSwipeRequestModel);
@Headers("Content-Type: application/json")
    @GET("hashtag/products/{id}")
    Call<String> gameDetailList(@Path("id") String id,  @Header("Auth-Identifier") String header);

//    @POST("coinsPayment")
//    Call<String> coinsPayment(@Body CoinsRequest gameRequest);

//    @POST("coinsLog")
//    Call<String> userCoinsLog(@Body CoinsRequest coinsRequest);

//    @POST("likeByUsers")
//    Call<String> profilesLikeByUser(@Body ProfilesRequest profilesModel);

//    @POST("profileDetails")
//    Call<String> myProfileDetail(@Body ProfilesRequest profilesModel);

//    @POST("updateProfile")
//    Call<String> userUpdateProfile(@Body ProfilesUpdateRequest profilesModel);

//    @POST("changeMobile")
//    Call<String> changeUserMobile(@Body ChangeMobileRequest mobileRequest);

//    @POST("referFriends")
//    Call<String> referFriends(@Body RefferFrdRequest refferFrdRequest);

//    @POST("coinsPurchaseLog")
//    Call<String> purchaseCoins(@Body PaymentRequest paymentRequest);

//    @POST("userBillingLogs")
//    Call<String> userBillingLogs(@Body PaymentRequest paymentRequest);

//    @POST("referFriendsCoins")
//    Call<String> referFriendsCoins(@Body ReffreCoinRequest paymentRequest);

//    @POST("getFriendsList")
//    Call<String> getFriendsList(@Body ProfilesUpdateRequest friendrquest);

//    @POST("friendStatus")
//    Call<String> friendStatus(@Body FriendStatusRequest friendrquest);

//    @POST("swapImage")
//    Call<String> swapImage(@Body ProfileModel deImage);

//    @POST("removeImage")
//    Call<String> removeImage(@Body ProfileModel deImage);

//    @POST("profileImages")
//    Call<String> profileImages(@Body ProfilesRequest request);

//    @POST("updateLocation")
//    Call<String> updateLocation(@Body LocationRequest request);

//    @POST("topicComments")
//    Call<String> topicComments(@Body TopicCommentRequest request);

//    @POST("addComment")
//    Call<String> saveComment(@Body CommentRequest request);

    @POST("topics")
    Call<String> getVideoTopic(@Body ProfilesRequest request);

//    @POST("frenzyCards")
//    Call<String> getValantineCard(@Body ValantineCardRequest request);

//    @POST("sendCard")
//    Call<String> sendValentineCard(@Body SendCardRequest request);

//    @GET
//    @Streaming
//    Call<ResponseBody> downloadFile(@Url String fileUrl);
}
