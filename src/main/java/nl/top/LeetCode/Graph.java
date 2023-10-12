package nl.top.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

  private HashMap<String, ArrayList<String>> adjacentList = new HashMap<>();

  public HashMap<String, ArrayList<String>> getAdjacentList() {
    return adjacentList;
  }

  public void printGraph() {
    System.out.println(adjacentList);
  }

  public boolean addVertex(String vertex) {
    if (adjacentList.get(vertex) == null) {
      adjacentList.put(vertex, new ArrayList<>());
      return true;
    }
    return false;
  }
}
