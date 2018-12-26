package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public abstract class ActivityZxingScanBinding extends ViewDataBinding {
  @NonNull
  public final ZXingView zxingScanView;

  protected ActivityZxingScanBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ZXingView zxingScanView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.zxingScanView = zxingScanView;
  }

  @NonNull
  public static ActivityZxingScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityZxingScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityZxingScanBinding>inflate(inflater, com.myapp.R.layout.activity_zxing_scan, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityZxingScanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityZxingScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityZxingScanBinding>inflate(inflater, com.myapp.R.layout.activity_zxing_scan, null, false, component);
  }

  public static ActivityZxingScanBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityZxingScanBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityZxingScanBinding)bind(component, view, com.myapp.R.layout.activity_zxing_scan);
  }
}
