package nl.top.LeetCode;

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

  class Node {
    int value;
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
}
