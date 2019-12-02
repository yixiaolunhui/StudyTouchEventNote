package com.zwl.recycleviewevent.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.zwl.recycleviewevent.MyDataUtils;
import com.zwl.recycleviewevent.R;
import com.zwl.recycleviewevent.data.MyData;
import com.zwl.recycleviewevent.fragment.MyItemAFragment;
import com.zwl.recycleviewevent.fragment.MyItemBFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwl
 * @date on 2019-12-02
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_NAME = 100;
    private final int TYPE_VIEWPAGER = 101;
    private final int TYPE_LIST = 102;

    private Fragment mFragment;
    private Context mContext;
    private List<MyData> mDataList;

    public MyAdapter(Fragment context, List<MyData> dataList) {
        this.mFragment = context;
        this.mContext = context.getContext();
        this.mDataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_NAME) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
            return new NameHolder(view);
        } else if (viewType == TYPE_LIST) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            return new ListHolder(view);
        } else if (viewType == TYPE_VIEWPAGER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewpager, parent, false);
            return new ViewPagerHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
            return new NameHolder(view);
        }

    }

    /**
     * name item
     */
    class NameHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public NameHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_name);
        }
    }

    /**
     * list item
     */
    class ListHolder extends RecyclerView.ViewHolder {

        RecyclerView mRecyclerView;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.item_recycler_view);
            LinearSnapHelper snapHelper=new LinearSnapHelper();
            snapHelper.attachToRecyclerView(mRecyclerView);
        }
    }

    /**
     * viewpager item
     */
    class ViewPagerHolder extends RecyclerView.ViewHolder {

        ViewPager mViewPager;

        public ViewPagerHolder(@NonNull View itemView) {
            super(itemView);
            mViewPager = itemView.findViewById(R.id.item_viewpager_layout);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof NameHolder) {
            NameHolder nameHolder = (NameHolder) holder;
            nameHolder.textView.setText(mDataList.get(position).name);
        } else if (holder instanceof ViewPagerHolder) {
            ViewPagerHolder viewPagerHolder = (ViewPagerHolder) holder;

            List<Fragment> fragments = new ArrayList<>();
            fragments.add(MyItemBFragment.newInstance("#BBFFFF"));
            fragments.add(MyItemBFragment.newInstance("#408080"));

            MyViewPagerAdapter adapter = new MyViewPagerAdapter(mFragment.getChildFragmentManager(), fragments);
            viewPagerHolder.mViewPager.setAdapter(adapter);

        } else if (holder instanceof ListHolder) {
            ListHolder listHolder = (ListHolder) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            listHolder.mRecyclerView.setLayoutManager(linearLayoutManager);
            MyItemListAdapter myItemListAdapter = new MyItemListAdapter(mContext, MyDataUtils.getItemListData());
            listHolder.mRecyclerView.setAdapter(myItemListAdapter);

        }
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }


    @Override
    public int getItemViewType(int position) {
        MyData myData = mDataList.get(position);
        switch (myData.type) {
            case MyData.TYPE_LIST:
                return TYPE_LIST;
            case MyData.TYPE_VIEWPAGER:
                return TYPE_VIEWPAGER;
            default:
                return TYPE_NAME;
        }
    }
}
