package com.myapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final TextView accessibility;

  @NonNull
  public final TextView constrationactivity;

  @NonNull
  public final TextView coordinator;

  @NonNull
  public final TextView dadabindingGlide;

  @NonNull
  public final TextView datepickerTimepicker;

  @NonNull
  public final TextView divide;

  @NonNull
  public final TextView editFocusable;

  @NonNull
  public final TextView fingerPrint;

  @NonNull
  public final TextView flexboxlayoutActivity;

  @NonNull
  public final TextView floatingWindow;

  @NonNull
  public final TextView fragmentLife;

  @NonNull
  public final TextView getcolor;

  @NonNull
  public final TextView hashmap;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView jetpackActivity;

  @NonNull
  public final TextView jsonGson;

  @NonNull
  public final TextView linphone;

  @NonNull
  public final TextView localScan;

  @NonNull
  public final TextView multipleTypesRecycle;

  @NonNull
  public final TextView mvc;

  @NonNull
  public final TextView navigationActivity;

  @NonNull
  public final TextView ordinary;

  @NonNull
  public final TextView popupwendow;

  @NonNull
  public final TextView pxMeasure;

  @NonNull
  public final TextView recyclerNestingRecycler;

  @NonNull
  public final TextView rsa;

  @NonNull
  public final TextView scanListenee;

  @NonNull
  public final TextView scrolltoScrollby;

  @NonNull
  public final TextView smartrefreshlayout;

  @NonNull
  public final TextView spinner;

  @NonNull
  public final TextView sweetAlert;

  @NonNull
  public final TextView touchevent;

  @NonNull
  public final TextView uiDelayed;

  @NonNull
  public final TextView websocket;

  @NonNull
  public final TextView zhuanhuan;

  @NonNull
  public final TextView zxingScanListenee;

  @Bindable
  protected View.OnClickListener mClick;

  @Bindable
  protected ObservableInt mSrc;

  protected ActivityMainBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView accessibility, TextView constrationactivity,
      TextView coordinator, TextView dadabindingGlide, TextView datepickerTimepicker,
      TextView divide, TextView editFocusable, TextView fingerPrint, TextView flexboxlayoutActivity,
      TextView floatingWindow, TextView fragmentLife, TextView getcolor, TextView hashmap,
      ImageView imageView, TextView jetpackActivity, TextView jsonGson, TextView linphone,
      TextView localScan, TextView multipleTypesRecycle, TextView mvc, TextView navigationActivity,
      TextView ordinary, TextView popupwendow, TextView pxMeasure, TextView recyclerNestingRecycler,
      TextView rsa, TextView scanListenee, TextView scrolltoScrollby, TextView smartrefreshlayout,
      TextView spinner, TextView sweetAlert, TextView touchevent, TextView uiDelayed,
      TextView websocket, TextView zhuanhuan, TextView zxingScanListenee) {
    super(_bindingComponent, _root, _localFieldCount);
    this.accessibility = accessibility;
    this.constrationactivity = constrationactivity;
    this.coordinator = coordinator;
    this.dadabindingGlide = dadabindingGlide;
    this.datepickerTimepicker = datepickerTimepicker;
    this.divide = divide;
    this.editFocusable = editFocusable;
    this.fingerPrint = fingerPrint;
    this.flexboxlayoutActivity = flexboxlayoutActivity;
    this.floatingWindow = floatingWindow;
    this.fragmentLife = fragmentLife;
    this.getcolor = getcolor;
    this.hashmap = hashmap;
    this.imageView = imageView;
    this.jetpackActivity = jetpackActivity;
    this.jsonGson = jsonGson;
    this.linphone = linphone;
    this.localScan = localScan;
    this.multipleTypesRecycle = multipleTypesRecycle;
    this.mvc = mvc;
    this.navigationActivity = navigationActivity;
    this.ordinary = ordinary;
    this.popupwendow = popupwendow;
    this.pxMeasure = pxMeasure;
    this.recyclerNestingRecycler = recyclerNestingRecycler;
    this.rsa = rsa;
    this.scanListenee = scanListenee;
    this.scrolltoScrollby = scrolltoScrollby;
    this.smartrefreshlayout = smartrefreshlayout;
    this.spinner = spinner;
    this.sweetAlert = sweetAlert;
    this.touchevent = touchevent;
    this.uiDelayed = uiDelayed;
    this.websocket = websocket;
    this.zhuanhuan = zhuanhuan;
    this.zxingScanListenee = zxingScanListenee;
  }

  public abstract void setClick(@Nullable View.OnClickListener click);

  @Nullable
  public View.OnClickListener getClick() {
    return mClick;
  }

  public abstract void setSrc(@Nullable ObservableInt src);

  @Nullable
  public ObservableInt getSrc() {
    return mSrc;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.myapp.R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.myapp.R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMainBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMainBinding)bind(component, view, com.myapp.R.layout.activity_main);
  }
}
