package nl.top.LeetCode.sortingMethods;

import java.util.Arrays;

public class MergeSort {
  public static int[] merge(int[] array1, int[] array2) {
    int[] combined = new int[array1.length + array2.length];
    int index = 0;
    int i = 0;
    int j = 0;

    while (i < array1.length && j < array2.length) {
      if (array1[i] < array2[j]) {
        combined[index] = array1[i];
        i++;
      } else {
        combined[index] = array2[j];
        j++;
      }
      index++;
    }

    while (i < array1.length) {
      combined[index] = array1[i];
      i++;
      index++;
    }

    while (j < array2.length) {
      combined[index] = array2[j];
      j++;
      index++;
    }

    return combined;
  }

	public static int[] mergeSort(int[] array){

		//base case for recursion if the entire array is split into single elements
		if(array.length == 1) return array;
		int midIndex = array.length/2;

		//splits the left half
		int[] arrayLeft = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
		//splits the right half
		int[] arrayRight = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));


		//each array has 1 element to start and with merge these 2 elements will be ordered
		//then each array has 2 elements these will be ordered.
		return merge(arrayLeft, arrayRight);
	}
}
