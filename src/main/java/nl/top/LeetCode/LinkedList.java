package nl.top.LeetCode;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

@Getter
public class LinkedList {

  private Node head;
  private Node tail;
  private int length;

  public LinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public class Node {
    public int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public void printAll() {
    if (length == 0) {
      System.out.println("Head: null");
      System.out.println("Tail: null");
    } else {
      System.out.println("Head: " + head.value);
      System.out.println("Tail: " + tail.value);
    }

    System.out.println("Length: " + length);
    System.out.println("\nLinkedList: ");

    if (length == 0) {
      System.out.println("empty");
    } else {
      printList();
    }
  }

  public void makeEmpty() {
    head = null;
    tail = null;
    length = 0;
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
    length++;
  }

  public Node removeLast() {
    if (length == 0) {
      return null;
    }

    Node temp = head;
    Node pre = head;

    while (temp.next != null) {
      pre = temp;
      temp = temp.next;
    }
    tail = pre;
    tail.next = null;
    length--;

    if (length == 0) {
      head = null;
      tail = null;
    }

    return temp;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {

    if (length == 0) {
      return null;
    }

    Node temp = head;
    head = head.next;
    temp.next = null;
    length--;

    if (length == 0) {
      tail = null;
    }

    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }

    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public boolean set(int index, int value) {
    Node temp = get(index);
    if (temp != null) {
      temp.value = value;
      return true;
    }
    return false;
  }

  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      return false;
    }

    if (index == 0) {
      prepend(value);
      return true;
    }

    Node newNode = new Node(value);
    Node pre = get(index - 1);

    newNode.next = pre.next;
    pre.next = newNode;
    length++;

    return true;
  }

  public Node remove(int index) {
    Node temp = get(index);
    if (temp == null) {
      return null;
    }

    if (index == 0) {
      return removeFirst();
    }

    Node pre = get(index - 1);
    pre.next = temp.next;
    temp.next = null;
    length--;
    return temp;
  }

  public void reverse() {
    Node dummy = new Node(0);
    Node temp = dummy;

    for (int i = 0; i < length; i++) {
      temp.next = get(length - 1 - i);
      temp = temp.next;
    }
    temp.next = null;
    head = dummy.next;
  }

  public void reverse3() {
    Node current = head;
    head = tail;
    tail = current;

    Node after;
    Node before = null;

    while (current != null) {
      after = current.next;
      current.next = before;
      before = current;
      current = after;
    }
  }

  public Node findMiddleNode() {

    if (head == null) {
      return null;
    }

    Node fast = head;
    Node slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public boolean hasLoop() {
    Node fast = head;
    Node slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }

  public Node findKthFromEnd(int k) {
    Node fast = head;
    Node slow = head;

    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    return slow;
  }

  public void partitionList(int x) {

    if (head == null) {
      return;
    }

    Node dummy1 = new Node(0);
    Node dummy2 = new Node(0);

    Node less = dummy1;
    Node more = dummy2;

    Node current = head;

    while (current != null) {
      if (current.value < x) {
        less.next = current;
        less = less.next;
      } else {
        more.next = current;
        more = more.next;
      }
      current = current.next;
    }

    head = dummy1.next;
    less.next = dummy2.next;
    more.next = null;
  }

  public void removeDuplicates() {
    Node current = head;

    while (current != null) {
      Node runner = current;
      while (runner.next != null) {
        if (runner.next.value == current.value) {
          runner.next = runner.next.next;
          length--;
        } else {
          runner = runner.next;
        }
      }
      current = current.next;
    }
  }

  public void removeDuplicates2() {
    Set<Integer> values = new HashSet<>();
    Node previous = null;
    Node current = head;

    while (current != null) {
      if (values.add(current.value)) {
        previous = current;
      } else {
        previous.next = current.next;
        length--;
      }
      current = current.next;
    }
  }

  public int binaryToDecimal() {
    int num = 0;
    Node current = head;
    while (current != null) {
      num = num * 2 + current.value;
      current = current.next;
    }
    return num;
  }

  public void reverseBetween(int m, int n) {
    if (head == null || m == n) return;

    Node dummy = new Node(0);
    dummy.next = head;
    Node start = dummy;

    for (int i = 0; i < m; i++) {
      start = start.next;
    }

    Node current = start.next;
    for (int i = 0; i < (n - m); i++) {
      Node temp = current.next;
      current.next = temp.next;
      temp.next = start.next;
      start.next = temp;
    }

    head = dummy.next;
  }

  public void bubbleSort() {
    if (length < 2) return;
    Node sortedUntil = tail.next; // or set it to null

    while (sortedUntil != head.next) {
      Node currentNode = head; // after each pass start with the first element in the list
      while (currentNode.next
          != sortedUntil) { // the sortedUntil moves to the left so not set to null => it will hang
        if (currentNode.value > currentNode.next.value) {
          int temp = currentNode.value;
          currentNode.value = currentNode.next.value;
          currentNode.next.value = temp;
        }
        currentNode = currentNode.next;
      }
      sortedUntil =
          currentNode; // set the marker to the last sorted element so it is moving to the left till
      // it reach 2nd element in the list
    }
  }

  public void selectionSort() {
    if (length < 2) return;

    Node current = head;
    while (current.next != null) {
      Node smallest = current;
      Node innerCurrent = smallest.next;
      while (innerCurrent != null) {
        if (smallest.value > innerCurrent.value) {
          smallest = innerCurrent;
        }
        innerCurrent = innerCurrent.next;
      }
      if (smallest != current) {
        int temp = smallest.value;
        smallest.value = current.value;
        current.value = temp;
      }
      current = current.next;
    }
    // after sorting, current is the last node. update tail
    tail = current;
  }

  public void insertionSort1() {
    if (length < 2) return;
    Node sorted = head;
    Node unsorted = sorted.next;

    while (unsorted != null) {
      Node pointer = unsorted;
      unsorted = unsorted.next;
      while (pointer != null) {
        if (pointer.value < sorted.value) {
          int temp = pointer.value;
          pointer.value = sorted.value;
          sorted.value = temp;
        }
        pointer = pointer.next;
      }
      sorted = sorted.next;
    }
  }

  public void insertionSort() {
    if (length < 2) return;
    // create a sorted list with the first element and the next element is pointing to null;
    Node sorted = head;
    Node unsorted = head.next;
    sorted.next = null;

    // iterate over the unsorted list
    while (unsorted != null) {
      Node current = unsorted;
      unsorted = unsorted.next;
      // if the current element is smaller than the item in the sorted list prepend it to the sorted
      // list
      // and update the head of the sortedList
      if (current.value < sorted.value) {
        current.next = sorted;
        sorted = current;
      } else {
        // if the current item is not smaller than the sorted item
        // find the right spot inside the sorted list
        Node pointer = sorted;
        while (pointer.next != null && current.value > pointer.next.value) {
          // move to the next element in the sorted list
          pointer = pointer.next;
        }
        // insert the current element after the pointer
        current.next = pointer.next;
        pointer.next = current;
      }
    }
    // update the head of the sortedList
    head = sorted;

    // Update the tail of the sortedList
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    tail = temp;
  }
}
