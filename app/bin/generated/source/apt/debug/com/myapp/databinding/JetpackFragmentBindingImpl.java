package com.myapp.databinding;
import com.myapp.R;
import com.myapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class JetpackFragmentBindingImpl extends JetpackFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener messageandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userinfo
            //         is com.myapp.databinding.JetpackFragmentBindingImpl.this.setUserinfo(callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(message);
            // localize variables for thread safety
            // userinfo
            java.lang.String userinfo = mUserinfo;


            if ((com.myapp.databinding.JetpackFragmentBindingImpl.this) != (null)) {



                com.myapp.databinding.JetpackFragmentBindingImpl.this.setUserinfo(callbackArg_0);
            }
        }
    };
    private androidx.databinding.InverseBindingListener message1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userinfo2.name
            //         is userinfo2.setName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(message1);
            // localize variables for thread safety
            // userinfo2 != null
            boolean userinfo2JavaLangObjectNull = false;
            // userinfo2
            com.myapp.model.UserBean userinfo2 = mUserinfo2;
            // userinfo2.name
            java.lang.String userinfo2Name = null;



            userinfo2JavaLangObjectNull = (userinfo2) != (null);
            if (userinfo2JavaLangObjectNull) {




                userinfo2.setName(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public JetpackFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private JetpackFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.jetpack.setTag(null);
        this.message.setTag(null);
        this.message1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.userinfo == variableId) {
            setUserinfo((java.lang.String) variable);
        }
        else if (BR.userinfo2 == variableId) {
            setUserinfo2((com.myapp.model.UserBean) variable);
        }
        else if (BR.click == variableId) {
            setClick((android.view.View.OnClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUserinfo(@Nullable java.lang.String Userinfo) {
        this.mUserinfo = Userinfo;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.userinfo);
        super.requestRebind();
    }
    public void setUserinfo2(@Nullable com.myapp.model.UserBean Userinfo2) {
        updateRegistration(0, Userinfo2);
        this.mUserinfo2 = Userinfo2;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.userinfo2);
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

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeUserinfo2((com.myapp.model.UserBean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeUserinfo2(com.myapp.model.UserBean Userinfo2, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.name) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        java.lang.String userinfo = mUserinfo;
        com.myapp.model.UserBean userinfo2 = mUserinfo2;
        java.lang.String userinfo2Name = null;
        android.view.View.OnClickListener click = mClick;

        if ((dirtyFlags & 0x12L) != 0) {
        }
        if ((dirtyFlags & 0x19L) != 0) {



                if (userinfo2 != null) {
                    // read userinfo2.name
                    userinfo2Name = userinfo2.getName();
                }
        }
        if ((dirtyFlags & 0x14L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x12L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.message, userinfo);
        }
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            this.message.setOnClickListener(click);
            this.message1.setOnClickListener(click);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.message, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, messageandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.message1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, message1androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.message1, userinfo2Name);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): userinfo2
        flag 1 (0x2L): userinfo
        flag 2 (0x3L): click
        flag 3 (0x4L): userinfo2.name
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}