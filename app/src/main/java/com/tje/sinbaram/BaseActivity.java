package com.tje.sinbaram;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 2017-08-16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    Context mContext = this;

    public abstract void setupEvents();
    public abstract void setValues();
    public abstract void bindViews();

}
