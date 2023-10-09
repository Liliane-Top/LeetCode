package nl.top.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

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
    for(int number : array2) {
			if(map.get(number) != null) return true;
    }
    return false;
  }
}
