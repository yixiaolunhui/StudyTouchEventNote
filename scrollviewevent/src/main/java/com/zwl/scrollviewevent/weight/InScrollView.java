package com.zwl.scrollviewevent.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @author zwl
 * @describe 内部拦截
 * @date on 2019-11-29
 */
public class InScrollView extends ScrollView {

    public InScrollView(Context context) {
        super(context);
    }

    public InScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //告诉父类不要拦截喔
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(ev);
    }
}
