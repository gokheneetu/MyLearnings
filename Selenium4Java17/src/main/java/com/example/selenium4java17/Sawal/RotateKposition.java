package com.example.selenium4java17.Sawal;

import java.util.Arrays;

public class RotateKposition {
    public static void main(String[] args) {
        int[] nums ={1,2,3,4,5,6,7};
        int k=8;
        k=k%nums.length;
        rev(nums,0,nums.length-1);
        rev(nums,0,k-1);
        rev(nums,k,nums.length-1);
        Arrays.stream(nums).forEach(n->System.out.print(n+" "));


    }
    private static void rev(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
