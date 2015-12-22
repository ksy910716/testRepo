package com.example.ksy.test2.fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ksy.test2.MainActivity;
import com.example.ksy.test2.R;

/**
 * Created by ium on 14. 2. 25.
 */
public class JoinFragment extends Fragment implements View.OnClickListener{

    Fragment fr;
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.join_fragment, container, false);
        view.findViewById(R.id.joinBtn1).setOnClickListener(this);
        view.findViewById(R.id.PREV).setOnClickListener(this);
        view.findViewById(R.id.BtnX).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.joinBtn1:
                ((MainActivity) getActivity()).replaceFragment(MainActivity.SIGNUP_ADDITIONAL_INFO_FRAGMENT_KEY, new Join2Fragment());
                break;
            default:
                ((MainActivity) getActivity()).replaceFragment(MainActivity.LOGIN_FRAGMENT_KEY, new LoginFragment());
                break;
        }
    }

}