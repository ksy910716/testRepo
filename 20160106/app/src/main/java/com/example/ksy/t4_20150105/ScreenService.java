package com.example.ksy.t4_20150105;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by ksy on 2016-01-05.
 */
public class ScreenService extends Service {
    private ScreenReceiver screenReceiver = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        screenReceiver = new ScreenReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(screenReceiver,filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        if(intent != null){
            if(intent.getAction() == null){
                if(screenReceiver == null){
                    screenReceiver = new ScreenReceiver();
                    IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
                    registerReceiver(screenReceiver,intentFilter);
                }
            }
        }

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(screenReceiver != null)
            unregisterReceiver(screenReceiver);
    }
}
