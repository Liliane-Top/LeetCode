package nl.top.LeetCode.sortingMethods;

public class SelectionSort {

  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
			}
			if(i != minIndex){//do not run the code when the item is already sorted into the right position
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
      }
    }
  }
}
