package com.zwl.recycleviewevent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * @author zwl
 * @describe TODO
 * @date on 2019-12-02
 */
public class VP_IN_RV_ViewPager extends ViewPager {
    private final String TAG = "VP_IN_RV_ViewPager";

    private int mTouchSlop;//最小滑动距离

    private boolean isDisallowInterceptTouchEvent = true;

    public VP_IN_RV_ViewPager(@NonNull Context context) {
        this(context, null);
    }

    public VP_IN_RV_ViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = new ViewConfiguration().getScaledTouchSlop();
    }

    float downX, downY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isDisallowInterceptTouchEvent = true;
                downX = ev.getX();
                downY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float offsetX = Math.abs(ev.getX() - downX);
                float offsetY = Math.abs(ev.getY() - downY);
                if (offsetY >= mTouchSlop && offsetY >= offsetX) {//竖直移动
                    Log.e(TAG, "dispatchTouchEvent-竖直移动--");
                    if (downY > ev.getY() && downY - ev.getY() >= mTouchSlop) {// 向下

                    } else if (downY < ev.getY() && ev.getY() - downY >= mTouchSlop) {// 向上

                    }
                    isDisallowInterceptTouchEvent = false;
                } else {//水平移动  不管是向左还是向右 因为Scrollview只有竖直滑动所有都返回false
                    Log.e(TAG, "dispatchTouchEvent-水平移动--");
                    if (downX > ev.getX() && downX - ev.getX() >= mTouchSlop) {// 向左
                        Log.e(TAG, "dispatchTouchEvent-向左");

                    } else if (downX < ev.getX() && ev.getX() - downX >= mTouchSlop) {// 向右
                        Log.e(TAG, "dispatchTouchEvent-向右");

                    }
                    isDisallowInterceptTouchEvent = true;
                }
                break;
        }

        getParent().requestDisallowInterceptTouchEvent(isDisallowInterceptTouchEvent);
        return super.onInterceptTouchEvent(ev);
    }
}
