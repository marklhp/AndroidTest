package com.myapp.databinding;
import com.myapp.R;
import com.myapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 37, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[20]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[36]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[11]
            );
        this.accessibility.setTag(null);
        this.constrationactivity.setTag(null);
        this.coordinator.setTag(null);
        this.dadabindingGlide.setTag(null);
        this.datepickerTimepicker.setTag(null);
        this.divide.setTag(null);
        this.editFocusable.setTag(null);
        this.fingerPrint.setTag(null);
        this.flexboxlayoutActivity.setTag(null);
        this.floatingWindow.setTag(null);
        this.fragmentLife.setTag(null);
        this.getcolor.setTag(null);
        this.hashmap.setTag(null);
        this.imageView.setTag(null);
        this.jetpackActivity.setTag(null);
        this.jsonGson.setTag(null);
        this.linphone.setTag(null);
        this.localScan.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.multipleTypesRecycle.setTag(null);
        this.mvc.setTag(null);
        this.navigationActivity.setTag(null);
        this.ordinary.setTag(null);
        this.popupwendow.setTag(null);
        this.pxMeasure.setTag(null);
        this.recyclerNestingRecycler.setTag(null);
        this.rsa.setTag(null);
        this.scanListenee.setTag(null);
        this.scrolltoScrollby.setTag(null);
        this.smartrefreshlayout.setTag(null);
        this.spinner.setTag(null);
        this.sweetAlert.setTag(null);
        this.touchevent.setTag(null);
        this.uiDelayed.setTag(null);
        this.websocket.setTag(null);
        this.zhuanhuan.setTag(null);
        this.zxingScanListenee.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.src == variableId) {
            setSrc((androidx.databinding.ObservableInt) variable);
        }
        else if (BR.click == variableId) {
            setClick((android.view.View.OnClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSrc(@Nullable androidx.databinding.ObservableInt Src) {
        updateRegistration(0, Src);
        this.mSrc = Src;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.src);
        super.requestRebind();
    }
    public void setClick(@Nullable android.view.View.OnClickListener Click) {
        this.mClick = Click;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.click);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSrc((androidx.databinding.ObservableInt) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSrc(androidx.databinding.ObservableInt Src, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        androidx.databinding.ObservableInt src = mSrc;
        android.view.View.OnClickListener click = mClick;
        int srcGet = 0;

        if ((dirtyFlags & 0x5L) != 0) {



                if (src != null) {
                    // read src.get()
                    srcGet = src.get();
                }
        }
        if ((dirtyFlags & 0x6L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.accessibility.setOnClickListener(click);
            this.constrationactivity.setOnClickListener(click);
            this.coordinator.setOnClickListener(click);
            this.dadabindingGlide.setOnClickListener(click);
            this.datepickerTimepicker.setOnClickListener(click);
            this.divide.setOnClickListener(click);
            this.editFocusable.setOnClickListener(click);
            this.fingerPrint.setOnClickListener(click);
            this.flexboxlayoutActivity.setOnClickListener(click);
            this.floatingWindow.setOnClickListener(click);
            this.fragmentLife.setOnClickListener(click);
            this.getcolor.setOnClickListener(click);
            this.hashmap.setOnClickListener(click);
            this.imageView.setOnClickListener(click);
            this.jetpackActivity.setOnClickListener(click);
            this.jsonGson.setOnClickListener(click);
            this.linphone.setOnClickListener(click);
            this.localScan.setOnClickListener(click);
            this.multipleTypesRecycle.setOnClickListener(click);
            this.mvc.setOnClickListener(click);
            this.navigationActivity.setOnClickListener(click);
            this.ordinary.setOnClickListener(click);
            this.popupwendow.setOnClickListener(click);
            this.pxMeasure.setOnClickListener(click);
            this.recyclerNestingRecycler.setOnClickListener(click);
            this.rsa.setOnClickListener(click);
            this.scanListenee.setOnClickListener(click);
            this.scrolltoScrollby.setOnClickListener(click);
            this.smartrefreshlayout.setOnClickListener(click);
            this.spinner.setOnClickListener(click);
            this.sweetAlert.setOnClickListener(click);
            this.touchevent.setOnClickListener(click);
            this.uiDelayed.setOnClickListener(click);
            this.websocket.setOnClickListener(click);
            this.zhuanhuan.setOnClickListener(click);
            this.zxingScanListenee.setOnClickListener(click);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            com.myapp.utils.glide.ImageViewAdapter.loadImage(this.imageView, srcGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): src
        flag 1 (0x2L): click
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}