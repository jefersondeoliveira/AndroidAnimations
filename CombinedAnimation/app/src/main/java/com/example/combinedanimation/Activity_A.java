 package com.example.combinedanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

 public class Activity_A extends AppCompatActivity {

     private Button start;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_a);

         start = findViewById(R.id.start);
         start.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Animation animationView = AnimationUtils.loadAnimation(Activity_A.this, R.anim.animate_view);
                 animationView.setAnimationListener(new Animation.AnimationListener() {
                     @Override
                     public void onAnimationStart(Animation animation) {

                     }

                     @Override
                     public void onAnimationEnd(Animation animation) {
                         startActivity(new Intent(Activity_A.this, Activity_B.class));
                        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
                     }

                     @Override
                     public void onAnimationRepeat(Animation animation) {

                     }
                 });
                 v.startAnimation(animationView);

             }
         });

     }
}
