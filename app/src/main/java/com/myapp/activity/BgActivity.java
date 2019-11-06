package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.myapp.App;
import com.myapp.R;

public class BgActivity extends AppCompatActivity {

    private float sNoncompatDensity;
    private float sNoncompatScaledDensity;
    private ComponentCallbacks componentCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bg);
        setCustomDensity(true);

    }
    /**
     * 屏幕适配使用
     *
     */
    public void setCustomDensity(boolean isCustom) {
        try {
            if (!isCustom){
                DisplayMetrics metrics = App.context.getResources().getDisplayMetrics();
                if (sNoncompatDensity == 0) {
                    sNoncompatDensity = metrics.density;
                    sNoncompatScaledDensity = metrics.scaledDensity;
                    App.context.registerComponentCallbacks(componentCallbacks);

                }

                DisplayMetrics activityDisplayMetrics = getResources().getDisplayMetrics();
                activityDisplayMetrics.scaledDensity = sNoncompatScaledDensity;
                activityDisplayMetrics.density = activityDisplayMetrics.scaledDensity = sNoncompatDensity;
                activityDisplayMetrics.densityDpi = metrics.densityDpi;
            }else {
                DisplayMetrics metrics = App.context.getResources().getDisplayMetrics();
                if (sNoncompatDensity == 0) {
                    sNoncompatDensity = metrics.density;
                    sNoncompatScaledDensity = metrics.scaledDensity;
                    App.context.registerComponentCallbacks(componentCallbacks);

                }

                //当前设备屏幕总宽度（单位为像素）/ 设计图总宽度（单位为 dp) = density
                float mWidth = metrics.widthPixels;
                float targetDensity = mWidth / 375;
                int targetDensityDpi = (int) (160 * targetDensity);

                metrics.scaledDensity = targetDensity * (sNoncompatScaledDensity / metrics.density);
                metrics.density = targetDensity;
                metrics.densityDpi = targetDensityDpi;


                DisplayMetrics activityDisplayMetrics = getResources().getDisplayMetrics();
                activityDisplayMetrics.scaledDensity = targetDensity * (activityDisplayMetrics.scaledDensity / activityDisplayMetrics.density);
                activityDisplayMetrics.density = activityDisplayMetrics.scaledDensity = targetDensity;
                activityDisplayMetrics.densityDpi = targetDensityDpi;
            }



        }catch (Exception e){}



    }
}
