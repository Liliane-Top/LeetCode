package nl.top.LeetCode.sortingMethods;

/**
 * comparing the first element with the next and swapping if first is > next
 */
public class BubbleSort {

	public static void bubbleSort(int[] array){

		for(int i = array.length - 1; i > 0 ; i--) {//start with last item in array
			for(int j = 0; j < i; j++) { //inside this inner loop we start with number of length and it goes down number of times
        if(array[j] > array[j + 1]) {//j<i as we do not have to keep going through the entire loop.
				 int temp = array[j];
				 array[j] = array[j + 1];
				 array[j+1] = temp;
        }
			}
		}
	}
}
