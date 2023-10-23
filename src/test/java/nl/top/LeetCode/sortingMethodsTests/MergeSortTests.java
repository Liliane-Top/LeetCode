package nl.top.LeetCode.sortingMethodsTests;

import static org.junit.jupiter.api.Assertions.*;

import nl.top.LeetCode.sortingMethods.MergeSort;
import org.junit.jupiter.api.Test;

class MergeSortTests {

  @Test
  void call_merge() {
    int[] array1 = {1, 3, 7, 8};
    int[] array2 = {2, 4, 5, 6};

    int[] mergedArray = MergeSort.merge(array1, array2);
    assertEquals(1, mergedArray[0]);
    assertEquals(2, mergedArray[1]);
    assertEquals(3, mergedArray[2]);
    assertEquals(4, mergedArray[3]);
    assertEquals(5, mergedArray[4]);
    assertEquals(6, mergedArray[5]);
  }

  @Test
  void call_mergeSort() {
    int[] originalArray = new int[] {5, 3, 1, 4, 2};
    int[] sorted = MergeSort.mergeSort(originalArray);

    assertEquals(1, sorted[0]);
    assertEquals(2, sorted[1]);
    assertEquals(3, sorted[2]);
    assertEquals(4, sorted[3]);
    assertEquals(5, sorted[4]);
  }
}
