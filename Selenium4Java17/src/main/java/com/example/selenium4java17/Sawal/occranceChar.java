package com.example.selenium4java17.Sawal;

class occranceChar {

    public static void main(String[] args) {

        String s = "Program";
        int[] c = new int[256]; // Array for ASCII characters

        // Increment count for each character
        for (char ch : s.toCharArray()) {
            c[ch]++;
        }

        System.out.println("Character Occurrences:");

        // Print characters with non-zero counts
        for (int i = 0; i < c.length; i++) {
            if (c[i] > 0) {
                System.out.println((char) i + " : " + c[i]);
            }
        }
    }
}