package com.myapp.databinding;
import com.myapp.R;
import com.myapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLinphoneBindingImpl extends ActivityLinphoneBinding  {

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
    @NonNull
    private final android.widget.TextView mboundView6;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener linphoneEt1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of username
            //         is com.myapp.databinding.ActivityLinphoneBindingImpl.this.setUsername(callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(linphoneEt1);
            // localize variables for thread safety
            // username
            java.lang.String username = mUsername;


            if ((com.myapp.databinding.ActivityLinphoneBindingImpl.this) != (null)) {



                com.myapp.databinding.ActivityLinphoneBindingImpl.this.setUsername(callbackArg_0);
            }
        }
    };
    private androidx.databinding.InverseBindingListener linphoneEt2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of password
            //         is com.myapp.databinding.ActivityLinphoneBindingImpl.this.setPassword(callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(linphoneEt2);
            // localize variables for thread safety
            // password
            java.lang.String password = mPassword;


            if ((com.myapp.databinding.ActivityLinphoneBindingImpl.this) != (null)) {



                com.myapp.databinding.ActivityLinphoneBindingImpl.this.setPassword(callbackArg_0);
            }
        }
    };
    private androidx.databinding.InverseBindingListener linphoneEt3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of servaladdress
            //         is com.myapp.databinding.ActivityLinphoneBindingImpl.this.setServaladdress(callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(linphoneEt3);
            // localize variables for thread safety
            // servaladdress
            java.lang.String servaladdress = mServaladdress;


            if ((com.myapp.databinding.ActivityLinphoneBindingImpl.this) != (null)) {



                com.myapp.databinding.ActivityLinphoneBindingImpl.this.setServaladdress(callbackArg_0);
            }
        }
    };
    private androidx.databinding.InverseBindingListener linphoneEt5androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of statu
            //         is com.myapp.databinding.ActivityLinphoneBindingImpl.this.setStatu(callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(linphoneEt5);
            // localize variables for thread safety
            // statu
            java.lang.String statu = mStatu;


            if ((com.myapp.databinding.ActivityLinphoneBindingImpl.this) != (null)) {



                com.myapp.databinding.ActivityLinphoneBindingImpl.this.setStatu(callbackArg_0);
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView6androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of mythrow
            //         is com.myapp.databinding.ActivityLinphoneBindingImpl.this.setMythrow(callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView6);
            // localize variables for thread safety
            // mythrow
            java.lang.String mythrow = mMythrow;


            if ((com.myapp.databinding.ActivityLinphoneBindingImpl.this) != (null)) {



                com.myapp.databinding.ActivityLinphoneBindingImpl.this.setMythrow(callbackArg_0);
            }
        }
    };

    public ActivityLinphoneBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityLinphoneBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            );
        this.linphoneEt1.setTag(null);
        this.linphoneEt2.setTag(null);
        this.linphoneEt3.setTag(null);
        this.linphoneEt4.setTag(null);
        this.linphoneEt5.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
        if (BR.mythrow == variableId) {
            setMythrow((java.lang.String) variable);
        }
        else if (BR.servaladdress == variableId) {
            setServaladdress((java.lang.String) variable);
        }
        else if (BR.click == variableId) {
            setClick((android.view.View.OnClickListener) variable);
        }
        else if (BR.password == variableId) {
            setPassword((java.lang.String) variable);
        }
        else if (BR.username == variableId) {
            setUsername((java.lang.String) variable);
        }
        else if (BR.statu == variableId) {
            setStatu((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMythrow(@Nullable java.lang.String Mythrow) {
        this.mMythrow = Mythrow;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.mythrow);
        super.requestRebind();
    }
    public void setServaladdress(@Nullable java.lang.String Servaladdress) {
        this.mServaladdress = Servaladdress;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.servaladdress);
        super.requestRebind();
    }
    public void setClick(@Nullable android.view.View.OnClickListener Click) {
        this.mClick = Click;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.click);
        super.requestRebind();
    }
    public void setPassword(@Nullable java.lang.String Password) {
        this.mPassword = Password;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.password);
        super.requestRebind();
    }
    public void setUsername(@Nullable java.lang.String Username) {
        this.mUsername = Username;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.username);
        super.requestRebind();
    }
    public void setStatu(@Nullable java.lang.String Statu) {
        this.mStatu = Statu;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.statu);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        java.lang.String mythrow = mMythrow;
        java.lang.String servaladdress = mServaladdress;
        android.view.View.OnClickListener click = mClick;
        java.lang.String password = mPassword;
        java.lang.String username = mUsername;
        java.lang.String statu = mStatu;

        if ((dirtyFlags & 0x41L) != 0) {
        }
        if ((dirtyFlags & 0x42L) != 0) {
        }
        if ((dirtyFlags & 0x44L) != 0) {
        }
        if ((dirtyFlags & 0x48L) != 0) {
        }
        if ((dirtyFlags & 0x50L) != 0) {
        }
        if ((dirtyFlags & 0x60L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x50L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.linphoneEt1, username);
        }
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.linphoneEt1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, linphoneEt1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.linphoneEt2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, linphoneEt2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.linphoneEt3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, linphoneEt3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.linphoneEt5, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, linphoneEt5androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView6, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView6androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x48L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.linphoneEt2, password);
        }
        if ((dirtyFlags & 0x42L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.linphoneEt3, servaladdress);
        }
        if ((dirtyFlags & 0x44L) != 0) {
            // api target 1

            this.linphoneEt4.setOnClickListener(click);
        }
        if ((dirtyFlags & 0x60L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.linphoneEt5, statu);
        }
        if ((dirtyFlags & 0x41L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, mythrow);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): mythrow
        flag 1 (0x2L): servaladdress
        flag 2 (0x3L): click
        flag 3 (0x4L): password
        flag 4 (0x5L): username
        flag 5 (0x6L): statu
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}