package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityFloatingWindowBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout floatingWindowCl;

  @Bindable
  protected View.OnClickListener mClick;

  protected ActivityFloatingWindowBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout floatingWindowCl) {
    super(_bindingComponent, _root, _localFieldCount);
    this.floatingWindowCl = floatingWindowCl;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static ActivityFloatingWindowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFloatingWindowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFloatingWindowBinding>inflate(inflater, com.myapp.R.layout.activity_floating_window, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFloatingWindowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFloatingWindowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFloatingWindowBinding>inflate(inflater, com.myapp.R.layout.activity_floating_window, null, false, component);
  }

  public static ActivityFloatingWindowBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFloatingWindowBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFloatingWindowBinding)bind(component, view, com.myapp.R.layout.activity_floating_window);
  }
}
