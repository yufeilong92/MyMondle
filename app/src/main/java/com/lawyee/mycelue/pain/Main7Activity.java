package com.lawyee.mycelue.pain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lawyee.mycelue.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main7Activity extends AppCompatActivity {

    @BindView(R.id.myView)
    MyView myView;
    private int a = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ButterKnife.bind(this);
    }

    public void addarc(View view) {
        if (a == 360) {
            a = 360;
        } else {
            a += 10;
        }
        Log.e("yfl", "addarc: " + a);
        myView.setArc(0, a);

    }

    public void reducearc(View view) {
        if (a == 0) {
            Toast.makeText(Main7Activity.this, "最少了", Toast.LENGTH_SHORT).show();
            a = 0;
        } else {
            a -= 10;
        }
        myView.setArc(0, a);
    }
}
