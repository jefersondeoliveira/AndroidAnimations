package com.example.xmlanimator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.animatedObject);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View image) {

                animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.my_animation);
                animatorSet.setDuration(2000);
                animatorSet.setTarget(image);
                animatorSet.start();

                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        new AlertDialog.Builder(MainActivity.this).setMessage("Animation Ended").show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

            }
        });

    }
}
