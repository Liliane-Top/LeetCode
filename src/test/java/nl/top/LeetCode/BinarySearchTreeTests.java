package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
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
}
