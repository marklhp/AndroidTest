package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.myapp.customview.TouchLinearLayout;

public abstract class ActivityTouchEventBinding extends ViewDataBinding {
  @NonNull
  public final TouchLinearLayout touchLl;

  @NonNull
  public final RecyclerView touchTv;

  protected ActivityTouchEventBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TouchLinearLayout touchLl, RecyclerView touchTv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.touchLl = touchLl;
    this.touchTv = touchTv;
  }

  @NonNull
  public static ActivityTouchEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityTouchEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityTouchEventBinding>inflate(inflater, com.myapp.R.layout.activity_touch_event, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTouchEventBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityTouchEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityTouchEventBinding>inflate(inflater, com.myapp.R.layout.activity_touch_event, null, false, component);
  }

  public static ActivityTouchEventBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityTouchEventBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityTouchEventBinding)bind(component, view, com.myapp.R.layout.activity_touch_event);
  }
}
