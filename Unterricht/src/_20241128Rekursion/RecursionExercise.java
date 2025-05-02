package _20241128Rekursion;

import java.sql.SQLOutput;

public class RecursionExercise {
    public static void main(String[] args) {
        System.out.println(factorial(10));
        System.out.println(factorial(2));
        System.out.println(fibonacci(10));
        printFibonacci(10);
        System.out.println(isPalindrome("Anna"));
        System.out.println(sumFraction(50));
    }

    public static long factorial(int n) {
        if(n < 0) return 0;
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static long fibonacci(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void printFibonacci(int n) {
        if(n < 0) return;
        for(int i = 0; i <= n; i++) {
            System.out.print((i==n) ? fibonacci(i) + "\n": fibonacci(i) + ", ");
        }
    }

    public static boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        if (s.charAt(0) == s.charAt(s.length()-1)) return true;
        return isPalindrome(s.substring(1, s.length()-1));
    }

    public static double sumFraction(double n){
        if(n == 1) return 1;
        return 1/n + sumFraction(n-1);
    }
}
