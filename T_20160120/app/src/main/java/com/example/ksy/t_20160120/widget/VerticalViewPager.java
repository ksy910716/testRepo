package com.example.ksy.t_20160120.widget;

import android.content.Context;
import android.support.v4.view.DirectionalViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by ksy on 2016-01-21.
 */
public class VerticalViewPager extends DirectionalViewPager {
    boolean flag = true;
    public VerticalViewPager(Context context) {
        super(context);
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        /*if (flag) {
            return false;
        }*/
        //Log.i("TEST ? ","event.getAction() : "+event.getAction());
        return super.onInterceptTouchEvent(event);
    }
}