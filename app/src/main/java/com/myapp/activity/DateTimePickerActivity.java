package com.myapp.activity;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.myapp.R;

public class DateTimePickerActivity extends Activity implements View.OnClickListener {
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);
        view = findViewById(R.id.datepicker_timepicker_iv);
        view.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        PopupWindow popupWindow=new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setContentView(LayoutInflater.from(this).inflate(R.layout.pop_layout,null,false));
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);


        popupWindow = new PopupWindow();
        View rootview = LayoutInflater.from(this).inflate(R.layout.activity_date_time_picker, null, false);
        popupWindow.setContentView(rootview);
        popupWindow.setHeight(500);
        popupWindow.setWidth(500);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            popupWindow.setOutsideTouchable(true);
        }

        popupWindow.showAtLocation(view, 0, 0, 0);
    }
}
