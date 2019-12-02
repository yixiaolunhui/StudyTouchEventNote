package com.zwl.recycleviewevent.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.zwl.recycleviewevent.adapter.MyAdapter;
import com.zwl.recycleviewevent.MyDataUtils;
import com.zwl.recycleviewevent.R;

/**
 * @author zwl
 * @date on 2019-12-02
 */
public class MyFragment extends Fragment {
    private final static String KEY_COLOR = "key_color";
    public String color;

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private LinearLayout mLayoutBg;

    public static MyFragment newInstance(String color) {
        MyFragment fragment = new MyFragment();
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
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRefreshLayout = view.findViewById(R.id.mRefreshLayout);

        mLayoutBg = view.findViewById(R.id.my_layout_bg);

        if (!TextUtils.isEmpty(color)) {
            mLayoutBg.setBackgroundColor(Color.parseColor(color));
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter myItemListAdapter = new MyAdapter(this, MyDataUtils.getListData());
        mRecyclerView.setAdapter(myItemListAdapter);

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }

}
