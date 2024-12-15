package com.example.selenium4java17;

public class ReverseString {
    public static void main(String[] args) throws Exception {
        String s = "heoeh";
        StringBuilder newS= new StringBuilder();
        int n = s.length();
        for (int i = n-1; i >=0; i--) {
            newS.append(s.charAt(i));
        }
        System.out.println(newS.toString().equals(s));

        if(s!=null){
            throw new Exception();
        }
    }

}
