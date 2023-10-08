package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    assertEquals(1, q.peek());
    assertFalse(q.isEmpty());
  }

  @Test
  void call_MyQueue_dequeue() {
    MyQueue q = new MyQueue();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);

    assertEquals(1, q.peek());
    assertEquals(1, q.dequeue());
    assertEquals(2, q.dequeue());

    q.enqueue(4);
    assertEquals(3, q.peek());
    assertEquals(3, q.dequeue());
    assertEquals(4, q.dequeue());
    assertTrue(q.isEmpty());

    // Dequeue from an empty queue and check if it returns null
    assertNull(q.dequeue());
  }
}
