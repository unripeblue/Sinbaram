package com.tje.sinbaram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends BaseActivity {

    private android.widget.ImageView menuNaviBtn;
    private android.widget.ImageView settingBtn;
    private android.widget.LinearLayout memberLatout;
    private NavigationView naviView;
    private DrawerLayout activitymaindrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        menuNaviBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activitymaindrawer.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.activitymaindrawer = (DrawerLayout) findViewById(R.id.activity_main_drawer);
        this.naviView = (NavigationView) findViewById(R.id.naviView);
        this.memberLatout = (LinearLayout) findViewById(R.id.memberLatout);
        this.settingBtn = (ImageView) findViewById(R.id.settingBtn);
        this.menuNaviBtn = (ImageView) findViewById(R.id.menuNaviBtn);
    }


    @Override
    public void onBackPressed() {
        if (this.activitymaindrawer.isDrawerOpen(GravityCompat.START)) {
            this.activitymaindrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
