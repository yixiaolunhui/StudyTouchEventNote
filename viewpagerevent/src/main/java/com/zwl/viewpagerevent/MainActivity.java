package com.zwl.viewpagerevent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewPager = findViewById(R.id.viewPager);



        List<Fragment> fragments = new ArrayList<>();
        fragments.add(DFragment.newInstance("#BBFFFF"));
        fragments.add(DFragment.newInstance("#408080"));
        fragments.add(DFragment.newInstance("#B766AD"));
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragments);

        mViewPager.setAdapter(adapter);
    }
}
