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
    assertEquals(4, myStack.getTop());
  }

  @Test
  void call_pushStack2() {
    Stack2 myStack = new Stack2();
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);

    myStack.printStack();

    assertEquals(1, myStack.getStackList().get(0));
    assertEquals(2, myStack.getStackList().get(1));
    assertEquals(3, myStack.getStackList().get(myStack.size() - 1));

    Stack2 stack = new Stack2();
    stack.push("Hello, ");
    stack.push("Beste ");
    stack.push("Liliane");

    stack.printStack(); // prints last element first => reversed order.

    assertEquals(3, myStack.size());

    assertEquals("Liliane", stack.pop());
    assertEquals("Hello, ", stack.getStackList().get(0));
    assertEquals("Beste ", stack.getStackList().get(1));

    assertEquals("Beste ", stack.pop());
    assertEquals("Hello, ", stack.pop());
    assertNull(stack.pop());
  }
}
