package com.example.henry.myapplication.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.henry.myapplication.R;

import java.util.ArrayList;

import lib.homhomlib.view2.DivergeView;

public class DivegerViewActivity extends AppCompatActivity {
    /**
     *
     *  @作者  henry
     *
     *  @创建日期   2017/3/4 16:23
     *
     */
    private DivergeView mDivergeView;
    private Button mBtnStart;
    private Button mBtnBack;
    private ImageView mImageView;
    private ArrayList<Bitmap> mList;
    private int mIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diveger_view);
        mBtnStart = (Button) findViewById(R.id.btnStart);
        mBtnBack = (Button) findViewById(R.id.btnBack);
        mImageView =(ImageView)findViewById(R.id.iv_start);
        mList = new ArrayList<>();
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm1, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm2, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm3, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm4, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm5, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm6, null)).getBitmap());
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mIndex == 5){
                    mIndex = 0 ;
                }
                mDivergeView.startDiverges(mIndex);
                mIndex++;
//                if (mDivergeView.isRunning()) {
//                    mDivergeView.stop();
//                } else {
//
//                }
            }
        });
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DivegerViewActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        mDivergeView = (DivergeView) findViewById(R.id.divergeView);
        mDivergeView.post(new Runnable() {
            @Override
            public void run() {
                mDivergeView.setEndPoint(new PointF(mDivergeView.getMeasuredWidth()/2,0));
                mDivergeView.setDivergeViewProvider(new Provider());
            }
        });
//        mDivergeView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mList != null){
            mList.clear();
            mList = null;
        }

    }

    class Provider implements DivergeView.DivergeViewProvider{

        @Override
        public Bitmap getBitmap(Object obj) {
            return mList == null ? null : mList.get((int)obj);
        }


    }
}
