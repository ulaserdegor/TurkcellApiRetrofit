package com.seyir.tcellapi.rest;
/*
 * Created by Ulas ERDEGOR on 17-Jan-17.
 */

import com.seyir.tcellapi.models.DeviceSearch;
import com.seyir.tcellapi.models.ResponseSuccess;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TCellAPI {

    @FormUrlEncoded
    @POST("sms")
    Call<ResponseSuccess> sendSMS(@Header("api_key") String apiKey, @Field("from") String from, @Field("to") String to, @Field("content") String content);

    @FormUrlEncoded
    @POST("call")
    Call<ResponseSuccess> makeCall(@Header("api_key") String apiKey, @Field("from") String from, @Field("to") String to, @Field("audio_text") String audio_text);

    @FormUrlEncoded
    @POST("device/currentdevice")
    Call<ResponseSuccess> searchDevice(@Header("api_key") String apiKey, @Field("msisdn") String msisdn, @Field("attributeid") int attributeId);

    @GET("device/currentdevice/{tickedId}")
    Call<DeviceSearch> getDeviceDetails(@Header("api_key") String apiKey, @Path("tickedId") String tickedId);
}
