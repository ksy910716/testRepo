package com.example.ksy.test2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.widget.Toast;

import com.example.ksy.test2.fragment.LoginFragment;
import com.example.ksy.test2.fragment.MainFragment;

public class MainActivity extends AppCompatActivity{

    Fragment fr;

    public static final int LOGIN_FRAGMENT_KEY = 0;
    public static final int SIGNUP_FRAGMENT_KEY = 1;
    public static final int SIGNUP_ADDITIONAL_INFO_FRAGMENT_KEY = 2;
    public static final int FIND_PASSWORD_FRAGMENT_KEY = 3;
    public static final int MAIN_FRAGMENT_KEY = 4;

    final int fragmentReplaceResId = R.id.frame;
    final boolean isBackStack = true;
    SparseArray<Fragment> fragmentSparseArray = new SparseArray<>();

    private long backKeyPressedTime;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(MAIN_FRAGMENT_KEY, new MainFragment(), fragmentReplaceResId, isBackStack);
        //첫화면 바궈줄때 이거부터 바꿔주면 댐
        //replaceFragment(LOGIN_FRAGMENT_KEY, new LoginFragment(), fragmentReplaceResId, isBackStack);
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
       /**
        * 메인페이지에서 백키를 누를경우 종료하시겠습니까? ->종료
        * 그외에는 백키누르면 이전스택으로만 가면됨
        */
       Fragment f = getFragmentManager().findFragmentById(R.id.frame);
       if(f instanceof LoginFragment){
           if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
               backKeyPressedTime = System.currentTimeMillis();
               toast = Toast.makeText(this, "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
               toast.show();
               return;
           }
           //연속 두번을 누른다
           if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
               finish();
               toast.cancel();
           }
       }else{
           FragmentManager fm = getFragmentManager();
           fm.popBackStack();
       }
    }
}
