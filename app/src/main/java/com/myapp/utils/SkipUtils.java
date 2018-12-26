package com.myapp.utils;

import com.myapp.R;
import com.myapp.base.BaseFragment;

import androidx.fragment.app.FragmentManager;

public class SkipUtils {
    public static void skipFragment(FragmentManager fragmentManager, BaseFragment baseFragment) {
        fragmentManager.beginTransaction().replace(R.id.fragment_fl,baseFragment,baseFragment.getClass().getName()).addToBackStack(baseFragment.getClass().getName()).commit();

    }
}
