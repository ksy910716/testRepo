package com.example.ksy.t4_20150105;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ksy on 2016-01-05.
 */
public class ConfigActivity extends Activity{

    private Button onBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        onBtn = (Button)findViewById(R.id.btn1);

        onBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfigActivity.this, ScreenService.class);
                startService(intent);
            }
        });

    }
}
