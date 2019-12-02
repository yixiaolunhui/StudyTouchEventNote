package com.zwl.scrollviewevent.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/**
 * @author zwl
 * @describe 内部优化版本
 * @date on 2019-11-29
 */
public class OptimizeScrollView extends ScrollView {

    private final String TAG = "OptimizeScrollView";

    private boolean isDisallowInterceptTouchEvent = true;

    private boolean isTop; //顶部
    private boolean isBottom;//底部
    private boolean isLeft;//左边
    private boolean isRight;//右边

    private int mTouchSlop;//最小滑动距离


    public OptimizeScrollView(Context context) {
        this(context, null);
    }

    public OptimizeScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OptimizeScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ViewConfiguration mVelocityTracker = new ViewConfiguration();
        mTouchSlop = mVelocityTracker.getScaledTouchSlop();
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        isTop = false;
        isBottom = false;
        isLeft = false;
        isRight = false;
        //到达顶部
        if (getScrollY() == 0) {
            isTop = true;
            Log.e(TAG, "顶部----getScrollY()=" + getScrollY());
        }
        //到达底部
        View contentView = getChildAt(0);
        if (contentView != null && contentView.getMeasuredHeight() == (getScrollY() + getHeight())) {
            isBottom = true;
            Log.e(TAG, "底部----getScrollY()=" + getScrollY());
        }

        //到达左边
        if (getScrollX() == 0) {
            isLeft = true;
            Log.e(TAG, "左边----getScrollX()=" + getScrollX());
        }

        //到达右边
        if (contentView != null && contentView.getMeasuredWidth() == (getScrollX() + getWidth())) {
            isRight = true;
            Log.e(TAG, "右边----getScrollX()=" + getScrollX());
        }
    }

    private float downX = 0;
    private float downY = 0;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "----dispatchTouchEvent=" + ev.getAction());
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
                        Log.e(TAG, "dispatchTouchEvent-向下----isBottom=" + isBottom);
                        if (isBottom) {
                            isDisallowInterceptTouchEvent = false;
                        } else {
                            isDisallowInterceptTouchEvent = true;
                        }

                    } else if (downY < ev.getY() && ev.getY() - downY >= mTouchSlop) {// 向上
                        Log.e(TAG, "dispatchTouchEvent-向上----isTop=" + isTop);
                        if (isTop) {
                            isDisallowInterceptTouchEvent = false;
                        } else {
                            isDisallowInterceptTouchEvent = true;
                        }
                    }
                } else {//水平移动  不管是向左还是向右 因为Scrollview只有竖直滑动所有都返回false
                    Log.e(TAG, "dispatchTouchEvent-水平移动--");
                    if (downX > ev.getX() && downX - ev.getX() >= mTouchSlop) {// 向左
                        Log.e(TAG, "dispatchTouchEvent-向左");
                        isDisallowInterceptTouchEvent = false;

                    } else if (downX < ev.getX() && ev.getX() - downX >= mTouchSlop) {// 向右
                        Log.e(TAG, "dispatchTouchEvent-向右");
                        isDisallowInterceptTouchEvent = false;

                    }
                }

                break;
        }
        getParent().requestDisallowInterceptTouchEvent(isDisallowInterceptTouchEvent);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(isDisallowInterceptTouchEvent);
        return super.onInterceptTouchEvent(ev);
    }
}
