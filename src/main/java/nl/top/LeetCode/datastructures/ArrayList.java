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

	public static int[] findMaxMin(int[] array){
    // option 1: sort in ascending order return first and last
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
}
