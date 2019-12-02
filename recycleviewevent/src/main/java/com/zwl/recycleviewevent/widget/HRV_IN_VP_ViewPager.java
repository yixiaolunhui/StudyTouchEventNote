package com.zwl.recycleviewevent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

/**
 * @author zwl
 * @describe ViewPager 中嵌套水平Recycleview时处理 冲突
 * @date on 2019-12-02
 */
public class HRV_IN_VP_ViewPager extends ViewPager {
    public HRV_IN_VP_ViewPager(@NonNull Context context) {
        super(context);
    }

    public HRV_IN_VP_ViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v.getVisibility() != VISIBLE) {
            return false;
        }
        //如果这个V是Recycleview 还是水平滑动的就返回true
        if (v != this && v instanceof RecyclerView
                && ((RecyclerView) v).getLayoutManager() instanceof LinearLayoutManager
                && ((LinearLayoutManager) ((RecyclerView) v).getLayoutManager()).getOrientation() == LinearLayoutManager.HORIZONTAL) {
            return true;
        }

        //如果子布局是ViewPager滑动时 不拦截
        if (v != this && v instanceof ViewPager) {
            return true;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }
}
