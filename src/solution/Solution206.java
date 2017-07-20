package solution;

import structure.ListNode;

/**
 * Script Created by daidai on 2017/2/18.
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
//		structure.ListNode rev = null;
//		while (head != null) {
//			structure.ListNode tmp = head.next;
//			head.next = rev;
//			rev = head;
//			head = tmp;
//		}
//		return rev;
        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode rev) {
        if (head == null) {
            return rev;
        }
        ListNode next = head.next;
        head.next = rev;
        return reverseList(next, head);
    }

    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;
        while (head.next != null) {
            head = head.next;
            tail = head;
        }
        ListNode temp;
        while (dummy.next != tail) {
            temp = dummy.next;
            dummy.next = temp.next;

            temp.next = tail.next;
            tail.next = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        ListNode listNode = ListNode.parse(nums);
        Solution206 solution206 = new Solution206();
        ListNode result = solution206.reverse(listNode);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
