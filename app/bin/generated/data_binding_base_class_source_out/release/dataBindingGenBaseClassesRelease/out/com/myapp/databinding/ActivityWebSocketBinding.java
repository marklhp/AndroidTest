package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityWebSocketBinding extends ViewDataBinding {
  @NonNull
  public final TextView websocketC;

  @NonNull
  public final TextView websocketClose;

  @NonNull
  public final TextView websocketReopen;

  @Bindable
  protected View.OnClickListener mClick;

  protected ActivityWebSocketBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView websocketC, TextView websocketClose,
      TextView websocketReopen) {
    super(_bindingComponent, _root, _localFieldCount);
    this.websocketC = websocketC;
    this.websocketClose = websocketClose;
    this.websocketReopen = websocketReopen;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  @NonNull
  public static ActivityWebSocketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityWebSocketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityWebSocketBinding>inflate(inflater, com.myapp.R.layout.activity_web_socket, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityWebSocketBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityWebSocketBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityWebSocketBinding>inflate(inflater, com.myapp.R.layout.activity_web_socket, null, false, component);
  }

  public static ActivityWebSocketBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityWebSocketBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityWebSocketBinding)bind(component, view, com.myapp.R.layout.activity_web_socket);
  }
}
