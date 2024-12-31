package com.example.selenium4java17.Sawal;

import java.util.HashMap;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String str = "abcdabbcddeggg";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else map.put(str.charAt(i), 1);
        }
        for(int i=0;i<str.length();i++) {
            int count = map.get(str.charAt(i));
            if(count == 1){
                System.out.println(str.charAt(i));
                break;
            }
        }
    }
}
