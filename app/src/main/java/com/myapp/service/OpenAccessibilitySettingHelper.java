package com.myapp.service;

import android.content.Context;
import android.content.Intent;

import com.myapp.activity.AccessibilityOpenHelperActivity;
import com.myapp.activity.AccessibilityServiceActivity;

public class OpenAccessibilitySettingHelper {
    private static final String ACTION = "action";
    private static final String ACTION_START_ACCESSIBILITY_SETTING = "action_start_accessibility_setting";

    public static void jumpToSettingPage(Context context) {
        try {
            Intent intent = new Intent(context,  AccessibilityOpenHelperActivity.class);
            intent.putExtra(ACTION, ACTION_START_ACCESSIBILITY_SETTING);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception ignore) {}
    }
}