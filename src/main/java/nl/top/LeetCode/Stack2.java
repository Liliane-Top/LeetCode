package nl.top.LeetCode;

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
}
