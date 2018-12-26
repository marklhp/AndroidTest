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

public abstract class ActivityRecyclerNestingRecyclerBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView recyclerviewNestingRv;

  protected ActivityRecyclerNestingRecyclerBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, RecyclerView recyclerviewNestingRv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.recyclerviewNestingRv = recyclerviewNestingRv;
  }

  @NonNull
  public static ActivityRecyclerNestingRecyclerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityRecyclerNestingRecyclerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityRecyclerNestingRecyclerBinding>inflate(inflater, com.myapp.R.layout.activity_recycler_nesting_recycler, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRecyclerNestingRecyclerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityRecyclerNestingRecyclerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityRecyclerNestingRecyclerBinding>inflate(inflater, com.myapp.R.layout.activity_recycler_nesting_recycler, null, false, component);
  }

  public static ActivityRecyclerNestingRecyclerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityRecyclerNestingRecyclerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityRecyclerNestingRecyclerBinding)bind(component, view, com.myapp.R.layout.activity_recycler_nesting_recycler);
  }
}
