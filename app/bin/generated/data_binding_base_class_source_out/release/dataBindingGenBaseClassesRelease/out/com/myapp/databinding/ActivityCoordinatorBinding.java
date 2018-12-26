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
import com.google.android.material.appbar.AppBarLayout;

public abstract class ActivityCoordinatorBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appbarlayout;

  @NonNull
  public final TextView coordinatorTv;

  @NonNull
  public final LinearLayout linearlayout;

  @Bindable
  protected View.OnClickListener mMPatientDetailClick;

  protected ActivityCoordinatorBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, AppBarLayout appbarlayout, TextView coordinatorTv,
      LinearLayout linearlayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbarlayout = appbarlayout;
    this.coordinatorTv = coordinatorTv;
    this.linearlayout = linearlayout;
  }

  public abstract void setMPatientDetailClick(@Nullable View.OnClickListener mPatientDetailClick);

  @Nullable
  public View.OnClickListener getMPatientDetailClick() {
    return mMPatientDetailClick;
  }

  @NonNull
  public static ActivityCoordinatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCoordinatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCoordinatorBinding>inflate(inflater, com.myapp.R.layout.activity_coordinator, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCoordinatorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCoordinatorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCoordinatorBinding>inflate(inflater, com.myapp.R.layout.activity_coordinator, null, false, component);
  }

  public static ActivityCoordinatorBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityCoordinatorBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityCoordinatorBinding)bind(component, view, com.myapp.R.layout.activity_coordinator);
  }
}
