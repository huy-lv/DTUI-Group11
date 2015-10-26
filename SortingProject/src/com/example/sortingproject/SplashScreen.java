package com.example.sortingproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {
	 
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(fe)
        setContentView(R.layout.activity_splash);
 
        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent();
                intent.setClass(SplashScreen.this, MainActivity.class);

                SplashScreen.this.startActivity(intent);
                SplashScreen.this.finish();

                // transition from splash to main menu
                overridePendingTransition(R.anim.activityfadein,
                        R.anim.splashfadeout);

            }
        }, SPLASH_TIME_OUT);
    }
 
}