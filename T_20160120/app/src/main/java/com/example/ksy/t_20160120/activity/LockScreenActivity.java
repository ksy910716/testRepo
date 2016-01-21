package com.example.ksy.t_20160120.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ksy.t_20160120.R;
import com.example.ksy.t_20160120.adapter.HorizonScreenAdapter;
import com.example.ksy.t_20160120.network.domain.Video;
import com.example.ksy.t_20160120.widget.HorizontalViewpager;

import java.util.List;

/**
 * Created by ksy on 2016-01-20.
 */
public class LockScreenActivity extends AppCompatActivity {
    ViewGroup v;
    HorizontalViewpager horizontalViewPager;
    com.liuguangqiang.swipeback.SwipeBackLayout swipeBackLayout;
    HorizonScreenAdapter horizonScreenAdapter;
    List<Video> videoList;
    boolean isDragging = false;
    TextView detail;
    TextView detailTxt;
    float defaultX = 0;
    float pointX = 0;
    float x;
    boolean doTouch;
    int pageNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockscreen);
        horizonScreenAdapter = new HorizonScreenAdapter(getSupportFragmentManager());

        swipeBackLayout = (com.liuguangqiang.swipeback.SwipeBackLayout) findViewById(R.id.swipeBackLayout);
        swipeBackLayout.setDragEdge(com.liuguangqiang.swipeback.SwipeBackLayout.DragEdge.LEFT);

        horizontalViewPager = (HorizontalViewpager) findViewById(R.id.horizontalViewPager);
        horizontalViewPager.setAdapter(horizonScreenAdapter);
        horizontalViewPager.setCurrentItem(1);
        horizontalViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    doTouch = false;
                } else if (position == 1) {
                    doTouch = true;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        horizontalViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (doTouch) {
                    detailTxt = (TextView) findViewById(R.id.detail_txt);
                    detail = (TextView) findViewById(R.id.detail);
                    int action = event.getAction();
                    if (event.getAction() == MotionEvent.ACTION_MOVE && !isDragging) {
                        if (defaultX == 0)
                            defaultX = detailTxt.getX();
                        isDragging = true;
                    } else if (isDragging) {
                        if (action == MotionEvent.ACTION_MOVE) {
                            if (pointX == 0) {
                                pointX = event.getX();
                            } else if (event.getX() != pointX) {
                                detailTxt.setX(detailTxt.getX() + event.getX() - pointX);
                                pointX = event.getX();
                            }
                            horizontalViewPager.setPagingDisabled();
                        } else if (action == MotionEvent.ACTION_UP) {
                            if (detailTxt.getX() > detail.getLeft() + 100) {
                                detailTxt.setX(defaultX);
                            } else {
                                //Intent videoDetailIntent = new Intent(getApplicationContext(), VideoDetailActivity.class);
                                //videoDetailIntent.putExtra("videoId", videoList.get(pageNum).getId());
                                //videoDetailIntent.putExtra("videoType", videoList.get(pageNum).getVideoType());
                                //startActivity(videoDetailIntent);
                                detailTxt.setX(defaultX);
                            }
                            pointX = 0;
                            isDragging = false;
                            horizontalViewPager.setPagingEnabled();
                        }
                    }
                }
                return false;
            }
        });
    }

    public void finishLockScreen(){
        finish();
        overridePendingTransition(0, 0);
    }

    public void setPageNum(int num){
        this.pageNum = num;
    }

    public void setVideoList(List<Video> videoList){
        this.videoList = videoList;
    }
}
