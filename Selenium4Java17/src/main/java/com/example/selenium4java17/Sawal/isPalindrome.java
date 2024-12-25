package com.example.selenium4java17.Sawal;

class isPalindrome {
    public static void main(String[] args) {
        System.out.println(iisPalindrome("Was it a car or a cat I saw?"));
    }
    private static boolean iisPalindrome(String s) {
        if(s ==null){
            return false;
        }

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
        }
        String s3 = sb.toString();
        int j=s3.length()-1;
        char[] s1 = s3.toCharArray();
        for(int i =0; i<s1.length;i++){
            if(i<=j){
                if(s1[i] != s1[j]){
                    return false;
                }
                j--;
            }
        }
        return true;
    }
}
