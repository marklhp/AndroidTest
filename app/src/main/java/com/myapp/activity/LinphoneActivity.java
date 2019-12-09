package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.util.SharedPreferencesUtils;
import com.myapp.App;
import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityLinphoneBinding;
import com.myapp.linphone.SipUtils;
import com.myapp.utils.AudioManagerUtils;

import org.linphone.core.AuthInfo;
import org.linphone.core.AuthMethod;
import org.linphone.core.Call;
import org.linphone.core.CallLog;
import org.linphone.core.CallStats;
import org.linphone.core.ChatMessage;
import org.linphone.core.ChatRoom;
import org.linphone.core.ConfiguringState;
import org.linphone.core.Content;
import org.linphone.core.Core;
import org.linphone.core.CoreException;
import org.linphone.core.CoreListenerStub;
import org.linphone.core.EcCalibratorStatus;
import org.linphone.core.Event;
import org.linphone.core.Factory;
import org.linphone.core.Friend;
import org.linphone.core.FriendList;
import org.linphone.core.GlobalState;
import org.linphone.core.InfoMessage;
import org.linphone.core.PresenceModel;
import org.linphone.core.ProxyConfig;
import org.linphone.core.PublishState;
import org.linphone.core.RegistrationState;
import org.linphone.core.SubscriptionState;
import org.linphone.core.Transports;
import org.linphone.core.VersionUpdateCheckResult;

import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.functions.Consumer;

import static android.media.AudioManager.STREAM_VOICE_CALL;

public class LinphoneActivity extends BaseActivity<ActivityLinphoneBinding> implements View.OnClickListener {

    Call call;
    @Override
    protected void initView() {
        binding.setClick(this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_linphone;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linphone_init:
                long tempTime=System.currentTimeMillis();
                SipUtils.init(coreListenerStub);
                Log.d("时间差", (System.currentTimeMillis()-tempTime)+"");
                break;
            case R.id.linphone_register:
                SipUtils.registerSip();

                break;
            case R.id.linphone_call:
                SipUtils.call();
                break;
            case R.id.linphone_accept:
                SipUtils.accept(App.context);
                break;
            case R.id.linphone_jilu:
//                mode=AudioManagerUtils.getIns().getMode();
//               isSpecOn= AudioManagerUtils.getIns().isSpeakerphoneOn();
                AudioManagerUtils.getIns().zhenling();
                break;
            case R.id.linphone_huifu:
                AudioManagerUtils.getIns().huifu(mode,isSpecOn);
                break;
            case  R.id.linphone_tingtong:
                AudioManagerUtils.getIns().tingTong();
                break;
            case  R.id.linphone_mianti:
                AudioManagerUtils.getIns().handFree();
                break;
            case R.id.linphone_lanya:
                AudioManagerUtils.getIns().blueTooth(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {

                    }
                });
                break;
        }
    }


    int mode;
    boolean isSpecOn;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    CoreListenerStub coreListenerStub=new CoreListenerStub(){
        @Override
        public void onCallCreated(Core lc, Call call) {
            super.onCallCreated(lc, call);
            Log.d("linphone_33===","==="+call.getUserData());
        }

        @Override
        public void onCallStateChanged(Core lc, Call call, Call.State cstate, String message) {
            super.onCallStateChanged(lc, call, cstate, message);
            Log.d("linphone_34===", cstate.name()+"==="+message+"===="+AudioManagerUtils.getIns().getRingerMode());
//            if (cstate== Call.State.IncomingReceived){
//                AudioManagerUtils.getIns().startRinging();
//            }else if (AudioManagerUtils.getIns().isRinging){
//                AudioManagerUtils.getIns().stopRinging();
//            }
//
//            if (cstate==Call.State.Connected){//来电音频调试
//                if (lc.getCallsNb() == 1) {
//                    //It is for incoming calls, because outgoing calls enter MODE_IN_COMMUNICATION immediately when they start.
//                    //However, incoming call first use the MODE_RINGING to play the local ring.
//                    if (call.getDir() == Call.Dir.Incoming) {
//                        AudioManagerUtils.getIns().setAudioManagerInCallMode();
//                        //mAudioManager.abandonAudioFocus(null);
//                        AudioManagerUtils.getIns().requestAudioFocus(STREAM_VOICE_CALL);
//                    }
//                }
//                AudioManagerUtils.getIns().adjustVolume(0);
//            }
//
//            if (cstate == Call.State.End || cstate == Call.State.Error) {
//                if (lc.getCallsNb() == 0) {
//                    if (AudioManagerUtils.getIns().mAudioFocused) {
//                        int res = AudioManagerUtils.getIns().abandonAudioFocus();
//                        org.linphone.mediastream.Log.d("Audio focus released a bit later: " + (res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED ? "Granted" : "Denied"));
//                        AudioManagerUtils.getIns().mAudioFocused = false;
//                    }
//
//                    TelephonyManager tm = (TelephonyManager) App.context.getSystemService(Context.TELEPHONY_SERVICE);
//                    if (tm.getCallState() == TelephonyManager.CALL_STATE_IDLE) {
//                        org.linphone.mediastream.Log.d("---AudioManager: back to MODE_NORMAL");
//                        AudioManagerUtils.getIns().setMode(AudioManager.MODE_NORMAL);
//                        org.linphone.mediastream.Log.d("All call terminated, routing back to earpiece");
//                        AudioManagerUtils.getIns().routeAudioToReceiver();
//                    }
//                }
//            }
//
//            if (cstate == Call.State.OutgoingInit) {
//                //Enter the MODE_IN_COMMUNICATION mode as soon as possible, so that ringback
//                //is heard normally in earpiece or bluetooth receiver.
//                AudioManagerUtils.getIns().requestAudioFocus(STREAM_VOICE_CALL);
//                AudioManagerUtils.getIns().blueTooth(new Consumer<Boolean>() {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//
//                    }
//                });
//            }
//
//            if (cstate == Call.State.StreamsRunning) {
//                AudioManagerUtils.getIns().blueTooth(new Consumer<Boolean>() {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//
//                    }
//                });
//            }
        }

        @Override
        public void onRegistrationStateChanged(Core lc, ProxyConfig cfg, RegistrationState cstate, String message) {
            super.onRegistrationStateChanged(lc, cfg, cstate, message);
            Log.d("linphone_35===", cstate.toString()+"==="+message);
        }

        @Override
        public void onConfiguringStatus(Core lc, ConfiguringState status, String message) {
            super.onConfiguringStatus(lc, status, message);
            Log.d("linphone_36===", lc.getUserAgent()+"--"+status.toString()+"==="+message);
        }

        @Override
        public void onGlobalStateChanged(Core lc, GlobalState gstate, String message) {
            super.onGlobalStateChanged(lc, gstate, message);
            Log.d("linphone_37===", lc.getUserAgent()+"--"+gstate.toString()+"==="+message);
        }

        @Override
        public void onTransferStateChanged(Core lc, Call transfered, Call.State newCallState) {
            super.onTransferStateChanged(lc, transfered, newCallState);
            Log.d("linphone_1===", lc.getUserAgent());
        }

        @Override
        public void onFriendListCreated(Core lc, FriendList list) {
            super.onFriendListCreated(lc, list);
            Log.d("linphone_2===", lc.getUserAgent());
        }

        @Override
        public void onSubscriptionStateChanged(Core lc, Event lev, SubscriptionState state) {
            super.onSubscriptionStateChanged(lc, lev, state);
            Log.d("linphone_4===", lc.getUserAgent());
        }

        @Override
        public void onCallLogUpdated(Core lc, CallLog newcl) {
            super.onCallLogUpdated(lc, newcl);
            Log.d("linphone_5===", lc.getUserAgent());
        }

        @Override
        public void onAuthenticationRequested(Core lc, AuthInfo authInfo, AuthMethod method) {
            super.onAuthenticationRequested(lc, authInfo, method);
            Log.d("linphone_6===", lc.getUserAgent());
        }

        @Override
        public void onNotifyPresenceReceivedForUriOrTel(Core lc, Friend lf, String uriOrTel, PresenceModel presenceModel) {
            super.onNotifyPresenceReceivedForUriOrTel(lc, lf, uriOrTel, presenceModel);
            Log.d("linphone_7===", lc.getUserAgent());
        }

        @Override
        public void onChatRoomStateChanged(Core lc, ChatRoom cr, ChatRoom.State state) {
            super.onChatRoomStateChanged(lc, cr, state);
            Log.d("linphone_8===", lc.getUserAgent());
        }

        @Override
        public void onBuddyInfoUpdated(Core lc, Friend lf) {
            super.onBuddyInfoUpdated(lc, lf);
            Log.d("linphone_9===", lc.getUserAgent());
        }

        @Override
        public void onNetworkReachable(Core lc, boolean reachable) {
            super.onNetworkReachable(lc, reachable);
            Log.d("linphone_10===", lc.getUserAgent());
        }

        @Override
        public void onNotifyReceived(Core lc, Event lev, String notifiedEvent, Content body) {
            super.onNotifyReceived(lc, lev, notifiedEvent, body);
            Log.d("linphone_11===", lc.getUserAgent());
        }

        @Override
        public void onNewSubscriptionRequested(Core lc, Friend lf, String url) {
            super.onNewSubscriptionRequested(lc, lf, url);
            Log.d("linphone_12===", lc.getUserAgent());
        }

        @Override
        public void onNotifyPresenceReceived(Core lc, Friend lf) {
            super.onNotifyPresenceReceived(lc, lf);
            Log.d("linphone_13===", lc.getUserAgent());
        }

        @Override
        public void onEcCalibrationAudioInit(Core lc) {
            super.onEcCalibrationAudioInit(lc);
            Log.d("linphone_14===", lc.getUserAgent());
        }

        @Override
        public void onMessageReceived(Core lc, ChatRoom room, ChatMessage message) {
            super.onMessageReceived(lc, room, message);
            Log.d("linphone_15===", lc.getUserAgent());
        }

        @Override
        public void onEcCalibrationResult(Core lc, EcCalibratorStatus status, int delayMs) {
            super.onEcCalibrationResult(lc, status, delayMs);
            Log.d("linphone_16===", lc.getUserAgent());
        }

        @Override
        public void onSubscribeReceived(Core lc, Event lev, String subscribeEvent, Content body) {
            super.onSubscribeReceived(lc, lev, subscribeEvent, body);
            Log.d("linphone_17===", lc.getUserAgent());
        }

        @Override
        public void onInfoReceived(Core lc, Call call, InfoMessage msg) {
            super.onInfoReceived(lc, call, msg);
            Log.d("linphone_18===", lc.getUserAgent());
        }

        @Override
        public void onCallStatsUpdated(Core lc, Call call, CallStats stats) {
            super.onCallStatsUpdated(lc, call, stats);
            Log.d("linphone_19===", lc.getUserAgent());
        }

        @Override
        public void onFriendListRemoved(Core lc, FriendList list) {
            super.onFriendListRemoved(lc, list);
            Log.d("linphone_20===", lc.getUserAgent());
        }

        @Override
        public void onReferReceived(Core lc, String referTo) {
            super.onReferReceived(lc, referTo);
            Log.d("linphone_21===", lc.getUserAgent());
        }

        @Override
        public void onQrcodeFound(Core lc, String result) {
            super.onQrcodeFound(lc, result);
            Log.d("linphone_22===", lc.getUserAgent());
        }

        @Override
        public void onPublishStateChanged(Core lc, Event lev, PublishState state) {
            super.onPublishStateChanged(lc, lev, state);
            Log.d("linphone_23===", lc.getUserAgent());
        }

        @Override
        public void onCallEncryptionChanged(Core lc, Call call, boolean on, String authenticationToken) {
            super.onCallEncryptionChanged(lc, call, on, authenticationToken);
            Log.d("linphone_24===", lc.getUserAgent());
        }

        @Override
        public void onIsComposingReceived(Core lc, ChatRoom room) {
            super.onIsComposingReceived(lc, room);
            Log.d("linphone_25===", lc.getUserAgent());
        }

        @Override
        public void onMessageReceivedUnableDecrypt(Core lc, ChatRoom room, ChatMessage message) {
            super.onMessageReceivedUnableDecrypt(lc, room, message);
            Log.d("linphone_26===", lc.getUserAgent());
        }

        @Override
        public void onLogCollectionUploadProgressIndication(Core lc, int offset, int total) {
            super.onLogCollectionUploadProgressIndication(lc, offset, total);
            Log.d("linphone_27===", lc.getUserAgent());
        }

        @Override
        public void onVersionUpdateCheckResultReceived(Core lc, VersionUpdateCheckResult result, String version, String url) {
            super.onVersionUpdateCheckResultReceived(lc, result, version, url);
            Log.d("linphone_28===", lc.getUserAgent());
        }

        @Override
        public void onEcCalibrationAudioUninit(Core lc) {
            super.onEcCalibrationAudioUninit(lc);
            Log.d("linphone_29===", lc.getUserAgent());
        }

        @Override
        public void onLogCollectionUploadStateChanged(Core lc, Core.LogCollectionUploadState state, String info) {
            super.onLogCollectionUploadStateChanged(lc, state, info);
            Log.d("linphone_30===", lc.getUserAgent());
        }

        @Override
        public void onDtmfReceived(Core lc, Call call, int dtmf) {
            super.onDtmfReceived(lc, call, dtmf);
            Log.d("linphone_31===", lc.getUserAgent());
        }
    };
}
