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
}
