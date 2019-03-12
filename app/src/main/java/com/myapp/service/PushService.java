package com.myapp.service;

import android.app.Service;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.myapp.App;
import com.myapp.utils.ClipboardUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class PushService extends FirebaseMessagingService {
    String TAG="pushservice.class";
    public PushService() {
    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Toast.makeText(App.context,remoteMessage.getFrom(),Toast.LENGTH_LONG).show();
        Toast.makeText(App.context,remoteMessage.getData().toString(),Toast.LENGTH_LONG).show();
        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
//                scheduleJob();
            } else {
                // Handle message within 10 seconds
//                handleNow();
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

//    /**
//     * Called if InstanceID token is updated. This may occur if the security of
//     * the previous token had been compromised. Note that this is called when the InstanceID token
//     * is initially generated so this is where you would retrieve the token.
//     */
//    @Override
//    public void onNewToken(String token) {
//        Log.d(TAG, "Refreshed token: " + token);
//
//        // If you want to send messages to this application instance or
//        // manage this apps subscriptions on the server side, send the
//        // Instance ID token to your app server.
//        sendRegistrationToServer(token);
//    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        sendRegistrationToServer(s);
    }

    private void sendRegistrationToServer(final String s) {
        Log.d(TAG, "打印令牌"+s);
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                ClipboardUtils.onClickCopy(s);
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
    }

}
