package nl.top.LeetCode.datastructures;

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
}
