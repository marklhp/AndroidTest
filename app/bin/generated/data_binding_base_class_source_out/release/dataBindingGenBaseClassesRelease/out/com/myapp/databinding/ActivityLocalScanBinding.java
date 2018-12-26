package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityLocalScanBinding extends ViewDataBinding {
  protected ActivityLocalScanBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  @NonNull
  public static ActivityLocalScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLocalScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLocalScanBinding>inflate(inflater, com.myapp.R.layout.activity_local_scan, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLocalScanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLocalScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLocalScanBinding>inflate(inflater, com.myapp.R.layout.activity_local_scan, null, false, component);
  }

  public static ActivityLocalScanBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityLocalScanBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityLocalScanBinding)bind(component, view, com.myapp.R.layout.activity_local_scan);
  }
}
