package com.zwl.scrollviewevent.scrollview_viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author zwl
 * @date on 2019-12-01
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;

    public MyViewPagerAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.fragments = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
