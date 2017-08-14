package solution000_099.solution082;

/**
 * Script Created by daidai on 2017/8/11.
 */

import structure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            //当前元素和下一个元素相同，则将head移动到最后一个相同元素处，并接着 head = head.next
            //直到下一个元素处，如果下一个元素也有相同数字，则继续移动，直到没有重复的数字
            //并将 prev 的 next 指针指向下一个元素
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
            } else {
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
        }
        //最后需要把 prev.next 置 null，防止全部相同元素的情况出现
        prev.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode res = solution.deleteDuplicates(ListNode.parse(new int[]{3, 1, 1}));
        ListNode.print(res);
    }
}
