package com.example.ksy.test2.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ksy.test2.R;

/**
 * Created by ium on 14. 2. 25.
 */
public class Join2Fragment extends Fragment{
    ArrayAdapter<CharSequence> adspin;
    ArrayAdapter<CharSequence> adspin2;
    boolean mInitSpinner;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.join2_fragment, container, false);

        //년도 스피너 셋팅
        Spinner spinner = (Spinner) view.findViewById(R.id.year);
        spinner.setPrompt("선택해주세요");
        adspin = ArrayAdapter.createFromResource(this.getActivity(),R.array.selected1,android.R.layout.simple_spinner_item);
        adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adspin);

        //사는곳 스피너
        Spinner spinner2 = (Spinner) view.findViewById(R.id.live);
        spinner2.setPrompt("선택해주세요");
        adspin2 = ArrayAdapter.createFromResource(this.getActivity(),R.array.selected,android.R.layout.simple_spinner_item);
        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adspin2);

        return view;
    }
}