package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityZhuanHuanBinding extends ViewDataBinding {
  @NonNull
  public final ImageView iv1;

  @NonNull
  public final ImageView iv2;

  @Bindable
  protected View.OnClickListener mClick;

  protected ActivityZhuanHuanBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView iv1, ImageView iv2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.iv1 = iv1;
    this.iv2 = iv2;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static ActivityZhuanHuanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityZhuanHuanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityZhuanHuanBinding>inflate(inflater, com.myapp.R.layout.activity_zhuan_huan, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityZhuanHuanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityZhuanHuanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityZhuanHuanBinding>inflate(inflater, com.myapp.R.layout.activity_zhuan_huan, null, false, component);
  }

  public static ActivityZhuanHuanBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityZhuanHuanBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityZhuanHuanBinding)bind(component, view, com.myapp.R.layout.activity_zhuan_huan);
  }
}
