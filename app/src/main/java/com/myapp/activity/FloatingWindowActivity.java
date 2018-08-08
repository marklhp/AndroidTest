package com.myapp.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.PixelFormat;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.myapp.App;
import com.myapp.R;
import com.myapp.databinding.ActivityFloatingWindowBinding;

/**
 * 浮动窗口
 */
public class FloatingWindowActivity extends AppCompatActivity implements View.OnClickListener {
     WindowManager windowManager;
     View view;
    View viewById2;

    WindowManager.LayoutParams layoutParams;
     boolean isScal=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFloatingWindowBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_floating_window);
        binding.setClick(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        windowManager = (WindowManager) App.context.getSystemService(Context.WINDOW_SERVICE);
                        layoutParams = new WindowManager.LayoutParams();
                        //设置windowtype
                        layoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;

                        layoutParams.format= PixelFormat.RGBA_8888;

                        //设置Window flag
                        layoutParams.flags=WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL|WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                        layoutParams.gravity= Gravity.TOP;

                        layoutParams.width=WindowManager.LayoutParams.MATCH_PARENT;
                        layoutParams.height=WindowManager.LayoutParams.WRAP_CONTENT;

                        view = LayoutInflater.from(App.context).inflate(R.layout.dialog_window_floating,null,false);
                        viewById2 = view.findViewById(R.id.dialog_window_floating_fl);
                        final View viewById = view.findViewById(R.id.dialog_window_floating);
                        final View viewById1 = view.findViewById(R.id.dialog_window_floating1);
                        final TextView textView = view.findViewById(R.id.dialog_window_floating_tv);
                        final TextView close = view.findViewById(R.id.dialog_window_floating_close_tv);
                        close.setOnClickListener(FloatingWindowActivity.this);
                        view.findViewById(R.id.dialog_window_floating_scal_tv).setOnClickListener(FloatingWindowActivity.this);
                        final FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) viewById.getLayoutParams();
                        final FrameLayout.LayoutParams params1 = (FrameLayout.LayoutParams) viewById1.getLayoutParams();
                        viewById2.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                Log.d("触摸打印",event.getRawY()+"");
                                int lastX = 0, lastY = 0;
                                int paramX = 0, paramY = 0;
                                switch (event.getAction())
                                {
                                    case MotionEvent.ACTION_DOWN:
                                        lastX = (int) event.getX();
                                        lastY = (int) event.getRawY();
                                        paramX = layoutParams.x;
                                        paramY = layoutParams.y;
                                        break;
                                    case MotionEvent.ACTION_MOVE:
                                        int dx = (int) event.getRawX() ;
                                        int dy = (int) event.getRawY();
                                        params.setMargins(0,dy,0,0);
                                        params1.setMargins(dx,0,0,0);
                                        viewById.setLayoutParams(params);
                                        viewById1.setLayoutParams(params1);
                                        textView.setText("宽："+dx+"---"+"高："+dy);
                                        break;
                                }
                                return true;
                            }
                        });
                        windowManager.addView(view,layoutParams);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.floating_window_cl:

                break;
            case R.id.dialog_window_floating_close_tv:
                windowManager.removeView(view);
                break;
            case R.id.dialog_window_floating_scal_tv:

                if (viewById2.getVisibility()==View.VISIBLE){
                    viewById2.setVisibility(View.GONE);
                }else {
                    viewById2.setVisibility(View.VISIBLE);
                }
                break;

        }
    }
}
