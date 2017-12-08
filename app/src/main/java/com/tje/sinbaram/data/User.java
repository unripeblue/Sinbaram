package com.tje.sinbaram.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by the on 2017-11-29.
 */

public class User implements Serializable {

    public static User getUserFromJsonObject(JSONObject json) {
        User tempUser = new User();
        try {
            tempUser.setId(json.getInt("id"));
            tempUser.setUserName(json.getString("name"));
            tempUser.setUserEmailAddress(json.getString("email"));
            tempUser.setUserPhoneNum(json.getString("phone"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tempUser;
    }

    private int id;
    private String userName;
    private String userEmailAddress;
    private String userPhoneNum;
    private String myCouponList;

    public User() {
    }

    public User(int id, String userName, String userEmailAddress, String userPhoneNum, String myCouponList) {
        this.id = id;
        this.userName = userName;
        this.userEmailAddress = userEmailAddress;
        this.userPhoneNum = userPhoneNum;
        this.myCouponList = myCouponList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String getMyCouponList() {
        return myCouponList;
    }

    public void setMyCouponList(String myCouponList) {
        this.myCouponList = myCouponList;
    }


}
