package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ActivityMultipleTypesRecycleBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView multipleTypesRv;

  protected ActivityMultipleTypesRecycleBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView multipleTypesRv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.multipleTypesRv = multipleTypesRv;
  }

  @NonNull
  public static ActivityMultipleTypesRecycleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMultipleTypesRecycleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMultipleTypesRecycleBinding>inflate(inflater, com.myapp.R.layout.activity_multiple_types_recycle, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMultipleTypesRecycleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMultipleTypesRecycleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMultipleTypesRecycleBinding>inflate(inflater, com.myapp.R.layout.activity_multiple_types_recycle, null, false, component);
  }

  public static ActivityMultipleTypesRecycleBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMultipleTypesRecycleBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMultipleTypesRecycleBinding)bind(component, view, com.myapp.R.layout.activity_multiple_types_recycle);
  }
}
