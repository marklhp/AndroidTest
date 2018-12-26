package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityDataBindingGlideBinding extends ViewDataBinding {
  @NonNull
  public final ChildItemBinding child;

  @NonNull
  public final ImageView image;

  @Bindable
  protected String mResId;

  @Bindable
  protected String mCircleUrl;

  @Bindable
  protected String mRoundUrl;

  @Bindable
  protected Integer mNum;

  @Bindable
  protected View.OnClickListener mGlideClick;

  protected ActivityDataBindingGlideBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ChildItemBinding child, ImageView image) {
    super(_bindingComponent, _root, _localFieldCount);
    this.child = child;
    setContainedBinding(this.child);;
    this.image = image;
  }

  public abstract void setResId(@Nullable String resId);

  @Nullable
  public String getResId() {
    return mResId;
  }

  public abstract void setCircleUrl(@Nullable String circleUrl);

  @Nullable
  public String getCircleUrl() {
    return mCircleUrl;
  }

  public abstract void setRoundUrl(@Nullable String roundUrl);

  @Nullable
  public String getRoundUrl() {
    return mRoundUrl;
  }

  public abstract void setNum(@Nullable Integer num);

  @Nullable
  public Integer getNum() {
    return mNum;
  }

  public abstract void setGlideClick(@Nullable View.OnClickListener glideClick);

  @Nullable
  public View.OnClickListener getGlideClick() {
    return mGlideClick;
  }

  @NonNull
  public static ActivityDataBindingGlideBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDataBindingGlideBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDataBindingGlideBinding>inflate(inflater, com.myapp.R.layout.activity_data_binding_glide_, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDataBindingGlideBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDataBindingGlideBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDataBindingGlideBinding>inflate(inflater, com.myapp.R.layout.activity_data_binding_glide_, null, false, component);
  }

  public static ActivityDataBindingGlideBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityDataBindingGlideBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityDataBindingGlideBinding)bind(component, view, com.myapp.R.layout.activity_data_binding_glide_);
  }
}
