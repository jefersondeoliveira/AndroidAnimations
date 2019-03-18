package com.example.sharedviewtransition;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mSharedImage1;
    private ImageView mSharedImage2;
    private ImageView mSharedImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedImage1 = findViewById(R.id.sharedImage1);
        mSharedImage2 = findViewById(R.id.sharedImage2);
        mSharedImage3 = findViewById(R.id.sharedImage3);
        mSharedImage1.setOnClickListener(mOnclickListener);

    }

    private View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this, DetailAcitivity.class);

            Pair<View, String> pair1 = Pair.create((View)mSharedImage1, mSharedImage1.getTransitionName());
            Pair<View, String> pair2 = Pair.create((View)mSharedImage2, mSharedImage2.getTransitionName());
            Pair<View, String> pair3 = Pair.create((View)mSharedImage3, mSharedImage3.getTransitionName());

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pair1, pair2, pair3);

            startActivity(intent, options.toBundle());

        }
    };
}
