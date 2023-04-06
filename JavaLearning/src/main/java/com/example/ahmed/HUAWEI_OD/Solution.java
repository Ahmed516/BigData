package com.example.ahmed.HUAWEI_OD;

import java.util.Scanner;

public class Solution {
    /**
     * 题目描述
     * 有一个N个整数的数组，和一个长度为M的窗口，窗口从数组内的第一个数开始滑动直到窗口不能滑动为止，每次窗口滑动产生一个窗口和（窗口内所有数和和），求窗口滑动产生的所有窗口和的最大值。
     *
     * 输入描述：
     * 第一行输入一个正整数N，表示整数个数。（0<N<100000）
     *
     * 第二行输入N个整数，整数的取值范围为[-100,100]。
     *
     * 第三行输入一个正整数M，M代表窗口大小，M<=100000，且M<=N。
     *
     * 输出描述：
     * 窗口滑动产生的所有窗口和的最大值。
     * @param nums,m
     */

    public static int maxWindowSum(int nums[],int m){
        int maxSum=0;
        for(int i=0;i<m;i++){
            maxSum+=nums[i];
        }

        for(int j=m;j<nums.length;j++){
            if(nums[j]>nums[j-m]){
                maxSum+=(nums[j]-nums[j-m]);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n= scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=scanner.nextInt();
            }

            System.out.println("最大窗口数和为："+maxWindowSum(nums, m));
        }

//        int nums[]={10,20,30,15,23,12};
//        int m=3;
    }
}
