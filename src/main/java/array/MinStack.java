package array;

import java.util.Stack;

/**
 * @author shenWenWen 2022/5/5 下午5:30
 */
public class MinStack {
    Stack<Integer> stack1, stack2;
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.size()<=0 || x<=stack2.peek()){
            stack2.push(x);
        }
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek())){
            stack2.pop();
        }
    }

    public int top() {
      return  stack1.peek();
    }

    public int min() {
    return stack2.peek();
    }
}
