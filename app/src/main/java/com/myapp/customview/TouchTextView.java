package com.myapp.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by lihaipeng on 2018/7/13.
 */

public class TouchTextView extends android.support.v7.widget.AppCompatTextView {
    public TouchTextView(Context context) {
        super(context);
    }

    public TouchTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.v("textview",event.getRawY()+"");
        return super.onTouchEvent(event);
    }
}
