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

public abstract class FragmentFristBinding extends ViewDataBinding {
  @NonNull
  public final Button btnNext;

  @Bindable
  protected View.OnClickListener mClick;

  protected FragmentFristBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnNext) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnNext = btnNext;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static FragmentFristBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFristBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFristBinding>inflate(inflater, com.myapp.R.layout.fragment_frist, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFristBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentFristBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentFristBinding>inflate(inflater, com.myapp.R.layout.fragment_frist, null, false, component);
  }

  public static FragmentFristBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentFristBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentFristBinding)bind(component, view, com.myapp.R.layout.fragment_frist);
  }
}
