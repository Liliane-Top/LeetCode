package nl.top.LeetCode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The function should return an array containing any combinations of elements
 * that add up exactly the targetSum. If there is no combination that adds up to the targetSum,
 * then return null
 */
public class HowSum {
    //storage for calculated results
    // brute force
    //time complexity O(n^t * t)
    //space complexity O(t)
    //memoization
    //time complexity O(n * t)
    //space complexity O(t^2)
    private final Map<Integer, List<Integer>> memo = new HashMap<>();
    public List<Integer> howSum(int targetSum, int[] numbers) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        //base cases
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int number : numbers) {
            int remainder = targetSum - number;
            if (remainder >= 0) {
                List<Integer> results = howSum(remainder, numbers);
                if (results != null) {
                    results.add(number);
                    memo.put(targetSum, results);
                    return results;
                }
            }
        }
        memo.put(targetSum, null);
        return null;
    }


    public static void main(String[] args) {
        var o1 = new HowSum();

        var results = o1.howSum(3999, new int[]{12, 32, 16, 13});
        assert results != null;
        for (Integer number : results) {
            System.out.print(number + " ");
        }

        System.out.println("-------------------");
        var o2 = new HowSum();
        var result = o2.howSum(11, new int[]{2,3,1,11});
        System.out.println(result);
    }
}
