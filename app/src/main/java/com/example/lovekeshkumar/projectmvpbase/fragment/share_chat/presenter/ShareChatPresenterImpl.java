package com.example.lovekeshkumar.projectmvpbase.fragment.share_chat.presenter;


import android.content.Context;

import com.example.lovekeshkumar.projectmvpbase.activity.gaming.interactor.GameInteractorImpl;
import com.example.lovekeshkumar.projectmvpbase.activity.gaming.interactor.IGameInteractor;
import com.example.lovekeshkumar.projectmvpbase.fragment.share_chat.view.IChatShareView;
import com.example.lovekeshkumar.projectmvpbase.model.ChatShareDataResponse;
import com.example.lovekeshkumar.projectmvpbase.model.CommonMethod;
import com.example.lovekeshkumar.projectmvpbase.network.ErrorModel;
import com.example.lovekeshkumar.projectmvpbase.utility.Utility;

import java.util.ArrayList;

import retrofit2.Response;

import static com.example.lovekeshkumar.projectmvpbase.utility.LogUtils.LOGD;
import static com.example.lovekeshkumar.projectmvpbase.utility.LogUtils.makeLogTag;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public class ShareChatPresenterImpl implements IShareChatPresenter {
    IChatShareView iShareChateView;
    IGameInteractor gameInteractor;
    Utility utility;
    private static final String TAG = makeLogTag(ShareChatPresenterImpl.class);

    public ShareChatPresenterImpl(IChatShareView iShareChateView, GameInteractorImpl gameInteractor, Utility utility) {
        this.iShareChateView = iShareChateView;
        this.gameInteractor = gameInteractor;
        this.utility = utility;
        //gameInteractor.getGameList(this);
    }

    public ShareChatPresenterImpl(IChatShareView iShareChateView, Utility utility) {
        this.iShareChateView = iShareChateView;
        this.utility = utility;
        sucessListCall(CommonMethod.getStaticDisplayList());
    }


    @Override
    public void sucessListCall(ArrayList<ChatShareDataResponse> chatShareDataResponses) {
        if (iShareChateView != null) {
            iShareChateView.bindDataOnView(chatShareDataResponses);
        } else {
            // TODO: 7/13/2018 call Toast If No Data Are there
            //  iShareChateView.bindDataOnView(chatShareDataResponses);
        }
    }

    @Override
    public Context getContext() {
        if (iShareChateView != null) {
            return iShareChateView.getContext();
        } else {
            return null;
        }
    }

    @Override
    public void onSuccessRedirection(Response object, int taskID) {

        if (!utility.isNetworkAvailable()) {
            return;
        }
        if (iShareChateView != null) {
            iShareChateView.hideProgress();
        }

        LOGD(TAG, "message::" + object.message());
        LOGD(TAG, "body::" + object.body());
//        RegistrationRsponse gameResponses = new Gson().fromJson((String) object.body(), RegistrationRsponse.class);
//        if (gameResponses != null
//                ) {
//            iShareChateView.bindDataOnView(gameResponses);
//        }

    }

    @Override
    public void onServerErrorRedirection(ErrorModel errorModel, int taskID) {
        LOGD(TAG, "errorModel::" + errorModel.error_message);
        LOGD(TAG, "errorModel::" + errorModel.error_code);

    }

    @Override
    public void onFailureRedirection(ErrorModel errorModel) {
        LOGD(TAG, "errorModel::" + errorModel.error_message);
        LOGD(TAG, "errorModel::" + errorModel.error_code);
    }
}
