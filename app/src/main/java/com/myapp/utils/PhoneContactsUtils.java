package com.myapp.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;


import androidx.lifecycle.MutableLiveData;

import com.myapp.App;
import com.myapp.callback.IRequestPermission;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.ContactItemBean;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PhoneContactsUtils {
    static ArrayList<String> nameList=new ArrayList<>();
    static int numx=1;
    // 号码
    public final static String NUM = ContactsContract.Data.DATA1;
    public final static String NUMBER_TYPE = ContactsContract.Data.DATA2;
    public final static String customNUMBER_TYPE = ContactsContract.Data.DATA3;
    // 联系人姓名
    public final static String NAME = ContactsContract.Data.DISPLAY_NAME_PRIMARY;
    public final static String contactID = ContactsContract.Data.CONTACT_ID;

    //联系人提供者的uri
    private static Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

    @SuppressLint("CheckResult")
    public static void getPhone(Activity activity) {
        PermissionUtil.reqPermission(activity,new IRequestPermission() {
            @Override
            public void accept() {
                getPhone("");
            }
        }, Manifest.permission.READ_CONTACTS);

    }

    //获取所有联系人
    @SuppressLint("CheckResult")
    public static void getPhone(String key) {
        Observable.create(new ObservableOnSubscribe<List<ContactItemBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ContactItemBean>> emitter) throws Exception {
                long startTime= System.currentTimeMillis();
                Map<Integer,ContactItemBean> viewMap = new HashMap<>();
                ArrayList<ContactItemBean> dbList=new ArrayList<>();
                ContentResolver cr = App.context.getContentResolver();
                Cursor cursor;
                if (TextUtils.isEmpty(key)){
                    cursor = cr.query(phoneUri, null, null, null, null);
                }else {
                    cursor = cr.query(phoneUri, null, "phonebook_label like ? or "+ContactsContract.Contacts.DISPLAY_NAME+
                            " like ?", new String[]{"%"+key+"%","%"+key+"%"}, null);
                }
                nameList.clear();
                while (cursor!=null&&cursor.moveToNext()) {
                    String hasPhone = cursor
                            .getString(cursor
                                    .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                    String mContactID = cursor.getString(cursor
                            .getColumnIndex(contactID));
                    String sort_key_str=cursor
                            .getString(cursor
                                    .getColumnIndex("sort_key"));

                    if (hasPhone.equalsIgnoreCase("1")) {
                        hasPhone = "true";
                    } else {
                        hasPhone = "false";
                    }
//
                    StringBuffer sb=new StringBuffer("打印数据库数据");
                    Map<String,String> tempMap=new HashMap<>();


                    for (int i=0;i<cursor.getColumnNames().length;i++){
                        sb.append(cursor.getColumnName(i)).append("==").append(cursor.getString(i)).append(";");
                        tempMap.put(cursor.getColumnName(i),cursor.getString(i));

                    }
                    sb.append("\n");
//                    LogUtils.d(sb.toString());






                    if (Boolean.parseBoolean(hasPhone)) {
                        String name = cursor
                                .getString(cursor
                                        .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));


                        String label=cursor.getString(cursor.getColumnIndex("phonebook_label"));
                        String number=cursor.getString(cursor.getColumnIndex(NUM));

                        nameList.add(getPinYin(name).toLowerCase());

                        //界面显示数据
                        ContactItemBean itemBean=viewMap.get(cursor.getInt(cursor.getColumnIndex(contactID)));
                        if (itemBean!=null){
                        }else {
                            itemBean = new ContactItemBean();
                            itemBean.setContact_id(mContactID);
                            itemBean.setContact_name(name);
                            itemBean.setInitials(label);
                            itemBean.setPhone_number(number);

                            viewMap.put(cursor.getInt(cursor.getColumnIndex(contactID)),itemBean);
                        }

                        //保存到本地数据库
                        ContactItemBean dbItemBean=new ContactItemBean();
                        dbItemBean.setContact_id(mContactID);
                        dbItemBean.setGroup_id(itemBean.getGroup_id());
                        dbItemBean.setContact_name(name);
                        dbItemBean.setInitials(label);
                        dbItemBean.setPhone_number(number.replace("-","").replace(" ",""));
                        dbList.add(dbItemBean);

                    }
                }
                if (cursor!=null) cursor.close();

                Collections.sort(nameList, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareToIgnoreCase(o2);
                    }
                });
                for (String s : nameList) {
                    LogUtils.d("打印排序的名称"+s);
                }

                ArrayList<ContactItemBean> viewList = new ArrayList<>(viewMap.values());
                Collections.sort(viewList, new Comparator<ContactItemBean>() {
                    @Override
                    public int compare(ContactItemBean o1, ContactItemBean o2) {
                        return o1.getPinYinAll().compareToIgnoreCase(o2.getPinYinAll());
                    }

                    @Override
                    public boolean equals(Object obj) {
                        return false;
                    }
                });
                long endTime= System.currentTimeMillis();

//                for (ContactItemBean itemBean : viewList) {
//                    LogUtils.d("打印联系人详细"+numx+"===="+itemBean.toString());
//                }
                LogUtils.d("打印时差"+(endTime-startTime));
                numx++;
                emitter.onNext(dbList);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<ContactItemBean>>() {
            @Override
            public void accept(List<ContactItemBean> sysContactBeans) throws Exception {
            }
        });
    }



    public static String getPinYin(String paramString) {
        char[] arrayOfChar = paramString.toCharArray();
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        String str = "";
        int i = arrayOfChar.length;
        for (byte b = 0;; b++) {
            if (b >= i)
                return str;
            try {
                if (Character.toString(arrayOfChar[b]).matches("[\\u4E00-\\u9FA5]+")) {
                    String[] arrayOfString = PinyinHelper.toHanyuPinyinStringArray(arrayOfChar[b], hanyuPinyinOutputFormat);
                    str = String.valueOf(str) + arrayOfString[0];
                } else {
                    str = String.valueOf(str) + Character.toString(arrayOfChar[b]);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                return null;
            } catch (NullPointerException e1) {
                return null;
            }
        }
    }
}
