package com.example.selenium4java17.Sawal;

// Java code to find the largest substring with
// non-repeating characters using Sliding Window

class LongestNonRepeatingString {

    // Function to find the length of the largest substring
    // with non-repeating characters using Sliding Window
    static int longestUniqueSubstr(String s) {

        // if string length is 0
        if (s.length() == 0)
            return 0;

        // if string length 1
        if (s.length() == 1)
            return 1;

        // if string length is more than 1
        int maxLength = 0;
        boolean[] visited = new boolean[256];

        // left and right pointer of sliding window
        int left = 0, right = 0;
        while (right < s.length()) {

            // If the character is repeated, move left pointer
            // to the right and mark visited characters as false
            // until the repeating character is no longer part
            // of the current window.
            while (visited[s.charAt(right)]) {
                visited[s.charAt(left)] = false;
                left++;
            }

            visited[s.charAt(right)] = true;

            // The length of the current window (right - left + 1)
            // is calculated and answer is updated accordingly
            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }
}
