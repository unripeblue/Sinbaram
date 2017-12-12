package com.tje.sinbaram;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tje.sinbaram.util.ContextUtil;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bindViews();
        setupEvents();
        setValues();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (ContextUtil.getLoginUser(mContext) == null) {
                    Intent myIntent = new Intent(mContext, LoginActivity.class);
                    startActivity(myIntent);
                    finish();
                }
                else {
                    Intent myIntent = new Intent(mContext, MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }
            }
        }, 900);
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

    }
}
