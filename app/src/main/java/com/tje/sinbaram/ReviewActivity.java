package com.tje.sinbaram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.tje.sinbaram.adapter.ReviewAdapter;
import com.tje.sinbaram.data.Review;

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
    }

    @Override
    public void bindViews() {
        this.writeReviewBtn = (Button) findViewById(R.id.writeReviewBtn);
        this.reviewListView = (ListView) findViewById(R.id.reviewListView);
    }
}
