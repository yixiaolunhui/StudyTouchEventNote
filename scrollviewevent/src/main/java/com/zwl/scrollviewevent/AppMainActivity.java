package com.zwl.scrollviewevent;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zwl.scrollviewevent.scrollview_recyclerview.ScrollView_RecyclerView_MainActivity;
import com.zwl.scrollviewevent.scrollview_scrollview.ScrollView_ScrollView_MainActivity;
import com.zwl.scrollviewevent.scrollview_swiperefreshlayout.Scrollview_swiperefreshlayout_MainActivity;
import com.zwl.scrollviewevent.scrollview_viewpager.Scrollview_viewpager_MainActivity;

/**
 * @author zwl
 * @describe 首页
 * @date on 2019-11-30
 */
public class AppMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);

        //Scrollview嵌套ScrollView
        findViewById(R.id.scrollview_scrollview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollView_ScrollView_MainActivity.start(AppMainActivity.this);
            }
        });


        //ScrollVIew中嵌套Recycleview
        findViewById(R.id.scrollview_recycleview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollView_RecyclerView_MainActivity.start(AppMainActivity.this);
            }
        });


        //swiperefreshlayout 中嵌套scrollview
        findViewById(R.id.scrollview_swiperefreshlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scrollview_swiperefreshlayout_MainActivity.start(AppMainActivity.this);
            }
        });


        //scrollview和viewpager嵌套
        findViewById(R.id.scrollview_viewpager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scrollview_viewpager_MainActivity.start(AppMainActivity.this);
            }
        });
    }
}
