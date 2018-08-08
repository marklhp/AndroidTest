package com.myapp.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

/**
 * json 简单操作的工具类
 *
 */
public class JSONUtils {

    private static Gson mGson = null;

    static {
        if (mGson == null) {
            synchronized (JSONUtils.class) {
                if (mGson == null) {
                    mGson = new Gson();
                }
            }
        }
    }

    private JSONUtils() {
    }

    /**
     * 将对象转换成json格式
     *
     * @param ts
     * @return
     */
    public static String objectToJson(Object ts) {
        String jsonStr = null;
        if (mGson != null) {
            jsonStr = mGson.toJson(ts);
        }
        return jsonStr;
    }

    /**
     * 将json转换成bean对象
     *
     * @param jsonStr
     * @return
     */
    public static <T> T jsonToBean(String jsonStr, Class<T> clazz) {
        if (mGson == null) return null;

        try {
            return mGson.fromJson(jsonStr, clazz);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Gson getGsonInstance() {
        return mGson;
    }

    /**
     * 将json转换成bean对象
     *
     * @return
     */
    public static <T> T objectToBean(Object data, Class<T> cl) {
        if (data == null) {
            return null;
        }
        return jsonToBean(objectToJson(data), cl);
    }

    public static <T> ArrayList<T> object2List(Object data, Class<T> clazz) {
        if (data == null) {
            return null;
        }

        ArrayList<T> result = new ArrayList<>();

        List datas = (List) data;
        for (int i = 0; i < datas.size(); i++) {
            String json = JSONUtils.objectToJson(datas.get(i));
            result.add(JSONUtils.jsonToBean(json, clazz));
        }

        return result;
    }

}
