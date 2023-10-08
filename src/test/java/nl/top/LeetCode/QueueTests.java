package nl.top.LeetCode;

import org.junit.jupiter.api.Test;

public class QueueTests {

  @Test
  void call_constructor() {
    Queue myQueue = new Queue(7);

    myQueue.getFirst();
    myQueue.getLast();
    myQueue.getLength();
    myQueue.printQueue();
  }

  @Test
  void call_enqueue() {
    Queue myQueue = new Queue(7);
  }

  @Test
  void call_MyQueue_enqueue() {
    MyQueue q = new MyQueue();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);

    System.out.println("front of the queue: " + q.peek());
    System.out.println("Is the queue empty? " + q.isEmpty());
  }
}
