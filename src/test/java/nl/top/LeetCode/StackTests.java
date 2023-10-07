package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTests {

  @Test
  void call_stack() {
    Stack myStack = new Stack(4);

    myStack.getTop();
    myStack.getHeight();
    myStack.printStack();
  }

  @Test
  void call_push() {
    Stack myStack = new Stack(4);
    myStack.printStack();

    myStack.push(5);
    myStack.printStack();
    assertEquals(2, myStack.getHeight());
    assertEquals(5, myStack.getTop());
  }

  @Test
  void call_pop() {
    Stack myStack = new Stack(4);
    myStack.printStack();

    myStack.push(5);
    myStack.printStack();
    myStack.pop();
    myStack.printStack();
    assertEquals(5, myStack.getTop());
  }
}
