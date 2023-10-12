package nl.top.LeetCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;import java.util.ArrayList;

public class GraphTests {
	@Test
	void call_addVertex(){
		Graph myGraph = new Graph();
		myGraph.addVertex("A");
		myGraph.addVertex("B");
    System.out.println("Graph: ");
		myGraph.printGraph();

		assertEquals(2, myGraph.getAdjacentList().size());
		assertEquals(new ArrayList<>(), myGraph.getAdjacentList().get("B"));
	}

}
