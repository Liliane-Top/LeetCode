package nl.top.LeetCode.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static Map<Integer, Long> storedResults = new HashMap<>();

    public static int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static Long enhancedFib(int n) {
        if (storedResults.containsKey(n)) return storedResults.get(n);
        if (n <= 2) return 1L;
        storedResults.put(n, enhancedFib(n - 1) + enhancedFib(n - 2));
        return storedResults.get(n);

    }

    public static void main(String[] args) {
        System.out.println(fib(8));
        System.out.println(enhancedFib(50));

    }
}
