package nl.top.LeetCode;

public class Queue {
  // FIFO first in first out
  private Node first;
  private Node last;
  private int length;

  public Queue(int value) {
    Node newNode = new Node(value);
    first = newNode;
    last = newNode;
    length = 1;
  }

  class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  public void printQueue() {
    Node temp = first;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public int getFirst() {
    System.out.println("First: " + first.value);
    return first.value;
  }

  public int getLast() {
    System.out.println("Last: " + last.value);
    return last.value;
  }

  public int getLength() {
    System.out.println("Length: " + length);
    return length;
  }

  public void enqueue(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      first = newNode;
      last = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    length++;
  }

  public Node dequeue() {
    if (length == 0) return null;

    Node temp = first;
    if (length == 1) {
      first = null;
      last = null;
    } else {
      first = first.next;
      temp.next = null;
    }

    length--;
    return temp;
  }
}
