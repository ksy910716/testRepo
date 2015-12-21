package com.example.ksy.test2.fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ksy.test2.R;

/**
 * Created by ium on 14. 2. 25.
 */
public class LoginFragment extends Fragment{

    Button joinBtn;
    Fragment fr;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_main, container, false);
        view.findViewById(R.id.joinBtn).setOnClickListener(mClickListener);
        view.findViewById(R.id.findPwd).setOnClickListener(mClickListener);
        return view;
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.findPwd:
                    fr = new FindPwdFragment();
                    break;
                case R.id.joinBtn:
                    fr = new JoinFragment();
                    break;

            }
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.frame, fr);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            fragmentTransaction.commit();
        }
    };

}