package com.example.selenium4java17.Sawal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {
    public static void main(String[] args) {
        int[] nums = new int[]{7,9,4,6};
        int target = 7;
        System.out.println(Arrays.toString(CheckAnagram.checkAnagramString(nums, target)));
    }

    private static int[] checkAnagramString(int [] arr, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i =0; i<arr.length;i++) {
            if (mp.containsKey(target - arr[i])){
                return new int[]{mp.get(target - arr[i]),i};
            }else mp.put(arr[i],1);
        }
        return new int[]{-1,-1};
    }
}
