package nl.top.LeetCode.sortingMethodsTests;

import static nl.top.LeetCode.sortingMethods.QuickSort.pivot;

import java.util.Arrays;
import nl.top.LeetCode.sortingMethods.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTests {

  @Test
  void call_pivot() {
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

  @Test
  void call_quickSort() {
    int[] myArray = {4, 6, 1, 7, 3, 2, 5};

    QuickSort.quickSort(myArray);
    System.out.println(Arrays.toString(myArray));

    Assertions.assertEquals(1, myArray[0]);
    Assertions.assertEquals(2, myArray[1]);
    Assertions.assertEquals(3, myArray[2]);
    Assertions.assertEquals(4, myArray[3]);
    Assertions.assertEquals(5, myArray[4]);
    Assertions.assertEquals(6, myArray[5]);
    Assertions.assertEquals(7, myArray[6]);
  }
}
