package com.myapp.receiver;

/*
KeepAliveReceiver.java
Copyright (C) 2017  Belledonne Communications, Grenoble, France

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

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.myapp.utils.LogUtils;

/*
 * Purpose of this receiver is to disable keep alives when screen is off
 * */
public class KeepAliveReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        LogUtils.d("===---=="+intent.getAction()+"---"+Thread.currentThread());
        String action = intent.getAction();
        if (action == null) {
            LogUtils.d("[KeepAlive] Refresh registers");
//            lc.refreshRegisters();
            //make sure iterate will have enough time, device will not sleep until exit from this method
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                LogUtils.e( e);
            } finally {
                //make sure the application will at least wakes up every 10 mn
            }
        } else if (action.equalsIgnoreCase(Intent.ACTION_SCREEN_ON)) {
            LogUtils.d("[KeepAlive] Screen is on, enable");
//            lc.enableKeepAlive(true);
        } else if (action.equalsIgnoreCase(Intent.ACTION_SCREEN_OFF)) {
            LogUtils.d("[KeepAlive] Screen is off, disable");
//            lc.enableKeepAlive(false);
        }
    }
}
