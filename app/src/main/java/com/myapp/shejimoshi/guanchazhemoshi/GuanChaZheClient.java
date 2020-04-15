package com.myapp.shejimoshi.guanchazhemoshi;

public class GuanChaZheClient {
    public static void main(String[] args){
        LiSi liSi=new LiSi();
        WangSi wangSi=new WangSi();

        HanFeiZi hanFeiZi=new HanFeiZi();
        hanFeiZi.addObserver(liSi);
        hanFeiZi.addObserver(wangSi);

        hanFeiZi.haveBreakfast();
    }
}
