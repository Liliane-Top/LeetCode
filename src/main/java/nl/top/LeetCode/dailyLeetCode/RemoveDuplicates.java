package nl.top.LeetCode.dailyLeetCode;

import java.util.Arrays;

public class RemoveDuplicates {
  // LeetCode number 80.

  public static int removeDuplicates2(int[] nums) {
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

  public static int removeDuplicates3(int[] nums) {
    int left = 2;

    for (int right = 2; right < nums.length; right++) {
      if (nums[left - 1] == nums[right]) {
        if (nums[left - 1] == nums[left - 2]) continue;
        nums[left++] = nums[right];
        continue;
      }
      if (nums[left - 1] != nums[right]) {
        nums[left++] = nums[right];
      }
    }
    return left;
  }

  public static int removeDuplicates4(int[] nums) {
    if (nums.length < 3) return nums.length;
    int i = 0, j = 0;

    while (i < nums.length) {

      nums[j++] = nums[i++];

      if (i < nums.length && nums[i] == nums[j - 1]) {
        nums[j++] = nums[i++];
      }

      while (i < nums.length && nums[i] == nums[j - 1]) {
        i++;
      }
    }
    return j;
  }

  public static int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }

    int index = 2;

    for (int i = 2; i < nums.length; i++) {
      // compare current value with the value 2 down. If they are the same you have a triplet and
      // this needs to be removed
      if (nums[i] != nums[index - 2]) {
        // here you remove the triplet by setting the third value to the second value
        // and move the pointer one to the right.
        // if the value is also the same as the current value we have a quadruple which needs to be
        // removed
        // by setting this 4th value equal to the second etc.

        nums[index] = nums[i];
        index++;
      } // if the current value as indicated by the index pointer is no longer the same as i
      // we can move i one step to the right and start comparing again.
    }

    return index;
  }

  public static void main(String[] args) {
    int[] input = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};

    System.out.println("length " + RemoveDuplicates.removeDuplicates(input));

    for (int x : input) System.out.println(x);
  }
}
