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
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;

public abstract class ActivityMvvmBinding extends ViewDataBinding {
  @NonNull
  public final TextView mvcGetUserInfo;

  @NonNull
  public final TextView mvcJobinfo;

  @NonNull
  public final TextView mvcUserForget;

  @NonNull
  public final TextView mvcUserinfo;

  @Bindable
  protected UserInfoBean mUser;

  protected ActivityMvvmBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView mvcGetUserInfo, TextView mvcJobinfo, TextView mvcUserForget,
      TextView mvcUserinfo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.mvcGetUserInfo = mvcGetUserInfo;
    this.mvcJobinfo = mvcJobinfo;
    this.mvcUserForget = mvcUserForget;
    this.mvcUserinfo = mvcUserinfo;
  }

  public abstract void setUser(@Nullable UserInfoBean user);

  @Nullable
  public UserInfoBean getUser() {
    return mUser;
  }

  @NonNull
  public static ActivityMvvmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMvvmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMvvmBinding>inflate(inflater, com.myapp.R.layout.activity_mvvm, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMvvmBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMvvmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMvvmBinding>inflate(inflater, com.myapp.R.layout.activity_mvvm, null, false, component);
  }

  public static ActivityMvvmBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMvvmBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMvvmBinding)bind(component, view, com.myapp.R.layout.activity_mvvm);
  }
}
