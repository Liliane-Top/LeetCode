package nl.top.LeetCode.datastructuresTests;

import static nl.top.LeetCode.datastructures.MySet.hasUniqueChars;
import static nl.top.LeetCode.datastructures.MySet.removeDuplicates;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import nl.top.LeetCode.datastructures.MySet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MySetTests {

  @ParameterizedTest
  @MethodSource("happyFlow")
  void call_removeDuplicates(List<Integer> input, List<Integer> output) {
    assertEquals(output, removeDuplicates(input));
  }

  public static Stream<Arguments> happyFlow() {
    return Stream.of(
        Arguments.of(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5)),
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))));
  }

  @ParameterizedTest
  @MethodSource("uniqueChars")
  void call_hasUniqueChars(String input, Boolean output) {
    assertEquals(output, hasUniqueChars(input));
  }

  public static Stream<Arguments> uniqueChars() {
    return Stream.of(
        Arguments.of("abcdefg", true),
        Arguments.of("hello", false),
        Arguments.of("", true),
        Arguments.of("0123456789", true),
        Arguments.of("abacadaeaf", false));
  }

  @ParameterizedTest
  @MethodSource("findPairs")
  void call_findPairs(int[] input1, int[] input2, int target, List<int[]> output) {
    List<int[]> result = MySet.findPairs(input1, input2, target);
    assertEquals(Arrays.toString(output.get(0)), Arrays.toString(result.get(0)));
  }

  public static Stream<Arguments> findPairs() {
    return Stream.of(
        Arguments.of(
            new int[] {1, 2, 3, 4, 5},
            new int[] {2, 4, 6, 8, 10},
            7,
            new ArrayList<>(Arrays.asList(new int[] {1, 6}, new int[] {3, 4}, new int[] {5, 2}))));
  }

  @ParameterizedTest
  @MethodSource("consecutive")
  void call_longestConsecutiveSequence(int[] input, int output) {
    assertEquals(output, MySet.longestConsecutiveSequence(input));
  }

  public static Stream<Arguments> consecutive() {
    return Stream.of(
        Arguments.of(new int[] {100, 4, 200, 1, 3, 2}, 4),
        Arguments.of(
            new int[] {
              3, 3, 3,
            },
            1),
        Arguments.of(new int[] {5}, 1),
        Arguments.of(new int[] {}, 0),
        Arguments.of(new int[] {1, 2, 3, 1, 2, 3, 1, 2, 3}, 3),
        Arguments.of(new int[] {0, 5, -4, 6, -3, -2, 10, -1}, 5),
        Arguments.of(new int[] {1, 3, 5, 7, 9, -1}, 1));
  }
}
