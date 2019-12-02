package com.zwl.viewpagerevent;

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

/**
 * @author zwl
 * @date on 2019-12-02
 */
public class EFragment extends Fragment {
    LinearLayout mLayoutBg;

    private final static String KEY_COLOR = "key_color";

    public String color;

    public static EFragment newInstance(String color) {
        EFragment fragment = new EFragment();
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
        View view = inflater.inflate(R.layout.fragment_e, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mLayoutBg = view.findViewById(R.id.dfragment_bg);
        if (!TextUtils.isEmpty(color)) {
            mLayoutBg.setBackgroundColor(Color.parseColor(color));
        }
    }
}
