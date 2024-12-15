package com.example.selenium4java17;

public class SortOn {

        // function to sort the array
        static void sortArr(int[] arr) {
            int n = arr.length;

            for (int i = 0; i < n; i++) {
                int originalVal = arr[i] % (n + 1);
                int correctIdx = originalVal - 1;
                arr[correctIdx] += originalVal * (n + 1);
            }

            for (int i = 0; i < n; i++)
                arr[i] = arr[i] / (n + 1);
        }

        public static void main(String[] args) {
            int[] arr = { 2, 1, 5, 4, 3 };
            sortArr(arr);
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
        }
    int[] arr = { 2, 1, 5, 4, 3 };
        void bc() {
            for (int j : arr)
                System.out.println(j);

        }


}
