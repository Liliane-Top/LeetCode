package nl.top.LeetCode.datastructures;

import java.util.Arrays;

public class ArrayList {
  public static int removeElement(int[] nums, int value) {
    int i = 0;

    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != value) {
        nums[i] = nums[j];
        i++;
      }
    }
    return i;
  }

  // option 2: set int min = first and int max = first and start comparing each item
  public static int[] findMaxMin1(int[] array) {
    int max = array[0];
    int min = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
      if (array[i] < min) {
        min = array[i];
      }
    }
    return new int[] {max, min};
  }

  // option 1: sort in ascending order return first and last
  public static int[] findMaxMin(int[] array) {
    quickSort(array); // sorting the array
    // return last , first elements
    return new int[] {array[array.length - 1], array[0]};
  }

  public static void quickSort(int[] array) {
    quickSortHelper(array, 0, array.length - 1);
  }

  private static void quickSortHelper(int[] array, int leftIndex, int rightIndex) {
    // base case
    if (leftIndex < rightIndex) {
      // calculate  middle index
      int pivotIndex = pivot(array, leftIndex, rightIndex);
      // recursion over left side
      quickSortHelper(array, leftIndex, pivotIndex - 1);
      // recursion over right side
      quickSortHelper(array, pivotIndex + 1, rightIndex);
    }
  }

  private static int pivot(int[] array, int pivotIndex, int endIndex) {
    int swapIndex = pivotIndex;

    for (int i = swapIndex; i <= endIndex; i++) {
      if (array[i] < array[pivotIndex]) {
        swapIndex++;
        swap(array, i, swapIndex);
      }
    }
    swap(array, pivotIndex, swapIndex);
    return swapIndex;
  }

  private static void swap(int[] array, int firstIndex, int secondIndex) {
    int temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
  }

  public static String findLongestString(String[] stringList) {
    String longest = "";
    for (String item : stringList) {
      if (item.length() > longest.length()) {
        longest = item;
      }
    }
    return longest;
  }

  public static int removeDuplicates2(int[] nums) {
    // input is a sorted array with duplicates
    if (nums.length == 0) {
      return 0;
    }

    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      // skip first element
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int writePointer = 1;

    for (int readPointer = 1; readPointer < nums.length; readPointer++) {
      if (nums[readPointer] != nums[readPointer - 1]) {
        nums[writePointer] = nums[readPointer];
        writePointer++;
      }
    }

    return writePointer;
  }

  public static int maxProfit2(int[] prices) {
    int profit = 0;

    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++)
        if (prices[i] < prices[j]) {
          int dif = prices[j] - prices[i];
          if (dif > profit) {
            profit = dif;
          }
        }
    }

    return profit;
  }

  public static int maxProfit(int[] prices) {
    // this solution has a big O of (n)
    // initialize minPrice with highest possible value of integer value
    int minPrice = Integer.MAX_VALUE;
    // initialize maxProfit to 0
    int maxProfit = 0;

    // loop over all prices
    for (int price : prices) {
      // if day price is lower than minPrice, update minPrice
      minPrice = Math.min(minPrice, price);
      // calculate possible profit in case day price is higher than minPrice money to be made
      int profit = price - minPrice;
      // check if this is the highest possible profit so far other wise update maxProfit
      maxProfit = Math.max(maxProfit, profit);
    }
    // after checking all prices return highest profit
    return maxProfit;
  }

  public static void rotate1(int[] nums, int k) {
    if (nums.length == 1) {
      return;
    }
    int[] temp = Arrays.copyOf(nums, nums.length);

    if (k > nums.length) {
      k -= nums.length;
    }

    for (int i = temp.length - 1; i >= 0; i--) {
      int newIndex = i - k;
      if (newIndex >= 0) {
        nums[i] = temp[newIndex];
      } else {
        nums[i] = temp[newIndex + temp.length];
      }
    }
  }

  // a solution with space complexity(1) no additional space is required
  // The reason this works is because reversing sections of the array and then the entire array
  // has the effect of rotating the elements.
  // This method is more efficient than a naive approach that would shift the elements one-by-one,
  // which would take more time for large k.

  public static void rotate(int[] nums, int k) {
    // reduce k to it equivalent value within array length range
    // as long as k is shorter than the length it remains the same
    // if it has the same length nothing happend as modules will be 0
    // if k > array.length then we deduct the length
    // same as what I did as I deducted it if k is higher than the length
    k = k % nums.length;

    // reverse the first part of the array (from start to length of k)
    for (int start = 0, end = nums.length - k - 1; start < end; start++, end--) {
      // swap elements at position 'start' and 'end'
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
    }

    // reverse the second part of the array ( from length k till end)
    for (int start = nums.length - k, end = nums.length - 1; start < end; start++, end--) {
      // swap elements at position 'start' and 'end'
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
    }

    // reverse the whole array
    for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
      // swap elements at position 'start' and 'end'
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
    }
  }

  public static int maxSubarray(int[] nums) {
    if (nums.length == 0) return 0;

    int highestSum = Integer.MIN_VALUE;
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] + sum > 0) {
        sum += nums[i];
        highestSum = Math.max(highestSum, sum);
      } else if (highestSum < 0) {
        highestSum = Math.max(highestSum, nums[i]);
      } else {
        sum = 0;
      }
    }
    return highestSum;
  }
}
