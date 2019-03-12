package com.myapp.utils;

import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

import com.myapp.App;

public class ClipboardUtils {
    public static void onClickCopy(String s) {
        // 从API11开始android推荐使用android.content.ClipboardManager
        // 为了兼容低版本我们这里使用旧版的android.text.ClipboardManager，虽然提示deprecated，但不影响使用。
        ClipboardManager cm = (ClipboardManager) App.application.getSystemService(Context.CLIPBOARD_SERVICE);
        // 将文本内容放到系统剪贴板里。
        cm.setText(s);
        Toast.makeText(App.context, "复制成功，可以发给朋友们了。", Toast.LENGTH_LONG).show();
    }
}
