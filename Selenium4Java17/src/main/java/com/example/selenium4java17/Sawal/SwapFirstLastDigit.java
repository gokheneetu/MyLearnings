package com.example.selenium4java17.Sawal;

public class SwapFirstLastDigit {
    public static void main(String[] args) {
        System.out.println(swapDigits(-1234));
    }
    static int swapDigits(int x) {
        System.out.print(x + " -> ");
        int sign = Integer.signum(x);
        x *= sign;  // invert negative number if necessary

        int last = x % 10;
        int n = x / 10;
        int s = 0;       // sum for the digits in the middle
        for (int p = 1; n > 10; n /= 10, last *= 10, p *= 10) {
            s += p * (n % 10);
        }
        return sign * (10 * (last + s) + n); // restore the sign and get swapped digits
    }
}
