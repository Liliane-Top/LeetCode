package nl.top.LeetCode.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * maxHeap parent is highest minHeap parent is lowest value
 *
 * <p>Heap can have duplicates and no particular sequence to the nodes except that the children are
 * always same value if smaller( higher in case of minHeap)
 *
 * <p>no Node class just a List<T>
 *
 * <p>complete heap is filled from left, always keep it complete
 */
public class Heap {

  private List<Integer> heap;

  public Heap() {
    this.heap = new ArrayList<>();
  }

  public List<Integer> getHeap() {
    return new ArrayList<>(heap); // returns a copy of the original heap no outside access
  }

  private int leftChildValue(int index) { // returns the value at this index if we start at index 0
    return heap.get(index * 2 + 1);
  }

  private int rightChildValue(int index) { // returns the value at this index if we start at index 0
    return heap.get(index * 2 + 2);
  }

  private int leftChild(int index) { // returns the index if we start at index 0
    return index * 2 + 1;
  }

  private int rightChild(int index) { // returns the index if we start at index 0
    return index * 2 + 2;
  }

  private int parentValue(int index) { // it returns the value of the parent and we start at index 0
    return heap.get((index - 1) / 2);
  }

  private int parent(int index) { // it returns the index of the parent and we start at index 0
    return (index - 1) / 2;
  }

  private void swap(int index1, int index2) {
    int temp = heap.get(index1);
    heap.set(index1, heap.get(index2));
    heap.set(index2, temp);
  }

  public boolean insert(int value) {
    heap.add(value); // add the value at the end of the list
    int currentIndex = heap.size() - 1; // index of the new node which is the last index
    while (currentIndex > 0 && heap.get(parent(currentIndex)) < value) {
      swap(currentIndex, parent(currentIndex));
      currentIndex = parent(currentIndex);
    }
    return true;
  }

  // always remove and return the top item
  // the very last item will be put on the top
  // sink down the top item in the right place to ensure a complete heap in which the parent is
  // equal or greater than its children
  // sinkdown is comparing the parent.value with both children.value and swap with the highest value

  public Integer remove() {

    if (heap.size() == 0) {
      return null;
    }

    if (heap.size() == 1) {
      return heap.remove(0); // this removes the value and returns the value this is a method of the
      // ArrayList.class
    }

    int maxValue = heap.get(0); // this is the top node/value
    heap.set(0, heap.remove(heap.size() - 1)); // set the top node/value to the last node
    sinkDown(
        0); // sinkDown the last node which is now the top value should be set in it proper place
    // the value of its children can't be higher
    return maxValue;
  }

  private void sinkDown(int index) {
    int parent = index;
    while (true) {
      int leftIndex = leftChild(index);
      int rightIndex = rightChild(index);
      if (leftIndex < heap.size()
          && heap.get(leftIndex)
              > heap.get(parent)) { // compare if the left child's value is bigger than parent
        parent = leftIndex;
      }
      if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(parent)) { //
        parent = rightIndex;
      }

      if (parent != index) {
        // swapping the values between the top value and the child that has higher value and becomes
        // the parent
        swap(index, parent);
        index = parent;
      } else {
        return;
      }
    }
  }

  public static int findKthSmallest1(int[] nums, int k) {
    Integer[] numbers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(numbers, Collections.reverseOrder());

    //	  for(int i = 0; i < nums.length; i++) {
    //		  for(int j = i + 1; j < nums.length; j++){
    //				if(nums[i] < nums [j]){
    //					int temp = nums[i];
    //					nums[i] = nums[j];
    //					nums[j] = temp;
    //				}
    //		  }
    //	  }
    Heap myHeap = new Heap();
    for (Integer number : numbers) {
      myHeap.insert(number);
    }

    return myHeap.getHeap().get(myHeap.getHeap().size() - k);
  }

  public static int findKthSmallest(int[] nums, int k) {
    Heap myHeap = new Heap();
    for (int number : nums) {
      myHeap.insert(number);
      // every kth insertion will be removed after it is inserted into the heap which has always the
      // highest value
      if (myHeap.getHeap().size() > k) {
        myHeap.remove();
      }
    }
    return myHeap.remove();
  }

  public static List<Integer> streamMax(int[] nums) {
    List<Integer> result = new ArrayList<>();
    Heap myHeap = new Heap();
    for (int i = 0; i < nums.length; i++) {
      myHeap.insert(nums[i]);
      // first Node is always the highest value so no need to check if it is the top node
      result.add(myHeap.getHeap().get(0));
    }
    return result;
  }
}
