package com.lawyee.mycelue;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Chronometer mChm;
    private Button mBtn;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mChm = (Chronometer) findViewById(R.id.chm);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
        mBtn4 = (Button) findViewById(R.id.btn4);
        mBtn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                mChm.start();
                break;
            case R.id.btn2:
                mChm.stop();
                break;
            case R.id.btn3:
                mChm.setBase(SystemClock.elapsedRealtime());
                break;
            case R.id.btn4:
                setTime();
                break;
        }
    }

    private void setTime() {
        mChm.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                String time = chronometer.getText().toString();
                if (time.equals("00:10")) {
                    Toast.makeText(Main2Activity.this, "时间到了", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
