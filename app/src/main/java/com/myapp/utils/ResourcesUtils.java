package com.myapp.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;

import com.myapp.App;

public class ResourcesUtils {
    public static Drawable getDrawable(int imageId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return App.context.getResources().getDrawable(imageId, null);
        } else {
            return App.context.getResources().getDrawable(imageId);
        }
    }

    public static int getColor(int resId) {
        return App.context.getResources().getColor(resId);
    }

    public static String getString(int resId) {
        return App.context.getResources().getString(resId);
    }

    public static LayoutInflater getInflater() {
        return LayoutInflater.from(App.context);
    }

    public static Resources getResources() {

        return App.context.getResources();
    }

}
