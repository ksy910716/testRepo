package com.example.ksy.t_20160120.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by ksy on 2016-01-20.
 */
public class HorizontalViewpager extends ViewPager {
    private boolean enabled = true;

    public HorizontalViewpager(Context context) {
        super(context);
    }

    public HorizontalViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setPagingEnabled() { //이 메소드를 이용해서 스크롤을 풀어주고
        this.enabled = true;
    }

    public void setPagingDisabled() { this.enabled = false; }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            if (this.enabled) {
                return super.onTouchEvent(event);
            }
        } catch (Exception e) {
            Log.e("INFO", e.getMessage());
        }

        return false;
    }

}