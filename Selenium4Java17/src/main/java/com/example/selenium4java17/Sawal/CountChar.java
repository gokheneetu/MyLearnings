package com.example.selenium4java17.Sawal;

public class CountChar {
    public static void main(String[] args) {
        String s = "aaabbbacfwww";
        char[] ch = s.toCharArray();
        int j=0; int count=0;
        StringBuilder sb  = new StringBuilder();
        for(int i=0;i<ch.length;i++) {
            if(ch[j] == ch[i]){
                count++;
                continue;
            }else {
                sb.append(ch[j]);
                if(count>1)
                    sb.append(String.valueOf(count));
                j=i;
                count=1;
            }
        }
        sb.append(s.charAt(s.length()-1));
        sb.append(String.valueOf(count));
        System.out.println(sb);

    }
}
