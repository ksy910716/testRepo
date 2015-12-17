package com.example.ksy.test;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ium on 14. 2. 25.
 */
public class Fragment1 extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        //TextView tv = (TextView) view.findViewById(R.id.text1);
        //tv.setText("Fragment 1");

        return view;

        //View view = inflater.inflate(R.layout.activity_main, container, false);
        //TextView testId = (TextView) view.findViewById(R.id.testid);
        //testId.setText("1");

        // inflater.inflate(R.layout.fragment_1, container, false);
    }
}