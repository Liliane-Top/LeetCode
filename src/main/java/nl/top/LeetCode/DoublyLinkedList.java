package nl.top.LeetCode;

import lombok.Getter;

@Getter
public class DoublyLinkedList {

  private Node head;
  private Node tail;
  private int length;

  public DoublyLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
      this.value = value;
    }
  }

  public Node getHead() {
    System.out.println("Head: " + head.value);
    return head;
  }

  public Node getTail() {
    System.out.println("Tail: " + tail.value);
    return tail;
  }

  public int getLength() {
    System.out.println("Length: " + length);
    return length;
  }

  public void printList() {
    DoublyLinkedList.Node temp = head;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public void makeEmpty() {
    head = null;
    tail = null;
    length = 0;
  }

  public void append(int value) {

    Node newNode = new Node(value);

    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
    }
    tail = newNode;
    length++;
  }

  public Node removeLast() {
    if (length == 0) return null;
    Node temp = tail;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      tail = tail.prev;
      tail.next = null;
      temp.prev = null;
    }
    length--;
    return temp;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);

    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) {
      return null;
    }
    Node temp = head;

    if (length == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.prev = null;
      temp.next = null;
    }
    length--;
    return temp;
  }

  public Node get(int index) {
    if (length == 0) return null;
    if (index < 0 || index > length - 1) return null;

    Node temp = head;
    if (index < length / 2) { // if index is in first half => start at head
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
    } else { // if index is in second half => start at tail
      temp = tail;
      for (int i = length - 1; i > index; i--) {
        temp = temp.prev;
      }
    }
    return temp;
  }

  public boolean set2(int index, int value) {
    if (index < 0 || index > length) return false;

    Node current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    current.value = value;

    return true;
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
    if (index < 0 || index > length) return false;

    if (index == 0) {
      prepend(value);
      return true;
    }

    if (index == length) {
      append(value);
      return true;
    }

    Node newNode = new Node(value);
    Node before = get(index - 1);
    Node after = before.next;

    newNode.prev = before;
    newNode.next = after;
    before.next = newNode;
    after.prev = newNode;

    length++;
    return true;
  }

  public Node remove(int index) {
    if (index < 0 || index > length) return null;
    if (index == 0) return removeFirst();
    if (index == length - 1) return removeLast();

    Node temp = get(index);

    temp.next.prev = temp.prev;
    temp.prev.next = temp.next;
    temp.next = null;
    temp.prev = null;

    length--;
    return temp;
  }

  public void swapFirstLast() {
    if (length < 2) return;

    int headValue = head.value;
    int tailValue = tail.value;

    head.value = tailValue;
    tail.value = headValue;
  }
}
