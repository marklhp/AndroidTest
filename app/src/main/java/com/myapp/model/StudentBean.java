package com.myapp.model;


import com.myapp.BR;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;

public class StudentBean extends BaseObservable implements Observable {
    String sname;
    String sage;
    String sex;
    String color;
    String sn;
    @Bindable
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
        notifyPropertyChanged(BR.sname);
    }
    @Bindable
    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
        notifyPropertyChanged(BR.sage);
    }
    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }
    @Bindable
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        notifyPropertyChanged(BR.color);
    }
    @Bindable
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
        notifyPropertyChanged(BR.sn);
    }

    @Override
    public void addOnPropertyChangedCallback(@NonNull OnPropertyChangedCallback callback) {
        super.addOnPropertyChangedCallback(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(@NonNull OnPropertyChangedCallback callback) {
        super.removeOnPropertyChangedCallback(callback);
    }

    @Override
    public void notifyPropertyChanged(int fieldId) {
        super.notifyPropertyChanged(fieldId);
    }
}
