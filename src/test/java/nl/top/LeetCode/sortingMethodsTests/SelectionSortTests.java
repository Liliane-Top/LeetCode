package nl.top.LeetCode.sortingMethodsTests;

import nl.top.LeetCode.sortingMethods.SelectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectionSortTests {

  @Test
  void call_selectionSort() {
    int[] array = new int[] {2, 4, 6, 1, 3, 5};
    SelectionSort.selectionSort(array);

    Assertions.assertEquals(1, array[0]);
    Assertions.assertEquals(2, array[1]);
    Assertions.assertEquals(3, array[2]);
    Assertions.assertEquals(4, array[3]);
    Assertions.assertEquals(5, array[4]);
    Assertions.assertEquals(6, array[5]);

    int[] array2 = new int[] {2, 4, 1, 4, 6, 3, 5, 1};
    SelectionSort.selectionSort(array2);
    Assertions.assertEquals(1, array2[0]);
    Assertions.assertEquals(1, array2[1]);
    Assertions.assertEquals(2, array2[2]);
    Assertions.assertEquals(3, array2[3]);
    Assertions.assertEquals(4, array2[4]);
    Assertions.assertEquals(4, array2[5]);
  }
}
