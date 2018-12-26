package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityDateTimePickerBinding extends ViewDataBinding {
  @NonNull
  public final ImageView datepickerTimepickerIv;

  @NonNull
  public final LinearLayout viewDatatime;

  @Bindable
  protected View.OnClickListener mClick;

  protected ActivityDateTimePickerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView datepickerTimepickerIv, LinearLayout viewDatatime) {
    super(_bindingComponent, _root, _localFieldCount);
    this.datepickerTimepickerIv = datepickerTimepickerIv;
    this.viewDatatime = viewDatatime;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static ActivityDateTimePickerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDateTimePickerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDateTimePickerBinding>inflate(inflater, com.myapp.R.layout.activity_date_time_picker, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDateTimePickerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDateTimePickerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDateTimePickerBinding>inflate(inflater, com.myapp.R.layout.activity_date_time_picker, null, false, component);
  }

  public static ActivityDateTimePickerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityDateTimePickerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityDateTimePickerBinding)bind(component, view, com.myapp.R.layout.activity_date_time_picker);
  }
}
