package com.rhemnet.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.rhemnet.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startDummyLoading();
    }

    private void startDummyLoading() {
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showLoginActivity();
            }
        }, 2 * 1000);
    }

    private void showLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);

        this.finish();
        this.startActivity(intent);
    }
}
