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
}
