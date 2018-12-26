package com.myapp.activity.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityNavigationBinding;

public class NavigationActivity extends BaseActivity<ActivityNavigationBinding> {


    @Override
    protected void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_navigation;
    }
    @Override
    public boolean onSupportNavigateUp() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);

        return NavHostFragment.findNavController(fragment).navigateUp();
    }
}
