package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LinkedListTests {

  @Test
  void call_append_and_printList() {
    LinkedList list = new LinkedList(1);
    list.append(2);
    list.printList();

    assertEquals(1, list.getHead().value);
    assertEquals(2, list.getHead().next.value);
    assertEquals(2, list.getTail().value);
    assertNull(list.getTail().next);

    list.makeEmpty();
    assertEquals(null, list.getHead());
    assertEquals(null, list.getTail());
    assertEquals(0, list.getLength());
    list.append(5);
    assertEquals(1, list.getLength());
    assertEquals(5, list.getHead().value);
    assertEquals(5, list.getTail().value);
  }

  @Test
  void call_removeLast() {
    LinkedList list = new LinkedList(5);
    list.append(8);
    list.append(3);
    list.append(89);
    list.append(6);

    list.printList();
    list.removeLast();
    list.printList();
    assertEquals(4, list.getLength());
    assertEquals(89, list.getTail().value);

    list.removeLast();
    list.printList();
    assertEquals(3, list.getLength());
    assertEquals(3, list.getTail().value);
    assertEquals(3, list.removeLast().value);
    assertEquals(8, list.removeLast().value);
    assertEquals(5, list.removeLast().value);
    assertEquals(null, list.removeLast());
    assertEquals(0, list.getLength());
    assertNull(list.getHead());
    assertNull(list.getTail());
  }

  @Test
  void call_prepend() {
    LinkedList list = new LinkedList(45);
    list.prepend(34);

    assertEquals(2, list.getLength());
    assertEquals(34, list.getHead().value);
    assertEquals(45, list.getTail().value);

    list.append(78);
    list.prepend(3);
    assertEquals(4, list.getLength());
    assertEquals(3, list.getHead().value);
    assertEquals(78, list.getTail().value);
  }

  @Test
  void call_removeFirst() {
    LinkedList list = new LinkedList(5);
    list.append(3);
    list.append(89);
    list.prepend(67);

    assertEquals(4, list.getLength());
    assertEquals(67, list.getHead().value);
    assertEquals(89, list.getTail().value);

    assertEquals(67, list.removeFirst().value);
    assertEquals(3, list.getLength());
    assertEquals(89, list.getTail().value);

    assertEquals(5, list.removeFirst().value);
    assertEquals(2, list.getLength());
    assertEquals(3, list.removeFirst().value);
    assertEquals(89, list.removeFirst().value);
    assertNull(list.removeFirst());
    assertNull(list.getHead());
    assertNull(list.getTail());
  }

  @Test
  void call_get() {
    LinkedList list = new LinkedList(5);
    list.append(3);
    list.append(89);
    list.append(67);

    assertEquals(5, list.get(0).value);
    assertEquals(3, list.get(1).value);
    assertEquals(89, list.get(2).value);
    assertEquals(67, list.get(3).value);
    assertNull(list.get(4));
    assertNull(list.get(-1));
  }

  @Test
  void call_set() {
    LinkedList list = new LinkedList(5);
    list.append(3);
    list.append(89);
    list.append(67);

    list.set(2, 7);
    assertEquals(4, list.getLength());
    assertEquals(7, list.get(2).value);

    assertTrue(list.set(1, 235));
    assertEquals(235, list.get(1).value);
    assertEquals(67, list.get(3).value);
    assertFalse(list.set(10, 34));
    assertFalse(list.set(-1, 34));

    list.makeEmpty();

    assertFalse(list.set(0, 55));
  }

  @Test
  void call_insert() {
    LinkedList list = new LinkedList(5);
    list.append(3);
    list.append(89);
    list.append(67);

    assertTrue(list.insert(2, 81));
    assertEquals(5, list.getLength());
    assertFalse(list.insert(-1, 67));
    assertFalse(list.insert(6, 67));
    assertEquals(81, list.get(2).value);
    assertEquals(89, list.get(3).value);
    assertTrue(list.insert(0, 125));
    assertEquals(125, list.get(0).value);
    assertEquals(5, list.get(1).value);
  }

  @Test
  void call_remove() {
    LinkedList list = new LinkedList(5);
    list.append(3);
    list.append(89);
    list.append(67);

    assertEquals(null, list.remove(4));
    assertEquals(null, list.remove(-1));
    assertEquals(89, list.remove(2).value);
    assertEquals(5, list.remove(0).value);
    assertEquals(2, list.getLength());
    assertEquals(67, list.remove(1).value);
  }

  @Test
  void call_reverse() {
    LinkedList list = new LinkedList(1);
    list.append(2);
    list.append(3);
    list.append(4);

    list.printList();
    list.reverse3();
    System.out.println("print reversed list");
    list.printList();

    assertEquals(1, list.get(list.getLength() - 1).value);
    assertEquals(4, list.get(0).value);
  }

  @Test
  void call_findMiddleNode() {
    LinkedList list = new LinkedList(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);

    assertEquals(3, list.findMiddleNode().value);

    list.append(6);
    assertEquals(4, list.findMiddleNode().value);

    list.makeEmpty();
    assertNull(list.findMiddleNode());
  }

  @Test
  void call_hasLoop() {
    LinkedList list = new LinkedList(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);

    assertFalse(list.hasLoop());

    list.getTail().next = list.getHead().next;

    assertTrue(list.hasLoop());
  }
}
