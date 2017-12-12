package com.tje.sinbaram;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tje.sinbaram.util.ContextUtil;

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
        setValues();
        setupEvents();

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

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextUtil.getLoginUser(mContext) == null) {
                    Toast.makeText(mContext, "회원 전용 기능입니다. 로그인해 주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (ContextUtil.getLoginUser(mContext).getId() ==1) {
                    Intent intent = new Intent(mContext, ManageActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(mContext, MyInfoActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void setValues() {
        Glide.with(this).load(R.drawable.main_img).into(mainImg);
        Glide.with(this).load(R.drawable.hall_img).into(hallImg);
        Glide.with(this).load(R.drawable.room_img).into(roomImg);
        Glide.with(this).load(R.drawable.table_img).into(tableImg);



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
