package nl.top.LeetCode.sortingMethods;

public class BubbleSort {

	public static void bubbleSort(int[] array){

		for(int i = array.length - 1; i > 0 ; i--) {//start with last item in array
			for(int j = 0; j < i; j++) { //inside this inner loop we start with number of length and it goes down number of times
        if(array[j] > array[j + 1]) {
				 int temp = array[j];
				 array[j] = array[j + 1];
				 array[j+1] = temp;
        }
			}
		}
	}
}
