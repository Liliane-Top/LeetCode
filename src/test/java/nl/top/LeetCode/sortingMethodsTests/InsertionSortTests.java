package nl.top.LeetCode.sortingMethodsTests;

import nl.top.LeetCode.sortingMethods.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortTests {

  @Test
  void call_insertionSort() {
    int[] array = new int[] {2, 4, 6, 1, 3, 5};
    InsertionSort.insertionSort(array);

    Assertions.assertEquals(1, array[0]);
    Assertions.assertEquals(2, array[1]);
    Assertions.assertEquals(3, array[2]);
    Assertions.assertEquals(4, array[3]);
    Assertions.assertEquals(5, array[4]);
    Assertions.assertEquals(6, array[5]);
  }
}
