package com.myapp.linphone;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.myapp.App;
import com.myapp.linphone.call.CallManager;

import org.linphone.core.Address;
import org.linphone.core.Call;
import org.linphone.core.CallParams;
import org.linphone.core.Core;
import org.linphone.core.CoreException;
import org.linphone.core.CoreListenerStub;
import org.linphone.core.Factory;
import org.linphone.core.GlobalState;
import org.linphone.core.ProxyConfig;
import org.linphone.core.TransportType;
import org.linphone.core.Transports;
import org.linphone.mediastream.Log;

import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.functions.Consumer;

public class SipUtils {

    private static Core core;
    private static Timer mTimer;
    private static TimerTask lTask;
    private static Handler handler=new Handler();

    public static void init(CoreListenerStub coreListenerStub){
        core = Factory.instance().createCore(App.application.getFilesDir().getAbsolutePath()+"/.linphonerc", App.application.getFilesDir().getAbsolutePath()+ "/assistant_create.rc",App.application);
        core.setUserAgent("iTalkFamilyCloud_android_","1.0"+";"+"con:"+"wi"+",biz:fc,bid:"+10);
        core.addListener(coreListenerStub);
        setSipPore();
        core.enableIpv6(false);
        core.clearProxyConfig();
        core.clearAllAuthInfo();
        core.clearCallLogs();
        core.start();
        lTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (core==null){
                            if (mTimer!=null){
                                mTimer.cancel();
                            }
                        }else {
                            core.iterate();
                        }
                    }
                });
            }
        };
        /*use schedule instead of scheduleAtFixedRate to avoid iterate from being call in burst after cpu wake up*/
        mTimer = new Timer("Linphone scheduler");
        mTimer.schedule(lTask, 0, 100);
    }
    //port值可以自己指定，-1代表随机
    public static void setSipPore() {
        Transports transportPorts = core.getTransports();//端口
        transportPorts.setUdpPort(-1);
        transportPorts.setTcpPort(-1);
        transportPorts.setTlsPort(-1);
        core.setTransports(transportPorts);

    }
    /**
     * 进行sip信息注册
     * tip 注册是否成功 调用 CoreListenerStub 回调判断
     * SipUtils.registerSip(sipinfo.getUsername(), "", sipinfo.getPassword(), sipinfo.getDisplaynumber(), null,null, sipinfo.getSipurl(), TransportType.Udp);
     * SipUtils.registerSip("69801006278", "", "101204375147#", "15235661546", null,null, "ose7.italkbb.com:10000", TransportType.Udp);
     */
    public static boolean registerSip() {
//        String username = "69802008619";
//        String password = "101944957262#";
//        String displayname = "17778115596";
//        String domain = "ose7.italkbb.com:10000";
        String username="69801018931";
        String password="102011203496#";
        String displayname="3473291022";
        String domain="cxc32.italkbb.com:10000";
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
    public static void call(){
        try {
            if (!acceptCallIfIncomingPending(core)){
                newOutgoingCall(core,"01116314400762",null);
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
    public static  boolean answer(boolean alreadyAcceptedOrDeniedCall, Call mCall, Consumer startFcCallActivity) {
        if (alreadyAcceptedOrDeniedCall) {
            return true;
        }

        return true;
    }

    public static void accept( Context context) {
        CallParams params = core.createCallParams(core.getCurrentCall());
        boolean isLowBandwidthConnection = !isHighBandwidthConnection(context);

        if (params != null) {
            params.enableLowBandwidth(isLowBandwidthConnection);
            core.acceptCallWithParams(core.getCurrentCall(), params);
        } else {
            Log.e("Could not create call params for call");
        }

    }

    public static void singout() {
        core.clearCallLogs();
        core.clearProxyConfig();
        core.clearAllAuthInfo();
    }

    public static void setAccountEnabled(int n, boolean enabled) {
        if (getLc() == null) return;
        ProxyConfig prxCfg = getProxyConfig(n);
        if (prxCfg == null) {
//            LinphoneUtils.displayErrorAlert(getString(R.string.error), mContext);
            return;
        }
        prxCfg.edit();
        prxCfg.enableRegister(enabled);
        prxCfg.done();

        // If default proxy config is disabled, try to set another one as default proxy
        if (!enabled && getLc().getDefaultProxyConfig().getIdentityAddress().equals(prxCfg.getIdentityAddress())) {
            int count = getLc().getProxyConfigList().length;
            if (count > 1) {
                for (int i = 0; i < count; i++) {
                    if (isAccountEnabled(i)) {
                        getLc().setDefaultProxyConfig(getProxyConfig(i));
                        break;
                    }
                }
            }
        }
    }
    private static Core getLc(){
        return core;
    }

    private static ProxyConfig getProxyConfig(int n) {
        if (getLc() == null) return null;
        ProxyConfig[] prxCfgs = getLc().getProxyConfigList();
        if (n < 0 || n >= prxCfgs.length)
            return null;
        return prxCfgs[n];
    }
    public static boolean isAccountEnabled(int n) {
        return getProxyConfig(n).registerEnabled();
    }
    public static int getAuths(){
        return getLc().getAuthInfoList().length;
    }

    public static void removeAcount() {
        getLc().clearAllAuthInfo();
        getLc().clearProxyConfig();
//        getLc().refreshRegisters();
    }
}
