package com.tje.sinbaram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.tje.sinbaram.adapter.ReviewAdapter;
import com.tje.sinbaram.data.Review;
import com.tje.sinbaram.util.ServerUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends BaseActivity {


    private android.widget.ListView reviewListView;
    List<Review> reviewList = new ArrayList<>();
    ReviewAdapter mReviewAdapter;
    private Button writeReviewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {


        writeReviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ReviewWriteActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {
        mReviewAdapter = new ReviewAdapter(mContext, reviewList);
        reviewListView.setAdapter(mReviewAdapter);

        ServerUtil.review(mContext, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    JSONArray reviews = json.getJSONArray("reviews");
                    for (int i=0; i<reviews.length(); i++) {
                        JSONObject review = reviews.getJSONObject(i);
                        Review tempReview = Review.getUserFromJsonObject(review);
                        reviewList.add(tempReview);
                    }
                    mReviewAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void bindViews() {
        this.writeReviewBtn = (Button) findViewById(R.id.writeReviewBtn);
        this.reviewListView = (ListView) findViewById(R.id.reviewListView);
    }
}
