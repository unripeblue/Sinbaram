package com.tje.sinbaram;

import android.os.Bundle;
import android.widget.ListView;

import com.tje.sinbaram.adapter.CouponAdapter;
import com.tje.sinbaram.data.Coupon;

import java.util.ArrayList;
import java.util.List;

public class CouponActivity extends BaseActivity {

    private android.widget.ListView couponListView;

    List<Coupon> couponList = new ArrayList<>();
    CouponAdapter mCouponAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        mCouponAdapter = new CouponAdapter(mContext, couponList);
        couponListView.setAdapter(mCouponAdapter);
    }

    @Override
    public void bindViews() {
        this.couponListView = (ListView) findViewById(R.id.couponListView);
    }
}
