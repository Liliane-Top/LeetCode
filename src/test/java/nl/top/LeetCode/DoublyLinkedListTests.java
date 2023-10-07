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

  @Test
  void call_removeFirst() {
    DoublyLinkedList myDDl = new DoublyLinkedList(8);

    assertEquals(8, myDDl.removeFirst().value);
    assertEquals(0, myDDl.getLength());
    assertNull(myDDl.removeFirst());

    myDDl.append(9);
    myDDl.append(10);
    myDDl.append(11);
    assertEquals(9, myDDl.removeFirst().value);
    assertEquals(10, myDDl.getHead().value);
    assertEquals(11, myDDl.getTail().value);
  }

  @Test
  void call_get() {
    DoublyLinkedList myDDl = new DoublyLinkedList(1);
    myDDl.append(2);
    myDDl.append(3);
    myDDl.append(4);

    assertEquals(2, myDDl.get(1).value);
    assertEquals(3, myDDl.get(2).value);
    myDDl.append(5);
    assertEquals(3, myDDl.get(2).value);

    myDDl.printList();
  }

  @Test
  void call_set() {
    DoublyLinkedList myDDl = new DoublyLinkedList(1);
    myDDl.append(2);
    myDDl.append(3);
    myDDl.append(4);

    assertTrue(myDDl.set(2, 6));
    assertEquals(4, myDDl.getLength());
    assertEquals(6, myDDl.get(2).value);
    assertEquals(4, myDDl.get(3).value);
    assertFalse(myDDl.set(5, 10));

    myDDl.printList();
  }

  @Test
  void call_insert() {
    DoublyLinkedList myDDl = new DoublyLinkedList(1);
    myDDl.append(2);
    myDDl.append(3);
    myDDl.append(4);

    assertTrue(myDDl.insert(2, 6));
    assertEquals(5, myDDl.getLength());
    assertEquals(6, myDDl.get(2).value);
    assertEquals(3, myDDl.get(3).value);
    assertEquals(4, myDDl.get(4).value);
    assertFalse(myDDl.insert(6, 10));
    assertTrue(myDDl.insert(0, 21));
    assertEquals(6, myDDl.getLength());
    assertEquals(21, myDDl.getHead().value);
  }

  @Test
  void call_remove() {
    DoublyLinkedList myDDl = new DoublyLinkedList(1);
    myDDl.append(2);
    myDDl.append(3);
    myDDl.append(4);

    assertEquals(3, myDDl.remove(2).value);
    assertEquals(3, myDDl.getLength());
    assertEquals(4, myDDl.remove(2).value);
    assertNull(myDDl.remove(3));
    assertNull(myDDl.remove(-1));
    assertEquals(1, myDDl.remove(0).value);
    assertEquals(2, myDDl.remove(0).value);
    assertNull(myDDl.remove(0));
  }

  @Test
  void call_swapFirstLast() {
    DoublyLinkedList myDDl = new DoublyLinkedList(1);
    myDDl.append(2);
    myDDl.append(3);
    myDDl.append(4);

    myDDl.swapFirstLast();

    assertEquals(4, myDDl.getHead().value);
    assertEquals(1, myDDl.getTail().value);
  }
}
