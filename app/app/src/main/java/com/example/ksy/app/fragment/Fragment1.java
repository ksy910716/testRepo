package com.example.ksy.app.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ksy.app.R;

/**
 * Created by ksy on 2015-12-16.
 */
public class Fragment1 extends Fragment {

    private static final String TAG = "Fragment1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        //TextView tv = (TextView) view.findViewById(R.id.text1);
        //tv.setText("Fragment 1");
        return view;
    }

}