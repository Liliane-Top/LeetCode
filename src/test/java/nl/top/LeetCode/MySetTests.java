package nl.top.LeetCode;

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
}
