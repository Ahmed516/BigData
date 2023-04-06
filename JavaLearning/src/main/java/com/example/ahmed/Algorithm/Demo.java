package com.example.ahmed.Algorithm;

public class Demo {

    /**
     * 二分法
     */
    public static int binarySearch(int nums[], int left, int right, int target){
        int size=nums.length;
        int mid;
        while(left<=right){
            mid=(left+right)/2;
            if(target==nums[mid]){
                return mid;
            }

            if(target>nums[mid]){
                left=mid+1;
            }

            if(target<nums[mid]){
                right=mid-1;
            }
        }
        return -1;
    }
    /**
     * leetcode 33.
     * @return
     */
    public static int searchRot(int nums[], int target){
        int size=nums.length;
        int left=0;
        int right=size-1;
        int mid;
        while(left<=right){
            mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            // 左半部分为升序数组
            if(nums[mid]>=nums[left]){
                if(target>=nums[left] && target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                // 右半部分为升序数组
                if(target<=nums[right] && target>nums[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[]={3,1};
        int target=3;
        System.out.println(searchRot(nums,target));
    }
}
