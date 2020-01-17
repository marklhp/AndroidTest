package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityFragmentSwitchBinding;
import com.myapp.myfragment.Test1Fragment;
import com.myapp.myfragment.Test2Fragment;
import com.myapp.myfragment.Test3Fragment;
import com.myapp.myfragment.Test4Fragment;

import java.util.List;

public class FragmentSwitchActivity extends BaseActivity<ActivityFragmentSwitchBinding> implements View.OnClickListener {
    Fragment[] fragments=new Fragment[4];
    FragmentTransaction fragmentTransaction;

    @Override
    protected void initView() {
        binding.setClick(this);

        fragments[0] = new Test1Fragment();

        fragments[1] = new Test2Fragment();

        fragments[2] = new Test3Fragment();

        fragments[3] = new Test4Fragment();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : fragments) {
            fragmentTransaction.remove(fragment);
        }
        fragmentTransaction.commit();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : fragments) {
            fragmentTransaction.add(R.id.fragment_switch_fl,fragment);
        }
        for (Fragment fragment : fragments) {
            if (!fragment.isHidden()){
                fragmentTransaction.hide(fragment);
            }
        }

        fragmentTransaction.show(fragments[0]).commit();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_fragment_switch;
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.fragment_switch_tv1:

                for (Fragment fragment : fragments) {
                    if (!fragment.isHidden()){
                        fragmentTransaction.hide(fragment);
                    }
                }

                fragmentTransaction.show(fragments[0]).commit();

                break;
            case R.id.fragment_switch_tv2:
                for (Fragment fragment : fragments) {
                    if (!fragment.isHidden()){
                        fragmentTransaction.hide(fragment);
                    }
                }

                fragmentTransaction.show(fragments[1]).commit();

                break;
            case R.id.fragment_switch_tv3:
                for (Fragment fragment : fragments) {
                    if (!fragment.isHidden()){
                        fragmentTransaction.hide(fragment);
                    }
                }

                fragmentTransaction.show(fragments[2]).commit();

                break;
            case R.id.fragment_switch_tv4:
                for (Fragment fragment : fragments) {
                    if (!fragment.isHidden()){
                        fragmentTransaction.hide(fragment);
                    }
                }

                fragmentTransaction.show(fragments[3]).commit();

                break;
        }
    }
}
