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
public class Fragment2 extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //View view = inflater.inflate(R.layout.activity_main, container, false);
        //TextView testId = (TextView) view.findViewById(R.id.testid);
        //testId.setText("2");
        return inflater.inflate(R.layout.fragment_2, container, false);
    }
}