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
}
