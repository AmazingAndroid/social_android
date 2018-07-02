package com.example.lovekeshkumar.projectmvpbase.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HP on 3/23/2017.
 * This class is for Web-service calling interactions
 */
public class ServiceCaller {
    public static final String TAG = ServiceCaller.class.getSimpleName();
    static int errorTaskID = 404;
    ServiceCallback callbackObj;
    int tasksID;
    Call call;
    String result;

    public ServiceCaller(ServiceCallback listnerObj, int tasksID, Call call) {
        this.callbackObj = listnerObj;
        this.tasksID = tasksID;
        this.call = call;
    }

    /***
     * Start enqueue process for Web-service call and return response
     */
    public void getWebServiceData() {
        this.call.enqueue(new Callback() {
            public void onResponse(Call call, Response response) {
                int statusCode = response.code();
                ServiceCaller.this.callbackObj.onResult(response, ServiceCaller.this.tasksID, statusCode, response.message(), (Throwable) null);
            }

            public void onFailure(Call call, Throwable t) {
                ServiceCaller.this.result = t.toString();
                ServiceCaller.this.callbackObj.onResult((Response) null, ServiceCaller.this.tasksID, ServiceCaller.errorTaskID, t.getMessage(), t);
            }
        });
    }
}