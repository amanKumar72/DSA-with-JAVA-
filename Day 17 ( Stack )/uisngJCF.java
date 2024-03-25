import java.util.*;

public class uisngJCF {
  // push at bottom of the stack
  public static void pushAtBottom(Stack<Integer> stack, int data) {
    if (stack.isEmpty()) {
      stack.push(data);
      return;
    }
    int top = stack.pop();
    pushAtBottom(stack, data);
    stack.push(top);
  }

  // reverse string
  public static String reverseString(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      s.push(str.charAt(i));
    }
    StringBuilder sb = new StringBuilder();
    while (!s.isEmpty()) {
      sb.append(s.pop());
    }
    return sb.toString();
  }

  public static void reverse(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }
    int top = stack.pop();
    reverse(stack);
    pushAtBottom(stack, top);
  }

  public static void print(Stack<Integer> stack) {
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  // stock span problem
  public static void stockspan(int stock[], int span[]) {
    Stack<Integer> s = new Stack<>();
    s.push(0);
    span[0] = 1;
    for (int i = 1; i < stock.length; i++) {
      int currPrice = stock[i];
      while (!s.isEmpty() && currPrice >= stock[(s.peek())]) {
        s.pop();
      }
      if (s.isEmpty()) {
        span[i] = i + 1;
      } else {
        span[i] = i - s.peek();
      }
      s.push(i);
    }
  }

  // Next Greater element
  public static void nextGreater(int arr[], int nextGr[]) {
    Stack<Integer> st = new Stack<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
        st.pop();
      }
      if (st.isEmpty()) {
        nextGr[i] = -1;
      } else {
        nextGr[i] = arr[st.peek()];
      }
      st.push(i);
    }
  }

  // Valid Paranthesis
  public static boolean validParanthesis(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
        s.push(str.charAt(i));
      } else {
        if ((s.peek() == '(' && str.charAt(i) == ')') || (s.peek() == '{' && str.charAt(i) == '}')
            || (s.peek() == '[' && str.charAt(i) == ']')) {
          s.pop();
        } else {
          return false;
        }
      }
    }
    if (s.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  // duplicate paranthesis
  public static boolean duplicateParanthesis(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != '}' && str.charAt(i) != ')' && str.charAt(i) != ']') {
        s.push(str.charAt(i));
      } else {
        int c = 0;
        while ((s.peek() != '(' && str.charAt(i) == ')') || (s.peek() != '{' && str.charAt(i) == '}')
            || (s.peek() != '[' && str.charAt(i) == ']')) {
          c++;
          s.pop();
        }
        s.pop();// remove the opening bracket
        if (c < 1) {
          return true;
        }
      }
    }
    return false;
  }

  // Max area in Histogram
  public static int maxAreaInHistogram(int heights[]) {
    int maxArea = 0;
    Stack<Integer> s = new Stack<>();
    int nextSmallerRight[] = new int[heights.length];
    int nextSmallerLeft[] = new int[heights.length];

    // Find Next Smaller on Right Side of Bar
    for (int i = heights.length - 1; i >= 0; i--) {
      while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
        s.pop();
      }
      if (s.isEmpty()) {
        nextSmallerRight[i] = heights.length;
      } else {
        nextSmallerRight[i] = s.peek();
      }
      s.push(i);
    }

    s = new Stack<>();

    // Find Next Smaller on left Side of Bar
    for (int i = 0; i < heights.length; i++) {
      while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
        s.pop();
      }
      if (s.isEmpty()) {
        nextSmallerLeft[i] = -1;
      } else {
        nextSmallerLeft[i] = s.peek();
      }
      s.push(i);
    }
    for (int i = 0; i < nextSmallerLeft.length; i++) {
      System.out.print(nextSmallerLeft[i] + " ");
    }
    for (int i = 0; i < nextSmallerRight.length; i++) {
      System.out.print(nextSmallerRight[i] + " ");
    }

    for (int i = 0; i < heights.length; i++) {
      int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
      int currArea = heights[i] * width;
      if (currArea > maxArea) {
        maxArea = currArea;
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    // Stack<Integer> stack = new Stack<>();
    // stack.push(0);
    // stack.push(5);
    // stack.push(8);
    // stack.push(1);
    // reverse(stack);
    // print(stack);
    // System.out.println(reverseString("reverse"));
    int stock[] = { 2, 1, 5, 6, 2, 3 };
    // int span[] = new int[stock.length];
    // stockspan(stock, span);
    // nextGreater(stock, span);
    // String s = "{(a+b)+{c+(c+d)}}";
    // System.out.println(duplicateParanthesis(s));
    // for (int i = 0; i < span.length; i++) {
    // System.out.println(span[i]);
    // }
    System.out.println("Max area= " + maxAreaInHistogram(stock));
  }
}
