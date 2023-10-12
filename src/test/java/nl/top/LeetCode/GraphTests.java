package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class GraphTests {

  @Test
  void call_addVertex() {
    Graph myGraph = new Graph();
    myGraph.addVertex("A");
    myGraph.addVertex("B");
    System.out.println("Graph: ");
    myGraph.printGraph();

    assertEquals(2, myGraph.getAdjacentList().size());
    assertEquals(new ArrayList<>(), myGraph.getAdjacentList().get("B"));
  }

  @Test
  void call_addEdge() {
    Graph myGraph = new Graph();
    myGraph.addVertex("A");
    myGraph.addVertex("B");
    myGraph.addEdge("A", "B");

    assertEquals("B", myGraph.getAdjacentList().get("A").get(0));
    assertEquals("A", myGraph.getAdjacentList().get("B").get(0));
  }
}
