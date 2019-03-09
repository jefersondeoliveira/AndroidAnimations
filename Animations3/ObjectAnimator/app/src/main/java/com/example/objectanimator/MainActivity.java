package com.example.objectanimator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start;
    ObjectAnimator mScaleX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mScaleX = ObjectAnimator.ofFloat(v, "scaleX", 5);
                mScaleX.setDuration(1000);
                mScaleX.setRepeatCount(ValueAnimator.INFINITE);
                mScaleX.setRepeatMode(ValueAnimator.REVERSE);
                mScaleX.start();

            }
        });
    }
}
