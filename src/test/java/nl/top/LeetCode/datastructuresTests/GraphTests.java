package nl.top.LeetCode.datastructuresTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import nl.top.LeetCode.datastructures.Graph;
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

  @Test
  void cal_removeEdge() {
    Graph myGraph = new Graph();
    myGraph.addVertex("A");
    myGraph.addVertex("B");
    myGraph.addVertex("C");

    myGraph.addEdge("A", "B");
    myGraph.addEdge("B", "C");
    myGraph.addEdge("A", "C");

    myGraph.removeEdge("A", "B");

    assertEquals("C", myGraph.getAdjacentList().get("A").get(0));
    assertEquals("C", myGraph.getAdjacentList().get("B").get(0));
    assertFalse(myGraph.getAdjacentList().get("A").contains("B"));
    assertFalse(myGraph.getAdjacentList().get("B").contains("A"));
  }

  @Test
  void call_removeVertex() {
    Graph myGraph = new Graph();

    myGraph.addVertex("A");
    myGraph.addVertex("B");
    myGraph.addVertex("C");
    myGraph.addVertex("D");

    myGraph.addEdge("A", "B");
    myGraph.addEdge("A", "C");
    myGraph.addEdge("A", "D");
    myGraph.addEdge("B", "D");
    myGraph.addEdge("C", "D");

    myGraph.removeVertex("D");

    assertEquals(3, myGraph.getAdjacentList().size());
    assertFalse(myGraph.getAdjacentList().get("A").contains("D"));
    assertFalse(myGraph.getAdjacentList().get("B").contains("D"));
  }
}
