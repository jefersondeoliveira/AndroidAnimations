package com.example.jefersonlopes.activityanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity_B extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__b);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_rigth_out);
    }
}
