package com.example.ksy.test2.fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ksy.test2.R;

/**
 * Created by ium on 14. 2. 25.
 */
public class FindPwdFragment extends Fragment{
    Fragment fr;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.findpwd_fragment, container, false);
        //view.findViewById(R.id.PREV).setOnClickListener(mClickListener);
        view.findViewById(R.id.BtnX).setOnClickListener(mClickListener);
        return view;
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            fr = new LoginFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.frame, fr);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            fragmentTransaction.commit();
        }
    };
}