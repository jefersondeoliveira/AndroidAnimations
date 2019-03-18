package com.example.fragmenttransitions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartButton = findViewById(R.id.start);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SimpleFragment simpleFragment = new SimpleFragment();

                simpleFragment.setEnterTransition(new Slide(Gravity.START));
                simpleFragment.setReturnTransition(new Slide(Gravity.END ));

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.container, simpleFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }
}
