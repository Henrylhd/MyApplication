package com.example.henry.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.henry.myapplication.R;

public class WheelPickkerActivity extends AppCompatActivity {
    /**
     *
     *  @作者  henry
     *
     *  @创建日期   2017/3/4 16:23
     *
     */
  private Button backToMainBtn = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_pickker);
        backToMainBtn = (Button) findViewById(R.id.backToMainBtn);

    }
    public void backToMain(View view){
        Intent intent = new Intent(WheelPickkerActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
