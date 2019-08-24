package com.example.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.fragment.app.FragmentActivity;

public class SplashActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        ParallaxContainer container = findViewById(R.id.parallax_container);

        container.setUp(new int[]{R.layout.view_intro_1,
                R.layout.view_intro_2,
                R.layout.view_intro_3,
                R.layout.view_intro_4,
                R.layout.view_intro_5,
                R.layout.view_login});
    }
}
