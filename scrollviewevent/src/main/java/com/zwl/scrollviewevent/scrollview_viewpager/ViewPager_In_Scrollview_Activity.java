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
 * @describe ViewPager_在_Scrollview中
 * @date on 2019-12-01
 */
public class ViewPager_In_Scrollview_Activity extends AppCompatActivity {
    ViewPager mViewPager;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ViewPager_In_Scrollview_Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_in_scrollview);


        mViewPager = findViewById(R.id.vp_in_sv);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());

        MyViewPagerAdapter adapter=new MyViewPagerAdapter(getSupportFragmentManager(),fragments);

        mViewPager.setAdapter(adapter);
    }
}
