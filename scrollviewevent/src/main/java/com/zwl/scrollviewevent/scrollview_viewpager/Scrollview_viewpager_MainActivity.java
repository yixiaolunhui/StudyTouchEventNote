package com.zwl.scrollviewevent.scrollview_viewpager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zwl.scrollviewevent.R;

/**
 * @author zwl
 * @describe Scrollview_viewpager
 * @date on 2019-12-01
 */
public class Scrollview_viewpager_MainActivity extends AppCompatActivity {
    public static void start(Context context) {
        context.startActivity(new Intent(context, Scrollview_viewpager_MainActivity.class));
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_viewpager);

        findViewById(R.id.sv_vp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scrollview_In_ViewPager_Activity.start(Scrollview_viewpager_MainActivity.this);
            }
        });
        findViewById(R.id.vp_sv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager_In_Scrollview_Activity.start(Scrollview_viewpager_MainActivity.this);
            }
        });
        findViewById(R.id.vp_sv_vp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager_In_Scrollview_In_ViewPager_Activity.start(Scrollview_viewpager_MainActivity.this);
            }
        });
    }
}
