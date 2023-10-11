package nl.top.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MySet {

  private static Set<Integer> myHashset = new HashSet<>();
  Set<Integer> myTreeSet = new TreeSet<>();
  Set<Integer> myLinkedHashSet = new LinkedHashSet<>();

  public static void printSet(Set<Integer> set) {
    for (Integer i : set) {
      System.out.println(i);
    }
  }

  public static List<Integer> removeDuplicates(List<Integer> input) {
    Set<Integer> set = new HashSet<>(input);
    return new ArrayList<>(set);
  }

  //  public static boolean hasUniqueChars(String input) {
  //    if (input.length() == 0) return true;
  //    Set<String> set = new HashSet<>(Arrays.asList(input.split("")));
  //    return input.length() == set.size();
  //  }

  public static boolean hasUniqueChars(String input) {
    Set<Character> set = new HashSet<>();
    for (char letter : input.toCharArray()) {
      if(set.contains(letter)){
				return false;
      }
			set.add(letter);
    }
    return true;
  }

  public static void main(String[] args) {
    myHashset.add(1);
    myHashset.add(2);
    myHashset.add(3);
    myHashset.add(4);
    myHashset.add(5);

    printSet(myHashset);

    System.out.println("Adding new element: " + myHashset.add(6));
    System.out.println("Adding existing element: " + myHashset.add(6));
    System.out.println("Removing exising element: " + myHashset.remove(3));
    System.out.println("Removing a non exising element: " + myHashset.remove(3));

    // Union of two sets
    Set<Integer> otherSet = new HashSet<>();
    otherSet.add(3);
    otherSet.add(4);
    otherSet.add(5);
    otherSet.add(6);
    printSet(otherSet);
    Set<Integer> unionSet = new HashSet<>(myHashset);
    unionSet.addAll(otherSet);
    System.out.println("Union");
    printSet(unionSet);

    // Intersection of two sets
    Set<Integer> intersectionSet = new HashSet<>(myHashset);
    intersectionSet.retainAll(otherSet);
    System.out.println("Intersection");
    printSet(intersectionSet);

    // Difference between 2 sets
    System.out.println("set1");
    printSet(myHashset);
    System.out.println("set2");
    printSet(otherSet);
    Set<Integer> differenceSet = new HashSet<>(myHashset);
    differenceSet.removeAll(otherSet);
    System.out.println("Difference");
    printSet(differenceSet);

    // checking if an element is in the set
    if (myHashset.contains(4)) {
      System.out.println("it contains a 4");
    }
  }
}
