package com.example.ksy.t_20160120.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ksy.t_20160120.R;
import com.example.ksy.t_20160120.activity.LockScreenActivity;
import com.example.ksy.t_20160120.adapter.VerticalScreenAdapter;
import com.example.ksy.t_20160120.util.LockScreenDateUtil;
import com.example.ksy.t_20160120.widget.VerticalViewPager;

/**
 * Created by ksy on 2016-01-20.
 */
public class HorizonScreenFragment extends Fragment {

    private int mPageNumber;
    public static FrameLayout dateTimeFrame;
    RelativeLayout route_info_tab;
    ViewGroup rootView;
    LayoutInflater inflater;
    LockScreenDateUtil dateUtil;
    TextView nowTime;
    TextView nowDate;
    public Thread lockScreenThread = new Thread(new DateTimeToLockScreen());

    public static HorizonScreenFragment create(int pageNumber) {
        HorizonScreenFragment fragment = new HorizonScreenFragment();
        Bundle args = new Bundle();
        args.putInt("page", pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt("page");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mPageNumber == 1) {
            final VerticalScreenAdapter verticalScreenAdapter = new VerticalScreenAdapter(getChildFragmentManager());
            rootView = (ViewGroup) inflater.inflate(R.layout.fm_vertical_viewpager, container, false);
            dateTimeFrame = (FrameLayout) rootView.findViewById(R.id.date_time_frame);
            VerticalViewPager verticalViewPager = (VerticalViewPager) rootView.findViewById(R.id.pager);
            verticalViewPager.setAdapter(verticalScreenAdapter);
            verticalViewPager.setOrientation(VerticalViewPager.VERTICAL);
            verticalViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    ((LockScreenActivity) getActivity()).setPageNum(position);
                }
                @Override
                public void onPageSelected(int position) {

                }
                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            lockScreenDateTime();
        } else {
            rootView = (ViewGroup) inflater.inflate(R.layout.fm_transparent, container, false);
        }
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (!isVisibleToUser) {
            if (mPageNumber == 1)
                ((LockScreenActivity) getActivity()).finishLockScreen();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    public void lockScreenDateTime(){
        inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        route_info_tab = (RelativeLayout) inflater.inflate(R.layout.fm_lockscreen_time, null);
        dateTimeFrame.addView(route_info_tab);
        nowTime = (TextView) dateTimeFrame.findViewById(R.id.now_time);
        nowDate = (TextView) dateTimeFrame.findViewById(R.id.now_date);
        lockScreenThread.start();
    }

    public class DateTimeToLockScreen extends Thread {
        public void run() {
            try {
                while (!isInterrupted()) {
                    if(getActivity() == null){
                        return;
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            dateUtil = new LockScreenDateUtil();
                            dateUtil.DateUtil();
                            nowTime.setText(dateUtil.getNowTime());
                            nowDate.setText(dateUtil.getNowDate());
                        }
                    });
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }
    }


}
