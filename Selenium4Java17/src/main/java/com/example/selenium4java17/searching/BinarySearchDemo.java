package com.example.selenium4java17.searching;

class BinarySearchDemo {
    public static void main(String[] args) {
        int arr[] = {2,4,7,8,9,11,35,67,89};
        int target =4;
        System.out.println(BinarySearch(arr, 0, arr.length-1, target));
    }
    public static int BinarySearch(int[] arr, int left, int right, int target){
        if(left<right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]<target)
                return BinarySearch(arr, mid+1, right,target);
            else
                return BinarySearch(arr, left, mid-1, target);

        }
        return -1;
    }

}