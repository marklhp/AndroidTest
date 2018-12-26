package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemRecyclerviewNestingBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout nestingLl;

  @NonNull
  public final TextView nestingTv;

  protected ItemRecyclerviewNestingBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FrameLayout nestingLl, TextView nestingTv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.nestingLl = nestingLl;
    this.nestingTv = nestingTv;
  }

  @NonNull
  public static ItemRecyclerviewNestingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemRecyclerviewNestingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemRecyclerviewNestingBinding>inflate(inflater, com.myapp.R.layout.item_recyclerview_nesting, root, attachToRoot, component);
  }

  @NonNull
  public static ItemRecyclerviewNestingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemRecyclerviewNestingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemRecyclerviewNestingBinding>inflate(inflater, com.myapp.R.layout.item_recyclerview_nesting, null, false, component);
  }

  public static ItemRecyclerviewNestingBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemRecyclerviewNestingBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemRecyclerviewNestingBinding)bind(component, view, com.myapp.R.layout.item_recyclerview_nesting);
  }
}
