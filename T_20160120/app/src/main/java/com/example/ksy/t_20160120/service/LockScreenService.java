package com.example.ksy.t_20160120.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.SystemClock;


/**
 * Created by ksy on 2016-01-08.
 */
public class LockScreenService  extends Service {

    private LockScreenReceiver mReceiver = null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        unregisterRestartAlarm();
        super.onCreate();

        mReceiver = new LockScreenReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mReceiver, filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent, flags, startId);

        if(intent != null){
            if(intent.getAction()==null){
                if(mReceiver==null){
                    mReceiver = new LockScreenReceiver();
                    IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
                    registerReceiver(mReceiver, filter);
                }
            }
        }

        /*NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setPriority(Notification.PRIORITY_MIN);*/

        startForeground(1, new Notification());
        /*NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(0, "hello", System.currentTimeMillis());
        nm.notify(1, notification);
        nm.cancel(1);*/
/*
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setPriority(Notification.PRIORITY_MIN);
        startForeground(0, mBuilder.build());
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.cancel(NOTIF_ID);*/


        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy(){
        registerRestartAlarm();
        super.onDestroy();

        if(mReceiver != null){
            unregisterReceiver(mReceiver);
        }
    }


    // support persistent of Service
    public void registerRestartAlarm() {
        //Log.d("PersistentService", "registerRestartAlarm");
        Intent intent = new Intent(LockScreenService.this, LockScreenReceiver.class);
        intent.setAction("ACTION.RESTART.PersistentService");
        PendingIntent sender = PendingIntent.getBroadcast(LockScreenService.this, 0, intent, 0);
        long firstTime = SystemClock.elapsedRealtime();
        firstTime += 10*1000;                                               // 10초 후에 알람이벤트 발생
        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, firstTime, 10 * 1000, sender);
    }

    public void unregisterRestartAlarm() {
        //Log.d("PersistentService", "unregisterRestartAlarm");
        Intent intent = new Intent(LockScreenService.this, LockScreenReceiver.class);
        intent.setAction("ACTION.RESTART.PersistentService");
        PendingIntent sender = PendingIntent.getBroadcast(LockScreenService.this, 0, intent, 0);
        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        am.cancel(sender);
    }
}
