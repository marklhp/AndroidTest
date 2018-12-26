package com.myapp.mvc_mvp_mvvm.mvp3.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.myapp.R;

import androidx.annotation.Nullable;

public class MVPBaseActivity<T extends BasePresenter> extends Activity implements BaseView {
    private ProgressDialog mProgressDialog;
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter= (T) new BasePresenter<>();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
    }
    /**
     * 界面可见并获取焦点
     */
    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
    }
    /**
     * 界面失去焦点
     */
    @Override
    protected void onPause() {
        super.onPause();
        presenter.detachView();
    }
    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr() {
        showToast(getResources().getString(R.string.api_error_msg));
    }

    @Override
    public Context getContext() {
        return MVPBaseActivity.this;
    }


}
