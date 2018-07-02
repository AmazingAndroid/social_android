package com.example.lovekeshkumar.projectmvpbase.network;

import retrofit2.Response;

/**
 * Created by HP on 3/23/2017.
 */
public interface ServiceCallback {
    /***"
     * method to return response from Server
     * @param var1
     * @param var2
     * @param var3
     * @param var4
     * @param t
     */
    void onResult(Response var1, int var2, int var3, String var4, Throwable t);
}