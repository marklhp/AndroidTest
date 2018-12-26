package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentSecondBinding extends ViewDataBinding {
  @NonNull
  public final Button btnBack;

  @Bindable
  protected View.OnClickListener mClick;

  protected FragmentSecondBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnBack) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnBack = btnBack;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static FragmentSecondBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSecondBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSecondBinding>inflate(inflater, com.myapp.R.layout.fragment_second, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSecondBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSecondBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSecondBinding>inflate(inflater, com.myapp.R.layout.fragment_second, null, false, component);
  }

  public static FragmentSecondBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentSecondBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentSecondBinding)bind(component, view, com.myapp.R.layout.fragment_second);
  }
}
