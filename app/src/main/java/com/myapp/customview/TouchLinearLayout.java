package com.myapp.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * Created by lihaipeng on 2018/7/13.
 */

public class TouchLinearLayout extends LinearLayout {
    public TouchLinearLayout(Context context) {
        super(context);
    }

    public TouchLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        return onTouchEvent(ev);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        float rawY = 0;
//        boolean flag = false;
//        switch (event.getAction()){
//
//            case MotionEvent.ACTION_DOWN:
//                rawY = event.getRawY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                if ((event.getRawY()-rawY)<20){
//                    flag=false;
//                }else {
//                    flag=true;
//                }
//                Log.v("linearlayoutview",event.getRawY()+"");
//                break;
//        }
//        return flag;
//    }
}
