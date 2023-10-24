package nl.top.LeetCode.datastructures;

public class ArrayList {
	public static int removeElement(int[] nums, int value){
		int i = 0;

    for (int j = 0; j < nums.length; j++) {
			if(nums[j] != value){
				nums[i] = nums[j];
				i++;
			}
    }
		return i;
	}

	public static int[] findMaxMin1(int[] array){

    // option 2: set int min = first and int max = first and start comparing each item
		int max = array[0];
		int min = array[0];
    for (int i = 1; i < array.length; i++) {
			if(array[i] > max){
				max = array[i];
			}

			if(array[i] < min){
				min = array[i];
			}

    }
		return new int[]{max, min};
	}

	// option 1: sort in ascending order return first and last
	public static int[] findMaxMin(int[] array){
		quickSort(array);//sorting the array
		//return last , first elements
		return new int[]{array[array.length-1], array[0]};
	}

	public static void quickSort(int[] array){
		quickSortHelper(array, 0, array.length -1);

	}

	private static void quickSortHelper(int[] array, int leftIndex, int rightIndex){
    // base case
    if (leftIndex < rightIndex) {
			//calculate  middle index
      int pivotIndex = pivot(array, leftIndex, rightIndex);
			//recursion over left side
      quickSortHelper(array, leftIndex, pivotIndex - 1);
	    //recursion over right side
      quickSortHelper(array, pivotIndex + 1, rightIndex);
		}

	}

	private static int pivot(int[] array, int pivotIndex, int endIndex){
		int swapIndex = pivotIndex;

		for (int i = swapIndex; i <= endIndex; i++){
			if(array[i] < array[pivotIndex]){
				swapIndex++;
				swap(array, i, swapIndex);
			}
		}
		swap(array, pivotIndex, swapIndex);
		return swapIndex;
	}

	private static void swap(int[] array, int firstIndex, int secondIndex){
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}


}
