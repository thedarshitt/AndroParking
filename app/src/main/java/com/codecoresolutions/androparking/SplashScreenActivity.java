package com.codecoresolutions.androparking;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent LoginIntent= new Intent(SplashScreenActivity.this,Login.class);
                startActivity(LoginIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
