package nl.top.LeetCode;

import org.junit.jupiter.api.Test;

public class StackTests {

  @Test
  void call_stack() {
    Stack myStack = new Stack(4);

    myStack.getTop();
    myStack.getHeight();
    myStack.printStack();
  }
}
