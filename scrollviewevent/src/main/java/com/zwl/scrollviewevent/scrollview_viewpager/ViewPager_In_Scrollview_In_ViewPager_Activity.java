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
import com.zwl.scrollviewevent.scrollview_viewpager.fragment.DFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwl
 * @describe ViewPager_In_Scrollview_In_ViewPager
 * @date on 2019-12-02
 */
public class ViewPager_In_Scrollview_In_ViewPager_Activity extends AppCompatActivity {

    ViewPager mViewPager;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ViewPager_In_Scrollview_In_ViewPager_Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_in_scrollview_in_viewpager);

        mViewPager = findViewById(R.id.viewpager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(DFragment.newInstance("#A52A2A"));
        fragments.add(DFragment.newInstance("#607B8B"));
        fragments.add(DFragment.newInstance("#0000FF"));

        MyViewPagerAdapter adapter=new MyViewPagerAdapter(getSupportFragmentManager(),fragments);

        mViewPager.setAdapter(adapter);

    }
}
