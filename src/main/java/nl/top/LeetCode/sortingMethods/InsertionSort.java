package nl.top.LeetCode.sortingMethods;

/**
 * insertion sort compares second with first/before value
 */
public class InsertionSort {

  public static void insertionSort(int[] array) {

    for (int i = 1; i < array.length; i++) { // starting with second item in the array
      int temp = array[i];
      int j = i - 1; // starts with the first element in the array
      while (j > -1 && temp < array[j]) { // in case we need to swap first 2 elements j will end up -1
        array[j + 1] = array[j];
        array[j] = temp;
        j--;
      }
    }
  }
}
