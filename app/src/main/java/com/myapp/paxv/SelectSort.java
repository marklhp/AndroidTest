package com.myapp.paxv;

public class SelectSort {
    public void sort(int[] array){
        int i,j,min;
        for (i=1;i<array.length;i++){
            min=i;
            for (j=i+1;j<array.length;j++){
                if (array[min]>array[j]){
                    min=j;
                }
            }

            if (i!=min){
             swap(array,i,min);
            }
        }
    }
    private void swap(int[] nums, int j, int i) {
        if (nums[j]>nums[i]){
            int tempInt=nums[i];
            nums[i]=nums[j];
            nums[j]=tempInt;
        }
    }
}
