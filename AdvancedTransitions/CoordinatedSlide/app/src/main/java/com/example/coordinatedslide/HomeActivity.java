package com.example.coordinatedslide;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class HomeActivity extends AppCompatActivity {

    private static final int TRANSITION_DURATION = 300;
    ViewGroup mRoot;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        for(int i = 0; i < mRoot.getChildCount(); i++) {
            final View view = mRoot.getChildAt(i);
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TransitionManager.beginDelayedTransition(mRoot, new Slide(Gravity.END));
                    view.setVisibility(view.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
                }
            }, TRANSITION_DURATION * i);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mRoot = findViewById(R.id.linearLayout);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                for(int i=0; i < mRoot.getChildCount(); i++){

                    final View v = mRoot.getChildAt(i);

                    v.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TransitionManager.beginDelayedTransition(mRoot, new Slide(Gravity.END));
                            v.setVisibility(v.getVisibility() == View.VISIBLE?View.GONE:View.VISIBLE);
                        }
                    }, 300 * i);

                }

            }
        });

    }

}
