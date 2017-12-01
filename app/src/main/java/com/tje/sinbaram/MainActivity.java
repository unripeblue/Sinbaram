package com.tje.sinbaram;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;

public class MainActivity extends BaseActivity {

    private android.widget.ImageView menuNaviBtn;
    private android.widget.ImageView settingBtn;
    private android.widget.LinearLayout memberLatout;
    private NavigationView naviView;
    private DrawerLayout activitymaindrawer;
    private ImageView mainBtn;
    private android.widget.ScrollView mainScrollView;
    private ImageView mainImg;
    private ImageView hallImg;
    private ImageView tableImg;
    private ImageView roomImg;

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

        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainScrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });

    }

    @Override
    public void setValues() {
        Glide.with(this).load(R.drawable.main_img).into(mainImg);


    }

    @Override
    public void bindViews() {
        this.activitymaindrawer = (DrawerLayout) findViewById(R.id.activity_main_drawer);
        this.naviView = (NavigationView) findViewById(R.id.naviView);
        this.memberLatout = (LinearLayout) findViewById(R.id.memberLatout);
        this.mainScrollView = (ScrollView) findViewById(R.id.mainScrollView);
        this.mainBtn = (ImageView) findViewById(R.id.mainBtn);
        this.roomImg = (ImageView) findViewById(R.id.roomImg);
        this.tableImg = (ImageView) findViewById(R.id.tableImg);
        this.hallImg = (ImageView) findViewById(R.id.hallImg);
        this.mainImg = (ImageView) findViewById(R.id.mainImg);
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
