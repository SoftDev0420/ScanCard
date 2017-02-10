package com.cosential.cardreader.helper.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by softdev0420 on 9/21/16.
 */

public class WebService {

    private static Retrofit retrofit = null;
    private static APIInterface instance = null;
    public static String BASE_URL = null;
    public static String X_APP_KEY = "iOSUserApp_OakFPeoFAW4";
    public static String AUTH_TOKEN = "";
    private static final int SUCCESS_CODE = 200;

    public static APIInterface getInstance() {
        if (instance == null) {
            instance = getClient().create(APIInterface.class);
        }
        return instance;
    }

    private static Retrofit getClient() {
        if (retrofit == null) {
            createRetrofit();
        }
        return retrofit;
    }

    public static void setAuthToken(final String authToken) {
        AUTH_TOKEN = authToken;
        createRetrofit();
        instance = retrofit.create(APIInterface.class);
    }

    public static void removeAuthToken() {
        AUTH_TOKEN = "";
        createRetrofit();
        instance = retrofit.create(APIInterface.class);
    }

    private static void createRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()

                        .header("X-App-Key", X_APP_KEY)
                        .header("X-Auth-Token", AUTH_TOKEN)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
