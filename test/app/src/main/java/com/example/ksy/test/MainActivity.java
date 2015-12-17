package com.example.ksy.test;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    TextView testId;

  //  public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fr = new Fragment1();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fr);
        fragmentTransaction.commit();

    }

    public void selectFrag(View view){
        Fragment fr;
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        testId = (TextView) findViewById(R.id.testid);

        if(testId.getText().equals("1") && view == findViewById(R.id.button2)){
            testId.setText("2");
            fr = new Fragment2();
        }else if(testId.getText().equals("2")){
            if(view == findViewById(R.id.button2)) {
                testId.setText("3");
                fr = new Fragment3();
            }else {
                testId.setText("1");
                fr = new Fragment1();
            }
        }else if(testId.getText().equals("3") && view == findViewById(R.id.button1)) {
            testId.setText("2");
            fr = new Fragment2();
        }else{
            testId.setText("1");
            fr = new Fragment1();
        }
        fragmentTransaction.replace(R.id.fragment, fr);
        fragmentTransaction.commit();
    }
}
 