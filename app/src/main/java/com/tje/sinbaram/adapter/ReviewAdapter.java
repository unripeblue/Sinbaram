package com.tje.sinbaram.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tje.sinbaram.R;
import com.tje.sinbaram.ReviewWriteActivity;
import com.tje.sinbaram.data.Review;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

import static android.R.attr.rating;

/**
 * Created by the on 2017-12-05.
 */

public class ReviewAdapter extends ArrayAdapter<Review> {

    Context mContext;
    List<Review> mList;
    LayoutInflater inf;

    public ReviewAdapter(Context context, List<Review> list) {
        super(context, R.layout.review_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            // 거의 반드시 딱 한줄만 if문 안에 들어옴.
            row = inf.inflate(R.layout.review_list_item, null);


        }
        final RatingBar ratingBar = (RatingBar) row.findViewById(R.id.ratingBar);
        final TextView writerNameTxt = (TextView) row.findViewById(R.id.writerNameTxt);
        final TextView contentTxt = (TextView) row.findViewById(R.id.contentTxt);


        final Review data = mList.get(position);

        ratingBar.setRating(data.getRate());
        writerNameTxt.setText(data.getName());
        contentTxt.setText(data.getContent());


        return row;
    }

}



