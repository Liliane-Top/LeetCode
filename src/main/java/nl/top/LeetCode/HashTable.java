package nl.top.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashTable {

  private int size = 7;
  Node[] dataMap;

  public HashTable() {
    dataMap = new Node[size];
  }

  public Node[] getDataMap() {
    return dataMap;
  }

  public void printTable() {
    for (int i = 0; i < dataMap.length; i++) {
      System.out.println(i + ":");
      Node temp = dataMap[i];
      while (temp != null) {
        System.out.println(" {" + temp.key + "= " + temp.value + "}");
        temp = temp.next;
      }
    }
  }

  private int hash(String key) {
    int hash = 0;
    char[] keyChars = key.toCharArray();
    for (int i = 0; i < keyChars.length; i++) {
      int asciiValue = keyChars[i];
      hash = (hash + asciiValue * 23) % dataMap.length;
    }
    return hash;
  }

  public void set(String key, int value) {
    Node newNode = new Node(key, value);
    int index = hash(key);
    if (dataMap[index] == null) {
      dataMap[index] = newNode;
    } else {
      Node temp = dataMap[index];
      if (temp.key == key) {
        temp.value += value;
        return;
      }
      while (temp.next != null) {
        temp = temp.next;
        if (temp.key == key) {
          temp.value += value;
          return;
        }
      }
      temp.next = newNode;
    }
  }

  public int get(String key) {
    int index = hash(key);
    Node temp = dataMap[index];
    while (temp != null) {
      if (temp.key == key) {
        return temp.value;
      } else {
        temp = temp.next;
      }
    }
    return 0;
  }

  public ArrayList<String> keys() {
    ArrayList<String> allKeys = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      Node temp = dataMap[i];
      while (temp != null) {
        allKeys.add(temp.key);
        temp = temp.next;
      }
    }
    return allKeys;
  }

  class Node {
    String key;
    int value;
    Node next;

    public Node(String key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public static boolean itemInCommon(int[] array1, int[] array2) {
    HashMap<Integer, Boolean> map = new HashMap<>();

    for (int number : array1) {
      map.put(number, true);
    }
    for (int number : array2) {
      if (map.get(number) != null) return true;
    }
    return false;
  }

  //  public static List<Integer> findDuplicates(int[] nums) {
  //    List<Integer> duplicates = new ArrayList<>();
  //    Map<Integer, String> map = new HashMap<>();
  //
  //    for (int number : nums) {
  //      if (map.get(number) == null) {
  //        map.put(number, "first");
  //      } else if (!map.get(number).contains("second")) {
  //        map.put(number, "second");
  //        duplicates.add(number);
  //      }
  //    }
  //    Collections.sort(duplicates);
  //    return duplicates;
  //  }

  public static List<Integer> findDuplicates(int[] nums) {

    Map<Integer, Integer> numCounts = new HashMap<>();
    for (int num : nums) {
      numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
    }

    List<Integer> duplicates = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) { // automatically sorted
      if (entry.getValue() > 1) {
        duplicates.add(entry.getKey());
      }
    }
    return duplicates;
  }

  public static Character firstNonRepeating2(String input) {
    Map<Character, Integer> letters = new HashMap<>();
    List<Character> singles = new ArrayList<>();

    for (Character letter : input.toCharArray()) {
      if (letters.get(letter) == null) { // if it is not in the map add to map and to list
        letters.put(letter, 1);
        singles.add(letter);
      } else if (singles.contains(letter)) { // if it is in the map and in the list remove it.
        singles.remove(letter);
      }
    }
    return singles.isEmpty() ? null : singles.get(0);
  }

  public static Character firstNonRepeating(String string) {
    Map<Character, Integer> charCounts = new HashMap<>();

    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);
      charCounts.put(
          c,
          charCounts.getOrDefault(c, 0)
              + 1); // The first loop counts the frequency of each character by using a HashMap. For
      // each character, the code checks if it already exists in the HashMap, and if
      // it does, it increments its count. If it doesn't exist, it initializes its
      // count to 1.
    }

    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);
      if (charCounts.get(c) == 1) {
        return c;
      }
    }
    return null;
  }

  public static List<List<String>> groupAnagrams(String[] strings) {
    Map<String, List<String>> anagrams = new HashMap<>();
    List<List<String>> result = new ArrayList<>();

    for (String string : strings) {
      String key = Arrays.stream(string.split("")).sorted().collect(Collectors.joining());
      if (anagrams.get(key) == null) {
        ArrayList<String> anagram = new ArrayList<>();
        anagram.add(string);
        anagrams.put(key, anagram);
      } else { // key is already in map, find it and add the string
        anagrams.get(key).add(string);
      }
    }

    return new ArrayList<>(anagrams.values());
  }
}

//    for (Map.Entry<String, List<String>> entrySet : anagrams.entrySet()) {
//      result.add(entrySet.getValue());
//    }
//
//    return result.stream()
//        .sorted((s1, s2) -> s2.size() - s1.size())
//        .toList(); // sort result on length
//  }
// }
