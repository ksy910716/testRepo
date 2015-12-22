package com.example.ksy.test2.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ksy.test2.MainActivity;
import com.example.ksy.test2.R;

/**
 * Created by ium on 14. 2. 25.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

    Button btnJoin;
    TextView findPwd;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_main, container, false);
        btnJoin = (Button) view.findViewById(R.id.joinBtn);
        btnJoin.setOnClickListener(this);
        findPwd = (TextView) view.findViewById(R.id.findPwd);
        findPwd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.joinBtn:
                ((MainActivity) getActivity()).replaceFragment(MainActivity.SIGNUP_FRAGMENT_KEY, new JoinFragment());
                break;
            case R.id.findPwd:
                ((MainActivity) getActivity()).replaceFragment(MainActivity.FIND_PASSWORD_FRAGMENT_KEY, new FindPwdFragment());
                break;
        }
    }

}