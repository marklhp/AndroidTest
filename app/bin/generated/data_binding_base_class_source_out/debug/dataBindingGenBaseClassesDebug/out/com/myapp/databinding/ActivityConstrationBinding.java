package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityConstrationBinding extends ViewDataBinding {
  @NonNull
  public final View constrationView1;

  @NonNull
  public final TextView constrationView2;

  @NonNull
  public final TextView constrationView3;

  @NonNull
  public final TextView constrationView4;

  @NonNull
  public final TextView constrationView5;

  @NonNull
  public final TextView constrationView6;

  @NonNull
  public final TextView constrationView7;

  @NonNull
  public final TextView constrationView8;

  protected ActivityConstrationBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, View constrationView1, TextView constrationView2,
      TextView constrationView3, TextView constrationView4, TextView constrationView5,
      TextView constrationView6, TextView constrationView7, TextView constrationView8) {
    super(_bindingComponent, _root, _localFieldCount);
    this.constrationView1 = constrationView1;
    this.constrationView2 = constrationView2;
    this.constrationView3 = constrationView3;
    this.constrationView4 = constrationView4;
    this.constrationView5 = constrationView5;
    this.constrationView6 = constrationView6;
    this.constrationView7 = constrationView7;
    this.constrationView8 = constrationView8;
  }

  @NonNull
  public static ActivityConstrationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityConstrationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityConstrationBinding>inflate(inflater, com.myapp.R.layout.activity_constration, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityConstrationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityConstrationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityConstrationBinding>inflate(inflater, com.myapp.R.layout.activity_constration, null, false, component);
  }

  public static ActivityConstrationBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityConstrationBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityConstrationBinding)bind(component, view, com.myapp.R.layout.activity_constration);
  }
}
