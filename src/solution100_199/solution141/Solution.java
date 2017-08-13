package solution100_199.solution141;

/**
 * Script Created by daidai on 2017/8/10.
 */

import structure.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = new ListNode(1);
        ListNode sec = new ListNode(2);
        root.next = sec;
        System.out.println(solution.hasCycle(root));
    }
}
