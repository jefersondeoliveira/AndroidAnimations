package com.example.jefersonlopes.animationresources;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button start;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        image = findViewById(R.id.image);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animate_one);
                Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animate_two);

                v.startAnimation(animation1);
                image.startAnimation(animation2);

            }
        });

    }
}
