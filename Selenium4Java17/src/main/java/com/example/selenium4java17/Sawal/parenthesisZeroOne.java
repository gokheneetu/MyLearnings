package com.example.selenium4java17.Sawal;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class parenthesisZeroOne {

    public static void main(String []args){
        Map<String, String> map = new HashMap<>();
        map.put(")(", "-11");
        map.put("((a)" , "10a0");
        map.put("(a(b)c)","0a0b0c0");
        map.put("()a((((" , "00a1111");
        map.forEach( (k,v) -> System.out.println( decodeOneZero(k)) );
    }

    private static String decodeOneZero(String k) {
        char[] c = k.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < c.length; i++) {
            char ch = c[i];
            if (ch == '(') {
                stack.push(i);
            } else if (stack.isEmpty()) {
                continue;
                } else if(ch == ')'){
                int index = stack.pop();
                c[i] = '0';
                c[index] = '0';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<c.length;i++) {
            if(c[i] == '('){
                sb.append("1");
            }else if(c[i] == ')'){
                sb.append("-1");
            }else {
                sb.append(String.valueOf(c[i]));
            }
        }
        return sb.toString();
    }
}
