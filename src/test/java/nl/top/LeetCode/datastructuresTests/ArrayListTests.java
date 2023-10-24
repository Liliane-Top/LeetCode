package nl.top.LeetCode.datastructuresTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

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

	public static Stream<Arguments> happyFlow(){
		return Stream.of(
				of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 1, 7),
				of(new int[]{1, 2, 3, 4, 5, 6}, 6, 5),
				of(new int[]{-1, -2, -3, -4, -5}, -1, 4),
				of(new int[]{}, 1, 0),
				of(new int[]{1, 1, 1, 1, 1}, 1, 0)
		);
	}
}
