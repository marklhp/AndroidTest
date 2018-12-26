package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayout;

public abstract class ItemRecyclerBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView itemRecyclerviewNestingRv;

  @NonNull
  public final FlexboxLayout recyclerviewNestingFbl;

  @NonNull
  public final TextView recyclerviewNestingTv;

  protected ItemRecyclerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView itemRecyclerviewNestingRv,
      FlexboxLayout recyclerviewNestingFbl, TextView recyclerviewNestingTv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemRecyclerviewNestingRv = itemRecyclerviewNestingRv;
    this.recyclerviewNestingFbl = recyclerviewNestingFbl;
    this.recyclerviewNestingTv = recyclerviewNestingTv;
  }

  @NonNull
  public static ItemRecyclerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemRecyclerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemRecyclerBinding>inflate(inflater, com.myapp.R.layout.item_recycler, root, attachToRoot, component);
  }

  @NonNull
  public static ItemRecyclerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemRecyclerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemRecyclerBinding>inflate(inflater, com.myapp.R.layout.item_recycler, null, false, component);
  }

  public static ItemRecyclerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemRecyclerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemRecyclerBinding)bind(component, view, com.myapp.R.layout.item_recycler);
  }
}
