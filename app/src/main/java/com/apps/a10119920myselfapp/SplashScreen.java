package com.apps.a10119920myselfapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Tanggal  : 20 MEI 2022
 * NAMA     : UMAR SAID ADI PRANOTO
 * NIM      : 10119920
 * KELAS    : IF10
 */

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    SharedPreferences onBoardingScreen;

    @SuppressLint("ApplySharedPref")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.splash_screen);

        onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
        boolean isFirst = onBoardingScreen.getBoolean("firstTime", true);
        if (isFirst) {
            SharedPreferences.Editor editor = onBoardingScreen.edit();
            editor.putBoolean("firstTime", false);
            editor.commit();

            OnBoardingScreen();
        } else {
            mainActivity();
        }
    }

    private void OnBoardingScreen() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, OnboardingActivity.class);
                startActivity(intent);
            }
        }, 2800);
    }

    private void mainActivity() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
            }
        }, 2800);
    }
}