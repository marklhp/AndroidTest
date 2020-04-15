package com.myapp;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestB {
    static long time;

    public static void main(String[] args){
        time = System.currentTimeMillis();
        HashMap<Integer,Integer> map=new HashMap<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Boolean> list=new ArrayList<>();
                int truenumMax=0;
                int truenum=0;
                int falsenumMax=0;
                int falsenum=0;
                for (int i=0;i<10000000;i++){
                    int random = (int) ((Math.random()*10)%2);
                    boolean flag= random != 0;
                    System.out.println("===="+flag);

                    list.add(flag);

                }
                for (int i = 0; i < list.size(); i++) {
                    if (i<list.size()-1){
                        if (list.get(i)&&list.get(i+1)){
                            truenum++;
                        }else {
                            if (truenumMax<truenum){
                                truenumMax=truenum;
                            }
                            Integer integer = map.get(truenum);
                            if (integer==null){
                                map.put(truenum,1);
                            }else {
                                map.put(truenum,integer+1);
                            }

                            truenum=0;
                        }

                        if (!list.get(i)&&!list.get(i+1)){
                            falsenum++;
                        }else {
                            if (falsenumMax<falsenum){
                                falsenumMax=falsenum;
                            }
                            falsenum=0;
                        }
                    }

                }

                System.out.println("------"+list.size()+"----"+truenumMax+"----"+falsenumMax);

                int sumNum=0;
                for (Integer integer : map.keySet()) {
                    sumNum=sumNum+map.get(integer);
                }

                for (Integer integer : map.keySet()) {
                    Integer integer1 = map.get(integer);

                    System.out.println("||||||"+integer+"======"+integer1);
                }

                System.out.println("......."+sumNum+"::::::::"+(System.currentTimeMillis()-time));
            }
        }).start();
    }
}
