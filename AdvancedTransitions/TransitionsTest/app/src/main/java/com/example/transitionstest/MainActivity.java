package com.example.transitionstest;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button mStartButton;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartButton = findViewById(R.id.start);
        mImage = findViewById(R.id.image);

        final TransitionSet set = new TransitionSet();
        set.addTransition(new ChangeTransform());
        set.addTransition(new ChangeImageTransform());
        set.addTransition(new ChangeClipBounds());

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition((ViewGroup)findViewById(android.R.id.content), set);

                mImage.setScaleX(2.0f);
                mImage.setScaleY(2.0f);
                mImage.setRotation(45);
                mImage.setScaleType(ImageView.ScaleType.CENTER);
                mImage.setClipBounds(new Rect(10, 20, 500, 400));

            }
        });

    }
}
