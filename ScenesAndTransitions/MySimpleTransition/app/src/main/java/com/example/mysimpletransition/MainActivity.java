package com.example.mysimpletransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transition fade = new Fade();
                Transition changeBounds = new ChangeBounds();

                TransitionSet set = new TransitionSet();
                set.addTransition(fade)
                        .addTransition(changeBounds)
                        .setDuration(2000)
                        .addListener(new Transition.TransitionListener() {
                        @Override
                        public void onTransitionStart(Transition transition) {

                        }

                        @Override
                        public void onTransitionEnd(Transition transition) {

                        }

                        @Override
                        public void onTransitionCancel(Transition transition) {

                        }

                        @Override
                        public void onTransitionPause(Transition transition) {

                        }

                        @Override
                        public void onTransitionResume(Transition transition) {

                        }
                    });
                
                ViewGroup root = findViewById(android.R.id.content);
                Scene scene2 = Scene.getSceneForLayout(root, R.layout.second_layout, getApplicationContext());
                TransitionManager.go(scene2, set);
            }
        });

    }
}
