package com.adurand.nativeapplication.services;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by adurand on 31/01/17.
 */

public class ApiClient {
    private static MobileApi REST_CLIENT;
    public static final String API_URL = "http://adurand.sis.cooperativaobrera.coop:8080/api/";

    public static MobileApi getApi() {
        if(REST_CLIENT == null) {
            init();
        }
        return REST_CLIENT;
    }

    private static void init() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();

        REST_CLIENT = retrofit.create(MobileApi.class);
    }

}
