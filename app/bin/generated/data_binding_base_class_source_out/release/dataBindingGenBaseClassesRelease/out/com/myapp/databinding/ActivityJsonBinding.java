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

public abstract class ActivityJsonBinding extends ViewDataBinding {
  @NonNull
  public final TextView gsonTv;

  @NonNull
  public final TextView jsonTv;

  @Bindable
  protected View.OnClickListener mClick;

  protected ActivityJsonBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView gsonTv, TextView jsonTv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.gsonTv = gsonTv;
    this.jsonTv = jsonTv;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static ActivityJsonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityJsonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityJsonBinding>inflate(inflater, com.myapp.R.layout.activity_json, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityJsonBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityJsonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityJsonBinding>inflate(inflater, com.myapp.R.layout.activity_json, null, false, component);
  }

  public static ActivityJsonBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityJsonBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityJsonBinding)bind(component, view, com.myapp.R.layout.activity_json);
  }
}
