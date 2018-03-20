package com.lawyee.mycelue.weight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lawyee.mycelue.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main9Activity extends AppCompatActivity {

    @BindView(R.id.btn_ceshi)
    Button btnCeshi;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        ButterKnife.bind(this);
        gestureDetector = new GestureDetector(this,new GestureDetectorView());
         init();
    }

    private void init() {
        btnCeshi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
        btnCeshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main9Activity.this,"222",Toast.LENGTH_SHORT).show();
            }
        });
    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return gestureDetector.onTouchEvent(event);
//    }
}
