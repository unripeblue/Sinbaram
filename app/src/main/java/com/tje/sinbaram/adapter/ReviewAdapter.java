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
import android.widget.TextView;

import com.tje.sinbaram.R;
import com.tje.sinbaram.ReviewWriteActivity;
import com.tje.sinbaram.data.Review;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

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
        final TextView replyBtn = (TextView) row.findViewById(R.id.replyBtn);


//        final Review data = mList.get(position);
//
//        // 왜 final을 붙여야 에러가 안나지?
//        // final : 수정이 불가능한 변수로 굳히기.
//
//        LinearLayout previewLayout = (LinearLayout) row.findViewById(R.id.previewLayout);
//
//        // Adapter의 getView에서 if를 통해 작업할때는
//        // 반드시 else의 경우도 작업해주자.
//        // 왜? Adapter를 활용하는 View는 재활용이 기본옵션.
//        if (data.getLinkUrl().length() == 0) {
//            previewLayout.setVisibility(View.GONE);
//        }
//        else {
//            previewLayout.setVisibility(View.VISIBLE);
//        }
//
//        TextView writerNameTxt = (TextView) row.findViewById(R.id.writerNameTxt);
//        writerNameTxt.setText(data.getWriterData().getUserName());
//
//        String minuteStr = TimeAgoUtil.getTimeAgoString(data.getMinuteAgo());
//        TextView minuteAgoTxt = (TextView) row.findViewById(R.id.minuteAgoTxt);
//        minuteAgoTxt.setText(minuteStr);
//
//        TextView contentTxt = (TextView) row.findViewById(R.id.contentTxt);
//        contentTxt.setText(data.getContentText());
//
//
//        String likeCountStr = String.format(Locale.KOREA, "%,d개", data.getLikeCount());
//        TextView likeCountTxt = (TextView) row.findViewById(R.id.likeCountTxt);
//        likeCountTxt.setText(likeCountStr);
//
//
//
//        Button likeBtn = (Button) row.findViewById(R.id.likeBtn);
//        Button replyBtn = (Button) row.findViewById(R.id.replyBtn);

//
//        likeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "좋아요를 눌렀습니다.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        replyBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, ReplyListActivity.class);
//                intent.putExtra("댓글달린뉴스피드", data);
//                intent.putExtra("몇번째줄", position);
//                mContext.startActivity(intent);
//            }
//        });

        return row;
    }

    @Override
    public int getCount() {
        return 2;
    }
}



