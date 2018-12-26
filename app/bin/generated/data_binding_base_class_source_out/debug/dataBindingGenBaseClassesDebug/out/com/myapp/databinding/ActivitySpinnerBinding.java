package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivitySpinnerBinding extends ViewDataBinding {
  @NonNull
  public final Spinner spinner;

  @NonNull
  public final ConstraintLayout spinnerCl;

  protected ActivitySpinnerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Spinner spinner, ConstraintLayout spinnerCl) {
    super(_bindingComponent, _root, _localFieldCount);
    this.spinner = spinner;
    this.spinnerCl = spinnerCl;
  }

  @NonNull
  public static ActivitySpinnerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySpinnerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySpinnerBinding>inflate(inflater, com.myapp.R.layout.activity_spinner, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySpinnerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivitySpinnerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivitySpinnerBinding>inflate(inflater, com.myapp.R.layout.activity_spinner, null, false, component);
  }

  public static ActivitySpinnerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivitySpinnerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivitySpinnerBinding)bind(component, view, com.myapp.R.layout.activity_spinner);
  }
}
