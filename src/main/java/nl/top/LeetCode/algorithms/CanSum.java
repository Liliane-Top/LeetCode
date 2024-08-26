package nl.top.LeetCode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanSum {

    public static boolean canSum(int target, int[] numbers) {
        if (target == 0) return true;
        if (target < 0) return false;
        for (int number : numbers) {
            int remainder = target - number;
            if (canSum(remainder, numbers)) {
                return true;
            }
        }
        return false;
    }

    public static Map<Integer, Boolean> values = new HashMap<>();

    public static boolean canSumEnhanced(int target, int[] numbers) {
        if (target == 0) return true;
        if (target < 0) return false;
        if (values.containsKey(target)) return values.get(target);

        for (int number : numbers) {
            int remainder = target - number;
            if (canSumEnhanced(remainder, numbers)) {
                values.put(target, true);
                return true;
            }
        }
        values.put(target, false);
        return false;
    }

    public static boolean canSumIterative(int target, int[] numbers) {
        boolean[] possibilities = new boolean[target + 1];
        possibilities[0] = true;

        for (int i = 0; i < target; i++) {
            if(possibilities[i]){
                for (int number : numbers) {
                    if(i + number <= target) {
                        possibilities[i + number] = true;
                        if (possibilities[target]) {
                            return true;
                        }
                    }
                }
            }
        }
        return possibilities[target];
    }

    public static void main(String[] args) {
//        System.out.println(canSum(7, new int[]{5,3,4,7}));//true
//        System.out.println(canSum(7, new int[]{2,4}));//false
//        System.out.println(canSum(7, new int[]{1,2,4}));//true
//        System.out.println(canSumEnhanced(300, new int[]{7,14}));//false almost hangs
        System.out.println(canSumIterative(5, new int[]{2, 3}));
        System.out.println(canSumIterative(300, new int[]{7, 14}));
    }
}
