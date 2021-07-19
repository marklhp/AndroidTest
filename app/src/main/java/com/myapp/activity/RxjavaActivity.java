package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityRxjavaBinding;
import com.myapp.utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

public class RxjavaActivity extends BaseActivity<ActivityRxjavaBinding> implements View.OnClickListener {

    @Override
    protected void initView() {
        binding.setClick(this);
        OkHttpClient client = new OkHttpClient.Builder()
//                .dns(OkHttpDns.getInstance(getApplicationContext()))
                .build();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_rxjava;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rxjava_map:
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        LogUtils.d("打印数据|"+3+"---"+Thread.currentThread().getName());
                        emitter.onNext(3);
                    }
                }).map(new Function<Integer, Boolean>() {
                    @Override
                    public Boolean apply(Integer integer) throws Exception {
                        LogUtils.d("打印数据="+integer+"---"+Thread.currentThread().getName());
                        return integer%2==0;
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        LogUtils.d("打印数据-"+aBoolean+"---"+Thread.currentThread().getName());
                    }
                });
                Intent intent=new Intent();
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
