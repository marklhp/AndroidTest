package com.myapp;

public class TestC {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    public static void main(String[] args){
        int c=ctlOf(RUNNING, 0);
        int rs = runStateOf(c);
        int wc = workerCountOf(c);
        System.out.println("打印数据"+workerCountOf(c)+"----"+rs+"-=-=-="+wc);

    }

    private static int ctlOf(int rs, int wc) { return rs | wc; }

    private static int workerCountOf(int c)  { return c & CAPACITY; }

    private static int runStateOf(int c)     { return c & ~CAPACITY; }


}
