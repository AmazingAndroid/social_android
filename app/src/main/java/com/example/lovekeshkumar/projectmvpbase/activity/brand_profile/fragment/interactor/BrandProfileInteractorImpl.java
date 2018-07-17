package com.example.lovekeshkumar.projectmvpbase.activity.brand_profile.fragment.interactor;



import android.media.MediaPlayer;

import com.example.lovekeshkumar.projectmvpbase.activity.Greetings.presenter.AudioPresenterImpl;

import java.io.IOException;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public class BrandProfileInteractorImpl implements IBrandProfileInteractor {
   /* @Override
    public void getAllCounty(MainPresenterImpl homePresenter) {
        Observable<Country> observer = ApiClient.getClient("http://services.groupkt.com/").create(ApiServices.class).getAllCountry();
        observer.subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(homePresenter::onSuccess, homePresenter::onError);
    }*/
//    NetworkManager networkManager;
//    @Override
//    public void getVideoList(MainPresenterImpl homePresenter) {
//        ProfilesRequest profilesRequest=new ProfilesRequest();
//        profilesRequest.chatId="10000118";
//        networkManager=NetworkManager.get(homePresenter.getContext(),homePresenter);
//        networkManager.getVideoTopic(profilesRequest, Constant.VIDEO_LIST_TASK_ID);
//    }

    @Override
    public void startAudio(String audioURL,MediaPlayer mediaPlayer, AudioPresenterImpl audioPresenter) {
        try {


            mediaPlayer.setDataSource(audioURL);

            mediaPlayer.prepare();

        }
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        mediaPlayer.start();
        audioPresenter.onSuccess();
    }

    @Override
    public void stopAudio(MediaPlayer mediaPlayer, AudioPresenterImpl audioPresenter) {
        mediaPlayer.stop();
        audioPresenter.onSuccess();
    }
}