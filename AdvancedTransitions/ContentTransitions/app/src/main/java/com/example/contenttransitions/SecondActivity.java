package com.example.contenttransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        Transition explode = new Slide();
//        explode.setDuration(2000);
//
//        getWindow().setEnterTransition(explode);
//        getWindow().setReturnTransition(explode);

    }
}
