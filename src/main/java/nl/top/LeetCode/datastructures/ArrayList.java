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
}
