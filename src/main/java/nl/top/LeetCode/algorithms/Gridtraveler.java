package nl.top.LeetCode.algorithms;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * How many ways can I travel a m by n grid
 * only allowed to move either right or down
 */
public class Gridtraveler {
    public static Map<String,Long> ways = new HashMap<>();
    public static long waysToTravel(int m, int n){
        if(m == 0 || n == 0) return 0;
        if(m == 1 && n == 1) return 1;
       return waysToTravel(m-1, n) + waysToTravel(m, n-1);
    }

    public static long enhancedWaysToTravel(int row, int column) {
        String key = row > column ? row + "," + column: column + "," + row;

        if(ways.containsKey(key)){
            return ways.get(key);
        }
        if (row == 0 || column == 0) return 0;
        if (row == 1 && column == 1) return 1;

        long result = enhancedWaysToTravel(row -1, column) + enhancedWaysToTravel(row, column -1);
        ways.put(key, result);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(waysToTravel(1,1));//1
        System.out.println(waysToTravel(2,3));//3
        System.out.println(waysToTravel(5,4));//35
        System.out.println(enhancedWaysToTravel(1,1));
        System.out.println(enhancedWaysToTravel(2,3));
        System.out.println(enhancedWaysToTravel(5,4));
        System.out.println(enhancedWaysToTravel(18,18));

    }
}
