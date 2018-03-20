package com.lawyee.mycelue;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                Object obj = msg.obj;
                String s = String.valueOf(obj);
                Toast.makeText(MainActivity.this, "" + s, Toast.LENGTH_SHORT).show();
            }
            return false;

        }
    });
    private ImageView mImg;
    private RoundLoadingBar mRd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Message message = mHandler.obtainMessage();
        message.arg1 = 1;
        message.what = 1;
        message.obj = "sb";
        message.sendToTarget();
        Message message1 = mHandler.obtainMessage();
        message1.what = 1;
        message1.obj = "sni";
        message1.sendToTarget();
    }


    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mRd = (RoundLoadingBar) findViewById(R.id.rd);
        mRd.setValue(100);
    }
}
