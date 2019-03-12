package com.example.transitionresources;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginButton;
    Button signupButton;

    Scene mainScene;
    Scene loginScene;
    Scene signupScene;

    TransitionSet transitionSet;
    TransitionManager transitionManager;

    ViewGroup rootLayout;

    Context context = this;

    private boolean transitionStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.login);
        signupButton = findViewById(R.id.signup);

        rootLayout = findViewById(R.id.rootLayout);

        mainScene = Scene.getSceneForLayout(rootLayout, R.layout.activity_main, context);
        loginScene = Scene.getSceneForLayout(rootLayout, R.layout.layout_login, context);
        signupScene = Scene.getSceneForLayout(rootLayout, R.layout.layout_singup, context);

        loginButton.setOnClickListener(this);
        signupButton.setOnClickListener(this);

        transitionSet = (TransitionSet) TransitionInflater.from(context).inflateTransition(R.transition.my_transitions);
        transitionManager = TransitionInflater.from(this).inflateTransitionManager(R.transition.transitions_manager, rootLayout);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.login:
                if(!transitionStarted) {
                    transitionStarted = true;
                    transitionManager.transitionTo(loginScene);
                }
                break;
            case R.id.signup:
                if(!transitionStarted) {
                    transitionStarted = true;
                    transitionManager.transitionTo(signupScene);
                }
                break;

        }

    }

    @Override
    public void onBackPressed() {
        if(transitionStarted) {
            transitionManager.transitionTo(mainScene);
            transitionStarted = false;

            //Note: We need to find buttons and set onClickListeners again
            findViewById(R.id.login).setOnClickListener(this);
            findViewById(R.id.signup).setOnClickListener(this);
        }
        else {
            super.onBackPressed();
        }
    }
}
