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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tje.sinbaram.R;
import com.tje.sinbaram.data.Coupon;

import java.util.List;

/**
 * Created by the on 2017-12-01.
 */

public class CouponAdapter extends ArrayAdapter<Coupon> {

    Context mContext;
    List<Coupon> mList;
    LayoutInflater inf;

    public CouponAdapter(Context context, List<Coupon> list) {
        super(context, R.layout.coupon_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.coupon_list_item, null);
        }

        final ImageView couponImg = (ImageView) row.findViewById(R.id.couponImg);
        final Button getCouponBtn = (Button) row.findViewById(R.id.getCouponBtn);

        Glide.with(mContext).load("http://news.tongplus.com/site/data/img_dir/2016/11/25/2016112502091_0.jpg").into(couponImg);


        getCouponBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder uc = new AlertDialog.Builder(mContext);
                uc.setTitle("쿠폰 발급");
                uc.setMessage("쿠폰을 발급받으시겠습니까?\n사용 기한을 확인 해주세요.");
                uc.setPositiveButton("발급받기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getCouponBtn.setBackgroundColor(Color.GRAY);
                        getCouponBtn.setText("발급 완료");
                        Toast.makeText(mContext, "쿠폰이 발급되었습니다. 보관함에서 확인해 주세요.", Toast.LENGTH_SHORT).show();
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
        return 3;
    }
}

