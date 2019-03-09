package com.example.animatorset;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start;
    ObjectAnimator translateAnim;
    ObjectAnimator xScaleAnim;
    ObjectAnimator colorAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);

        translateAnim = ObjectAnimator.ofFloat(start, "translationY", 300);
        translateAnim.setRepeatMode(ValueAnimator.REVERSE);
        translateAnim.setRepeatCount(ValueAnimator.INFINITE);

        xScaleAnim = ObjectAnimator.ofFloat(start, "scaleX", 3);
        xScaleAnim.setRepeatMode(ValueAnimator.REVERSE);
        xScaleAnim.setRepeatCount(ValueAnimator.INFINITE);

        colorAnim = ObjectAnimator.ofObject(start, "textColor", new ArgbEvaluator(), Color.RED, Color.GREEN);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);

        final AnimatorSet set = new AnimatorSet();
        set.playTogether(translateAnim, xScaleAnim, colorAnim);
        //set.playSequentially(translateAnim, xScaleAnim, colorAnim);
        set.setDuration(1000);
        set.start();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(set.isRunning()){
                    set.end();
                }else{
                    set.start();
                }

            }
        });

    }
}
