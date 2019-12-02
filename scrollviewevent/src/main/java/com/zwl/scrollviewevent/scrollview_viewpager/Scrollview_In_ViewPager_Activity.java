package com.zwl.scrollviewevent.scrollview_viewpager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.zwl.scrollviewevent.R;
import com.zwl.scrollviewevent.scrollview_viewpager.fragment.AFragment;
import com.zwl.scrollviewevent.scrollview_viewpager.fragment.BFragment;
import com.zwl.scrollviewevent.scrollview_viewpager.fragment.CFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwl
 * @describe Scrollview_在_ViewPager中
 * @date on 2019-12-01
 */
public class Scrollview_In_ViewPager_Activity extends AppCompatActivity {

    ViewPager mViewPager;

    public static void start(Context context) {
        context.startActivity(new Intent(context, Scrollview_In_ViewPager_Activity.class));
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_in_viewpager);

        mViewPager = findViewById(R.id.viewpager);


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());

        MyViewPagerAdapter adapter=new MyViewPagerAdapter(getSupportFragmentManager(),fragments);

        mViewPager.setAdapter(adapter);


    }
}
