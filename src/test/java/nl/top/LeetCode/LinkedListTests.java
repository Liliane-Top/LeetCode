package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
  }
}

//  }
//
//  @Test
//  void call_append_andResetHead() {
//    LinkedList list = new LinkedList(1);
//    list.append(2);
//    list.append(3);
//    list.append(4);
//    list.append(5);
//    list.append(6);
//    list.append(7);
//
//    list.printList();
//    System.out.println();
//    list.reverseBetween(2, 4);
//    list.printList();
//
//    //    LinkedList.Node head = list.getHead();
//    //
//    //    assertEquals(1, head.value);
//    //    assertNull(head.next.next);
//    //    assertEquals(1, list.getHead().value);
//
//    //    list.getHead().value =
//    //        list.getTail()
//    //            .value; // we set the value of Node that is appointed by the head to the value
// of
//    // the
//    //    // Node appointed by the Tail
//    //    assertEquals(2, list.getHead().value);
//
//    //    head = list.getHead(); // the head pointer is setting to the head pointer
//    //        head.next = head.next.next; // move the head pointer to the right
//    //    head = list.getTail();
//    //    System.out.println();
//    //    list.printList();
//    //    list.append(3);
//    //    head = list.getTail();
//    //
//    //    System.out.println();
//    //    System.out.println("Head: " + list.getHead().value);
//    //    System.out.println("Tail: " + list.getTail().value);
//    //    System.out.println("head pointer: " + head.value);
//    //
//    //    list.printList();
//    //    assertNull(head.next);
//    //    assertEquals(1, list.getHead().value);
//    //    assertEquals(head, list.getTail()); // it is pointing to the tail
//    //    		assertEquals(list.getHead(), list.getTail());//Node@37574691 Node@6a79c292
//    //        assertEquals(head, list.getTail()); //Node@37574691 Node@6a79c292// why do they not
//    // point
//    //     to the same Node?
//  }
// }
