package com.example.lovekeshkumar.projectmvpbase.network;

import retrofit2.Response;

/**
 * Created by HP on 3/23/2017.
 */
public interface ServiceRedirection {

    /**
     * The interface method implemented in the java files activity  or Fragments for Success Response
     *
     * @param taskID the id based on which the relevant action is performed
     * @return none
     */

    void onSuccessRedirection(Response object, int taskID);

    /***
     * The interface method implemented in the java files activity  or Fragments for Server Error  Response
     * @param errorModel
     * @param taskID
     */
    void onServerErrorRedirection(ErrorModel errorModel, int taskID);

    /**
     * The interface method implemented in the java files activity  or Fragments for Failure Response
     *
     * @param errorModel the error message to be displayed
     * @return none
     */
    void onFailureRedirection(ErrorModel errorModel);
}