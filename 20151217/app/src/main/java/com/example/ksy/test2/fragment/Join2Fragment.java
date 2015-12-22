package com.example.ksy.test2.fragment;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ksy.test2.MainActivity;
import com.example.ksy.test2.R;

/**
 * Created by ium on 14. 2. 25.
 */
public class Join2Fragment extends Fragment implements View.OnClickListener{
    ArrayAdapter<CharSequence> adspin;
    ArrayAdapter<CharSequence> adspin2;
    boolean mInitSpinner;

    RadioGroup gender;
    RadioGroup marry;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.join2_fragment, container, false);

        //년도 스피너 셋팅
        Spinner spinner = (Spinner) view.findViewById(R.id.year);
        adspin = ArrayAdapter.createFromResource(this.getActivity(),R.array.selected1,android.R.layout.simple_spinner_item);
        adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adspin);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,View view, int pos, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(15);
                ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
        //사는곳 스피너
        Spinner spinner2 = (Spinner) view.findViewById(R.id.live);
        adspin2 = ArrayAdapter.createFromResource(this.getActivity(),R.array.selected,android.R.layout.simple_spinner_item);
        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adspin2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(15);
                ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        gender = (RadioGroup) view.findViewById(R.id.gender);
        marry = (RadioGroup) view.findViewById(R.id.marry);
        marry.check(R.id.notMarried);
        gender.check(R.id.girl);

        view.findViewById(R.id.joinBtn1).setOnClickListener(this);
        view.findViewById(R.id.BtnX).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view){
        ((MainActivity) getActivity()).replaceFragment(MainActivity.SIGNUP_FRAGMENT_KEY,new JoinFragment());
    }


}