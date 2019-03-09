package com.example.simpleviewpropertyanimator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.start);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.animate()
                        .translationY(300)
                        .scaleX(2)
                        .alpha(0.5f)
                        .setDuration(2000)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "End animation", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
            }
        });
    }
}
