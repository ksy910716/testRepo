package com.example.ksy.t4_20150105;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.view.DirectionalViewPager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;


public class MainActivity extends SwipeBackActivity {
    private SwipeBackLayout mSwipeBackLayout;
    private static final int VIBRATE_DURATION = 20;
    private long now;
    private Date date;
    private TextView nowTime;
    private TextView nowDate;
    private SimpleDateFormat sdfnowTime;
    private SimpleDateFormat sdfNowDate;
    private DirectionalViewPager pager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up the pager
        pager = (DirectionalViewPager)findViewById(R.id.pager);
        pager.setAdapter(new TestFragmentAdapter(getSupportFragmentManager()));

        /**
         * 이거를 모두 제스쳐로 해봅니다. 테스트 20150106 10:51
         * 아래 -> 위 일경우 DirectionPageView
         * 위 ->  아래  일경우 동일
         * 왼 -> 오 일경우 swipeBackLayout 으로 잠금해재됨
         * 오 -> 왼 일경우 가지고있는 데이터를 가지고 액티비티정보를 가지고 프래그먼트, 액티비티를 띄운다
         */

        //그다음 인플레이션으로 겹치는 레이아웃을 깐다
       /* LayoutInflater inflater = (LayoutInflater)getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.viewpager_childview_1, null);

        LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);
        getWindow().addContentView(linear, paramlinear);//이 부분이 레이아웃을겹치는 부분*/
        //add는 기존의 레이아웃에 겹쳐서 배치하라는 뜻이다.

        //ViewPager pager = (ViewPager) findViewById(R.id.pager1);
        //pager.setPageTransformer(true, new DepthPageTransformer());

        pager.setOrientation(DirectionalViewPager.VERTICAL);
        //pager.setOrientation(DirectionalViewPager.HORIZONTAL);

        getWindow().setFormat(PixelFormat.RGB_565);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);

        mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
            @Override
            public void onScrollStateChange(int state, float scrollPercent) {

            }

            @Override
            public void onEdgeTouch(int edgeFlag) {
                //vibrate(VIBRATE_DURATION);
            }

            @Override
            public void onScrollOverThreshold() {
                vibrate(VIBRATE_DURATION);
            }
        });

        /*Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateYOURthing();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();*/

        nowTime = (TextView) findViewById(R.id.now_time);
        nowDate = (TextView) findViewById(R.id.now_date);
       /* sdfnowTime = new SimpleDateFormat("HH:mm");
        sdfNowDate = new SimpleDateFormat("YY.DD");*/
    }

    private void updateYOURthing() {
        now = System.currentTimeMillis();
        date = new Date(now);
        nowTime.setText(sdfnowTime.format(date));
        nowDate.setText(sdfNowDate.format(date));
    }


    private void vibrate(long duration) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {
                0, duration
        };
        vibrator.vibrate(pattern, -1);
    }

    public void verticalPage()
    {
        pager.setOrientation(DirectionalViewPager.VERTICAL);
    }

    public void horizontalPage()
    {
        pager.setOrientation(DirectionalViewPager.HORIZONTAL);
    }

    public void test(){
        mSwipeBackLayout.computeScroll();
    }


    public class DepthPageTransformer implements ViewPager.PageTransformer {

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = 0.75f
                        + (1 - 0.75f) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}