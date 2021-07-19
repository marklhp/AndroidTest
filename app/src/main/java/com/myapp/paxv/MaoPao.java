package com.myapp.paxv;

class MaoPao {

    public int[] bobbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j=nums.length-1;j>=i;j--){
                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);

                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int j, int i) {
        if (nums[j]>nums[i]){
            int tempInt=nums[i];
            nums[i]=nums[j];
            nums[j]=tempInt;
        }
    }
}
