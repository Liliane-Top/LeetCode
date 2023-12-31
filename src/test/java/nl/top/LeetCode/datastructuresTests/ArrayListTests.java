package nl.top.LeetCode.datastructuresTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import nl.top.LeetCode.datastructures.ArrayList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ArrayListTests {

  @ParameterizedTest
  @MethodSource("happyFlow")
  void call_removeElement(int[] input, int value, int output) {
    assertEquals(output, ArrayList.removeElement(input, value));
  }

  public static Stream<Arguments> happyFlow() {
    return Stream.of(
        of(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}, 1, 7),
        of(new int[] {1, 2, 3, 4, 5, 6}, 6, 5),
        of(new int[] {-1, -2, -3, -4, -5}, -1, 4),
        of(new int[] {}, 1, 0),
        of(new int[] {1, 1, 1, 1, 1}, 1, 0));
  }

  @ParameterizedTest
  @MethodSource("happyFlow2")
  void call_findMaxMin(int[] input, int[] output) {
    assertEquals(Arrays.toString(output), Arrays.toString(ArrayList.findMaxMin(input)));
  }

  public static Stream<Arguments> happyFlow2() {
    return Stream.of(
        of(new int[] {5, 3, 8, 1, 6, 9}, new int[] {9, 1}),
        of(new int[] {-5, -3, -8, -1, -6, -9}, new int[] {-1, -9}),
        of(new int[] {0, 0, 0, 0, 0}, new int[] {0, 0}),
        of(new int[] {100, 200, 300, 400, 500}, new int[] {500, 100}));
  }

  @ParameterizedTest
  @MethodSource("happyFlow3")
  void call_longestString(String[] input, String output) {
    assertEquals(output, ArrayList.findLongestString(input));
  }

  public static Stream<Arguments> happyFlow3() {
    return Stream.of(
        of(new String[] {"apple", "banana", "kiwi", "pear"}, "banana"),
        of(new String[] {"cat", "giraffe", "elephant", "hippopotamus"}, "hippopotamus"),
        of(new String[] {"sun", "moon", "planet", "universe"}, "universe"),
        of(new String[] {"java", "python", "javascript", "c"}, "javascript"),
        of(new String[] {"", "a", "aa", "aaa"}, "aaa"),
        of(new String[] {"", "a", "bbb", "aa", "aaa"}, "bbb"));
  }

  @ParameterizedTest
  @MethodSource("happyFlow4")
  void call_removeDuplicates(int[] input, int output) {
    assertEquals(output, ArrayList.removeDuplicates(input));
  }

  public static Stream<Arguments> happyFlow4() {
    return Stream.of(
        of(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5),
        of(new int[] {1, 1, 2}, 2),
        of(new int[] {-1, 0, 0, 0, 3, 3}, 3),
        of(new int[] {}, 0),
        of(new int[] {5}, 1),
        of(new int[] {5, 5}, 1),
        of(new int[] {1, 1, 1, 1, 1}, 1));
  }

  @ParameterizedTest
  @MethodSource("maxProfit")
  void call_maxProfit(int[] input, int output) {
    assertEquals(output, ArrayList.maxProfit(input));
  }

  public static Stream<Arguments> maxProfit() {
    return Stream.of(
        of(new int[] {7, 1, 5, 3, 6, 4}, 5),
        of(new int[] {7, 6, 5, 4, 3, 2, 1}, 0),
        of(new int[] {1, 2, 3, 4, 5, 6, 7}, 6),
        of(new int[] {3, 2, 6, 5, 0, 3}, 4),
        of(new int[] {2, 4, 1}, 2));
  }

  @ParameterizedTest
  @MethodSource("rotate")
  void call_rotate(int[] array, int k, int[] output) {
    ArrayList.rotate(array, k);
    assertEquals(Arrays.toString(output), Arrays.toString(array));
  }

  public static Stream<Arguments> rotate() {
    return Stream.of(
        of(new int[] {1, 2, 3, 4, 5, 6, 7}, 3, new int[] {5, 6, 7, 1, 2, 3, 4}),
        of(new int[] {-1, -100, 3, 99}, 2, new int[] {3, 99, -1, -100}),
        of(new int[] {1, 2}, 3, new int[] {2, 1}),
        of(new int[] {1}, 0, new int[] {1}),
        of(new int[] {1, 2, 3, 4, 5, 6}, 6, new int[] {1, 2, 3, 4, 5, 6}));
  }

  @ParameterizedTest
  @MethodSource("maxSubarray")
  void call_maxSubarray(int[] input, int sum) {
    assertEquals(sum, ArrayList.maxSubarray(input));
  }

  public static Stream<Arguments> maxSubarray() {
    return Stream.of(
        of(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
        of(new int[] {1, 2, 3, -4, 5, 6}, 13),
        of(new int[] {-1, -2, -3, -4, -5}, -1),
        of(new int[] {1, -1, 1, -1, 1}, 1),
        of(new int[] {}, 0));
  }
}
