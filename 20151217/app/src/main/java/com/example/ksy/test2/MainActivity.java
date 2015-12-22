package com.example.ksy.test2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;

import com.example.ksy.test2.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity{

    Fragment fr;

    public static final int LOGIN_FRAGMENT_KEY = 0;
    public static final int SIGNUP_FRAGMENT_KEY = 1;
    public static final int SIGNUP_ADDITIONAL_INFO_FRAGMENT_KEY = 2;
    public static final int FIND_PASSWORD_FRAGMENT_KEY = 3;

    final int fragmentReplaceResId = R.id.frame;
    final boolean isBackStack = true;
    SparseArray<Fragment> fragmentSparseArray = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(LOGIN_FRAGMENT_KEY, new LoginFragment(), fragmentReplaceResId, isBackStack);
    }

    public void replaceFragment(int key, Fragment fragment) {
        replaceFragment(key, fragment, fragmentReplaceResId, isBackStack);
    }

    public void replaceFragment(int key, Fragment fragment, int replaceResourceId, boolean isBackStack) {

        Fragment fm = fragmentSparseArray.get(key);
        if (fm == null) {
            fragmentSparseArray.put(key, fragment);
            fm = fragment;
        }
        replaceFragment(fm, replaceResourceId, isBackStack);
    }

    private void replaceFragment(Fragment fm, int replaceResourceId, boolean isBackStack) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
        ft.setCustomAnimations(R.anim.anim_fade_in_half, R.anim.anim_fade_out_half, R.anim.anim_fade_in_half, R.anim.anim_fade_out_half);
        ft.replace(replaceResourceId, fm);
        if (isBackStack) {
            /**
             * 최초 fragment는 backstack에 저장하면 안됨. 그럴 경우 빈 화면이 표시된다.
             * 이 것을 피하기 위해서는 최초 fragment에 대한 backstack을 지정하지 않거나, 애초에 activity에 fragment를 설정하면 된다.
             * 여기에는 최초에 fragment가 activity에 설정이 안되어 있어 아래와 같이 처리 한다.
             */
            if (fragmentSparseArray.size() > 1)
                ft.addToBackStack(null);
        }
        ft.commit();
    }

   @Override
    public void onBackPressed() {
       FragmentManager fm = getFragmentManager();
       fm.popBackStack();
    }
}
