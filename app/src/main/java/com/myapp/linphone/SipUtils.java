package com.myapp.linphone;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.telephony.TelephonyManager;

import com.myapp.App;
import com.myapp.linphone.call.CallManager;

import org.linphone.core.Address;
import org.linphone.core.Core;
import org.linphone.core.CoreException;
import org.linphone.core.Factory;
import org.linphone.core.GlobalState;
import org.linphone.core.ProxyConfig;
import org.linphone.core.TransportType;
import org.linphone.mediastream.Log;

public class SipUtils {



    /**
     * 进行sip信息注册
     * tip 注册是否成功 调用 CoreListenerStub 回调判断
     * SipUtils.registerSip(sipinfo.getUsername(), "", sipinfo.getPassword(), sipinfo.getDisplaynumber(), null,null, sipinfo.getSipurl(), TransportType.Udp);
     * SipUtils.registerSip("69801006278", "", "101204375147#", "15235661546", null,null, "ose7.italkbb.com:10000", TransportType.Udp);
     */
    public static boolean registerSip(Core core) {
//        String username = "69802008619";
//        String password = "101944957262#";
//        String displayname = "17778115596";
//        String domain = "ose7.italkbb.com:10000";
        String username="69801006278";
        String password="101204375147#";
        String displayname="15235661546";
        String domain="ose7.italkbb.com:10000";
        String userid="";
        String ha1=null;
        String prefix=null;
        TransportType transport= TransportType.Udp;

        username = getDisplayableUsernameFromAddress(core,username);
        domain = getDisplayableUsernameFromAddress(core,domain);

        String identity = "sip:" + username + "@" + domain;
        Address address = Factory.instance().createAddress(identity);
        AccountBuilder builder = new AccountBuilder(core)
                .setUsername(username)
                .setDomain(domain)
                .setHa1(ha1)
                .setUserid(userid)
                .setDisplayName(displayname)
                .setPassword(password);
        if (transport != null) {
            builder.setTransport(transport);
        }

        try {
            builder.saveNewAccount();
            return true;
        } catch (CoreException e) {
            e.printStackTrace();
            return false;
        }
    }




    public static String getDisplayableUsernameFromAddress(Core lc,String sipAddress) {
        String username = sipAddress;
        if (lc == null) return username;

        if (username.startsWith("sip:")) {
            username = username.substring(4);
        }

        if (username.contains("@")) {
            String domain = username.split("@")[1];
            ProxyConfig lpc = lc.getDefaultProxyConfig();
            if (lpc != null) {
                if (domain.equals(lpc.getDomain())) {
                    return username.split("@")[0];
                }
            } else {
                if (false) {
                    return username.split("@")[0];
                }
            }
        }
        return username;
    }
    /**
     * 拨打电话
     * @param
     */
    public static void call(Core core){
        try {
            if (!acceptCallIfIncomingPending(core)){
                newOutgoingCall(core,"69802008619",null);
            }
        } catch (CoreException e) {
            core.terminateCall(core.getCurrentCall());
        }
    }
    public static void newOutgoingCall(Core mLc, String to, String displayName) {
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
        lAddress.setDisplayName(displayName);

        boolean isLowBandwidthConnection = !isHighBandwidthConnection(App.context);

        if (mLc.isNetworkReachable()) {
            try {
                CallManager.getInstance().inviteAddress(mLc,lAddress, false, isLowBandwidthConnection);


            } catch (CoreException e) {
                return;
            }
        }else {
            Log.d("linphone " , "Network is unreachable");
        }
    }
    public static boolean isHighBandwidthConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected() && isConnectionFast(info.getType(), info.getSubtype()));
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

//    /**
//     * 接听电话
//     * @param alreadyAcceptedOrDeniedCall
//     * @param mCall
//     * @param startFcCallActivity
//     * @return
//     */
//    public static  boolean answer(boolean alreadyAcceptedOrDeniedCall, Call mCall, Consumer startFcCallActivity) {
//        if (alreadyAcceptedOrDeniedCall) {
//            return true;
//        }
//        CallParams params = LinphoneManager.getLc().createCallParams(mCall);
//
//        boolean isLowBandwidthConnection = !LinphoneUtils.isHighBandwidthConnection(LinphoneService.instance().getApplicationContext());
//
//        if (params != null) {
//            params.enableLowBandwidth(isLowBandwidthConnection);
//        } else {
//            Log.e("Could not create call params for call");
//        }
//
//        if (params == null || !LinphoneManager.getInstance().acceptCallWithParams(mCall, params)) {
//            // the above method takes care of Samsung Galaxy S
//            ToastUtil.showToastShort( R.string.couldnt_accept_call);
//        } else {
//            LinphoneManager.getInstance().routeAudioToReceiver();
//            try {
//                startFcCallActivity.accept("");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return true;
//    }

}
