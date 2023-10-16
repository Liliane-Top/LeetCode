package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapTests {

  @Test
  void call_insert() {
    Heap myHeap = new Heap();
    myHeap.insert(99);
    myHeap.insert(72);
    myHeap.insert(61);
    myHeap.insert(58);

    System.out.println(myHeap.getHeap());

    myHeap.insert(100);
    System.out.println(myHeap.getHeap());

    myHeap.insert(75);
    System.out.println(myHeap.getHeap());
  }

  @Test
  void call_remove() {
    Heap myHeap = new Heap();
    myHeap.insert(99);
    myHeap.insert(72);
    myHeap.insert(61);
    myHeap.insert(58);

    assertEquals(4, myHeap.getHeap().size());
    myHeap.remove();
    assertEquals(3, myHeap.getHeap().size());
  }

  @Test
  void call_findKthSmallest() {
    int[] nums = {7, 10, 4, 3, 20, 15};
    int k = 3;

    Assertions.assertEquals(7, Heap.findKthSmallest(nums, k));

	  int[] nums2 = {2, 1, 3, 5, 6, 4};
	  int k2 = 2;
	  Assertions.assertEquals(2, Heap.findKthSmallest(nums2, k2));

	  int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
	  int k3 = 5;
	  Assertions.assertEquals(7, Heap.findKthSmallest(nums3, k3));

  }
}
