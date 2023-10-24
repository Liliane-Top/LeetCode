package nl.top.LeetCode.sortingMethodsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.top.LeetCode.datastructures.LinkedList;
import nl.top.LeetCode.sortingMethods.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BubbleSortTests {

  @Test
  void call_bubbleSort() {
    int[] array = new int[] {2, 4, 6, 1, 3, 5};
    BubbleSort.bubbleSort(array);

    Assertions.assertEquals(1, array[0]);
    Assertions.assertEquals(2, array[1]);
    Assertions.assertEquals(3, array[2]);
    Assertions.assertEquals(4, array[3]);
    Assertions.assertEquals(5, array[4]);
    Assertions.assertEquals(6, array[5]);
  }

  @Test
  void call_bubbleSortWithLL() {

    LinkedList myLinkedList = new LinkedList(4);
    myLinkedList.append(2);
    myLinkedList.append(6);
    myLinkedList.append(5);
    myLinkedList.append(1);
    myLinkedList.append(3);

    System.out.println("Unsorted Linked List:");
    myLinkedList.printList();

    myLinkedList.bubbleSort();

    System.out.println("\nSorted Linked List:");
    myLinkedList.printList();

    assertEquals(1, myLinkedList.get(0).value);
    assertEquals(2, myLinkedList.get(1).value);
    assertEquals(3, myLinkedList.get(2).value);
    assertEquals(4, myLinkedList.get(3).value);
    assertEquals(5, myLinkedList.get(4).value);
    assertEquals(6, myLinkedList.get(5).value);
  }
}
