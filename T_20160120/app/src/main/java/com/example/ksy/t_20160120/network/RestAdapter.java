package com.example.ksy.t_20160120.network;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.example.ksy.t_20160120.Constants;
import com.example.ksy.t_20160120.util.SharedPreferenceUtil;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RequestInterceptor;
import retrofit.client.OkClient;


/**
 * Created by PrographerJ on 2015-07-10.
 */
public class RestAdapter {

    public static retrofit.RestAdapter getInstance(final Context ctx) {
        final TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
        // if (instance == null) {
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(120, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(120, TimeUnit.SECONDS);
        retrofit.RestAdapter instance = new retrofit.RestAdapter.Builder()
                .setEndpoint(Constants.HOST)
                .setClient(new OkClient(okHttpClient))
                .setRequestInterceptor(     new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("UnTV-User", tm.getDeviceId());
                        if (ctx.getClass() != null)
                            request.addHeader("UnTV-Activity", ctx.getClass().getSimpleName());
                    }
                })
                .build();
        // }
        return instance;
    }
}
