package com.example.ksy.t_20160120.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ksy.t_20160120.fragment.VerticalScreenFragment;

/**
 * Created by Prograper on 2016-01-06.
 */
public class VerticalScreenAdapter extends FragmentStatePagerAdapter {

    public static VerticalScreenFragment screenFragment;

    public VerticalScreenAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return screenFragment.create(position);
    }

    @Override
    public int getCount() {
        return 16;
    }
}
