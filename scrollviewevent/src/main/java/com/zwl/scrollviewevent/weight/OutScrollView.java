package com.zwl.scrollviewevent.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @author zwl
 * @describe 外部拦截法  这个scrollview嵌套scrollview不适合使用此方法
 * @date on 2019-11-29
 */
public class OutScrollView extends ScrollView {
    public OutScrollView(Context context) {
        this(context, null);
    }

    public OutScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OutScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            super.onInterceptTouchEvent(ev);
            return false;
        }
        return true;
    }
}
