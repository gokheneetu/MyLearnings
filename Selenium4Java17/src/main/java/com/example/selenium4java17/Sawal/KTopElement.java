package com.example.selenium4java17.Sawal;

import java.util.*;

class KTopElement {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,4,4};
        int k = 2;
        Arrays.stream(topKFrequent(nums, k)).forEach(System.out::println);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> mp = new HashMap<>();
        int res[] = new int[k];
        List<Integer>[] freq = new List[nums.length+1];
        for(int n:nums){
            mp.put(n, mp.getOrDefault(n,0)+1);
        }
        for(int i=0;i<freq.length;i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int j=0;
        for(int i=freq.length-1;i>0 && j<k;i--){
            if(freq[i]!=null)
                for(int n:freq[i]){
                    res[j++]=n;
                    if(j == k){
                        return res;
                    }

                }
        }
        return res;
    }
}
