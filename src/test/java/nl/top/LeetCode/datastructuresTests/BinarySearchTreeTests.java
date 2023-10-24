package nl.top.LeetCode.datastructuresTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Stream;
import nl.top.LeetCode.datastructures.BinarySearchTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    bst.rInsert(11);
    assertEquals(27, bst.root.left.right.value);
    assertEquals(82, bst.root.right.right.value);
    assertEquals(11, bst.root.left.left.left.value);
  }

  @Test
  void call_rInsert() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.rInsert(47);
    bst.rInsert(21);
    bst.rInsert(76);
    bst.rInsert(18);
    bst.rInsert(52);
    bst.rInsert(47);
    bst.rInsert(82);
    bst.rInsert(27);

    assertEquals(27, bst.root.left.right.value);
    assertEquals(82, bst.root.right.right.value);
    assertEquals(18, bst.minValue(bst.root));
    assertEquals(52, bst.minValue(bst.root.right));
    assertEquals(82, bst.minValue(bst.root.right.right));
  }

  @Test
  void call_delete() {

    BinarySearchTree bst3 = new BinarySearchTree();
    bst3.insert(3);
    bst3.insert(1);

    bst3.deleteNode(3);
    assertEquals(1, bst3.root.value);
    assertEquals(null, bst3.root.right);
    assertEquals(null, bst3.root.left);
    assertFalse(bst3.contains(3));

    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(2);
    bst.insert(1);
    bst.insert(3);

    bst.deleteNode(2);
    assertEquals(3, bst.root.value);
    assertEquals(null, bst.root.right);
    assertEquals(1, bst.root.left.value);

    bst.deleteNode(3);
    assertEquals(1, bst.root.value);
    assertEquals(null, bst.root.right);
    assertEquals(null, bst.root.left);

    bst.insert(47);
    bst.insert(21);
    bst.insert(76);
    bst.insert(18);
    bst.insert(52);
    bst.insert(82);
    bst.insert(27);

    // delete a leaf node
    bst.deleteNode(18);
    assertFalse(bst.contains(18));
    // delete a Node with 1 child
    bst.deleteNode(21); // has a child on the right
    assertFalse(bst.contains(21));
    assertEquals(1, bst.root.value);
    assertEquals(27, bst.root.right.left.value);

    bst.insert(26);
    bst.deleteNode(27); // has a child on the left
    assertEquals(26, bst.root.right.left.value);

    // delete a node with 2 children
    bst.deleteNode(76);
    assertFalse(bst.contains(76));
    assertEquals(52, bst.root.right.right.left.value);
    assertEquals(82, bst.root.right.right.value);
    assertEquals(
        52,
        bst.minValue(
            bst.root
                .right
                .right)); // it is the minimum value to the right of the current node which is 82
  }

  @ParameterizedTest
  @MethodSource("contains")
  void call_contains(boolean output, int input) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(47);
    bst.insert(21);
    bst.insert(76);
    bst.insert(18);
    bst.insert(52);
    bst.insert(82);
    bst.insert(27);
    assertEquals(output, bst.contains(input));
    assertEquals(output, bst.rContains(input));
  }

  public static Stream<Arguments> contains() {
    return Stream.of(Arguments.of(true, 27), Arguments.of(true, 82), Arguments.of(false, 45));
  }

  @Test
  void call_breadthFirstSearch() {
    BinarySearchTree myBST = new BinarySearchTree();

    myBST.insert(47);
    myBST.insert(21);
    myBST.insert(76);
    myBST.insert(18);
    myBST.insert(27);
    myBST.insert(52);
    myBST.insert(82);

    System.out.println("\nBreadth First Search:");
    System.out.println(myBST.breadthFirstSearch());
    ArrayList<Integer> results = myBST.breadthFirstSearch();
    assertEquals(47, results.get(0));
    assertEquals(27, results.get(4));
  }

  @Test
  void call_depthFirstPreOrder() {
    BinarySearchTree myBST = new BinarySearchTree();

    myBST.insert(47);
    myBST.insert(21);
    myBST.insert(76);
    myBST.insert(18);
    myBST.insert(27);
    myBST.insert(52);
    myBST.insert(82);

    System.out.println("\nDepth First Pre Order:");
    System.out.println(myBST.depthFirstSearchPreOrder());
    ArrayList<Integer> results = myBST.depthFirstSearchPreOrder();
    assertEquals(47, results.get(0));
    assertEquals(27, results.get(3));
    assertEquals(76, results.get(4));
    assertEquals(52, results.get(5));
  }

  @Test
  void call_depthFirstPostOrder() {
    BinarySearchTree myBST = new BinarySearchTree();

    myBST.insert(47);
    myBST.insert(21);
    myBST.insert(76);
    myBST.insert(18);
    myBST.insert(27);
    myBST.insert(52);
    myBST.insert(82);

    System.out.println("\nDepth First Post Order:");
    System.out.println(myBST.depthFirstSearchPostOrder());
    ArrayList<Integer> results = myBST.depthFirstSearchPostOrder();
    assertEquals(47, results.get(6));
    assertEquals(27, results.get(1));
    assertEquals(76, results.get(5));
    assertEquals(52, results.get(3));
  }

  @Test
  void call_depthFirstInOrder() {
    BinarySearchTree myBST = new BinarySearchTree();

    myBST.insert(47);
    myBST.insert(21);
    myBST.insert(76);
    myBST.insert(18);
    myBST.insert(27);
    myBST.insert(52);
    myBST.insert(82);

    System.out.println("\nDepth First In Order:");
    System.out.println(myBST.depthFirstSearchInOrder());
    ArrayList<Integer> results = myBST.depthFirstSearchInOrder();
    assertEquals(47, results.get(3));
    assertEquals(27, results.get(2));
    assertEquals(76, results.get(5));
    assertEquals(52, results.get(4));
  }

  @Test
  void call_kthSmallest() {
    BinarySearchTree bst = new BinarySearchTree();

    bst.insert(5);
    bst.insert(3);
    bst.insert(7);
    bst.insert(2);
    bst.insert(4);
    bst.insert(6);
    bst.insert(8);

    assertEquals(2, bst.kthSmallest(1));
    assertEquals(4, bst.kthSmallest(3));
    assertEquals(7, bst.kthSmallest(6));
  }
}
