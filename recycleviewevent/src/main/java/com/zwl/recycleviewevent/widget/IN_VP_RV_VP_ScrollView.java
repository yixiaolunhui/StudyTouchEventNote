package com.zwl.recycleviewevent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/**
 * @author zwl
 * @describe 内部拦截
 * @date on 2019-11-29
 */
public class IN_VP_RV_VP_ScrollView extends ScrollView {

    private final String TAG = IN_VP_RV_VP_ScrollView.class.getSimpleName();

    private boolean isDisallowInterceptTouchEvent = true;

    private int mTouchSlop;//最小滑动距离

    private float downX = 0;
    private float downY = 0;

    public IN_VP_RV_VP_ScrollView(Context context) {
        this(context, null);
    }

    public IN_VP_RV_VP_ScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IN_VP_RV_VP_ScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = new ViewConfiguration().getScaledTouchSlop();
    }

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
                    isDisallowInterceptTouchEvent = true;
                } else {//水平移动  不管是向左还是向右 因为Scrollview只有竖直滑动所有都返回false
                    Log.e(TAG, "dispatchTouchEvent-水平移动--");
                    isDisallowInterceptTouchEvent = false;
                }

                break;
        }

        //告诉父类不要拦截喔
        getParent().requestDisallowInterceptTouchEvent(isDisallowInterceptTouchEvent);
        return super.onInterceptTouchEvent(ev);
    }
}
