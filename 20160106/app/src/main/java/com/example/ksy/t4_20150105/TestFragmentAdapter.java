package com.example.ksy.t4_20150105;

/**
 * Created by ksy on 2016-01-05.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

class TestFragmentAdapter extends FragmentPagerAdapter {
    static final int NUM_ITEMS = 8;

    protected static final String[] CONTENT = new String[] { "This", "Is Is", "A A A", "Test", };

    public TestFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        //return TestFragment.newInstance(CONTENT[position]);
        return TestFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

}