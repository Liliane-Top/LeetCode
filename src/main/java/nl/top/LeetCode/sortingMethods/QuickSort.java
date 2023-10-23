package nl.top.LeetCode.sortingMethods;

public class QuickSort {

  private static void swap(int[] array, int firstIndex, int secondIndex) {
    int temp = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temp;
  }

  public static int pivot(int[] array, int pivotIndex, int endIndex) {
    int swapIndex = pivotIndex;

    for (int i = pivotIndex + 1; i <= endIndex; i++) {
      if (array[i] < array[pivotIndex]) {
        swapIndex++;
        swap(array, i, swapIndex);
      }
    }

    swap(array, swapIndex, pivotIndex);
    return swapIndex;
  }

  public static void quickSort(int[] array) {
    quickSortHelper(array, 0, array.length - 1);
  }

  private static void quickSortHelper(int[] array, int leftIndex, int rightIndex) {
    if (leftIndex < rightIndex) {// this is the base case
			//every recursion a new pivot index will be found
      int pivotIndex = pivot(array, leftIndex, rightIndex);
//no need for a for loop. Recursion will keep running till base case
      quickSortHelper(array, leftIndex, pivotIndex - 1);
      quickSortHelper(array, pivotIndex + 1, rightIndex);
    }
  }
}
