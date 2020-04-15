package com.myapp.shejimoshi.guanchazhemoshi;

import java.util.Observable;
import java.util.Observer;

public class WangSi implements Observer {
    //首先李斯是个观察者，一旦韩非子有活动，他就知道，他就要向老板汇报
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("王斯:观察到韩非子活动，自己也开始活动了...");
        this.cry(arg.toString());
        System.out.println("王斯:真真的哭死了...\n");
    }



    //汇报给秦始皇
    private void cry(String context) {
        System.out.println("王斯:因为"+context+"，——所以我悲伤呀!");
    }
}
