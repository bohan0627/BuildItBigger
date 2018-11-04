package com.bohan.android.jokesandroidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Bo Han.
 */
public class JokeDisplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container,new JokeDisplayFragment()).commit();
        }
    }
}

