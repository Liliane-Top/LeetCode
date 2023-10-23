package nl.top.LeetCode.sortingMethodsTests;

import static nl.top.LeetCode.sortingMethods.QuickSort.pivot;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTests {

  @Test
  void call_quickSort() {
    int[] myArray = {4, 6, 1, 7, 3, 2, 5};

    int returnedIndex = pivot(myArray, 0, 6);

    System.out.println("Returned Index: " + returnedIndex);

    System.out.println(Arrays.toString(myArray));

    Assertions.assertEquals(3, returnedIndex);

    int[] myArray2 = {4, 6, 1, 7, -3, 2, 5};
    int returnedIndex2 = pivot(myArray2, 0, 6);
    System.out.println("Returned Index: " + returnedIndex2);

    System.out.println(Arrays.toString(myArray2));

    Assertions.assertEquals(3, returnedIndex2);
  }
}
