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
