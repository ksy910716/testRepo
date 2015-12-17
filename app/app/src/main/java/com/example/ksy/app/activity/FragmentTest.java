package com.example.ksy.app.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ksy.app.R;

/**
 * Created by ksy on 2015-12-16.
 */
public class FragmentTest extends Activity {
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.FragmentTest);
        }

    public static class CounterFragment extends Fragment{
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.counterfragment, container, false);

            Button btnIncrease = (Button) root.findViewById(R.id.btnincrease);
            final TextView textCounter = (TextView) root.findViewById(R.id.txtcounter);
            btnIncrease.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    int count = Integer.parseInt(textCounter.getText().toString());
                    textCounter.setText(Integer.toString(count + 1));
                }
            });
            return root;
        }
    }
}
