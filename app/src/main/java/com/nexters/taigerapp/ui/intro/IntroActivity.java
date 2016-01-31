package com.nexters.taigerapp.ui.intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.nexters.taigerapp.R;
import com.nexters.taigerapp.ui.login.LoginActivity;

public class IntroActivity extends AppCompatActivity {
    private static final long INTRO_LOADING_TIME = 2000L;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_intro);

        loading();
    }

    private void loading() {
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            public void run() {
                endIntro();
            }
        }, INTRO_LOADING_TIME);

    }

    private void endIntro() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
