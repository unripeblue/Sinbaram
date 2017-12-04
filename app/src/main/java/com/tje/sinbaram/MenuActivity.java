package com.tje.sinbaram;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.bumptech.glide.Glide;

public class MenuActivity extends BaseActivity {

    private android.widget.TabWidget tabs;
    private android.widget.LinearLayout tab1;
    private android.widget.LinearLayout tab2;
    private android.widget.FrameLayout tabcontent;
    private android.widget.TabHost tabHost;
    private android.widget.ImageView ori01;
    private android.widget.ImageView ori02;
    private android.widget.ImageView ori03;
    private android.widget.ImageView ori04;
    private android.widget.ImageView ori05;
    private android.widget.ImageView ori06;
    private android.widget.ImageView side01;
    private android.widget.ImageView side02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bindViews();
        makeTabHost();
        setupEvents();
        setValues();
    }

    private void makeTabHost() {
        tabHost.setup();

        TabHost.TabSpec ts1 = tabHost.newTabSpec("tab1").setIndicator("메인 요리");
        ts1.setContent(R.id.tab1);
        tabHost.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost.newTabSpec("tab2").setIndicator("사이드 / 음료");
        ts2.setContent(R.id.tab2);
        tabHost.addTab(ts2);

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        Glide.with(this).load(R.drawable.ori_01).into(ori01);
        Glide.with(this).load(R.drawable.ori_02).into(ori02);
        Glide.with(this).load(R.drawable.ori_03).into(ori03);
        Glide.with(this).load(R.drawable.ori_04).into(ori04);
        Glide.with(this).load(R.drawable.ori_05).into(ori05);
        Glide.with(this).load(R.drawable.ori_06).into(ori06);
        Glide.with(this).load(R.drawable.side_01).into(side01);
        Glide.with(this).load(R.drawable.side_02).into(side02);
    }

    @Override
    public void bindViews() {
        this.tabHost = (TabHost) findViewById(R.id.tabHost);
        this.tabcontent = (FrameLayout) findViewById(android.R.id.tabcontent);
        this.tab2 = (LinearLayout) findViewById(R.id.tab2);
        this.side02 = (ImageView) findViewById(R.id.side02);
        this.side01 = (ImageView) findViewById(R.id.side01);
        this.tab1 = (LinearLayout) findViewById(R.id.tab1);
        this.ori06 = (ImageView) findViewById(R.id.ori06);
        this.ori05 = (ImageView) findViewById(R.id.ori05);
        this.ori04 = (ImageView) findViewById(R.id.ori04);
        this.ori03 = (ImageView) findViewById(R.id.ori03);
        this.ori02 = (ImageView) findViewById(R.id.ori02);
        this.ori01 = (ImageView) findViewById(R.id.ori01);
        this.tabs = (TabWidget) findViewById(android.R.id.tabs);
    }
}
