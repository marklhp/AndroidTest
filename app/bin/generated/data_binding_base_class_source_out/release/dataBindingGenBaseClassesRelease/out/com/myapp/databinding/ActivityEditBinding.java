package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityEditBinding extends ViewDataBinding {
  @NonNull
  public final EditText focusableEt;

  @NonNull
  public final LinearLayout focusableLl;

  @NonNull
  public final TextView focusableTv;

  @Bindable
  protected View.OnClickListener mClick;

  protected ActivityEditBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText focusableEt, LinearLayout focusableLl, TextView focusableTv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.focusableEt = focusableEt;
    this.focusableLl = focusableLl;
    this.focusableTv = focusableTv;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static ActivityEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityEditBinding>inflate(inflater, com.myapp.R.layout.activity_edit, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityEditBinding>inflate(inflater, com.myapp.R.layout.activity_edit, null, false, component);
  }

  public static ActivityEditBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityEditBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityEditBinding)bind(component, view, com.myapp.R.layout.activity_edit);
  }
}
