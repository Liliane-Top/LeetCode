package nl.top.LeetCode.datastructures;

import java.util.ArrayList;

public class Stack2<T> {

  private ArrayList<T> stackList = new ArrayList<>();

  public ArrayList<T> getStackList() {
    return stackList;
  }

  public void printStack() { // start with last element and move to front
    for (int i = stackList.size() - 1; i >= 0; i--) {
      System.out.println(stackList.get(i));
    }
  }

  public boolean isEmpty() {
    return stackList.size() == 0;
  }

  public T peek() {
    if (isEmpty()) {
      return null;
    } else {
      return stackList.get(stackList.size() - 1);
    }
  }

  public int size() {
    return stackList.size();
  }

  public void push(T data) {
    stackList.add(data);
  }

  public T pop() {
    if (isEmpty()) return null;
    return stackList.remove(size() - 1);
  }

  public static String reverse(String input) {
    String result = "";
    Stack2<Character> stack = new Stack2<>();

    //		for (String letter : input.split("")) {
    //      stack.push(letter);
    //    }

    for (char letter : input.toCharArray()) {
      stack.push(letter);
    }

    while (!stack.isEmpty()) {
      result += stack.pop();
    }

    return result;
  }

  public static boolean isBalanced(String input) {
    if (input.equals("")) return true;
    Stack2<String> stack = new Stack2<>();
    String[] signs = input.split("");
    if (signs.length % 2 != 0) return false;
    for (String sign : signs) {
      if (sign.equals("(") || sign.equals("[") || sign.equals("{")) {
        stack.push(sign);
      } else if ((!stack.isEmpty() && sign.equals(")") && stack.pop().equals("("))
          || (sign.equals("}") && stack.pop().equals("{"))
          || (sign.equals("]") && stack.pop().equals("["))) {
      }
    }
    return stack.isEmpty();
  }

  public static void sortStack(Stack2 stack) {
    Stack2<Integer> sortedStack = new Stack2<>();
    Integer original;
    sortedStack.push((Integer) stack.pop());
    while (!stack.isEmpty()) {
      original = (Integer) stack.pop();
      while (!sortedStack.isEmpty() && (sortedStack.peek() > original)) {
        stack.push(sortedStack.pop());
      }
      sortedStack.push(original);
    }
    while (!sortedStack.isEmpty()) {
      stack.push(sortedStack.pop());
    }
  }
}
