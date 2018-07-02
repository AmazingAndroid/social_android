package com.example.lovekeshkumar.projectmvpbase.network;

import retrofit2.Call;


/**
 * Created by HP on 3/23/2017.
 * <p>
 * This class will be responsible for the communication and will be used to call the webservice requests
 */
public class CommunicationManager {


    /**
     * Constructor
     * @param contextObj  The Context from where the method is called
     * @return none
     */


    /**
     * Call the required web service through library
     *
     * @param listnerObj object of interface CallBack
     * @param tasksID    the ID to differential multiple webservice calls
     * @param call       An invocation of a Retrofit method that sends a request to a webserver and returns a response.
     * @return none
     */
    public void callWebService(ServiceCallback listnerObj, int tasksID, Call call) {
        ServiceCaller gwsdObj = new ServiceCaller(listnerObj, tasksID, call);
        gwsdObj.getWebServiceData();
    }
}
