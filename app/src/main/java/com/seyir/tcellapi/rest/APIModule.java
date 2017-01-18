package com.seyir.tcellapi.rest;
/*
 * Created by Ulas ERDEGOR on 17-Jan-17.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIModule {

    private static final String TCELL_URL = "https://api-gw.turkcell.com.tr/api/v1/";

    public static Retrofit connectTcellAPI() {

        return new Retrofit.Builder()
                .baseUrl(TCELL_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}