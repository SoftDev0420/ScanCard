package com.cosential.cardreader.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.cosential.cardreader.BuildConfig;
import com.cosential.cardreader.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                SharedPreferences sharedPreferences = getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
                String authToken = sharedPreferences.getString("authToken", "");

                authToken = "A";

                if (authToken.equals("A")) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else {
//                    startActivity(new Intent(SplashActivity.this, LoadingActivity.class));
                }

                finish();
            }
        }).start();
    }
}
