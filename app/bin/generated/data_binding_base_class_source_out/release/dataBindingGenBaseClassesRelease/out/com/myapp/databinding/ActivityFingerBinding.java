package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityFingerBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout buttonPanel;

  @NonNull
  public final Button cancelButton;

  @NonNull
  public final Button startButton;

  protected ActivityFingerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout buttonPanel, Button cancelButton, Button startButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.buttonPanel = buttonPanel;
    this.cancelButton = cancelButton;
    this.startButton = startButton;
  }

  @NonNull
  public static ActivityFingerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFingerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFingerBinding>inflate(inflater, com.myapp.R.layout.activity_finger, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFingerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityFingerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityFingerBinding>inflate(inflater, com.myapp.R.layout.activity_finger, null, false, component);
  }

  public static ActivityFingerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityFingerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityFingerBinding)bind(component, view, com.myapp.R.layout.activity_finger);
  }
}
