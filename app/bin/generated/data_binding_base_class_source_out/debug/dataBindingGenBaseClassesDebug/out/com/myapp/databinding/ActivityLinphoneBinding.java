package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityLinphoneBinding extends ViewDataBinding {
  @NonNull
  public final EditText linphoneEt1;

  @NonNull
  public final EditText linphoneEt2;

  @NonNull
  public final EditText linphoneEt3;

  @NonNull
  public final TextView linphoneEt4;

  @NonNull
  public final TextView linphoneEt5;

  @Bindable
  protected String mUsername;

  @Bindable
  protected String mPassword;

  @Bindable
  protected String mServaladdress;

  @Bindable
  protected View.OnClickListener mClick;

  @Bindable
  protected String mStatu;

  @Bindable
  protected String mMythrow;

  protected ActivityLinphoneBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText linphoneEt1, EditText linphoneEt2, EditText linphoneEt3,
      TextView linphoneEt4, TextView linphoneEt5) {
    super(_bindingComponent, _root, _localFieldCount);
    this.linphoneEt1 = linphoneEt1;
    this.linphoneEt2 = linphoneEt2;
    this.linphoneEt3 = linphoneEt3;
    this.linphoneEt4 = linphoneEt4;
    this.linphoneEt5 = linphoneEt5;
  }

  public abstract void setUsername(@Nullable String username);

  @Nullable
  public String getUsername() {
    return mUsername;
  }

  public abstract void setPassword(@Nullable String password);

  @Nullable
  public String getPassword() {
    return mPassword;
  }

  public abstract void setServaladdress(@Nullable String servaladdress);

  @Nullable
  public String getServaladdress() {
    return mServaladdress;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  public abstract void setStatu(@Nullable String statu);

  @Nullable
  public String getStatu() {
    return mStatu;
  }

  public abstract void setMythrow(@Nullable String mythrow);

  @Nullable
  public String getMythrow() {
    return mMythrow;
  }

  @NonNull
  public static ActivityLinphoneBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLinphoneBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLinphoneBinding>inflate(inflater, com.myapp.R.layout.activity_linphone, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLinphoneBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLinphoneBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLinphoneBinding>inflate(inflater, com.myapp.R.layout.activity_linphone, null, false, component);
  }

  public static ActivityLinphoneBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityLinphoneBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityLinphoneBinding)bind(component, view, com.myapp.R.layout.activity_linphone);
  }
}
