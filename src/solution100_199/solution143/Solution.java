package solution100_199.solution143;

/**
 * Script Created by daidai on 2017/6/19.
 */

import structure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }

        List<ListNode> list1 = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        tmp = head;
        int i = 0;
        while (tmp != null) {
            if (i <= (count - 1) / 2) {
                list1.add(tmp);
            } else {
                stack.push(tmp);
            }
            i++;
            tmp = tmp.next;
        }

        for (int j = 0; j < list1.size(); j++) {
            if (!stack.isEmpty()) {
                ListNode pop = stack.pop();
                list1.get(j).next = pop;
                pop.next = (j != list1.size() - 1 ? list1.get(j + 1) : null);
            } else {
                list1.get(j).next = null;
            }
        }
    }

    public void solve(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next;
        fast = slow.next;
        while (fast != null) {
            next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }
        fast = head;
        ListNode next2;
        while (fast.next != slow && slow != fast) {
            next = fast.next;
            next2 = slow.next;
            fast.next = slow;
            slow.next = next;
            fast = next;
            slow = next2;
        }
        slow.next = null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.parse(new int[]{1, 2, 3, 4, 5, 6, 7});
        solution.reorderList(listNode);
        ListNode.print(listNode);
    }
}