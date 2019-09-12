package com.myapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.myapp.fragment.PlusFourFragment;
import com.myapp.fragment.PlusOneFragment;
import com.myapp.fragment.PlusThreeFragment;
import com.myapp.fragment.PlusTwoFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    Fragment[] fragments={new PlusOneFragment(),new PlusTwoFragment(),new PlusThreeFragment(),new PlusFourFragment()};
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
