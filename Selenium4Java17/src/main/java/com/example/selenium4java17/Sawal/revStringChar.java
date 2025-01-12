package com.example.selenium4java17.Sawal;

public class revStringChar {
    public static void main(String[] args)
    {
        String str = "internship at geeks for geeks";

        preserveSpace(str);
    }

    private static void preserveSpace(String str) {

        int start =0;
        int end = str.length()-1;
        char[] arr = str.toCharArray();

        while(start < end){
            if(arr[start]==' '){
                start++;
            }
            else if(arr[end] == ' '){
                end--;
            } else {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;

            }

        }
        System.out.println(String.valueOf(arr));
    }
}
