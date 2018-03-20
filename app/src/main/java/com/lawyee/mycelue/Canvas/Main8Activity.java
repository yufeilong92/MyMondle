package com.lawyee.mycelue.Canvas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lawyee.mycelue.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main8Activity extends AppCompatActivity {

    @BindView(R.id.iv_show_img)
    RoundImageView ivShowImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        ButterKnife.bind(this);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.e);
        ivShowImg.setBitmap(bitmap);
    }
}
