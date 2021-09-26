package com.myapp.apt;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Process;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class IastingHolder {

    public static final String TAG = "CasSettingsProvider";

    public IastingHolder() {
    }


    public static final class Settings implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.nrivi.baidu.mapsset/settingsData");
        private static Application mApplication = null;

        static {
            getContext();
        }

        private Settings() {
        }

        public static String getSetting(String key) {
            if (TextUtils.isEmpty(key)) {
                return null;
            } else {
                ContentResolver resolver = mApplication.getContentResolver();
                String[] projection = new String[]{"_value"};
                String where = "_key = ?";
                String[] args = new String[]{key};
                String value = null;
                Cursor cursor = resolver.query(CONTENT_URI, projection, where, args, "_key ASC");
                if (cursor != null) {
                    int index = cursor.getColumnIndex("_value");
                    if (cursor.getCount() > 0 && cursor.moveToNext()) {
                        value = cursor.getString(index);
                    }

                    cursor.close();
                }

                return value;
            }
        }


        public static Uri addString(String key, String value) {
            return addSetting(key, value);
        }

        public static String getString(String key, String value) {
            String tempString=getSetting(key);
            if (TextUtils.isEmpty(tempString)){
                return value;
            }else {
                return tempString;
            }
        }

        public static Uri addDouble(String key, double value) {
            return addSetting(key, String.valueOf(value));
        }

        public static Uri addBoolean(String key, boolean value) {
            return addSetting(key, String.valueOf(value));
        }

        public static Uri addInt(String key, int value) {
            return addSetting(key, String.valueOf(value));
        }

        public static double getDouble(String key, double defVal) {
            String value = getSetting(key);
            if (value == null) {
                return defVal;
            } else {
                try {
                    return Double.valueOf(value);
                } catch (NumberFormatException var5) {
                    return defVal;
                }
            }
        }

        public static boolean getBoolean(String key, boolean defVal) {
            String value = getSetting(key);
            return value == null ? defVal : Boolean.valueOf(value);
        }

        public static int getInt(String key, int defVal) {
            String value = getSetting(key);
            if (value == null) {
                return defVal;
            } else {
                try {
                    return Integer.valueOf(value);
                } catch (NumberFormatException var5) {
                    return defVal;
                }
            }
        }

        public static Uri addSetting(String key, String value) {
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                checkWritePermission(key);

                ContentValues values = new ContentValues(2);
                values.put("_key", key);
                values.put("_value", value);
                ContentResolver resolver = mApplication.getContentResolver();


                String[] projection = new String[]{"_value"};
                String where = "_key = ?";
                String[] args = new String[]{key};
                Cursor cursor = resolver.query(CONTENT_URI, projection, where, args, "_key ASC");
                if (cursor != null && cursor.moveToNext()) {
                    return Uri.parse(String.valueOf(resolver.update(CONTENT_URI, values, where, args)));
                } else {
                    return resolver.insert(CONTENT_URI, values);
                }
            } else {
                return null;
            }
        }

        public static Uri addSetting(String key, boolean value) {
            return addSetting(key, String.valueOf(value));
        }

        public static Uri addSetting(String key, int value) {
            return addSetting(key, String.valueOf(value));
        }

        public static int updateSetting(String key, String value) {
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                checkWritePermission(key);
                ContentValues values = new ContentValues(2);
                values.put("_key", key);
                values.put("_value", value);
                String where = "_key = ?";
                String[] args = new String[]{key};
                ContentResolver resolver = mApplication.getContentResolver();
                return resolver.update(CONTENT_URI, values, where, args);
            } else {
                return -1;
            }
        }

        public static int updateSetting(String key, boolean value) {
            return updateSetting(key, String.valueOf(value));
        }

        public static int updateSetting(String key, int value) {
            return updateSetting(key, String.valueOf(value));
        }

        public static Uri updateOnConflict(String key, String value) {
            String previous = getSetting(key);
            if (TextUtils.isEmpty(previous)) {
                return addSetting(key, value);
            } else {
                int id = updateSetting(key, value);
                return id >= 0 ? CONTENT_URI.buildUpon().appendPath(Integer.toString(id)).build() : null;
            }
        }

        public static Uri updateOnConflict(String key, boolean value) {
            return updateOnConflict(key, String.valueOf(value));
        }

        public static Uri updateOnConflict(String key, int value) {
            return updateOnConflict(key, String.valueOf(value));
        }

        public static int deleteSetting(String key) {
            if (key == null) {
                return 0;
            } else {
                checkWritePermission(key);
                String where = "_key = ? ";
                String[] args = new String[]{key};
                ContentResolver resolver = mApplication.getContentResolver();
                return resolver.delete(CONTENT_URI, where, args);
            }
        }

        private static void checkWritePermission(String key) {
            boolean isRestricted = false;
            boolean isSystemEnforced = false;
            if (key.startsWith("cluster")) {
                isRestricted = true;
                isSystemEnforced = true;
            }

            if (isRestricted && isSystemEnforced && Process.myUid() % 100000 != 1000) {
                throw new SecurityException("option is only allowed to system app");
            }
        }


        private static void getContext() {
            if (mApplication != null) {
                return;
            }
            try {
                Class<?> aClass = Class.forName("android.app.ActivityThread");
                Constructor constructor = aClass.getDeclaredConstructor();
                Object o = constructor.newInstance();

                Field sCurrentActivityThread = aClass.getDeclaredField("sCurrentActivityThread");

                sCurrentActivityThread.setAccessible(true);
                Object o1 = sCurrentActivityThread.get(o);
                Field applicationField = aClass.getDeclaredField("mInitialApplication");
                applicationField.setAccessible(true);

                mApplication = (Application) applicationField.get(o1);


            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("打印对象applion", mApplication + "");

        }
    }
}
