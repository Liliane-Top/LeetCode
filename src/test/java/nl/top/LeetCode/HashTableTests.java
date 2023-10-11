package nl.top.LeetCode;

import static nl.top.LeetCode.HashTable.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HashTableTests {

  @Test
  void call_constructor() {
    HashTable myHashTable = new HashTable();

    myHashTable.set("nails", 100);
    myHashTable.set("tile", 50);
    myHashTable.set("lumber", 80);
    myHashTable.set("bolts", 200);
    myHashTable.set("screws", 140);

    myHashTable.printTable();

    myHashTable.set("screws", 100);
    myHashTable.printTable();

    assertEquals(240, myHashTable.get("screws"));
    assertEquals(100, myHashTable.get("nails"));
    assertEquals(80, myHashTable.get("lumber"));
    assertEquals(0, myHashTable.get("pins"));

    myHashTable.printTable();

    assertEquals(
        new ArrayList<>(Arrays.asList("screws", "bolts", "nails", "tile", "lumber")),
        myHashTable.keys());
  }

  @Test
  void call_itemInCommon() {

    int[] array1 = {1, 3, 5};
    int[] array2 = {2, 4, 5};
    assertTrue(itemInCommon(array1, array2));

    int[] array3 = {1, 3, 5};
    int[] array4 = {2, 4, 6};

    assertFalse(itemInCommon(array3, array4));
  }

  @Test
  void call_findDuplicates() {
    int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
    assertEquals(new ArrayList<>(Arrays.asList(1, 2, 4)), findDuplicates(nums));

    int[] nums2 = {1, 2, 3, 4, 5};
    assertEquals(new ArrayList<>(), findDuplicates(nums2));

    int[] nums3 = {3, 3, 3, 3, 3};
    assertEquals(new ArrayList<>(Arrays.asList(3)), findDuplicates(nums3));

    int[] nums4 = {-1, 0, 1, 0, -1, -1, 2, 2};
    assertEquals(new ArrayList<>(Arrays.asList(-1, 0, 2)), findDuplicates(nums4));

    int[] nums5 = {};
    assertEquals(new ArrayList<>(), findDuplicates(nums5));
  }

  @Test
  void call_firstNonRepeatingChar() {
    assertEquals('l', firstNonRepeating("leetcode"));
    assertEquals('h', firstNonRepeating("hello"));
    assertEquals(null, firstNonRepeating(""));
    assertEquals(null, firstNonRepeating("aabbcc")); // as every char is repeated
    assertEquals('b', firstNonRepeating("aabcc"));
    assertEquals('a', firstNonRepeating("a"));
    assertEquals('&', firstNonRepeating("aa&"));
    assertEquals('a', firstNonRepeating("ab"));
    assertEquals('!', firstNonRepeating("1a@@a!11"));
    assertEquals('a', firstNonRepeating("1, abcde45671, "));
  }

  @Test
  void call_groupsAnagrams() {
    String[] input = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> output = new ArrayList<>();
    output.add(new ArrayList<>(Arrays.asList("eat", "tea", "ate")));
    output.add(new ArrayList<>(Arrays.asList("bat")));
    output.add(new ArrayList<>(Arrays.asList("tan", "nat")));
    assertEquals(output, HashTable.groupAnagrams(input));

    String[] input2 = new String[] {"abc", "cba", "bac", "foo", "bar"};
    List<List<String>> output2 = new ArrayList<>();
    output2.add(new ArrayList<>(Arrays.asList("bar")));
    output2.add(new ArrayList<>(Arrays.asList("abc", "cba", "bac")));
    output2.add(new ArrayList<>(Arrays.asList("foo")));
    assertEquals(output2, HashTable.groupAnagrams(input2));

    String[] input3 = new String[] {"listen", "silent", "triangle", "integral", "garden", "ranged"};
    List<List<String>> output3 = new ArrayList<>();
    output3.add(new ArrayList<>(Arrays.asList("listen", "silent")));
    output3.add(new ArrayList<>(Arrays.asList("triangle", "integral")));
    output3.add(new ArrayList<>(Arrays.asList("garden", "ranged")));
    assertEquals(output3, HashTable.groupAnagrams(input3));
  }

  @ParameterizedTest
  @MethodSource("happyFlow")
  void call_twoSum(int[] input, int target, int[] output) {
    assertEquals(Arrays.toString(output), Arrays.toString(HashTable.twoSum(input, target)));
  }

  public static Stream<Arguments> happyFlow() {
    return Stream.of(
        Arguments.of(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
        Arguments.of(new int[] {3, 2, 4}, 6, new int[] {1, 2}),
        Arguments.of(new int[] {3, 3}, 6, new int[] {0, 1}),
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 10, new int[] {}),
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 7, new int[] {2, 3}),
        Arguments.of(new int[] {}, 0, new int[] {}));
  }

  @ParameterizedTest
  @MethodSource("subarraySum")
  void call_subarraySum(int[] input, int target, int[] output) {
    assertEquals(Arrays.toString(output), Arrays.toString(HashTable.subarraySum(input, target)));
  }

  public static Stream<Arguments> subarraySum() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 9, new int[] {1, 3}),
        Arguments.of(new int[] {1, 2, 3, 4, -4, -3, 12}, 12, new int[] {6, 6}),
        Arguments.of(new int[] {-1, 2, 3, -4, 5}, 0, new int[] {0, 3}),
        Arguments.of(new int[] {1}, 1, new int[] {0, 0}),
        Arguments.of(new int[] {2, 3, 4, 5, 6}, 3, new int[] {1, 1}),
        Arguments.of(new int[] {}, 0, new int[] {}),
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 345, new int[] {}));
  }
}
