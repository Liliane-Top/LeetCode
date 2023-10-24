package nl.top.LeetCode.datastructures;

public class MyQueue { // FIFO first in is First out "denk aan een rij mensen voor loket"
  private Stack2<Integer> stack1;
  private Stack2<Integer> stack2;

  public MyQueue() {
    stack1 = new Stack2<>();
    stack2 = new Stack2<>();
  }

  public void enqueue(int value) {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    stack1.push(value);
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
  }

  public Integer dequeue() {
    if (stack1.isEmpty()) return null;
    return stack1.pop();
  }

  public int peek() {
    return stack1.peek();
  }

  public boolean isEmpty() {
    return stack1.isEmpty();
  }
}
