package com.zwl.recycleviewevent.fragment;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zwl.recycleviewevent.MyDataUtils;
import com.zwl.recycleviewevent.R;
import com.zwl.recycleviewevent.adapter.MyItemListAdapter;

/**
 * @author zwl
 * @date on 2019-12-02
 */
public class MyItemBFragment extends Fragment {

    private final static String KEY_COLOR = "key_color";
    public String color;

    public LinearLayout mLayoutBg;

    private RecyclerView mRecyclerView;

    public static MyItemBFragment newInstance(String color) {
        MyItemBFragment fragment = new MyItemBFragment();
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
        View view = inflater.inflate(R.layout.fragment_item_my_b, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mLayoutBg = view.findViewById(R.id.item_my_layout_bg);
        mRecyclerView = view.findViewById(R.id.item_recycler_view);
        if (!TextUtils.isEmpty(color)) {
            mLayoutBg.setBackgroundColor(Color.parseColor(color));
        }


        GridLayoutManager linearLayoutManager = new GridLayoutManager(this.getContext(), 4);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        MyItemListAdapter myItemListAdapter = new MyItemListAdapter(this.getContext(), MyDataUtils.getItemBListData());
        mRecyclerView.setAdapter(myItemListAdapter);

    }

}
