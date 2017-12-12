package com.tje.sinbaram.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by the on 2017-12-05.
 */

public class Review implements Serializable{
    private int id;
    private String userId;
    private String content;
    private int rate;
    private String name;

    User user;

    public static Review getUserFromJsonObject(JSONObject json) {
        Review tempReview = new Review();
        try {
            tempReview.setId(json.getInt("id"));
            tempReview.setUserId(json.getString("user_id"));
            tempReview.setContent(json.getString("content"));
            tempReview.setRate(json.getInt("rate"));
            tempReview.setName(json.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tempReview;
    }

    public Review() {
    }

    public Review(int id, String userId, String content, int rate, String name) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.rate = rate;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
