package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityFragmentBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout lifeFl;

  @NonNull
  public final TextView lifeTv1;

  @NonNull
  public final TextView lifeTv2;

  @Bindable
  protected View.OnClickListener mClick;

  protected ActivityFragmentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FrameLayout lifeFl, TextView lifeTv1, TextView lifeTv2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.lifeFl = lifeFl;
    this.lifeTv1 = lifeTv1;
    this.lifeTv2 = lifeTv2;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static ActivityFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFragmentBinding>inflate(inflater, com.myapp.R.layout.activity_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFragmentBinding>inflate(inflater, com.myapp.R.layout.activity_fragment, null, false, component);
  }

  public static ActivityFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFragmentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFragmentBinding)bind(component, view, com.myapp.R.layout.activity_fragment);
  }
}
