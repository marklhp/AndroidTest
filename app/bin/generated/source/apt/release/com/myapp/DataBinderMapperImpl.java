package com.myapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.myapp.databinding.ActivityAccessibilityServiceBindingImpl;
import com.myapp.databinding.ActivityConstrationBindingImpl;
import com.myapp.databinding.ActivityCoordinatorBindingImpl;
import com.myapp.databinding.ActivityDataBindingGlideBindingImpl;
import com.myapp.databinding.ActivityDateTimePickerBindingImpl;
import com.myapp.databinding.ActivityEditBindingImpl;
import com.myapp.databinding.ActivityFingerBindingImpl;
import com.myapp.databinding.ActivityFloatingWindowBindingImpl;
import com.myapp.databinding.ActivityFragmentBindingImpl;
import com.myapp.databinding.ActivityJsonBindingImpl;
import com.myapp.databinding.ActivityLinphoneBindingImpl;
import com.myapp.databinding.ActivityLocalScanBindingImpl;
import com.myapp.databinding.ActivityMainBindingImpl;
import com.myapp.databinding.ActivityMultipleTypesRecycleBindingImpl;
import com.myapp.databinding.ActivityMvvmBindingImpl;
import com.myapp.databinding.ActivityNavigationBindingImpl;
import com.myapp.databinding.ActivityRecyclerNestingRecyclerBindingImpl;
import com.myapp.databinding.ActivityRefreshLayoutBindingImpl;
import com.myapp.databinding.ActivitySpinnerBindingImpl;
import com.myapp.databinding.ActivityTouchEventBindingImpl;
import com.myapp.databinding.ActivityWebSocketBindingImpl;
import com.myapp.databinding.ActivityZhuanHuanBindingImpl;
import com.myapp.databinding.ActivityZxingScanBindingImpl;
import com.myapp.databinding.ChildItemBindingImpl;
import com.myapp.databinding.FragmentFristBindingImpl;
import com.myapp.databinding.FragmentSecondBindingImpl;
import com.myapp.databinding.ItemRecyclerBindingImpl;
import com.myapp.databinding.ItemRecyclerviewNestingBindingImpl;
import com.myapp.databinding.JetpackFragmentBindingImpl;
import com.myapp.databinding.PopLayoutBindingImpl;
import com.myapp.databinding.TestLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYACCESSIBILITYSERVICE = 1;

  private static final int LAYOUT_ACTIVITYCONSTRATION = 2;

  private static final int LAYOUT_ACTIVITYCOORDINATOR = 3;

  private static final int LAYOUT_ACTIVITYDATABINDINGGLIDE = 4;

  private static final int LAYOUT_ACTIVITYDATETIMEPICKER = 5;

  private static final int LAYOUT_ACTIVITYEDIT = 6;

  private static final int LAYOUT_ACTIVITYFINGER = 7;

  private static final int LAYOUT_ACTIVITYFLOATINGWINDOW = 8;

  private static final int LAYOUT_ACTIVITYFRAGMENT = 9;

  private static final int LAYOUT_ACTIVITYJSON = 10;

  private static final int LAYOUT_ACTIVITYLINPHONE = 11;

  private static final int LAYOUT_ACTIVITYLOCALSCAN = 12;

  private static final int LAYOUT_ACTIVITYMAIN = 13;

  private static final int LAYOUT_ACTIVITYMULTIPLETYPESRECYCLE = 14;

  private static final int LAYOUT_ACTIVITYMVVM = 15;

  private static final int LAYOUT_ACTIVITYNAVIGATION = 16;

  private static final int LAYOUT_ACTIVITYRECYCLERNESTINGRECYCLER = 17;

  private static final int LAYOUT_ACTIVITYREFRESHLAYOUT = 18;

  private static final int LAYOUT_ACTIVITYSPINNER = 19;

  private static final int LAYOUT_ACTIVITYTOUCHEVENT = 20;

  private static final int LAYOUT_ACTIVITYWEBSOCKET = 21;

  private static final int LAYOUT_ACTIVITYZHUANHUAN = 22;

  private static final int LAYOUT_ACTIVITYZXINGSCAN = 23;

  private static final int LAYOUT_CHILDITEM = 24;

  private static final int LAYOUT_FRAGMENTFRIST = 25;

  private static final int LAYOUT_FRAGMENTSECOND = 26;

  private static final int LAYOUT_ITEMRECYCLER = 27;

  private static final int LAYOUT_ITEMRECYCLERVIEWNESTING = 28;

  private static final int LAYOUT_JETPACKFRAGMENT = 29;

  private static final int LAYOUT_POPLAYOUT = 30;

  private static final int LAYOUT_TESTLAYOUT = 31;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(31);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_accessibility_service, LAYOUT_ACTIVITYACCESSIBILITYSERVICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_constration, LAYOUT_ACTIVITYCONSTRATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_coordinator, LAYOUT_ACTIVITYCOORDINATOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_data_binding_glide_, LAYOUT_ACTIVITYDATABINDINGGLIDE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_date_time_picker, LAYOUT_ACTIVITYDATETIMEPICKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_edit, LAYOUT_ACTIVITYEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_finger, LAYOUT_ACTIVITYFINGER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_floating_window, LAYOUT_ACTIVITYFLOATINGWINDOW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_fragment, LAYOUT_ACTIVITYFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_json, LAYOUT_ACTIVITYJSON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_linphone, LAYOUT_ACTIVITYLINPHONE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_local_scan, LAYOUT_ACTIVITYLOCALSCAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_multiple_types_recycle, LAYOUT_ACTIVITYMULTIPLETYPESRECYCLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_mvvm, LAYOUT_ACTIVITYMVVM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_navigation, LAYOUT_ACTIVITYNAVIGATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_recycler_nesting_recycler, LAYOUT_ACTIVITYRECYCLERNESTINGRECYCLER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_refresh_layout, LAYOUT_ACTIVITYREFRESHLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_spinner, LAYOUT_ACTIVITYSPINNER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_touch_event, LAYOUT_ACTIVITYTOUCHEVENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_web_socket, LAYOUT_ACTIVITYWEBSOCKET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_zhuan_huan, LAYOUT_ACTIVITYZHUANHUAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.activity_zxing_scan, LAYOUT_ACTIVITYZXINGSCAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.child_item, LAYOUT_CHILDITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.fragment_frist, LAYOUT_FRAGMENTFRIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.fragment_second, LAYOUT_FRAGMENTSECOND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.item_recycler, LAYOUT_ITEMRECYCLER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.item_recyclerview_nesting, LAYOUT_ITEMRECYCLERVIEWNESTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.jetpack_fragment, LAYOUT_JETPACKFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.pop_layout, LAYOUT_POPLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.myapp.R.layout.test_layout, LAYOUT_TESTLAYOUT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYACCESSIBILITYSERVICE: {
          if ("layout/activity_accessibility_service_0".equals(tag)) {
            return new ActivityAccessibilityServiceBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_accessibility_service is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCONSTRATION: {
          if ("layout/activity_constration_0".equals(tag)) {
            return new ActivityConstrationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_constration is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCOORDINATOR: {
          if ("layout/activity_coordinator_0".equals(tag)) {
            return new ActivityCoordinatorBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_coordinator is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDATABINDINGGLIDE: {
          if ("layout/activity_data_binding_glide__0".equals(tag)) {
            return new ActivityDataBindingGlideBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_data_binding_glide_ is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDATETIMEPICKER: {
          if ("layout/activity_date_time_picker_0".equals(tag)) {
            return new ActivityDateTimePickerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_date_time_picker is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYEDIT: {
          if ("layout/activity_edit_0".equals(tag)) {
            return new ActivityEditBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_edit is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYFINGER: {
          if ("layout/activity_finger_0".equals(tag)) {
            return new ActivityFingerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_finger is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYFLOATINGWINDOW: {
          if ("layout/activity_floating_window_0".equals(tag)) {
            return new ActivityFloatingWindowBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_floating_window is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYFRAGMENT: {
          if ("layout/activity_fragment_0".equals(tag)) {
            return new ActivityFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYJSON: {
          if ("layout/activity_json_0".equals(tag)) {
            return new ActivityJsonBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_json is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLINPHONE: {
          if ("layout/activity_linphone_0".equals(tag)) {
            return new ActivityLinphoneBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_linphone is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOCALSCAN: {
          if ("layout/activity_local_scan_0".equals(tag)) {
            return new ActivityLocalScanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_local_scan is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMULTIPLETYPESRECYCLE: {
          if ("layout/activity_multiple_types_recycle_0".equals(tag)) {
            return new ActivityMultipleTypesRecycleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_multiple_types_recycle is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMVVM: {
          if ("layout/activity_mvvm_0".equals(tag)) {
            return new ActivityMvvmBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_mvvm is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYNAVIGATION: {
          if ("layout/activity_navigation_0".equals(tag)) {
            return new ActivityNavigationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_navigation is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYRECYCLERNESTINGRECYCLER: {
          if ("layout/activity_recycler_nesting_recycler_0".equals(tag)) {
            return new ActivityRecyclerNestingRecyclerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_recycler_nesting_recycler is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREFRESHLAYOUT: {
          if ("layout/activity_refresh_layout_0".equals(tag)) {
            return new ActivityRefreshLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_refresh_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSPINNER: {
          if ("layout/activity_spinner_0".equals(tag)) {
            return new ActivitySpinnerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_spinner is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTOUCHEVENT: {
          if ("layout/activity_touch_event_0".equals(tag)) {
            return new ActivityTouchEventBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_touch_event is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWEBSOCKET: {
          if ("layout/activity_web_socket_0".equals(tag)) {
            return new ActivityWebSocketBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_web_socket is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYZHUANHUAN: {
          if ("layout/activity_zhuan_huan_0".equals(tag)) {
            return new ActivityZhuanHuanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_zhuan_huan is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYZXINGSCAN: {
          if ("layout/activity_zxing_scan_0".equals(tag)) {
            return new ActivityZxingScanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_zxing_scan is invalid. Received: " + tag);
        }
        case  LAYOUT_CHILDITEM: {
          if ("layout/child_item_0".equals(tag)) {
            return new ChildItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for child_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFRIST: {
          if ("layout/fragment_frist_0".equals(tag)) {
            return new FragmentFristBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_frist is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSECOND: {
          if ("layout/fragment_second_0".equals(tag)) {
            return new FragmentSecondBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_second is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRECYCLER: {
          if ("layout/item_recycler_0".equals(tag)) {
            return new ItemRecyclerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_recycler is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRECYCLERVIEWNESTING: {
          if ("layout/item_recyclerview_nesting_0".equals(tag)) {
            return new ItemRecyclerviewNestingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_recyclerview_nesting is invalid. Received: " + tag);
        }
        case  LAYOUT_JETPACKFRAGMENT: {
          if ("layout/jetpack_fragment_0".equals(tag)) {
            return new JetpackFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for jetpack_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_POPLAYOUT: {
          if ("layout/pop_layout_0".equals(tag)) {
            return new PopLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for pop_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_TESTLAYOUT: {
          if ("layout/test_layout_0".equals(tag)) {
            return new TestLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for test_layout is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(28);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "color");
      sKeys.put(2, "num");
      sKeys.put(3, "glideClick");
      sKeys.put(4, "password");
      sKeys.put(5, "circleUrl");
      sKeys.put(6, "sage");
      sKeys.put(7, "sn");
      sKeys.put(8, "userinfo");
      sKeys.put(9, "userinfo2");
      sKeys.put(10, "image");
      sKeys.put(11, "src");
      sKeys.put(12, "sex");
      sKeys.put(13, "itext");
      sKeys.put(14, "statu");
      sKeys.put(15, "click");
      sKeys.put(16, "resId");
      sKeys.put(17, "mythrow");
      sKeys.put(18, "mPatientDetailClick");
      sKeys.put(19, "sname");
      sKeys.put(20, "name");
      sKeys.put(21, "myclick");
      sKeys.put(22, "servaladdress");
      sKeys.put(23, "roundUrl");
      sKeys.put(24, "user");
      sKeys.put(25, "age");
      sKeys.put(26, "username");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(31);

    static {
      sKeys.put("layout/activity_accessibility_service_0", com.myapp.R.layout.activity_accessibility_service);
      sKeys.put("layout/activity_constration_0", com.myapp.R.layout.activity_constration);
      sKeys.put("layout/activity_coordinator_0", com.myapp.R.layout.activity_coordinator);
      sKeys.put("layout/activity_data_binding_glide__0", com.myapp.R.layout.activity_data_binding_glide_);
      sKeys.put("layout/activity_date_time_picker_0", com.myapp.R.layout.activity_date_time_picker);
      sKeys.put("layout/activity_edit_0", com.myapp.R.layout.activity_edit);
      sKeys.put("layout/activity_finger_0", com.myapp.R.layout.activity_finger);
      sKeys.put("layout/activity_floating_window_0", com.myapp.R.layout.activity_floating_window);
      sKeys.put("layout/activity_fragment_0", com.myapp.R.layout.activity_fragment);
      sKeys.put("layout/activity_json_0", com.myapp.R.layout.activity_json);
      sKeys.put("layout/activity_linphone_0", com.myapp.R.layout.activity_linphone);
      sKeys.put("layout/activity_local_scan_0", com.myapp.R.layout.activity_local_scan);
      sKeys.put("layout/activity_main_0", com.myapp.R.layout.activity_main);
      sKeys.put("layout/activity_multiple_types_recycle_0", com.myapp.R.layout.activity_multiple_types_recycle);
      sKeys.put("layout/activity_mvvm_0", com.myapp.R.layout.activity_mvvm);
      sKeys.put("layout/activity_navigation_0", com.myapp.R.layout.activity_navigation);
      sKeys.put("layout/activity_recycler_nesting_recycler_0", com.myapp.R.layout.activity_recycler_nesting_recycler);
      sKeys.put("layout/activity_refresh_layout_0", com.myapp.R.layout.activity_refresh_layout);
      sKeys.put("layout/activity_spinner_0", com.myapp.R.layout.activity_spinner);
      sKeys.put("layout/activity_touch_event_0", com.myapp.R.layout.activity_touch_event);
      sKeys.put("layout/activity_web_socket_0", com.myapp.R.layout.activity_web_socket);
      sKeys.put("layout/activity_zhuan_huan_0", com.myapp.R.layout.activity_zhuan_huan);
      sKeys.put("layout/activity_zxing_scan_0", com.myapp.R.layout.activity_zxing_scan);
      sKeys.put("layout/child_item_0", com.myapp.R.layout.child_item);
      sKeys.put("layout/fragment_frist_0", com.myapp.R.layout.fragment_frist);
      sKeys.put("layout/fragment_second_0", com.myapp.R.layout.fragment_second);
      sKeys.put("layout/item_recycler_0", com.myapp.R.layout.item_recycler);
      sKeys.put("layout/item_recyclerview_nesting_0", com.myapp.R.layout.item_recyclerview_nesting);
      sKeys.put("layout/jetpack_fragment_0", com.myapp.R.layout.jetpack_fragment);
      sKeys.put("layout/pop_layout_0", com.myapp.R.layout.pop_layout);
      sKeys.put("layout/test_layout_0", com.myapp.R.layout.test_layout);
    }
  }
}
