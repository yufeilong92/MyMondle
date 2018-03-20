package com.lawyee.mycelue.Animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lawyee.mycelue.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main5Activity extends AppCompatActivity {

    @BindView(R.id.iv_show)
    ImageView ivShow;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.img)
    ImageView img;

    private AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ivShow.setImageResource(R.drawable.anim);
                        drawable = (AnimationDrawable) ivShow.getDrawable();
                        drawable.start();

                    }
                }, 300);
                break;

            case R.id.button2:
                drawable.stop();
                break;
            case R.id.button3:
                drawable.start();
                break;
            case R.id.button4:
               TransitionDrawable td= (TransitionDrawable) img.getDrawable();
               td.startTransition(3000);
                break;
        }
    }


}
