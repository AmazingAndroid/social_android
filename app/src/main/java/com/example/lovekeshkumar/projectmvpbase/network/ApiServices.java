package com.example.lovekeshkumar.projectmvpbase.network;




import com.example.lovekeshkumar.projectmvpbase.model.Country;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by mukesh on 4/12/17.
 * Affle India Pvt Ltd.
 */

public interface ApiServices {
    @GET("country/get/all")
    Observable<Country> getAllCountry();
}
