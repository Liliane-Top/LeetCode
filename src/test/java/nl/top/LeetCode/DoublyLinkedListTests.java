package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListTests {

  @Test
  void call_constructor() {
    DoublyLinkedList myDDL = new DoublyLinkedList(7);
    myDDL.getHead();
    myDDL.getTail();
    myDDL.getLength();

    myDDL.printList();
  }

  @Test
  void call_append() {
    DoublyLinkedList myDDl = new DoublyLinkedList(8);
    myDDl.append(9);

    assertEquals(2, myDDl.getLength());
    myDDl.printList();

    myDDl.append(2);
    assertEquals(3, myDDl.getLength());
  }

  @Test
  void call_removeLast() {
    DoublyLinkedList myDDl = new DoublyLinkedList(8);
    myDDl.append(9);
    myDDl.append(10);

    assertEquals(10, myDDl.removeLast().value);
    assertEquals(2, myDDl.getLength());
    assertEquals(9, myDDl.removeLast().value);
    assertEquals(1, myDDl.getLength());
    assertEquals(8, myDDl.removeLast().value);
    assertEquals(0, myDDl.getLength());
    assertNull(myDDl.removeLast());
  }

  @Test
  void call_prepend() {
    DoublyLinkedList myDDl = new DoublyLinkedList(8);
    myDDl.prepend(7);
    assertEquals(2, myDDl.getLength());

    myDDl.makeEmpty();
    myDDl.prepend(10);
    assertEquals(1, myDDl.getLength());
    myDDl.prepend(23);
    assertEquals(2, myDDl.getLength());
    assertEquals(23, myDDl.getHead().value);
    myDDl.printList();
  }
}
