package com.tje.sinbaram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.tje.sinbaram.adapter.MyCouponAdapter;
import com.tje.sinbaram.data.Coupon;
import com.tje.sinbaram.util.ContextUtil;

import java.util.ArrayList;
import java.util.List;

public class MyInfoActivity extends BaseActivity {

    private android.widget.ListView myCouponListView;

    List<Coupon> couponList = new ArrayList<>();
    MyCouponAdapter mCouponAdapter;

    private android.widget.TextView majorAgeTxt;
    private android.widget.TextView nameTxt;
    private android.widget.TextView nickNameTxt;
    private android.widget.Button checkScheduleBtn;
    private android.widget.Button reservationBtn;
    private TextView emailTxt;
    private TextView phoneTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        bindViews();
        setValues();
        setupEvents();
    }

    @Override
    public void setupEvents() {
        reservationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ReservationActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void setValues() {
        mCouponAdapter = new MyCouponAdapter(mContext, couponList);
        myCouponListView.setAdapter(mCouponAdapter);

        nameTxt.setText(ContextUtil.getLoginUser(mContext).getUserName());
        emailTxt.setText(ContextUtil.getLoginUser(mContext).getUserEmailAddress());
        phoneTxt.setText(ContextUtil.getLoginUser(mContext).getUserPhoneNum());
    }

    @Override
    public void bindViews() {
        this.reservationBtn = (Button) findViewById(R.id.reservationBtn);
        this.checkScheduleBtn = (Button) findViewById(R.id.checkScheduleBtn);
        this.myCouponListView = (ListView) findViewById(R.id.myCouponListView);
        this.phoneTxt = (TextView) findViewById(R.id.phoneTxt);
        this.emailTxt = (TextView) findViewById(R.id.emailTxt);
        this.nameTxt = (TextView) findViewById(R.id.nameTxt);
    }
}
