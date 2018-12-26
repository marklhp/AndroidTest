package com.myapp.databinding;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ChildItemBinding extends ViewDataBinding {
  @Bindable
  protected String mItext;

  @Bindable
  protected Drawable mImage;

  @Bindable
  protected View.OnClickListener mMyclick;

  protected ChildItemBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setItext(@Nullable String itext);

  @Nullable
  public String getItext() {
    return mItext;
  }

  public abstract void setImage(@Nullable Drawable image);

  @Nullable
  public Drawable getImage() {
    return mImage;
  }

  public abstract void setMyclick(@Nullable View.OnClickListener myclick);

  @Nullable
  public View.OnClickListener getMyclick() {
    return mMyclick;
  }

  @NonNull
  public static ChildItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ChildItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ChildItemBinding>inflate(inflater, com.myapp.R.layout.child_item, root, attachToRoot, component);
  }

  @NonNull
  public static ChildItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ChildItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ChildItemBinding>inflate(inflater, com.myapp.R.layout.child_item, null, false, component);
  }

  public static ChildItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ChildItemBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ChildItemBinding)bind(component, view, com.myapp.R.layout.child_item);
  }
}
