package com.example.ksy.t_20160120.adapter;

/**
 * Created by ksy on 2016-01-20.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.ksy.t_20160120.fragment.HorizonScreenFragment;

import java.lang.reflect.Field;


public class HorizonScreenAdapter extends FragmentStatePagerAdapter {
    HorizonScreenFragment horizonScreenFragment;

    public HorizonScreenAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return horizonScreenFragment.create(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final Object fragment = super.instantiateItem(container, position);
        try {
            final Field saveFragmentStateField = Fragment.class.getDeclaredField("mSavedFragmentState");
            saveFragmentStateField.setAccessible(true);
            final Bundle savedFragmentState = (Bundle) saveFragmentStateField.get(fragment);
            if (savedFragmentState != null) {
                savedFragmentState.setClassLoader(Fragment.class.getClassLoader());
            }
        } catch (Exception e) {
        }
        return fragment;
    }

}
