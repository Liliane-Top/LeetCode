package nl.top.LeetCode;

import static nl.top.LeetCode.HashTable.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    Assertions.assertEquals(new ArrayList<>(Arrays.asList(1, 2, 4)), findDuplicates(nums));

    int[] nums2 = {1, 2, 3, 4, 5};
    Assertions.assertEquals(new ArrayList<>(), findDuplicates(nums2));

    int[] nums3 = {3, 3, 3, 3, 3};
    Assertions.assertEquals(new ArrayList<>(Arrays.asList(3)), findDuplicates(nums3));

    int[] nums4 = {-1, 0, 1, 0, -1, -1, 2, 2};
    Assertions.assertEquals(new ArrayList<>(Arrays.asList(-1, 0, 2)), findDuplicates(nums4));

    int[] nums5 = {};
    Assertions.assertEquals(new ArrayList<>(), findDuplicates(nums5));
  }
}
