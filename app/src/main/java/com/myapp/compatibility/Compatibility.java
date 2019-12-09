package com.myapp.compatibility;
/*
Compatibility.java
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

import android.app.AlarmManager;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

import org.linphone.mediastream.Version;

public class Compatibility {


    public static void scheduleAlarm(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
        if (Version.sdkAboveOrEqual(Version.API19_KITKAT_44)) {
            ApiNineteenPlus.scheduleAlarm(alarmManager, type, triggerAtMillis, operation);
        } else {
            ApiElevenPlus.scheduleAlarm(alarmManager, type, triggerAtMillis, operation);
        }
    }

}
