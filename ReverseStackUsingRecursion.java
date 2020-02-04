import java.util.*;

class ReverseStackUsingRecursion {

  static Stack<Character> stack = new Stack<Character>();

  public static void main(String[] args) {
    stack.push('S');
    stack.push('H');
    stack.push('R');
    stack.push('U');
    stack.push('T');
    stack.push('I');

    System.out.println("Original Stack: ");
    System.out.print(stack);

    reverse();

    System.out.println("Reverse Stack: ");
    System.out.print(stack);

  }

  public static void reverse() {
    if(!stack.empty()) {
      // hold all stack characters in the function call stack
      // until we reach end of stack
      char x = stack.peek();
      stack.pop();
      // call reverse recursively to hold values in call stack
      reverse();
      // once the stack is empty and loaded in function call Stack..
      // insert characters the bottom
      insertAtBottom(x);
    }
  }

  public static void insertAtBottom(char x) {
    if(stack.empty()) {
      stack.push(x);
    } else {
      // pop all elements in function call stack and
      // then push the elements
      char a = stack.peek();
      stack.pop();
      insertAtBottom(x);

      // push elements into stack
      stack.push(a);
    };
  }

}
