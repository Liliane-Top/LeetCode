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
}
