package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DoublyLinkedLIstTests {

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
}
