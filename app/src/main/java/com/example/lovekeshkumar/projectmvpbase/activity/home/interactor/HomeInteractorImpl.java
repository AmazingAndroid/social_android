package com.example.lovekeshkumar.projectmvpbase.activity.home.interactor;



import com.example.lovekeshkumar.projectmvpbase.activity.home.presenter.HomePresenterImpl;
import com.example.lovekeshkumar.projectmvpbase.model.RequestLogin;
import com.example.lovekeshkumar.projectmvpbase.network.NetworkManager;

/**
 * Created by Mukesh on 12/16/2017.
 * Affle Appstudio S/W Pvt. Ltd.
 * mukesh.yadav@affle.com
 */
public class HomeInteractorImpl implements IHomeInteractor {
   /* @Override
    public void getAllCounty(MainPresenterImpl homePresenter) {
        Observable<Country> observer = ApiClient.getClient("http://services.groupkt.com/").create(ApiServices.class).getAllCountry();
        observer.subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(homePresenter::onSuccess, homePresenter::onError);
    }*/
    NetworkManager networkManager;
    @Override
    public void getVideoList(HomePresenterImpl homePresenter) {
        RequestLogin requestLogin=new RequestLogin();
        requestLogin.email="";
        requestLogin.registeredMobile="9331111890";
        requestLogin.registeredMobileAreaCode="86";
        networkManager=NetworkManager.get(homePresenter.getContext(),homePresenter);
    //    networkManager.getVideoTopic(requestLogin, Constant.VIDEO_LIST_TASK_ID);
    }
}