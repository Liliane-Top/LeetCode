package nl.top.LeetCode;

import static nl.top.LeetCode.MySet.hasUniqueChars;
import static nl.top.LeetCode.MySet.removeDuplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MySetTests {

  @ParameterizedTest
  @MethodSource("happyFlow")
  void call_removeDuplicates(List<Integer> input, List<Integer> output) {
    Assertions.assertEquals(output, removeDuplicates(input));
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
    Assertions.assertEquals(output, hasUniqueChars(input));
  }

  public static Stream<Arguments> uniqueChars() {
    return Stream.of(
        Arguments.of("abcdefg", true),
        Arguments.of("hello", false),
        Arguments.of("", true),
        Arguments.of("0123456789", true),
        Arguments.of("abacadaeaf", false));
  }
}
