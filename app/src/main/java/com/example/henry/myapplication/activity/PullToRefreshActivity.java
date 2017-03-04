package com.example.henry.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.henry.myapplication.R;
import com.itheima.pulltorefreshlib.PullToRefreshBase;
import com.itheima.pulltorefreshlib.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class PullToRefreshActivity extends AppCompatActivity {
    /**
     *
     *  @作者  henry
     *
     *  @创建日期   2017/3/4 19:34
     *
     */
    private ArrayList<String> mItems = new ArrayList<>();
    private ArrayAdapter  mArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh);

        final PullToRefreshListView pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_to_refresh_list_view);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mockList(0, 300));
        pullToRefreshListView.setAdapter(mArrayAdapter);
        //设置模式BOTH,既能上拉也能下拉
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        //设置刷新监听
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            /**
             * 下拉刷新回调
             * @param refreshView
             */
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //模拟延时两秒刷新
                pullToRefreshListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mItems.clear();
                        mockList(0, 20);
                        mArrayAdapter.notifyDataSetChanged();
                        pullToRefreshListView.onRefreshComplete();

                    }
                }, 2000);
            }
            /**
             * 上拉加载更多回调
             * @param refreshView
             */

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //模拟延时两秒加载更多数据
                pullToRefreshListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mockList(mItems.size(), 20);
                        mArrayAdapter.notifyDataSetChanged();
                        pullToRefreshListView.onRefreshComplete();
                    }
                }, 2000);
            }
        });
    }
    //添加模拟数据
    private List<String> mockList(int start, int count){
        /**
         * 创建或动态添加测试用的数据列表
         * @param start 数据的起始位置
         * @param count 数据的个数
         * @return 当前的数据列表
         */
        for(int i = start; i < start + count; i++){
            mItems.add("talk the cheap, give me the code："+ i);
        }
        return mItems;
    }
}
