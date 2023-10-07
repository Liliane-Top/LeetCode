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

  public void getHead() {
    System.out.println("Head: " + head.value);
  }

  public void getTail() {
    System.out.println("Tail: " + tail.value);
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
    return null;
  }
}
