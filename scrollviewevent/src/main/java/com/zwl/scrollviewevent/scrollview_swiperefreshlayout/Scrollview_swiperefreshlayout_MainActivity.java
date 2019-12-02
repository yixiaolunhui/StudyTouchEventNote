package com.zwl.scrollviewevent.scrollview_swiperefreshlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.zwl.scrollviewevent.R;

/**
 * @author zwl
 * @describe Scrollview_swiperefreshlayout 没有冲突
 * @date on 2019-12-01
 */
public class Scrollview_swiperefreshlayout_MainActivity extends AppCompatActivity {

    SwipeRefreshLayout mSwipeRefreshLayout;

    public static void start(Context context) {
        context.startActivity(new Intent(context, Scrollview_swiperefreshlayout_MainActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_swiperefreshlayout);


        mSwipeRefreshLayout = findViewById(R.id.mRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

    }

}
