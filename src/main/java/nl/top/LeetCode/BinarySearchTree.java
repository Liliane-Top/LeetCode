package nl.top.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
  Node root; // parent

  class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  public boolean insert(int value) {
    Node newNode = new Node(value);

    if (root == null) {
      root = newNode;
      return true;
    }

    Node temp = root;
    while (true) {
      if (newNode.value == temp.value) {
        return false;
      }
      if (newNode.value < temp.value) {
        if (temp.left == null) {
          temp.left = newNode;
          return true;
        }
        temp = temp.left;
      } else {
        if (temp.right == null) {
          temp.right = newNode;
          return true;
        }
        temp = temp.right;
      }
    }
  }

  private Node rInsert(Node currentNode, int value) {

    if (currentNode == null) return new Node(value);

    if (value < currentNode.value) {
      currentNode.left = rInsert(currentNode.left, value);
    } else if (value > currentNode.value) {
      currentNode.right = rInsert(currentNode.right, value);
    }
    return currentNode;
  }

  public void rInsert(int value) {
    if (root == null) root = new Node(value);
    rInsert(root, value);
  }

  public boolean contains(int value) {
    Node temp = root;
    while (temp != null) {
      if (value < temp.value) {
        temp = temp.left;
      } else if (value > temp.value) {
        temp = temp.right;
      } else {
        return true;
      }
    }
    return false;
  }

  private boolean rContains(Node currentNode, int value) {
    if (currentNode == null) return false;

    if (currentNode.value == value) return true;

    if (value < currentNode.value) {
      return rContains(currentNode.left, value);
    } else {
      return rContains(currentNode.right, value);
    }
  }

  public boolean rContains(int value) {
    return rContains(root, value);
  }

  public int minValue(Node currentNode) {
    while (currentNode.left != null) {
      currentNode = currentNode.left;
    }
    return currentNode.value;
  }

  public void deleteNode(int value) {
    root = deleteNode(root, value);
  }

  private Node deleteNode(Node currentNode, int value) {
    // The deleteNode method begins by checking whether the currentNode is null.
    // If it is, the method returns null because there is no node to delete.
    if (currentNode == null) return null;

    // The method then checks if the value to be deleted is less than the value of currentNode.
    // If so, the method performs a recursive call to delete the node in the left subtree of the
    // currentNode.
    if (value < currentNode.value) {
      currentNode.left = deleteNode(currentNode.left, value);
      // Conversely, if the value to be deleted is more than the value of currentNode, the method
      // performs a recursive call
      // to delete the node in the right subtree of the currentNode.
    } else if (value > currentNode.value) {
      currentNode.right = deleteNode(currentNode.right, value);
      // If the value to be deleted is equal to the value of the currentNode,
      // the method proceeds to delete the currentNode.
    } else {
      // If the currentNode is a leaf node (both left and right children are null),
      // the method simply removes the node by returning null. or the currentNode is set to null
      if (currentNode.left == null && currentNode.right == null) {
        currentNode = null;
        // If the currentNode has only a right child (the left child is null), the method bypasses
        // the currentNode by
        // returning the right child, effectively deleting the currentNode.
      } else if (currentNode.left == null) {
        currentNode = currentNode.right;

        // If the currentNode has only a left child (the right child is null), the method bypasses
        // the currentNode by
        // returning the left child, effectively deleting the currentNode.
      } else if (currentNode.right == null) {
        currentNode = currentNode.left;
        // If the currentNode has both left and right children, the method finds the minimum value
        // in the right subtree
        // of the currentNode (which is the next larger value in the BST) and replaces the value of
        // the currentNode with this minimum value. This replacement preserves the BST property.
      } else {
        int minimum = minValue(currentNode.right);
        currentNode.value = minimum;
        // The method then performs a recursive call to delete this minimum value from the right
        // subtree of the currentNode,
        // effectively removing the duplicate resulting from the replacement in the previous step.
        currentNode.right = deleteNode(currentNode.right, minimum);
      }
    }
    // Finally, the method returns the currentNode (which could be a different node due to the
    // replacements
    // or the same node if no deletion occurred at this level).
    // This return value allows the parent nodes to update their child pointers appropriately,
    // thereby updating the tree structure.
    return currentNode;
  }

  public ArrayList<Integer> breadthFirstSearch() {
    Node currentNode = root;
    Queue<Node> nodes = new LinkedList<>(); // FIFO
    ArrayList<Integer> results = new ArrayList<>();
    nodes.add(currentNode);

    while (nodes.size() > 0) {
      currentNode = nodes.remove();
      results.add(currentNode.value);
      if (currentNode.left != null) {
        nodes.add(currentNode.left);
      }
      if (currentNode.right != null) {
        nodes.add(currentNode.right);
      }
    }
    return results;
  }

  public ArrayList<Integer> depthFirstSearchPreOrder() {

    ArrayList<Integer> results = new ArrayList<>();
    class Traverse {
      Traverse(Node currentNode) {
        results.add(currentNode.value);
        if (currentNode.left != null) {
          new Traverse(currentNode.left);
        }
        if (currentNode.right != null) {
          new Traverse(currentNode.right);
        }
      }
    }
    new Traverse(root);
    return results;
  }
}
