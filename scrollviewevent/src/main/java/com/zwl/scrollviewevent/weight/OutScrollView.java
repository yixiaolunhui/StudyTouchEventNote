package com.zwl.scrollviewevent.weight;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import com.zwl.scrollviewevent.R;



/**
 * @author zwl
 * @describe 外部拦截法  这个scrollview嵌套scrollview不适合使用此方法
 * 外部拦截法指点击事件首先都会经过父容器的拦截处理，父容器如果需要此事件就进行拦截，如果不需要此事件就不进行拦截，这样就可以解决滑动冲突问题。外部拦截法主要就是重写父容器的onInterceptTouchEvent方法，但是要注意，父容器拦截不能在ACTION_DOWN中返回true，否则之后的所有事件序列都会交给它处理，无论返回什么，因为不会再调用它的onInterceptTouchEvent函数了。所以父控件应该在ACTION_MOVE中选择是否拦截。但是这种拦截的问题是，如果拦截了，那么子控件的onClick事件将无法再出发了。
 * 伪代码如下：
 * https://zhuanlan.zhihu.com/p/96810719
 * @date on 2019-11-29
 */
public class OutScrollView extends ScrollView {
    private View tagetView;

    public OutScrollView(Context context) {
        this(context, null);
    }

    public OutScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OutScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    //    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
//        ev?.run {
//            if (action == MotionEvent.ACTION_MOVE && 父容器需要点击事件){
//                return true
//            }
//        }
//        return super.onInterceptTouchEvent(ev)
//    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE && isClickInViewRect(tagetView, ev)) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tagetView = findViewById(R.id.in_scroll);
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
