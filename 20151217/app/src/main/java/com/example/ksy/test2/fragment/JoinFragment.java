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
public class JoinFragment extends Fragment{

    Fragment fr;
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.join_fragment, container, false);
/*
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_BACK) {
                    Log.i(JoinFragment.class.getSimpleName(), "onKey Back listener is working!!!");
                    Intent intent = new Intent(getActivity(),MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    intent.putExtra("finishstatus", true);
                    startActivity(intent);
                    getActivity().finish();
                    return true;
                } else {
                    return false;
                }
            }
        });*/

        view.findViewById(R.id.joinBtn1).setOnClickListener(mClickListener);
        view.findViewById(R.id.PREV).setOnClickListener(mClickListener);
        view.findViewById(R.id.BtnX).setOnClickListener(mClickListener);


        return view;
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.joinBtn1:
                    fr = new Join2Fragment();
                    break;
                default:
                    fr = new LoginFragment();
                    break;
            }
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.frame, fr);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            fragmentTransaction.commit();
        }
    };
}