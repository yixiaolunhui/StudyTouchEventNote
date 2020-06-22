package com.zwl.scrollviewevent.weight;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * 内部拦截法
 * 重写子元素的 dispatchTouchEvent() 方法，得到伪代码如下：
 * override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
 * ev?.run {
 * when(action){
 * MotionEvent.ACTION_DOWN -> parent.requestDisallowInterceptTouchEvent(true)
 * MotionEvent.ACTION_MOVE ->{
 * if(满足需要让外部容器拦截事件){
 * parent.requestDisallowInterceptTouchEvent(false)
 * }
 * }
 * }
 * }
 * return super.dispatchTouchEvent(ev)
 * }
 * <p>
 * <p>
 * 当我们的父容器拦截掉 ACTION_DOWN 事件的时候，所有的事件都无法再传递到子元素中，自然也就不会调用上面我们写的 dispatchTouchEvent() 方法了。所以我们在内部拦截法的时候还需要重写父容器的 onInterceptTouchEvent() 方法。
 * <p>
 * override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
 * ev?.run {
 * if (action == MotionEvent.ACTION_DOWN){
 * return false
 * }
 * }
 * return super.onInterceptTouchEvent(ev)
 * }
 */
public class OutInScrollView extends ScrollView {

    public OutInScrollView(Context context) {
        this(context, null);
    }

    public OutInScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OutInScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                getParent().requestDisallowInterceptTouchEvent(isClickInViewRect(this, ev));
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    /**
     * 触摸事件 是否在指定view内
     **/
    public static boolean isClickInViewRect(View v, MotionEvent event) {
        Rect rect = new Rect();
        //获取View可点击矩形左、上、右、下边界相对于父View的左顶点的距离（偏移量）放到 Rect中
        v.getHitRect(rect);
        float eventX = event.getX();
        float eventY = event.getY();
        return rect.contains((int) eventX, (int) eventY);
    }

}
