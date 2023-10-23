package nl.top.LeetCode.sortingMethods;

public class QuickSort {

	private static void swap(int [] array, int firstIndex, int secondIndex){
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	public static int pivot(int[] array, int pivotIndex, int endIndex){
		int swapIndex = pivotIndex;
		
		for(int i = pivotIndex + 1; i <= endIndex ; i++) {
			if(array[i] < array[pivotIndex]){
				swapIndex++;
				swap(array, i, swapIndex);
			}
		}

		swap(array, swapIndex, pivotIndex);
		return swapIndex;
	}

	public static void quickSort(int[] array){
    quickSortHelper(array, 0, array.length -1);
	}

	private static void quickSortHelper(int[] array, int leftIndex, int rightIndex){
    if (leftIndex < rightIndex) {
      int pivotIndex = pivot(array, leftIndex, rightIndex);

      for (int i = leftIndex; i < pivotIndex; i++) {
        quickSortHelper(array, leftIndex, pivotIndex - 1);
      }
      for (int i = pivotIndex; i < rightIndex; i++) {
        quickSortHelper(array, pivotIndex + 1, rightIndex);
      }
		}
	}
}
