package com.myapp.activity.jetpack;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myapp.R;
import com.myapp.databinding.JetpackFragmentBinding;
import com.myapp.model.CarBean;
import com.myapp.model.StudentBean;
import com.myapp.model.UserBean;
import com.myapp.utils.httputil.HttpCallBack;


public class JetpackFragment extends Fragment implements View.OnClickListener {
    JetpackFragmentBinding binding;
    String string;
    int num=0;
    UserBean bean;

    private JetpackViewModel mViewModel;

    public static JetpackFragment newInstance() {
        return new JetpackFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.jetpack_fragment,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(JetpackViewModel.class);

        binding.setClick(this);
        // TODO: Use the ViewModel
        JetpackModel.getUser().observe(this, new Observer<UserBean>() {
            @Override
            public void onChanged(UserBean userBean) {
                binding.setUserinfo2(userBean);
            }
        });
        studentBean.setSname("名字");
        binding.setStudent(studentBean);
    }
    CarBean carBean=new CarBean();
    StudentBean studentBean=new StudentBean();
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message:

                studentBean.setSage("34"+System.currentTimeMillis());

                break;
            case R.id.message1:
//                userBean.setName("jllj");
                break;
        }
    }
    @BindingAdapter("android:bindsolid")
    public static void bindSolid(TextView textView, String src){
        textView.setText(src+ System.currentTimeMillis());
    }
}
