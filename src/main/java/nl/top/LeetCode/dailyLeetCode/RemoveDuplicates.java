package nl.top.LeetCode.dailyLeetCode;

import java.util.Arrays;

public class RemoveDuplicates {
  // LeetCode number 80.

  public static int removeDuplicates(int[] nums) {
    int count = 1;
    int length = nums.length;
    int temp = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        count++;
        if (count > 2) {
          nums[i] = temp;
          length--;
        }
      } else {
        count = 1;
      }
    }
		Arrays.sort(nums);
    return length;
  }

  public static void main(String[] args) {
    int[] input = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};

    System.out.println("length " + RemoveDuplicates.removeDuplicates(input));

    for (int x : input) System.out.println(x);
  }
}
