package com.example.henry.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.henry.myapplication.R;
import com.itheima.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    private Button showWheelPickerBtn;
    private Button showDivergeViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showWheelPickerBtn = (Button) findViewById(R.id.showWheelPickerbtn);
        showDivergeViewBtn = (Button) findViewById(R.id.btnDivergeView);

    }
    public void showDialog(View view){
        new MaterialDialog.Builder(this)
        .title("标题")
        .content("描述内容")
        .positiveText("确定")
        .negativeText("取消")
        .show();

    }
    public void showWheelPicker(View view){
        Intent intent = new Intent(MainActivity.this,WheelPickkerActivity.class);
        startActivity(intent);
    }

    public void showDivergeView(View view){
        Intent intent = new Intent(MainActivity.this,DivegerViewActivity.class);
        startActivity(intent);
    }
}
