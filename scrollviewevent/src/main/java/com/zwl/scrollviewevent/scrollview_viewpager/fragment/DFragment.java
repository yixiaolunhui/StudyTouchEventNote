package com.zwl.scrollviewevent.scrollview_viewpager.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.zwl.scrollviewevent.R;
import com.zwl.scrollviewevent.scrollview_viewpager.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwl
 * @date on 2019-12-02
 */
public class DFragment extends Fragment {
    ViewPager mViewPager;
    LinearLayout mLayoutBg;

    private final static String KEY_COLOR = "key_color";

    public String color;

    public static DFragment newInstance(String color) {
        DFragment fragment = new DFragment();
        Bundle args = new Bundle();
        args.putString(KEY_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getString(KEY_COLOR);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_viewpager_in_scrollview, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {

        mViewPager = view.findViewById(R.id.vp_in_sv);
        mLayoutBg = view.findViewById(R.id.dfragment_bg);


        if (!TextUtils.isEmpty(color)) {
            mLayoutBg.setBackgroundColor(Color.parseColor(color));
        }


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getChildFragmentManager(), fragments);

        mViewPager.setAdapter(adapter);
    }
}
