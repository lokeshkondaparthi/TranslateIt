package com.example.lokesh.translateit;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface DetailsAPI {

    @FormUrlEncoded
    @POST("/v2")
    void insertUser(@Field("key") String key,@Field("q") String query,
                    @Field("target") String target, @Field("source") String source,
                    Callback<JsonObject> jsonObjectCallback);
}