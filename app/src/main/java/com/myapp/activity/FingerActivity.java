package com.myapp.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myapp.R;
import com.myapp.finger.CryptoObjectHelper;
import com.myapp.finger.MyAuthCallback;

import androidx.annotation.RequiresApi;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.core.os.CancellationSignal;

public class FingerActivity extends Activity {


    private final String TAG = "FingerActivity";

    private TextView mResultInfo = null;
    private Button mCancelBtn = null;
    private Button mStartBtn = null;

    private FingerprintManagerCompat fingerprintManager = null;
    private MyAuthCallback myAuthCallback = null;
    private CancellationSignal cancellationSignal = null;

    private Handler handler = null;
    public static final int MSG_AUTH_SUCCESS = 100;
    public static final int MSG_AUTH_FAILED = 101;
    public static final int MSG_AUTH_ERROR = 102;
    public static final int MSG_AUTH_HELP = 103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger);
        mResultInfo = (TextView) this.findViewById(R.id.fingerprint_status);
        mCancelBtn = (Button) this.findViewById(R.id.cancel_button);
        mStartBtn = (Button) this.findViewById(R.id.start_button);

        mCancelBtn.setEnabled(false);
        mStartBtn.setEnabled(true);

        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCancelBtn.setEnabled(false);
                mStartBtn.setEnabled(true);

                cancellationSignal.cancel();
                cancellationSignal=null;
            }
        });

        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                mResultInfo.setText("Touch sensor");
                mResultInfo.setTextColor(getApplicationContext().getColor(R.color.hint_color));

                try{
                    CryptoObjectHelper cryptoObjectHelper=new CryptoObjectHelper();
                    if (cancellationSignal==null){
                        cancellationSignal=new CancellationSignal();
                    }
                    fingerprintManager.authenticate(cryptoObjectHelper.buildCryptoObject(),0,cancellationSignal,myAuthCallback,null);

                    mStartBtn.setEnabled(false);
                    mCancelBtn.setEnabled(true);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                Log.d(TAG, "msg: " + msg.what + " ,arg1: " + msg.arg1);
                switch (msg.what) {
                    case MSG_AUTH_SUCCESS:
                        setResultInfo(R.string.fingerprint_success);
                        mCancelBtn.setEnabled(false);
                        mStartBtn.setEnabled(true);
                        cancellationSignal = null;
                        break;
                    case MSG_AUTH_FAILED:
                        setResultInfo(R.string.fingerprint_not_recognized);
                        mCancelBtn.setEnabled(false);
                        mStartBtn.setEnabled(true);
                        cancellationSignal = null;
                        break;
                    case MSG_AUTH_ERROR:
                        handleErrorCode(msg.arg1);
                        break;
                    case MSG_AUTH_HELP:
                        handleHelpCode(msg.arg1);
                        break;
                }
            }
        };

        // init fingerprint.
        fingerprintManager = FingerprintManagerCompat.from(this);

        if (!fingerprintManager.isHardwareDetected()) {
            // no fingerprint sensor is detected, show dialog to tell user.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.no_sensor_dialog_title);
            builder.setMessage(R.string.no_sensor_dialog_message);
            builder.setIcon(android.R.drawable.stat_sys_warning);
            builder.setCancelable(false);
            builder.setNegativeButton(R.string.cancel_btn_dialog, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            // show this dialog.
            builder.create().show();
        } else if (!fingerprintManager.hasEnrolledFingerprints()) {
            // no fingerprint image has been enrolled.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.no_fingerprint_enrolled_dialog_title);
            builder.setMessage(R.string.no_fingerprint_enrolled_dialog_message);
            builder.setIcon(android.R.drawable.stat_sys_warning);
            builder.setCancelable(false);
            builder.setNegativeButton(R.string.cancel_btn_dialog, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            // show this dialog
            builder.create().show();
        } else {
            try {
                myAuthCallback = new MyAuthCallback(handler);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (!mStartBtn.isEnabled() && cancellationSignal != null) {
            cancellationSignal.cancel();
        }
    }

    private void handleHelpCode(int code) {
        switch (code) {
            case FingerprintManager.FINGERPRINT_ACQUIRED_GOOD:
                setResultInfo(R.string.AcquiredGood_warning);
                break;
            case FingerprintManager.FINGERPRINT_ACQUIRED_IMAGER_DIRTY:
                setResultInfo(R.string.AcquiredImageDirty_warning);
                break;
            case FingerprintManager.FINGERPRINT_ACQUIRED_INSUFFICIENT:
                setResultInfo(R.string.AcquiredInsufficient_warning);
                break;
            case FingerprintManager.FINGERPRINT_ACQUIRED_PARTIAL:
                setResultInfo(R.string.AcquiredPartial_warning);
                break;
            case FingerprintManager.FINGERPRINT_ACQUIRED_TOO_FAST:
                setResultInfo(R.string.AcquiredTooFast_warning);
                break;
            case FingerprintManager.FINGERPRINT_ACQUIRED_TOO_SLOW:
                setResultInfo(R.string.AcquiredToSlow_warning);
                break;
        }
    }

    private void handleErrorCode(int code) {
        switch (code) {
            case FingerprintManager.FINGERPRINT_ERROR_CANCELED:
                setResultInfo(R.string.ErrorCanceled_warning);
                break;
            case FingerprintManager.FINGERPRINT_ERROR_HW_UNAVAILABLE:
                setResultInfo(R.string.ErrorHwUnavailable_warning);
                break;
            case FingerprintManager.FINGERPRINT_ERROR_LOCKOUT:
                setResultInfo(R.string.ErrorLockout_warning);
                break;
            case FingerprintManager.FINGERPRINT_ERROR_NO_SPACE:
                setResultInfo(R.string.ErrorNoSpace_warning);
                break;
            case FingerprintManager.FINGERPRINT_ERROR_TIMEOUT:
                setResultInfo(R.string.ErrorTimeout_warning);
                break;
            case FingerprintManager.FINGERPRINT_ERROR_UNABLE_TO_PROCESS:
                setResultInfo(R.string.ErrorUnableToProcess_warning);
                break;
        }
    }

    private void setResultInfo(int stringId) {
        if (mResultInfo != null) {
            if (stringId == R.string.fingerprint_success) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mResultInfo.setTextColor(getColor(R.color.success_color));
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mResultInfo.setTextColor(getColor(R.color.warning_color));
                }
            }
            mResultInfo.setText(stringId);
        }
    }
}
