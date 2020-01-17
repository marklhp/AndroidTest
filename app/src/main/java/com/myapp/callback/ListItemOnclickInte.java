package com.myapp.callback;

/**
 * Created by lihaipeng on 2018/5/14.
 */

public interface ListItemOnclickInte<T> {
    void onItemclick(int viewId, int position, T t);
}
