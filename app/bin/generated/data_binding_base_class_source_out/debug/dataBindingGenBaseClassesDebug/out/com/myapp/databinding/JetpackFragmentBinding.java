package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.myapp.model.UserBean;

public abstract class JetpackFragmentBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout jetpack;

  @NonNull
  public final TextView message;

  @NonNull
  public final TextView message1;

  @Bindable
  protected String mUserinfo;

  @Bindable
  protected UserBean mUserinfo2;

  @Bindable
  protected View.OnClickListener mClick;

  protected JetpackFragmentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout jetpack, TextView message, TextView message1) {
    super(_bindingComponent, _root, _localFieldCount);
    this.jetpack = jetpack;
    this.message = message;
    this.message1 = message1;
  }

  public abstract void setUserinfo(@Nullable String userinfo);

  @Nullable
  public String getUserinfo() {
    return mUserinfo;
  }

  public abstract void setUserinfo2(@Nullable UserBean userinfo2);

  @Nullable
  public UserBean getUserinfo2() {
    return mUserinfo2;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static JetpackFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static JetpackFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<JetpackFragmentBinding>inflate(inflater, com.myapp.R.layout.jetpack_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static JetpackFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static JetpackFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<JetpackFragmentBinding>inflate(inflater, com.myapp.R.layout.jetpack_fragment, null, false, component);
  }

  public static JetpackFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static JetpackFragmentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (JetpackFragmentBinding)bind(component, view, com.myapp.R.layout.jetpack_fragment);
  }
}
