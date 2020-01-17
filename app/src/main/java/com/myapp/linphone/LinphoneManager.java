package com.myapp.linphone;

/*
LinphoneManager.java
Copyright (C) 2018  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorEvent;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;


import com.myapp.linphone.call.CallManager;

import org.linphone.core.Address;
import org.linphone.core.AuthInfo;
import org.linphone.core.Call;
import org.linphone.core.CallParams;
import org.linphone.core.Core;
import org.linphone.core.CoreException;
import org.linphone.core.Factory;
import org.linphone.core.FriendList;
import org.linphone.core.LogCollectionState;
import org.linphone.core.LogLevel;
import org.linphone.core.LoggingService;
import org.linphone.core.LoggingServiceListener;
import org.linphone.core.PresenceActivity;
import org.linphone.core.PresenceBasicStatus;
import org.linphone.core.PresenceModel;
import org.linphone.core.ProxyConfig;
import org.linphone.core.Reason;
import org.linphone.mediastream.Log;

import java.util.Map;

/**
 * Manager of the low level LibLinphone stuff.<br />
 * Including:<ul>
 * <li>Starting C liblinphone</li>
 * <li>Reacting to C liblinphone state changes</li>
 * <li>Calling Linphone android service listener methods</li>
 * <li>Interacting from Android GUI/service with low level SIP stuff/</li>
 * </ul>
 * <p>
 * Add Service Listener to react to Linphone state changes.
 */
public class LinphoneManager {
    private static final int dbStep = 4;
    private static LinphoneManager instance;
    private Core mLc;


    protected LinphoneManager(final Context c) {
    }


    private boolean isPresenceModelActivitySet() {
        Core lc = getLcIfManagerNotDestroyedOrNull();
        if (isInstanciated() && lc != null) {
            return lc.getPresenceModel() != null && lc.getPresenceModel().getActivity() != null;
        }
        return false;
    }

    public void changeStatusToOnline() {
        Core lc = getLcIfManagerNotDestroyedOrNull();
        if (lc == null) return;
        PresenceModel model = lc.createPresenceModel();
        model.setBasicStatus(PresenceBasicStatus.Open);
        lc.setPresenceModel(model);
    }

    @SuppressLint("InvalidWakeLockTag")
    public synchronized void initLiblinphone(Core lc) throws CoreException {
        mLc = lc;
        if (true) return;
        mLc.migrateLogsFromRcToDb();
        initPushNotificationsService();


    }

    private void initPushNotificationsService() {
        try {
            Class<?> firebaseClass = Class.forName("com.google.firebase.iid.FirebaseInstanceId");
            Object firebaseInstance = firebaseClass.getMethod("getInstance").invoke(null);
            final String refreshedToken = (String) firebaseClass.getMethod("getToken").invoke(firebaseInstance);

            //final String refreshedToken = com.google.firebase.iid.FirebaseInstanceId.getInstance().getToken();
            if (refreshedToken != null) {
                Log.i("[Push Notification] init push notif service token is: " + refreshedToken);
                setPushNotificationRegistrationID(refreshedToken);
            }
        } catch (Exception e) {
            Log.i("[Push Notification] firebase not available.");
        }
    }

    public void setPushNotificationRegistrationID(String regId) {
        if (getLc().getConfig() == null) return;
        Log.i("[Push Notification] New token received" + regId);
        getLc().getConfig().setString("app", "push_notification_regid", (regId != null) ? regId : "");
        setPushNotificationEnabled(isPushNotificationEnabled());
    }

    public boolean isPushNotificationEnabled() {
        return getLc().getConfig().getBool("app", "push_notification", true);
    }

    public String getXmlrpcUrl() {
        return getLc().getConfig().getString("assistant", "xmlrpc_url", null);
    }

    public void setPushNotificationEnabled(boolean enable) {
        getLc().getConfig().setBool("app", "push_notification", enable);

        Core lc = getLc();
        if (lc == null) {
            return;
        }

        if (enable) {
            // Add push infos to exisiting proxy configs
            String regId = getPushNotificationRegistrationID();
            String appId = "929724111839";
            if (regId != null && lc.getProxyConfigList().length > 0) {
                for (ProxyConfig lpc : lc.getProxyConfigList()) {
                    if (lpc == null) continue;
                    if (!lpc.isPushNotificationAllowed()) {
                        lpc.edit();
                        lpc.setContactUriParameters(null);
                        lpc.done();
                        if (lpc.getIdentityAddress() != null)
                            Log.d("Push notif infos removed from proxy config " + lpc.getIdentityAddress().asStringUriOnly());
                    } else {
                        String contactInfos = "app-id=" + appId + ";pn-type=push_type" + ";pn-tok=" + regId + ";pn-silent=1";
                        String prevContactParams = lpc.getContactParameters();
                        if (prevContactParams == null || prevContactParams.compareTo(contactInfos) != 0) {
                            lpc.edit();
                            lpc.setContactUriParameters(contactInfos);
                            lpc.done();
                            if (lpc.getIdentityAddress() != null)
                                Log.d("Push notif infos added to proxy config " + lpc.getIdentityAddress().asStringUriOnly());
                        }
                    }
                }
                Log.i("[Push Notification] Refreshing registers to ensure token is up to date" + regId);
                lc.refreshRegisters();
            }
        } else {
            if (lc.getProxyConfigList().length > 0) {
                for (ProxyConfig lpc : lc.getProxyConfigList()) {
                    lpc.edit();
                    lpc.setContactUriParameters(null);
                    lpc.done();
                    if (lpc.getIdentityAddress() != null)
                        Log.d("Push notif infos removed from proxy config " + lpc.getIdentityAddress().asStringUriOnly());
                }
                lc.refreshRegisters();
            }
        }
    }

    public String getPushNotificationRegistrationID() {
        return getLc().getConfig().getString("app", "push_notification_regid", null);
    }

    public void changeStatusToOnThePhone() {
        Core lc = getLcIfManagerNotDestroyedOrNull();
        if (lc == null) return;

        if (isInstanciated() && isPresenceModelActivitySet() && lc.getPresenceModel().getActivity().getType() != PresenceActivity.Type.OnThePhone) {
            lc.getPresenceModel().getActivity().setType(PresenceActivity.Type.OnThePhone);
        } else if (isInstanciated() && !isPresenceModelActivitySet()) {
            PresenceModel model = lc.createPresenceModelWithActivity(PresenceActivity.Type.OnThePhone, null);
            lc.setPresenceModel(model);
        }
    }

    public void changeStatusToOffline() {
        Core lc = getLcIfManagerNotDestroyedOrNull();
        if (isInstanciated() && lc != null) {
            PresenceModel model = lc.getPresenceModel();
            model.setBasicStatus(PresenceBasicStatus.Closed);
            lc.setPresenceModel(model);
        }
    }

    public void subscribeFriendList(boolean enabled) {
        Core lc = getLcIfManagerNotDestroyedOrNull();
        if (lc != null && lc.getFriendsLists() != null && lc.getFriendsLists().length > 0) {
            FriendList mFriendList = (lc.getFriendsLists())[0];
            Log.i("Presence list subscription is " + (enabled ? "enabled" : "disabled"));
            mFriendList.enableSubscriptions(enabled);
        }
    }


    public static synchronized final LinphoneManager getInstance(Context applicationContext) {
        if (instance == null) {
            instance = new LinphoneManager(applicationContext);
        }
        return instance;
    }

    public static synchronized final LinphoneManager getInstance() {
        return instance;
    }

    public static synchronized final Core getLc() {
        return getInstance().mLc;
    }


    public void playDtmf(ContentResolver r, char dtmf) {
        try {
            if (Settings.System.getInt(r, Settings.System.DTMF_TONE_WHEN_DIALING) == 0) {
                // audible touch disabled: don't play on speaker, only send in outgoing stream
                return;
            }
        } catch (SettingNotFoundException e) {
        }

        getLc().playDtmf(dtmf, -1);
    }

    public synchronized final void destroyCore() {
        try {
            destroyLinphoneCore();

        } catch (RuntimeException e) {
            Log.e(e);
        } finally {

            mLc = null;
        }
    }


    //public void loadConfig(){
    //	try {
    //		copyIfNotExist(R.raw.configrc, mConfigFile);
    //	} catch (Exception e){
    //		Log.w(e);
    //	}
    //	LinphonePreferences.instance().setRemoteProvisioningUrl("file://" + mConfigFile);
    //	getLc().getConfig().setInt("misc","transient_provisioning",1);
    //}

    private void destroyLinphoneCore() {
        mLc.setNetworkReachable(false);
        mLc = null;
    }



    public static synchronized void destroy() {

        if (instance == null) return;
        instance.changeStatusToOffline();
        instance.destroyCore();
        instance = null;
    }





    public String getRingtone(String defaultRingtone) {
        String ringtone = getLc().getConfig().getString("app", "ringtone", defaultRingtone);
        if (ringtone == null || ringtone.length() == 0)
            ringtone = defaultRingtone;
        return ringtone;
    }


    public static synchronized Core getLcIfManagerNotDestroyedOrNull() {

        return getLc();
    }

    public static final boolean isInstanciated() {
        return instance != null;
    }



    public static boolean onKeyBackGoHome(Activity activity, int keyCode, KeyEvent event) {
        if (!(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)) {
            return false; // continue
        }

        activity.startActivity(new Intent()
                .setAction(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_HOME));
        return true;
    }


    public String getAddressDisplayName() {
        Address address = getLc().getCurrentCallRemoteAddress();
        if (address == null) return null;
        return address.getDisplayName();
    }

    public String getasStringUriOnly() {
        Address address = getLc().getCurrentCallRemoteAddress();
        if (address == null) return null;
        return address.asStringUriOnly();
    }

    public void deleteAccount() {
        if (getLc() == null) return;
        getLc().clearAllAuthInfo();
        getLc().clearProxyConfig();
        getLc().clearCallLogs();

        getLc().refreshRegisters();
    }


    // Accounts settings

    /**
     * 发送按键值
     *
     * @param c
     */
    public void sendDtmf(char c) {
        if (getLc() != null && getLc().getCurrentCall() != null) {
            getLc().getCurrentCall().sendDtmf(c);
        }
    }

    /**
     * 关闭按键声音
     */
    public void stopDtmf() {
        if (getLc() != null) {
            getLc().stopDtmf();
        }
    }

    /**
     * 通话是否静音
     *
     * @param isMicMuted
     */
    public void switchingMute(boolean isMicMuted) {
        if (getLc() != null) {
            getLc().enableMic(isMicMuted);
        } else {
            throw new NullPointerException("核心类core为空");
        }
    }

    /**
     * 挂断电话
     */
    public void hangUp() {
        try {
            if (getLc().isInConference()) {
                getLc().terminateConference();
            } else {
                getLc().terminateAllCalls();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 挂断指定电话
     */
    public void hangUpAppoint() {
        try {
            if (getLc().getCurrentCall() != null) {
                getLc().terminateCall(getLc().getCurrentCall());
            } else {
                if (getLc().isInConference()) {
                    getLc().terminateConference();
                } else {
                    getLc().terminateAllCalls();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 接听电话
     *
     * @return
     */
    public boolean answer(Context context) {
        CallParams params = getLc().createCallParams(getLc().getCurrentCall());

        boolean isLowBandwidthConnection = !isHighBandwidthConnection(context);

        if (params != null) {
            params.enableLowBandwidth(isLowBandwidthConnection);
        } else {
            Log.e("Could not create call params for call");
        }

        if (params == null || !acceptCallWithParams(getLc().getCurrentCall(), params)) {
            // the above method takes care of Samsung Galaxy S
            Toast.makeText(context, "接受呼叫时出错", Toast.LENGTH_SHORT).show();
        } else {

        }
        return true;
    }

    public boolean acceptCallWithParams(Call call, CallParams params) {
        getLc().acceptCallWithParams(call, params);
        return true;
    }

    public static boolean isHighBandwidthConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected() && isConnectionFast(info.getType(), info.getSubtype()));
    }

    /**
     * 拨打电话
     *
     * @param context
     * @param number
     */
    public void call(String number, String displayName, Map<String, String> headMap, Context context) {
        try {
            if (!acceptCallIfIncomingPending(getLc())) {

                newOutgoingCall(getLc(), number, displayName, headMap, context);
            }
        } catch (CoreException e) {
            getLc().terminateCall(getLc().getCurrentCall());
        }

    }

    public static void newOutgoingCall(Core mLc, String to, String displayName, Map<String, String> headMap, Context context) {
//		if (mLc.inCall()) {
//			listenerDispatcher.tryingNewOutgoingCallButAlreadyInCall();
//			return;
//		}
        if (to == null) return;

        // If to is only a username, try to find the contact to get an alias if existing

        Address lAddress;
        lAddress = mLc.interpretUrl(to); // InterpretUrl does normalizePhoneNumber
        if (lAddress == null) {
            Log.e("Couldn't convert to String to Address : " + to);
            return;
        }

        ProxyConfig lpc = mLc.getDefaultProxyConfig();
        if (false && lpc != null && lAddress.asStringUriOnly().equals(lpc.getIdentityAddress())) {
            return;
        }
        if (!TextUtils.isEmpty(displayName)) {
            lAddress.setDisplayName(displayName);
        }

        boolean isLowBandwidthConnection = !isHighBandwidthConnection(context);

        if (mLc.isNetworkReachable()) {
            try {
                CallManager.getInstance().inviteAddress(mLc, lAddress, false, isLowBandwidthConnection);


            } catch (CoreException e) {
                Exception exception = e;
                return;
            }
        } else {
            Log.d("ajsip ", "Network is unreachable");
        }
    }


    public static boolean acceptCallIfIncomingPending(Core mLc) throws CoreException {
        if (mLc.isIncomingInvitePending()) {
            mLc.acceptCall(mLc.getCurrentCall());
            return true;
        }
        return false;
    }

    private static boolean isConnectionFast(int type, int subType) {
        if (type == ConnectivityManager.TYPE_MOBILE) {
            switch (subType) {
                case TelephonyManager.NETWORK_TYPE_EDGE:
                case TelephonyManager.NETWORK_TYPE_GPRS:
                case TelephonyManager.NETWORK_TYPE_IDEN:
                    return false;
            }
        }
        //in doubt, assume connection is good.
        return true;
    }

    public static void signOut() {
        if (instance == null || getLc() == null) return;
        getLc().setDefaultProxyConfig(null);
        getLc().clearAllAuthInfo();
        getLc().clearProxyConfig();

        getLc().refreshRegisters();

        LinphoneManager.destroy();

    }

    public int getCurrentDirection() {
        int time = 0;
        if (getLc() != null && getLc().getCurrentCall() != null) {
            time = getLc().getCurrentCall().getDuration();
        }
        return time;

    }

    public String getUserAgent() {
        if (getLc() == null || getLc().getUserAgent() == null) return null;
        return getLc().getUserAgent();
    }

    public String getDomain(String name) {
        if (getLc() == null || getLc().getAuthInfoList() == null) return null;
        String tempDomain = "";
        for (AuthInfo authInfo : getLc().getAuthInfoList()) {
            if (TextUtils.equals(authInfo.getUsername(), name)) {
                tempDomain = authInfo.getDomain();
                break;
            }
        }
        return tempDomain;
    }

    public String getCallDomain() {
        if (getLc() == null || getLc().getCurrentCallRemoteAddress() == null) return null;
        return getLc().getCurrentCallRemoteAddress().getDomain();
    }

    public String getCallUserName() {
        Address address = getLc().getCurrentCallRemoteAddress();
        if (address == null) return null;
        return address.getUsername();
    }

    public String getCallId() {
        return getLc().getCurrentCall().getCallLog().getCallId();
    }




    public void refuseToAccept() {
        if (getLc() != null && getLc().getCurrentCall() != null) {
            getLc().declineCall(getLc().getCurrentCall(), Reason.Busy);
        }
    }

    /**
     * core可能会因为app在后台时间比较长被销毁
     * @return
     */
    public boolean isCoreNotNull() {
        return getLc()!=null;
    }

    public int getCallsNb(){
        return getLc()==null?0:getLc().getCallsNb();
    }

    public static Boolean isProximitySensorNearby(final SensorEvent event) {
        float threshold = 4.001f; // <= 4 cm is near

        final float distanceInCm = event.values[0];
        final float maxDistance = event.sensor.getMaximumRange();
        Log.d("Proximity sensor report [" + distanceInCm + "] , for max range [" + maxDistance + "]");

        if (maxDistance <= threshold) {
            // Case binary 0/1 and short sensors
            threshold = maxDistance;
        }
        return distanceInCm < threshold;
    }

    public void refreshRegisters(){
        if (getLc()!=null){
            getLc().refreshRegisters();
        }
    }
    public int getUserSize(){
        int size=0;
        if (getLc()!=null){
            size=getLc().getAuthInfoList()!=null?getLc().getAuthInfoList().length:0;
        }
        return size;
    }

    public void adjustVolume(int i,AudioManager mAudioManager) {
        if (Build.VERSION.SDK_INT < 15) {
            int oldVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL);
            int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL);

            int nextVolume = oldVolume + i;
            if (nextVolume > maxVolume) nextVolume = maxVolume;
            if (nextVolume < 0) nextVolume = 0;

            mLc.setPlaybackGainDb((nextVolume - maxVolume) * dbStep);
        } else
            // starting from ICS, volume must be adjusted by the application, at least for STREAM_VOICE_CALL volume stream
            mAudioManager.adjustStreamVolume(AudioManager.STREAM_VOICE_CALL, i < 0 ? AudioManager.ADJUST_LOWER : AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
    }

    public static void initLoggingService(boolean isUseJavaLogger, boolean isDebugEnabled, String appName) {
        if (!isUseJavaLogger) {
            Factory.instance().enableLogCollection(LogCollectionState.Enabled);
            Factory.instance().setDebugMode(isDebugEnabled, appName);
        } else {
            Factory.instance().setDebugMode(isDebugEnabled, appName);
            Factory.instance().enableLogCollection(LogCollectionState.EnabledWithoutPreviousLogHandler);
            Factory.instance().getLoggingService().setListener(new LoggingServiceListener() {
                public void onLogMessageWritten(LoggingService logService, String domain, LogLevel lev, String message) {
                    switch (lev) {
                        case Debug:
                            android.util.Log.d(domain, message);
                            break;
                        case Message:
                            android.util.Log.i(domain, message);
                            break;
                        case Warning:
                            android.util.Log.w(domain, message);
                            break;
                        case Error:
                            android.util.Log.e(domain, message);
                            break;
                        case Fatal:
                        default:
                            android.util.Log.wtf(domain, message);
                    }

                }
            });
        }
    }
}
