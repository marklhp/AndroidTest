package bean;

import android.text.TextUtils;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


import java.util.ArrayList;


public class ContactItemBean {

    /**
     * id : eedbd69f-ed16-48a8-9b46-7c4037789cf9
     * name : Aa
     * ab : A
     * number : 2027945769
     * cc : 1
     * isfamily : false
     * imgtype : 1
     * tags : ["98b62050-da47-466a-9b4f-4ec2fce754fa","5501E6D2-31F1-49B3-8E4C-43A308FF9228","10dd3006-b65d-4f45-baf7-82bca4c4f150"]
     */
    @PrimaryKey(autoGenerate = true)
    private int autoAddInt;
    private String contact_id;
    private String phone_number;
    private String group_id;
    private String contact_name;
    private String m_id;
    private String contact_json;
    @Ignore
    private MultiAddContactJson contact_bean;
    private String country_code;
    private String initials;
    private ArrayList<String> tags;
    private String time;
    private String bcolor;
    private String ecolor;
    private ArrayList<String> tagNames;
    private boolean iscontact;
    @Ignore
    private boolean isDelete;
    @Ignore
    private String pinYinAll;


    public String getContact_json() {
        return contact_json;
    }

    public void setContact_json(String contact_json) {
        this.contact_json = contact_json;
    }

    public MultiAddContactJson getContact_bean() {
        return contact_bean;
    }

    public void setContact_bean(MultiAddContactJson contact_bean) {
        this.contact_bean = contact_bean;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getBcolor() {
        return bcolor;
    }

    public void setBcolor(String bcolor) {
        this.bcolor = bcolor;
    }

    public String getEcolor() {
        return ecolor;
    }

    public void setEcolor(String ecolor) {
        this.ecolor = ecolor;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public ArrayList<String> getTagNames() {
        return tagNames;
    }

    public void setTagNames(ArrayList<String> tagNames) {
        this.tagNames = tagNames;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public boolean isIscontact() {
        return iscontact;
    }

    public void setIscontact(boolean iscontact) {
        this.iscontact = iscontact;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }


    public int getAutoAddInt() {
        return autoAddInt;
    }

    public void setAutoAddInt(int autoAddInt) {
        this.autoAddInt = autoAddInt;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getPinYinAll() {
        if (TextUtils.isEmpty(pinYinAll)){
            return "";
        }else {
            return pinYinAll;
        }
    }

    public void setPinYinAll(String pinYinAll) {
        this.pinYinAll = pinYinAll;
    }


    @Override
    public String toString() {
        return "ContactItemBean{" +
                "autoAddInt=" + autoAddInt +
                ", contact_id='" + contact_id + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", group_id='" + group_id + '\'' +
                ", contact_name='" + contact_name + '\'' +
                ", m_id='" + m_id + '\'' +
                ", contact_json='" + contact_json + '\'' +
                ", contact_bean=" + contact_bean +
                ", country_code='" + country_code + '\'' +
                ", initials='" + initials + '\'' +
                ", tags=" + tags +
                ", time='" + time + '\'' +
                ", bcolor='" + bcolor + '\'' +
                ", ecolor='" + ecolor + '\'' +
                ", tagNames=" + tagNames +
                ", iscontact=" + iscontact +
                ", isDelete=" + isDelete +
                ", pinYinAll='" + pinYinAll + '\'' +
                '}';
    }
}
