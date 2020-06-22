package com.zwl.scrollviewevent.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @author zwl
 * @describe 内部拦截
 * 解决方法二：内部拦截法
 * 	内部拦截法指的是父容器不拦截任何事件，所有事件全部传递给子元素，如果子元素需要就进行消耗，否则交由父容器进行处理。这种方式需要配合ViewGroup的FLAG_DISALLOW_INTERCEPT标志位来使用。设置此标志为可以通过requestDisallowIntercept TouchEvent函数来设置，如果设置了此标志位，那么ViewGroup就无法拦截除了ACTION_DOWN之外的任何事件。这样首先我们保证ViewGroup的onInterceptTouchEvent方法除了DOWN其他都返回true，DOWN返回false，这样保证了不会拦截DOWN事件，交给它的子View进行处理；重写View的dispatchTouchEvent函数，在DOWN中设置parent.requestDisallowInterceptTouchEvent(true)，这样父控件在默认的情况下DOWN之后的所有事件它都拦截不到，交由子View来处理，View在MOVE中判断父控件需要时，调用parent.requestDisallow InterceptTouchEvent(false)，这样父控件的拦截又起作用了，相应的事件交给了父控件进行处理。伪代码如下：
 * 父控件中：
 * @Override
 * public boolean onInterceptTouchEvent(MotionEvent ev) {
 *     int action = ev.getAction();
 *     if(action == MotionEvent.ACTION_DOWN){
 *         return false;
 *     } else {
 *         return true;
 *     }
 * }
 *
 * 子View中：
 * @Override
 * public boolean dispatchTouchEvent(MotionEvent ev) {
 *
 *     switch (ev.getAction()){
 *         case MotionEvent.ACTION_DOWN:
 *             getParent().requestDisallowInterceptTouchEvent(true);
 *             break;
 *         case MotionEvent.ACTION_MOVE:
 *             if(父控件需要此点击事件){
 *                 getParent().requestDisallowInterceptTouchEvent(false);
 *             }
 *             break;
 *         case MotionEvent.ACTION_UP:
 *             break;
 *     }
 * }
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
