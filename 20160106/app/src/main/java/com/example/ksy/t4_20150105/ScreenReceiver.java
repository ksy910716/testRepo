package com.example.ksy.t4_20150105;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

/**
 * Created by ksy on 2015-12-29.
 */
public class ScreenReceiver extends BroadcastReceiver {

    private KeyguardManager km = null;
    private KeyguardManager.KeyguardLock keyLock = null;
    private TelephonyManager telephonyManager = null;
    private boolean isPhoneIdle = true;


    @Override
    public void onReceive(Context context, Intent intent) {

        //화면이 꺼졌을 때
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {

            //기본잠금화면이 크고 꺼짐
            if (km == null)
                km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);

            if (keyLock == null)
                keyLock = km.newKeyguardLock(Context.KEYGUARD_SERVICE);

/*
            //전화가 울릴경우 사용될 서비스
            if(telephonyManager == null){
                telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
                telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
            }*/

            disableKeyguard();

            if(isPhoneIdle) {
                Intent i = new Intent(context, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //액티비티에서 바로 실행하지 못하기 때문에 넣음
                context.startActivity(i);
            }
        }

//        //잠금해제 된 후의 액션
//
//        if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
//        }
    }

    //기본잠금화면 나타내기
    public void reenableKeyguard() {
        keyLock.reenableKeyguard();
    }


    //기본잠금화면 없에기
    public void disableKeyguard() {
        keyLock.disableKeyguard();
    }

    //전화받고있을경우의 잠금화면 표시방법
    private PhoneStateListener phoneListener = new PhoneStateListener(){
        @Override
        public void onCallStateChanged(int state, String incomingNumber){
            switch(state){
                case TelephonyManager.CALL_STATE_IDLE :
                    isPhoneIdle = true;
                    break;
                case TelephonyManager.CALL_STATE_RINGING :
                    isPhoneIdle = false;
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK :
                    isPhoneIdle = false;
                    break;
            }
        }
    };
}