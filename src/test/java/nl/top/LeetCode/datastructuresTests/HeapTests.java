package nl.top.LeetCode.datastructuresTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import nl.top.LeetCode.datastructures.Heap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HeapTests {

  @Test
  void call_insert() {
    Heap myHeap = new Heap();
    myHeap.insert(99);
    myHeap.insert(72);
    myHeap.insert(61);
    myHeap.insert(58);

    System.out.println(myHeap.getHeap());

    myHeap.insert(100);
    System.out.println(myHeap.getHeap());

    myHeap.insert(75);
    System.out.println(myHeap.getHeap());
  }

  @Test
  void call_remove() {
    Heap myHeap = new Heap();
    myHeap.insert(99);
    myHeap.insert(72);
    myHeap.insert(61);
    myHeap.insert(58);

    assertEquals(4, myHeap.getHeap().size());
    myHeap.remove();
    assertEquals(3, myHeap.getHeap().size());
  }

  @ParameterizedTest
  @MethodSource("findKtSmallest")
  void call_findKtSmallest(int[] input, int k, int output) {
    Assertions.assertEquals(output, Heap.findKthSmallest(input, k));
  }

  public static Stream<Arguments> findKtSmallest() {
    return Stream.of(
        Arguments.of(new int[] {7, 10, 4, 3, 20, 15}, 3, 7),
        Arguments.of(new int[] {2, 1, 3, 5, 6, 4}, 2, 2),
        Arguments.of(new int[] {9, 3, 2, 11, 7, 10, 4, 5}, 5, 7));
  }

  @ParameterizedTest
  @MethodSource("streamMax")
  void call_streamMax(int[] input, int[] output) {
    List<Integer> result = new ArrayList<>();
    for (int num : output) {
      result.add(num);
    }
    Assertions.assertEquals(result, Heap.streamMax(input));
  }

  public static Stream<Arguments> streamMax() {
    return Stream.of(
        Arguments.of(new int[] {1, 5, 2, 9, 3, 6, 8}, new int[] {1, 5, 5, 9, 9, 9, 9}),
        Arguments.of(new int[] {10, 2, 5, 1, 0, 11, 6}, new int[] {10, 10, 10, 10, 10, 11, 11}),
        Arguments.of(new int[] {3, 3, 3, 3, 3}, new int[] {3, 3, 3, 3, 3}));
  }
}
