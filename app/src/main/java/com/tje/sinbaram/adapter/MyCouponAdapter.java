package com.tje.sinbaram.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.tje.sinbaram.R;
import com.tje.sinbaram.data.Coupon;

import java.util.List;

/**
 * Created by the on 2017-12-01.
 */

public class MyCouponAdapter extends ArrayAdapter<Coupon> {

    Context mContext;
    List<Coupon> mList;
    LayoutInflater inf;

    public MyCouponAdapter(Context context, List<Coupon> list) {
        super(context, R.layout.mycoupon_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.mycoupon_list_item, null);
        }

        final ImageView useImg = (ImageView) row.findViewById(R.id.useImg);
        final ImageView noUseImg = (ImageView) row.findViewById(R.id.noUseImg);
        final LinearLayout couponBackground = (LinearLayout) row.findViewById(R.id.couponBackground);
        final ImageView couponImg = (ImageView) row.findViewById(R.id.couponImg);

        Glide.with(mContext).load("http://news.tongplus.com/site/data/img_dir/2016/11/25/2016112502091_0.jpg").into(couponImg);

        noUseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder uc = new AlertDialog.Builder(mContext);
                uc.setTitle("쿠폰 사용");
                uc.setMessage("사용 처리됩니다.\n정말 사용하시겠습니까?");
                uc.setPositiveButton("사용합니다!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        noUseImg.setVisibility(View.GONE);
                        useImg.setVisibility(View.VISIBLE);
                        couponBackground.setBackgroundColor(Color.GRAY);
                    }
                });
                uc.setNegativeButton("취소", null);
                uc.show();
            }
        });


        return row;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

