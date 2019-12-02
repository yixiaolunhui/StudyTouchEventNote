package com.zwl.scrollviewevent.scrollview_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zwl.scrollviewevent.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwl
 * @describe ScrollView_RecyclerView    没有冲突
 * @date on 2019-11-30
 */
public class ScrollView_RecyclerView_MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    RecyclerAdapter mRecyclerAdapter;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ScrollView_RecyclerView_MainActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_recyclerview);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerAdapter = new RecyclerAdapter(getData());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);

    }

    private List<MyData> getData() {
        List<MyData> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyData myData = new MyData();
            myData.name = "测试数据" + i;
            dataList.add(myData);
        }
        return dataList;
    }
}
