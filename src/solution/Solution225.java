package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Script Created by daidai on 2017/2/15.
 */
public class Solution225 {

    private List<Integer> integers = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public Solution225() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        integers.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return integers.remove(integers.size() - 1);
    }

    /**
     * Get the top element.
     */
    public int top() {
        return integers.get(integers.size() - 1);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return integers.size() == 0;
    }
}

/*
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
