package solution400_499.solution445;

/**
 * Script Created by daidai on 2017/4/16.
 */

import structure.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        Stack<Integer> resStack = new Stack<>();
        while (!stack1.empty() && !stack2.empty()) {
            int val1 = stack1.pop();
            int val2 = stack2.pop();
            int cur = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            resStack.push(cur);
        }
        Stack<Integer> nonEmpty = !stack1.empty() ? stack1 : stack2;
        while (!nonEmpty.empty()) {
            int val = nonEmpty.pop();
            int cur = (val + carry) % 10;
            carry = (val + carry) / 10;
            resStack.push(cur);
        }
        if (carry != 0) {
            resStack.push(carry);
        }

        ListNode res = new ListNode(0);
        ListNode dump = res;
        while (!resStack.empty()) {
            res.next = new ListNode(resStack.pop());
            res = res.next;
        }
        return dump.next;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.parse(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNode.parse(new int[]{5, 6, 4});
        ListNode res = solution.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
