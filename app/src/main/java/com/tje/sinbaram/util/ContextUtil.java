package com.tje.sinbaram.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.tje.sinbaram.data.User;

/**
 * Created by user on 2017-08-31.
 */

public class ContextUtil {

    private static User loginUser = null;

    private final static String prefName = "sinbaram";
    private final static String ID = "ID";
    private final static String USER_ID = "UESR_ID";
    private final static String USER_NAME = "USE_NAME";
    private final static String USER_PHONE = "USER_PHONE";

    public static void logout(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(ID, 0).commit();
        pref.edit().putString(USER_ID, "").commit();
        pref.edit().putString(USER_NAME, "").commit();
        pref.edit().putString(USER_PHONE, "").commit();

        loginUser = null;


    }

    public static void login(Context context, User loginUser) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(ID, loginUser.getId()).commit();
        pref.edit().putString(USER_ID, loginUser.getUserEmailAddress()).commit();
        pref.edit().putString(USER_NAME, loginUser.getUserName()).commit();
        pref.edit().putString(USER_PHONE, loginUser.getUserPhoneNum()).commit();
    }

    public static User getLoginUser(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        if (pref.getString(USER_ID, "").equals("")) {
//            로그인이 안된 상태
            loginUser = null;
        }
        else {
            loginUser = new User();
            loginUser.setId(pref.getInt(ID, 0));
            loginUser.setUserEmailAddress(pref.getString(USER_ID, ""));
            loginUser.setUserName(pref.getString(USER_NAME, ""));
            loginUser.setUserPhoneNum(pref.getString(USER_PHONE, ""));
        }

        return loginUser;
    }
}
