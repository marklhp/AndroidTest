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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class ActivityRefreshLayoutBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView refreshLayoutRv;

  @NonNull
  public final SmartRefreshLayout refreshLayoutSmartrefresh;

  protected ActivityRefreshLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView refreshLayoutRv,
      SmartRefreshLayout refreshLayoutSmartrefresh) {
    super(_bindingComponent, _root, _localFieldCount);
    this.refreshLayoutRv = refreshLayoutRv;
    this.refreshLayoutSmartrefresh = refreshLayoutSmartrefresh;
  }

  @NonNull
  public static ActivityRefreshLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityRefreshLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityRefreshLayoutBinding>inflate(inflater, com.myapp.R.layout.activity_refresh_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRefreshLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityRefreshLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityRefreshLayoutBinding>inflate(inflater, com.myapp.R.layout.activity_refresh_layout, null, false, component);
  }

  public static ActivityRefreshLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityRefreshLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityRefreshLayoutBinding)bind(component, view, com.myapp.R.layout.activity_refresh_layout);
  }
}
