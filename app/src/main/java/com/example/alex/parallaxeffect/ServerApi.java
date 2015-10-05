package com.example.alex.parallaxeffect;

import com.example.alex.parallaxeffect.entity.TransferObject;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Alex on 04.10.2015.
 */
public interface ServerApi {

    @GET("home/video")
    public Call<TransferObject> getStr();

}

