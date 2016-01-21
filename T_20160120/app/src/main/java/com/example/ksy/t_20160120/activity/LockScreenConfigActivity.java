package com.example.ksy.t_20160120.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ksy.t_20160120.R;
import com.example.ksy.t_20160120.service.LockScreenService;

/**
 * Created by ksy on 2016-01-21.
 */
public class LockScreenConfigActivity extends AppCompatActivity {
    private Button onBtn, offBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockscreen_config);

        onBtn= (Button)findViewById(R.id.btn1);
        offBtn= (Button)findViewById(R.id.btn2);

        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LockScreenService.class);
                stopService(intent);
            }
        });
        onBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LockScreenService.class);
                startService(intent);
            }
        });
    }
}
