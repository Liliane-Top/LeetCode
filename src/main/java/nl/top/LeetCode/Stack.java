package nl.top.LeetCode;

public class Stack {
  // LIFO = last in first out

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
}
