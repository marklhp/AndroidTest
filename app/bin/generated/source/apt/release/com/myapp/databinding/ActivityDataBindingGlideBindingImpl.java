package com.myapp.databinding;
import com.myapp.R;
import com.myapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityDataBindingGlideBindingImpl extends ActivityDataBindingGlideBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(8);
        sIncludes.setIncludes(1, 
            new String[] {"child_item"},
            new int[] {7},
            new int[] {R.layout.child_item});
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.ImageView mboundView3;
    @NonNull
    private final android.widget.ImageView mboundView4;
    @NonNull
    private final android.widget.ImageView mboundView5;
    // variables
    // values
    private java.lang.String mOldResId;
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDataBindingGlideBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ActivityDataBindingGlideBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.myapp.databinding.ChildItemBinding) bindings[7]
            , (android.widget.ImageView) bindings[6]
            );
        this.image.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.ImageView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.ImageView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.ImageView) bindings[5];
        this.mboundView5.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
        }
        child.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (child.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.roundUrl == variableId) {
            setRoundUrl((java.lang.String) variable);
        }
        else if (BR.num == variableId) {
            setNum((java.lang.Integer) variable);
        }
        else if (BR.circleUrl == variableId) {
            setCircleUrl((java.lang.String) variable);
        }
        else if (BR.resId == variableId) {
            setResId((java.lang.String) variable);
        }
        else if (BR.glideClick == variableId) {
            setGlideClick((android.view.View.OnClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRoundUrl(@Nullable java.lang.String RoundUrl) {
        this.mRoundUrl = RoundUrl;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.roundUrl);
        super.requestRebind();
    }
    public void setNum(@Nullable java.lang.Integer Num) {
        this.mNum = Num;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.num);
        super.requestRebind();
    }
    public void setCircleUrl(@Nullable java.lang.String CircleUrl) {
        this.mCircleUrl = CircleUrl;
    }
    public void setResId(@Nullable java.lang.String ResId) {
        this.mResId = ResId;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.resId);
        super.requestRebind();
    }
    public void setGlideClick(@Nullable android.view.View.OnClickListener GlideClick) {
        this.mGlideClick = GlideClick;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.glideClick);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        child.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeChild((com.myapp.databinding.ChildItemBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeChild(com.myapp.databinding.ChildItemBinding Child, int fieldId) {
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
        int androidxDatabindingViewDataBindingSafeUnboxNum = 0;
        java.lang.String roundUrl = mRoundUrl;
        java.lang.Integer num = mNum;
        java.lang.String resId = mResId;
        android.view.View.OnClickListener glideClick = mGlideClick;

        if ((dirtyFlags & 0x42L) != 0) {
        }
        if ((dirtyFlags & 0x44L) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(num)
                androidxDatabindingViewDataBindingSafeUnboxNum = androidx.databinding.ViewDataBinding.safeUnbox(num);
        }
        if ((dirtyFlags & 0x50L) != 0) {
        }
        if ((dirtyFlags & 0x60L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            this.child.setItext(getRoot().getResources().getString(R.string.app_name));
            this.child.setImage(androidx.databinding.adapters.Converters.convertColorToDrawable(com.myapp.R.mipmap.ic_launcher));
        }
        if ((dirtyFlags & 0x42L) != 0) {
            // api target 1

            com.myapp.utils.glide.ImageViewAdapter.loadRoundImage(this.image, roundUrl, com.myapp.R.mipmap.ic_launcher, 20);
            com.myapp.utils.glide.ImageViewAdapter.loadRoundImage(this.mboundView5, roundUrl, 10);
        }
        if ((dirtyFlags & 0x60L) != 0) {
            // api target 1

            this.mboundView2.setOnClickListener(glideClick);
        }
        if ((dirtyFlags & 0x50L) != 0) {
            // api target 1

            com.myapp.utils.glide.ImageViewAdapter.loadImage(this.mboundView3, this.mOldResId, resId);
        }
        if ((dirtyFlags & 0x44L) != 0) {
            // api target 1

            com.myapp.utils.glide.ImageViewAdapter.loadCircleImage(this.mboundView4, androidxDatabindingViewDataBindingSafeUnboxNum);
        }
        if ((dirtyFlags & 0x50L) != 0) {
            this.mOldResId = resId;
        }
        executeBindingsOn(child);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): child
        flag 1 (0x2L): roundUrl
        flag 2 (0x3L): num
        flag 3 (0x4L): circleUrl
        flag 4 (0x5L): resId
        flag 5 (0x6L): glideClick
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}