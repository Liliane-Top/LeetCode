package nl.top.LeetCode.algorithms;

import java.util.*;

public class BestSum {

    private static List<Integer> bestSum(int targetSum, int[] numbers){
        Arrays.sort(numbers);
        return bestSum(targetSum, numbers, new HashMap<>());
    }

    //brute force time: O(n^m * m) space: O(m^2)
    //memoized time: O(n * m ^2) iterating over de numbers array (n) times the height of the tree (m) and adding the possible solutions to an array which can have the length of (m) => n * M * M => n * m^2
    // space: O(m^2)    number of keys inside memo and each key contains a list of possible values in worse case scenario is size m => m * m
    private static List<Integer> bestSum(int targetSum,
                                         int[] numbers,
                                         Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> bestSolution = null;

        for (int number : numbers) {
            int remainder = targetSum - number;
            var possibility = bestSum(remainder, numbers, memo);
            if (possibility != null) {
                List<Integer> newPossibility = new ArrayList<>(possibility);
                newPossibility.add(number);
                if(newPossibility.size() == 1){
                    return newPossibility;
                }
                if (bestSolution == null || newPossibility.size() < bestSolution.size()) {
                    bestSolution = newPossibility;
                }
            }
        }
        memo.put(targetSum, bestSolution);
        return bestSolution;
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5, 3, 7, 4, 1}));//7
        System.out.println(bestSum(7, new int[]{2, 4}));//null
        System.out.println(bestSum(7, new int[]{1, 2, 4}));//4,2,1
        System.out.println(bestSum(300, new int[]{7, 14}));//null
        System.out.println(bestSum(5, new int[]{2, 3}));//3,2
        System.out.println(bestSum(100, new int[]{1, 5, 25, 15, 4}));
        System.out.println(bestSum(300, new int[]{7, 14, 15}));
    }
}
