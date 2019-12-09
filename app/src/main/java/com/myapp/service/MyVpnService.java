package com.myapp.service;

import android.app.Service;
import android.content.Intent;
import android.net.VpnService;
import android.os.IBinder;

public class MyVpnService extends VpnService {
    public MyVpnService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
