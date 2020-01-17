package com.myapp.utils;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;

import com.myapp.App;

import java.util.List;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.bluetooth.BluetoothDevice.BOND_BONDED;

public class AudioManagerUtils {
    private BluetoothAdapter mBluetoothAdapter;
    private AudioManager mAudioManager = null;
    private static AudioManagerUtils audioManagerUtils;
    private Vibrator mVibrator;
    public boolean mAudioFocused;//是否占用音频焦点
    public boolean isRinging;//是否振铃中
    private boolean isBluetoothConnected;
    private BluetoothProfile.ServiceListener mProfileListener;
    private BluetoothHeadset mBluetoothHeadset;
    private BluetoothDevice mBluetoothDevice;
    private boolean isScoConnected;

    public AudioManagerUtils() {
        if (mAudioManager==null){
            mAudioManager = ((AudioManager) getMyContext().getSystemService(Context.AUDIO_SERVICE));
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            mVibrator = (Vibrator) getMyContext().getSystemService(Context.VIBRATOR_SERVICE);
        }
    }

    private Context getMyContext() {
        return App.context;
    }

    public static AudioManagerUtils getIns(){
        synchronized (AudioManagerUtils.class){
            if (audioManagerUtils==null){
                audioManagerUtils=new AudioManagerUtils();
            }
        }

        return audioManagerUtils;
    }

    public  void messageDetailHandFree(){
        mAudioManager.setSpeakerphoneOn(true);
        mAudioManager.setMode( AudioManager.MODE_NORMAL);
    }

    public  void messageDetailTingTong(){
        mAudioManager.setSpeakerphoneOn(false);
        mAudioManager.setMode( AudioManager.MODE_IN_COMMUNICATION);
    }

    public  void handFree(){
        stopBlueTooth();
        mAudioManager.setSpeakerphoneOn(true);
        mAudioManager.setMode( AudioManager.MODE_NORMAL);
    }

    public  void tingTong(){
        stopBlueTooth();
        mAudioManager.setSpeakerphoneOn(false);
        mAudioManager.setMode( AudioManager.MODE_IN_COMMUNICATION);
    }

    public void stopBlueTooth(){
        mAudioManager.setMode(AudioManager.MODE_NORMAL);
        if (mAudioManager.isBluetoothScoOn()){
            mAudioManager.stopBluetoothSco();
            mAudioManager.setBluetoothScoOn(false);
        }
    }

    public void broadCast(){
        mAudioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
        mAudioManager.setSpeakerphoneOn(false);
        if (mAudioManager.isBluetoothScoOn()){
            mAudioManager.stopBluetoothSco();
            mAudioManager.setBluetoothScoOn(false);
        }
    }

    public boolean isBluetoothScoOn(){
        return mBluetoothAdapter.isEnabled()&&mAudioManager.isBluetoothScoOn();
    }

    public boolean isSpeakerphoneOn() {
        return mAudioManager.isSpeakerphoneOn();
    }

    public void volumeUp() {
        mAudioManager.adjustStreamVolume(
                AudioManager.STREAM_VOICE_CALL,
                AudioManager.ADJUST_RAISE,
                AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_SHOW_UI);
    }

    public void volumeDown() {
        mAudioManager.adjustStreamVolume(
                AudioManager.STREAM_VOICE_CALL,
                AudioManager.ADJUST_LOWER,
                AudioManager.FLAG_PLAY_SOUND | AudioManager.FLAG_SHOW_UI);
    }



    public boolean isBluetoothConnect(){

        return mBluetoothAdapter.getProfileConnectionState(BluetoothProfile.HEADSET) == BluetoothAdapter.STATE_CONNECTED;
    }



    public int getMode() {
        return mAudioManager.getMode();
    }

    public void huifu(int mode, boolean isSpecOn) {
        mAudioManager.setSpeakerphoneOn(false);
        mAudioManager.setMode(AudioManager.MODE_NORMAL);
    }

    public void zhenling() {
        mAudioManager.setSpeakerphoneOn(true);
        mAudioManager.setMode(AudioManager.MODE_RINGTONE);
    }

    public synchronized void startRinging() {
//        mAudioManager.setSpeakerphoneOn(false);
//        mAudioManager.setMode(AudioManager.MODE_NORMAL);
//        //设置音频流类型
//        mAudioManager.requestAudioFocus(null, AudioManager.STREAM_RING, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE);
        //设置震动
        if ((mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_VIBRATE || mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                && mVibrator != null) {
            long[] patern = {0, 1000, 1000};
            mVibrator.vibrate(patern, 1);
        }
        isRinging = true;
    }
    public synchronized void stopRinging(){
        if (mVibrator != null) {
            mVibrator.cancel();
        }
        isRinging = false;
    }

    public int getRingerMode() {
        return mAudioManager.getRingerMode();
    }

    public void setAudioManagerInCallMode() {
        if (mAudioManager.getMode() == AudioManager.MODE_IN_COMMUNICATION) {
            android.util.Log.w("","[AudioManager] already in MODE_IN_COMMUNICATION, skipping...");
            return;
        }
        android.util.Log.d("","[AudioManager] Mode: MODE_IN_COMMUNICATION");

        mAudioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
    }

    public void requestAudioFocus(int stream) {
        if (!mAudioFocused) {
            int res = mAudioManager.requestAudioFocus(null, stream, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE);
            Log.d("","Audio focus requested: " + (res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED ? "Granted" : "Denied"));
            if (res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) mAudioFocused = true;
        }
    }

    public void adjustVolume(int i) {
        // starting from ICS, volume must be adjusted by the application, at least for STREAM_VOICE_CALL volume stream
        mAudioManager.adjustStreamVolume(AudioManager.STREAM_VOICE_CALL, i < 0 ? AudioManager.ADJUST_LOWER : AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);

    }

    public int abandonAudioFocus() {
        return mAudioManager.abandonAudioFocus(null);
    }

    public void setMode(int modeNormal) {
        mAudioManager.setMode(modeNormal);
    }

    public void routeAudioToReceiver() {
        disableBluetoothSCO();
        mAudioManager.setSpeakerphoneOn(false);
    }
    public void disableBluetoothSCO() {
        if (mAudioManager != null && mAudioManager.isBluetoothScoOn()) {
            mAudioManager.stopBluetoothSco();
            mAudioManager.setBluetoothScoOn(false);

            // Hack to ensure bluetooth sco is really stopped
            int retries = 0;
            while (mAudioManager.isBluetoothScoOn() && retries < 10) {
                retries++;

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }

                mAudioManager.stopBluetoothSco();
                mAudioManager.setBluetoothScoOn(false);
            }
            android.util.Log.w("BluetoothManager", "[Bluetooth] SCO disconnected!");
        }
    }

    public boolean isBluetoothHeadsetAvailable() {
        if (mBluetoothAdapter != null && mBluetoothAdapter.isEnabled() && mAudioManager != null && mAudioManager.isBluetoothScoAvailableOffCall()) {
            boolean isHeadsetConnected = false;
            if (mBluetoothHeadset != null) {
                List<BluetoothDevice> devices = mBluetoothHeadset.getConnectedDevices();
                mBluetoothDevice = null;
                for (final BluetoothDevice dev : devices) {
                    if (mBluetoothHeadset.getConnectionState(dev) == BluetoothHeadset.STATE_CONNECTED) {
                        mBluetoothDevice = dev;
                        isHeadsetConnected = true;
                        break;
                    }
                }
                android.util.Log.d("BluetoothManager", isHeadsetConnected ? "[Bluetooth] Headset found, bluetooth audio route available" : "[Bluetooth] No headset found, bluetooth audio route unavailable");
            }
            return isHeadsetConnected;
        }

        return false;
    }


    public void startBluetooth() {
        if (isBluetoothConnected) {
            android.util.Log.e("BluetoothManager", "[Bluetooth] Already started, skipping...");
            return;
        }

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter != null && mBluetoothAdapter.isEnabled()) {
            if (mProfileListener != null) {
                android.util.Log.w("BluetoothManager", "[Bluetooth] Headset profile was already opened, let's close it");
                mBluetoothAdapter.closeProfileProxy(BluetoothProfile.HEADSET, mBluetoothHeadset);
            }

            mProfileListener = new BluetoothProfile.ServiceListener() {
                public void onServiceConnected(int profile, BluetoothProfile proxy) {
                    if (profile == BluetoothProfile.HEADSET) {
                        android.util.Log.d("BluetoothManager", "[Bluetooth] Headset connected");
                        mBluetoothHeadset = (BluetoothHeadset) proxy;
                        isBluetoothConnected = true;
                    }
                }

                public void onServiceDisconnected(int profile) {
                    if (profile == BluetoothProfile.HEADSET) {
                        mBluetoothHeadset = null;
                        isBluetoothConnected = false;
                        android.util.Log.d("BluetoothManager", "[Bluetooth] Headset disconnected");
                        routeAudioToReceiver();
                    }
                }
            };
            boolean success = mBluetoothAdapter.getProfileProxy(getMyContext(), mProfileListener, BluetoothProfile.HEADSET);
            if (!success) {
                android.util.Log.e("BluetoothManager", "[Bluetooth] getProfileProxy failed !");
            }
        } else {
            android.util.Log.w("BluetoothManager", "[Bluetooth] Interface disabled on device");
        }
    }

    public boolean isUsingBluetoothAudioRoute() {
        return mBluetoothHeadset != null && mBluetoothHeadset.isAudioConnected(mBluetoothDevice) && isScoConnected;
    }

    public boolean isVolumeFixed() {
        return mAudioManager.isVolumeFixed();
    }
}
