package com.example.ksy.test2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.ksy.test2.fragment.FindPwdFragment;
import com.example.ksy.test2.fragment.Join2Fragment;
import com.example.ksy.test2.fragment.JoinFragment;
import com.example.ksy.test2.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {

    Fragment fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fragmentListener(new LoginFragment());
        fr = new LoginFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame,fr).commit();

    }

    /*public void onClick(View v) {
        switch (v.getId()) {
            case R.id.joinBtn:
                fragmentListener(new JoinFragment());
                break;
            case R.id.joinBtn1:
                fragmentListener(new Join2Fragment());
                break;
            case R.id.findPwd:
                fragmentListener(new FindPwdFragment());
                break;
            default:
                fragmentListener(new LoginFragment());
                break;
            *//*case R.id.btn_signup:
                ((LoginActivity) getActivity()).replaceFragment(LoginActivity.SIGNUP_FRAGMENT_KEY, new SignUpFragment());
                break;
            case R.id.btn_find_password:
                ((LoginActivity) getActivity()).replaceFragment(LoginActivity.FIND_PASSWORD_FRAGMENT_KEY, new FindPasswrodFragment());
                break;*//*
        }
    }*/


    /*public void fragmentListener(Fragment fr){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.frame, fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }*/

   Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
        switch (v.getId()) {
            case R.id.joinBtn:
                fr = new JoinFragment();
                break;
            case R.id.joinBtn1:
                fr = new Join2Fragment();
                break;
            case R.id.findPwd:
                fr = new FindPwdFragment();
                break;
            default:
                fr = new LoginFragment();
                break;
        }
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.frame, fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        }
    };
/*

    //가입하기 클릭시 화면 리플레이스
    public void memJoin(View view){
        fr = new JoinFragment();
        test(fr);

    }

    //가입하기 - 계속 클릭시 화면 리플레이스
    public void join2(View view){
        fr = new Join2Fragment();
        test(fr);
    }

    //비밀번호 찾기시 화면 리플레이스
    public void findPwd(View view){
        fr = new FindPwdFragment();
        test(fr);
    }

    //로그인페이지로 리턴
    public void returnLogin(View view){
        fr = new LoginFragment();
        test(fr);
    }

    public void test(Fragment frag){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.frame, frag);
        fragmentTransaction.commit();
    }*/

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
