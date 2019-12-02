package com.zwl.recycleviewevent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.zwl.recycleviewevent.adapter.MyViewPagerAdapter;
import com.zwl.recycleviewevent.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewPager = findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(2);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(MyFragment.newInstance("#D81B60"));
        fragments.add(MyFragment.newInstance("#408080"));
        fragments.add(MyFragment.newInstance("#B766AD"));
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragments);

        mViewPager.setAdapter(adapter);
    }
}
