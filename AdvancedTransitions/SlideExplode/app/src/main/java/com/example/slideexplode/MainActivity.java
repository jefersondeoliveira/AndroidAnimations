package com.example.slideexplode;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImage;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImage = findViewById(R.id.image);
        mStartButton = findViewById(R.id.start);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ViewGroup rootLayout = findViewById(android.R.id.content);

                //Transition transition = new Explode();
                //Transition transition = new Fade();
                Transition transition = new Slide(Gravity.LEFT);

                TransitionManager.beginDelayedTransition(rootLayout, transition);

                int visibilityImage = mImage.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
                mImage.setVisibility(visibilityImage);

            }
        });
    }
}
