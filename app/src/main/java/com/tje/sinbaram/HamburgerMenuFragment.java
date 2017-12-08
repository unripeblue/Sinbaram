package com.tje.sinbaram;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tje.sinbaram.data.User;
import com.tje.sinbaram.util.ContextUtil;

/**
 * Created by the on 2017-09-14.
 */

public class HamburgerMenuFragment extends Fragment {

    User myInfo;
    private android.widget.TextView customcenterBtn;
    private TextView textView;
    private android.widget.LinearLayout menuViewLayout;
    private android.widget.LinearLayout reservationLayout;
    private android.widget.LinearLayout eventpageLayout;
    private TextView userNameTxt;
    private TextView userPhoneTxt;
    private TextView userMailTxt;
    private TextView userCouponTxt;
    private LinearLayout reviewLayout;
    private android.widget.Button logoutBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_hamburger_menu, container, false);
        this.logoutBtn = (Button) v.findViewById(R.id.logoutBtn);
        myInfo = ContextUtil.getLoginUser(getActivity());
        this.reviewLayout = (LinearLayout) v.findViewById(R.id.reviewLayout);
        this.userCouponTxt = (TextView) v.findViewById(R.id.userCouponTxt);
        this.userMailTxt = (TextView) v.findViewById(R.id.userMailTxt);
        this.userPhoneTxt = (TextView) v.findViewById(R.id.userPhoneTxt);
        this.userNameTxt = (TextView) v.findViewById(R.id.userNameTxt);
        this.eventpageLayout = (LinearLayout) v.findViewById(R.id.eventpageLayout);
        this.reservationLayout = (LinearLayout) v.findViewById(R.id.reservationLayout);
        this.menuViewLayout = (LinearLayout) v.findViewById(R.id.menuViewLayout);
        this.textView = (TextView) v.findViewById(R.id.textView);
        return v;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (ContextUtil.getLoginUser(getActivity()).getUserName().equals(null)) {

        }
        else {
            userMailTxt.setText(myInfo.getUserName());
        }



        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContextUtil.logout(getActivity());
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        menuViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MenuActivity.class);
                startActivity(intent);
            }
        });

        reservationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReservationActivity.class);
                startActivity(intent);
            }
        });

        eventpageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CouponActivity.class);
                startActivity(intent);
            }
        });

        reviewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReviewActivity.class);
                startActivity(intent);
            }
        });

    }
}
