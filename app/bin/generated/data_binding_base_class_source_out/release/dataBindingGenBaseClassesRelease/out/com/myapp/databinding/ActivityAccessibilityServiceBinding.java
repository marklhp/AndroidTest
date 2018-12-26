package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityAccessibilityServiceBinding extends ViewDataBinding {
  @NonNull
  public final TextView accessibilityTv;

  @Bindable
  protected View.OnClickListener mClick;

  protected ActivityAccessibilityServiceBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView accessibilityTv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.accessibilityTv = accessibilityTv;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static ActivityAccessibilityServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAccessibilityServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAccessibilityServiceBinding>inflate(inflater, com.myapp.R.layout.activity_accessibility_service, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAccessibilityServiceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAccessibilityServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAccessibilityServiceBinding>inflate(inflater, com.myapp.R.layout.activity_accessibility_service, null, false, component);
  }

  public static ActivityAccessibilityServiceBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityAccessibilityServiceBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityAccessibilityServiceBinding)bind(component, view, com.myapp.R.layout.activity_accessibility_service);
  }
}
