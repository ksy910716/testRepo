package com.example.ksy.test2.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ksy.test2.R;

/**
 * Created by ium on 14. 2. 25.
 */
public class JoinFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.join_fragment, container, false);
        return view;
    }
}