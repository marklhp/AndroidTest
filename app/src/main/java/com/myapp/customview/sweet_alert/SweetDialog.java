package com.myapp.customview.sweet_alert;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;

import com.myapp.R;

/**
 * Created by lihaipeng on 2018/5/31.
 */

public class SweetDialog extends Dialog {
    public FrameLayout mDialogView;
    private AnimationSet mModalInAnim;
    private AnimationSet mModalOutAnim;
    private boolean mCloseFromCancel;

    public static final int NORMAL_TYPE = 0;

    public SweetDialog(Context context) {
        this(context, NORMAL_TYPE);
    }

    public SweetDialog(Context context, int alertType) {
        super(context, R.style.alert_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        mDialogView=View.inflate(context,R.layout.dialog,null).findViewById(R.id.mDialogView);
        setContentView(mDialogView);
        mModalInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_in);
        mModalOutAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_out);
        mModalOutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.setVisibility(View.GONE);
                mDialogView.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mCloseFromCancel) {
                            SweetDialog.super.cancel();
                        } else {
                            SweetDialog.super.dismiss();
                        }
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }



    /**
     * The real Dialog.cancel() will be invoked async-ly after the animation finishes.
     */
    @Override
    public void cancel() {
        dismissWithAnimation(true);
    }
    protected void onStart() {
        mDialogView.startAnimation(mModalInAnim);
    }

    private void dismissWithAnimation(boolean fromCancel) {
        mCloseFromCancel = fromCancel;
        mDialogView.startAnimation(mModalOutAnim);
    }
}
