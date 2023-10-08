package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTests {

  @Test
  void call_constructor() {
    BinarySearchTree bst = new BinarySearchTree();
    System.out.println("Root = " + bst.root);
  }

  @Test
  void call_insert() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(47);
    bst.insert(21);
    bst.insert(76);
    bst.insert(18);
    bst.insert(52);

    bst.insert(82);
    bst.insert(27);

    assertEquals(27, bst.root.left.right.value);
    assertEquals(82, bst.root.right.right.value);
  }

  @Test
  void call_contains() {

    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(47);
    bst.insert(21);
    bst.insert(76);
    bst.insert(18);
    bst.insert(52);
    bst.insert(82);
    bst.insert(27);

    assertTrue(bst.contains(27));
    assertTrue(bst.contains(82));
    assertFalse(bst.contains(45));
  }
}
