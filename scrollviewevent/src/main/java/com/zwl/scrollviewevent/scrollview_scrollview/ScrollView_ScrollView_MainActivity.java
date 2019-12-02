package com.zwl.scrollviewevent.scrollview_scrollview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zwl.scrollviewevent.R;

public class ScrollView_ScrollView_MainActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, ScrollView_ScrollView_MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //内部拦截法
        findViewById(R.id.sv_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollView_ScrollView_InActivity.start(ScrollView_ScrollView_MainActivity.this);
            }
        });

        //外部拦截法
        findViewById(R.id.sv_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollView_ScrollView_OutActivity.start(ScrollView_ScrollView_MainActivity.this);
            }
        });

        //优化版本
        findViewById(R.id.sv_other).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollView_ScrollView_OtherActivity.start(ScrollView_ScrollView_MainActivity.this);
            }
        });

    }

}
