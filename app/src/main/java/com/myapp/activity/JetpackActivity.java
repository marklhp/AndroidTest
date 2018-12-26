package com.myapp.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.myapp.R;
import com.myapp.activity.jetpack.Jetpack2Fragment;
import com.myapp.activity.jetpack.JetpackFragment;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.JetpackActivityBinding;
import com.myapp.utils.StatusBarUtil;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

public class JetpackActivity extends BaseActivity<JetpackActivityBinding> {


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initView() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, JetpackFragment.newInstance())
                .commitNow();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container1, Jetpack2Fragment.newInstance())
                .commitNow();

        //状态栏设置沉浸
        StatusBarUtil.setRootViewFitsSystemWindows(this,false);
        StatusBarUtil.setStatusBarColor(this,0x00000000);
        //设置状态栏字体颜色
        StatusBarUtil.setStatusBarDarkTheme(this,true);

//        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        StatusBarUtil.setStatusBarColor(this,0xFFFF0000);
        StatusBarUtil.setMiuiUI(this,true);

    }

    @Override
    public int getLayoutId() {
        return R.layout.jetpack_activity;
    }
}
