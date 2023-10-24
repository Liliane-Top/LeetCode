package nl.top.LeetCode.datastructures;

public class Stack {
  // LIFO = last in first out push (erbij) and pop(eraf)

  private Node top;
  private int height;

  public Stack(int value) {
    Node newNode = new Node(value);
    top = newNode;
    height = 1;
  }

  class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  public void printStack() {
    Node temp = top;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public int getTop() {
    System.out.println("Top: " + top.value);
    return top.value;
  }

  public int getHeight() {
    System.out.println("Height: " + height);
    return height;
  }

  public void makeEmpty() {
    top = null;
    height = 0;
  }

  public void push(int value) {
    Node newNode = new Node(value);
    if (height == 0) {
      top = newNode;
    } else {
      newNode.next = top;
      top = newNode;
    }
    height++;
  }

  public Node pop() {
    if (height == 0) return null;
    Node temp = top;
    top = top.next;
    temp.next = null;
    height--;
    return temp;
  }
}
